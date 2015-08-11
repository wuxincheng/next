package com.wuxincheng.next.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wuxincheng.next.model.Collect;
import com.wuxincheng.next.model.CollectUser;
import com.wuxincheng.next.model.Product;
import com.wuxincheng.next.service.CollectService;
import com.wuxincheng.next.service.CollectUserService;
import com.wuxincheng.next.service.ProductService;
import com.wuxincheng.next.util.Constants;
import com.wuxincheng.next.util.ImageUtil;
import com.wuxincheng.next.util.Validation;

/**
 * 产品集，现更名为榜单
 * 
 * @author wuxincheng(wxcking)
 * @date 2015年7月1日 下午10:30:45 
 *
 */
@Controller
@RequestMapping("/collect")
public class CollectController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(CollectController.class);
	
	@Autowired
	private CollectService collectService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CollectUserService collectUserService;
	
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request) {
		logger.info("显示榜单列表");
		
		requestMessageProcess(request);
		
		List<Collect> collects = collectService.queryAll();
		
		if (null == collects || collects.size() < 1) {
			model.addAttribute(Constants.MSG_INFO, "目前还没发布榜单");
			logger.debug("目前还没发布榜单");
		}
		
		request.setAttribute("collects", collects);
		
		return "collect/list";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(Model model, HttpServletRequest request) {
		logger.info("显示添加榜单页面");
		requestMessageProcess(request);
		
		// 判断用户是否有创建榜单权限
		// if (!isCollectPermission(request)) {
			// model.addAttribute(Constants.MSG_WARN, "您还没有该项权限");
			// return "redirect:list";
		// }
		
		request.setAttribute(Constants.CURRENT_USERID, getCurrentUserid(request));
		
		return "collect/edit";
	}
	
	@RequestMapping(value = "/create")
	public String create(Model model, HttpServletRequest request, Collect collect) {
		logger.info("添加新的榜单");
		
		// 判断用户是否有创建榜单权限
		// 目前不做限制
		// if (!isCollectPermission(request)) {
			// model.addAttribute(Constants.MSG_WARN, "您还没有该项权限");
			// return "redirect:edit";
		// }
		
		// 验证榜单名称和说明是否为空
		if (StringUtils.isEmpty(collect.getCollectName())) {
			model.addAttribute(Constants.MSG_WARN, "榜单名称不能为空");
			logger.debug("榜单名称不能为空");
			return "redirect:edit";
		}
		if (StringUtils.isEmpty(collect.getMemo())) {
			model.addAttribute(Constants.MSG_WARN, "榜单说明不能为空");
			logger.debug("榜单说明不能为空");
			return "redirect:edit";
		}
		if (collect.getCollectName().length() > 15 || collect.getCollectName().length() < 4) {
			model.addAttribute(Constants.MSG_WARN, "榜单名称长度不合法，应在4到15位之间");
			logger.debug("榜单名称长度不合法，应在4到15位之间");
			return "redirect:edit";
		}
		if (collect.getMemo().length() > 36 || collect.getMemo().length() < 5) {
			model.addAttribute(Constants.MSG_WARN, "一句话介绍长度不合法，应在5到36位之间");
			logger.debug("一句话介绍长度不合法，应在5到36位之间");
			return "redirect:edit";
		}
		if (StringUtils.isNotEmpty(collect.getRecommend())) {
			if (collect.getRecommend().length() > 100) {
				model.addAttribute(Constants.MSG_WARN, "内容介绍长度过长，不能超过200个字");
				logger.debug("内容介绍长度过长，不能超过200个字");
				return "redirect:edit";
			}
		}
		
		logger.debug("开始验证榜单封面图片");
		
		// 验证是否上传了图片
		if (null == collect.getCoverImgFile()) {
			model.addAttribute(Constants.MSG_WARN, "榜单背景图片不能为空");
			logger.debug("榜单背景图片不能为空");
			return "redirect:edit";
		}
		
		// 控制图片大小不能大于3M
		if (collect.getCoverImgFile().getSize() > 5*1024*1024) {
			model.addAttribute(Constants.MSG_WARN, "榜单背景图片不能超过3M");
			logger.debug("榜单背景图片不能超过3M size={}", collect.getCoverImgFile().getSize());
			return "redirect:edit";
		}
		
		// 验证图片的格式(只支持png、jpg格式)
		String checkFileName = collect.getCoverImgFile().getOriginalFilename();
		String lastFix = checkFileName.substring(checkFileName.lastIndexOf("."), checkFileName.length());
		if (!".png|.jpg".contains(lastFix)) {
			model.addAttribute(Constants.MSG_WARN, "榜单背景图片仅支持png、jpg格式");
			logger.debug("榜单背景图片仅支持png、jpg格式 lastFix={}", lastFix);
			return "redirect:edit";
		}
		
		// 生成图片名称
		String ctxPath = request.getSession().getServletContext().getRealPath("/") + "collect/coverbg/"; 
		logger.debug("图片存放路径 ctxPath={}", ctxPath);
		String coverImgPath = System.currentTimeMillis() + lastFix;
		logger.info("封面图片 coverImgPath={}", coverImgPath);
		
		logger.debug("开始保存图片");
		// 保存图片到服务器
		ImageUtil.saveFile(ctxPath, coverImgPath, collect.getCoverImgFile());
		// 设置Collect对中图片存储的路径
		collect.setCoverImgPath(coverImgPath);
		logger.info("封面图片存储成功");
		
		try {
			collectService.createOrUpdate(collect);
			logger.info("榜单创建成功");
			model.addAttribute(Constants.MSG_SUCCESS, "榜单创建成功");
		} catch (Exception e) {
			logger.error("榜单创建出现异常", e);
			model.addAttribute(Constants.MSG_ERROR, "榜单创建错误");
		}
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/detail")
	public String detail(HttpServletRequest request, String collectid) {
		logger.info("显示榜单 collectionid={}", collectid);
		
		// 提示信息显示
		requestMessageProcess(request);
		
		// 判断collectid
		if (StringUtils.isEmpty(collectid) || !Validation.isIntPositive(collectid)) {
			logger.debug("详细显示失败：collectid为空");
			return "redirect:list";
		}
		
		// 是否存在这个榜单
		Collect collect = collectService.queryDetailByCollectid(collectid);
		if (null == collect) {
			logger.debug("详细显示失败：榜单不存在 collectid={}", collectid);
			return "redirect:list";
		}
		
		String userid = null;
		
		// 判断用户是否已经登录
		if (getCurrentUserid(request) != null) {
			// 如果登录，查询该用户是否已经收藏该榜单
			CollectUser collectUser =collectUserService.query(Integer.parseInt(collectid), 
					getCurrentUserid(request));
			request.setAttribute("collectUser", collectUser);
			userid = getCurrentUseridStr(request);
		}
		
		// 查询这个榜单下的所有产品
		Map<String, String> queryMap = new HashMap<String, String>();
		queryMap.put("collectid", collectid);
		queryMap.put("userid", userid);
		List<Product> products = productService.queryProductsByCollectid(queryMap);
		
		request.setAttribute("products", products);
		request.setAttribute("collect", collect);
		
		return "collect/detail";
	}
	
	/**
	 * 榜单收藏和取消收藏操作
	 * 
	 * @param collectid
	 * @param userid
	 * @return
	 */
	@RequestMapping(value = "/collect")
	public String collect(Integer collectid, Integer userid) {
		logger.info("榜单收藏和取消收藏操作 collectionid={} userid={}", collectid, userid);
		
		if (collectid != null && userid != null) {
			collectUserService.collect(collectid, userid);
			logger.debug("榜单收藏和取消收藏操作成功");
		} else {
			logger.debug("榜单收藏和取消收藏操作失败：collectid或userid为空");
		}
		
		return "redirect:/collect/detail?collectid="+collectid;
	}

}
