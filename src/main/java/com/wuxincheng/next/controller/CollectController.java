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
import com.wuxincheng.next.util.StringUtil;
import com.wuxincheng.next.util.Validation;

/**
 * 产品集
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
		logger.info("显示产品集列表");
		
		requestMessageProcess(request);
		
		List<Collect> collects = collectService.queryAll();
		
		if (null == collects || collects.size() < 1) {
			model.addAttribute(Constants.MSG_INFO, "目前还没发布产品集");
		}
		
		request.setAttribute("collects", collects);
		
		return "collect/list";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(Model model, HttpServletRequest request) {
		logger.info("显示添加产品集页面");
		requestMessageProcess(request);
		
		// 判断用户是否有创建产品集权限
		if (!isCollectPermission(request)) {
			model.addAttribute(Constants.MSG_WARN, "您还没有该项权限");
			return "redirect:list";
		}
		
		request.setAttribute(Constants.CURRENT_USERID, getCurrentUserid(request));
		
		return "collect/edit";
	}
	
	@RequestMapping(value = "/create")
	public String create(Model model, HttpServletRequest request, Collect collect) {
		logger.info("添加新的产品集 collection={}", StringUtil.toStringMultiLine(collect));
		
		// 判断用户是否有创建产品集权限
		if (!isCollectPermission(request)) {
			model.addAttribute(Constants.MSG_WARN, "您还没有该项权限");
			return "redirect:edit";
		}
		
		// 验证产品集名称和说明是否为空
		if (StringUtils.isEmpty(collect.getCollectName())) {
			model.addAttribute(Constants.MSG_WARN, "产品集名称不能为空");
			return "redirect:edit";
		}
		if (StringUtils.isEmpty(collect.getMemo())) {
			model.addAttribute(Constants.MSG_WARN, "产品集说明不能为空");
			return "redirect:edit";
		}
		
		// 验证是否上传了图片
		if (null == collect.getCoverImgFile()) {
			model.addAttribute(Constants.MSG_WARN, "产品集背景图片不能为空");
			return "redirect:edit";
		}
		
		// 控制图片大小不能大于3M
		if (collect.getCoverImgFile().getSize() > 400000) {
			model.addAttribute(Constants.MSG_WARN, "产品集背景图片不能超过3M");
			return "redirect:edit";
		}
		
		// 验证图片的格式(只支持png、jpg格式)
		String checkFileName = collect.getCoverImgFile().getOriginalFilename();
		String lastFix = checkFileName.substring(checkFileName.lastIndexOf("."), checkFileName.length());
		if (!".png|.jpg".contains(lastFix)) {
			model.addAttribute(Constants.MSG_WARN, "产品集背景图片仅支持png、jpg格式");
			return "redirect:edit";
		}
		
		// 生成图片名称
		String ctxPath = request.getSession().getServletContext().getRealPath("/") + "collect/coverbg/"; 
		String coverImgPath = System.currentTimeMillis() + lastFix;
		logger.info("封面图片 coverImgPath={}", coverImgPath);
		
		// 保存图片到服务器
		ImageUtil.saveFile(ctxPath, coverImgPath, collect.getCoverImgFile());
		// 设置Collect对中图片存储的路径
		collect.setCoverImgPath(coverImgPath);
		logger.info("封面图片存储成功");
		
		try {
			collectService.create(collect);
			logger.info("产品集创建成功");
			model.addAttribute(Constants.MSG_SUCCESS, "产品集创建成功");
		} catch (Exception e) {
			logger.error("产品集创建出现异常", e);
			model.addAttribute(Constants.MSG_ERROR, "产品集创建错误");
		}
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/detail")
	public String detail(HttpServletRequest request, String collectid) {
		logger.info("显示产品集 collectionid={}", collectid);
		
		// 提示信息显示
		requestMessageProcess(request);
		
		// 判断collectid
		if (StringUtils.isEmpty(collectid) || !Validation.isIntPositive(collectid)) {
			return "redirect:list";
		}
		
		// 是否存在这个产品集
		Collect collect = collectService.queryDetailByCollectid(collectid);
		if (null == collect) {
			return "redirect:list";
		}
		
		String userid = null;
		
		// 判断用户是否已经登录
		if (getCurrentUserid(request) != null) {
			// 如果登录，查询该用户是否已经收藏该产品集
			CollectUser collectUser =collectUserService.query(Integer.parseInt(collectid), 
					getCurrentUserid(request));
			request.setAttribute("collectUser", collectUser);
			userid = getCurrentUseridStr(request);
		}
		
		// 查询这个产品集下的所有产品
		Map<String, String> queryMap = new HashMap<String, String>();
		queryMap.put("collectid", collectid);
		queryMap.put("userid", userid);
		List<Product> products = productService.queryProductsByCollectid(queryMap);
		
		request.setAttribute("products", products);
		request.setAttribute("collect", collect);
		
		return "collect/detail";
	}
	
	/**
	 * 产品集收藏和取消收藏操作
	 * 
	 * @param collectid
	 * @param userid
	 * @return
	 */
	@RequestMapping(value = "/collect")
	public String collect(Integer collectid, Integer userid) {
		if (collectid != null && userid != null) {
			collectUserService.collect(collectid, userid);
		}
		
		return "redirect:/collect/detail?collectid="+collectid;
	}

}
