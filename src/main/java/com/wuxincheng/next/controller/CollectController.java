package com.wuxincheng.next.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.wuxincheng.next.model.Collect;
import com.wuxincheng.next.model.Product;
import com.wuxincheng.next.service.CollectService;
import com.wuxincheng.next.service.ProductService;
import com.wuxincheng.next.util.Constants;
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
	CollectService collectService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request) {
		logger.info("显示产品集列表");
		
		requestMessageProcess(request);
		
		List<Collect> collects = collectService.queryAll();
		
		request.setAttribute("collects", collects);
		
		return "collect/list";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(Model model, HttpServletRequest request) {
		logger.info("显示添加产品集页面");
		requestMessageProcess(request);
		
		// 判断用户是否有创建产品集权限
		if (!isCollectPermission(request)) {
			model.addAttribute(Constants.MSG_INFO, "您还没有该项权限");
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
			model.addAttribute(Constants.MSG_INFO, "您还没有该项权限");
			return "redirect:edit";
		}
		
		// 验证产品集名称和说明是否为空
		if (StringUtils.isEmpty(collect.getCollectName())) {
			model.addAttribute(Constants.MSG_INFO, "产品集名称不能为空");
			return "redirect:edit";
		}
		if (StringUtils.isEmpty(collect.getMemo())) {
			model.addAttribute(Constants.MSG_INFO, "产品集说明不能为空");
			return "redirect:edit";
		}
		
		// 验证是否上传了图片
		if (null == collect.getCoverImgFile()) {
			model.addAttribute(Constants.MSG_INFO, "产品集背景图片不能为空");
			return "redirect:edit";
		}
		
		// 控制图片大小不能大于2M
		if (collect.getCoverImgFile().getSize() > 220000) {
			model.addAttribute(Constants.MSG_INFO, "产品集背景图片不能超过2M");
			return "redirect:edit";
		}
		
		// 验证图片的格式(只支持png、jpg格式)
		String checkFileName = collect.getCoverImgFile().getOriginalFilename();
		String lastFix = checkFileName.substring(checkFileName.lastIndexOf("."), checkFileName.length());
		if (!".png|.jpg".contains(lastFix)) {
			model.addAttribute(Constants.MSG_INFO, "产品集背景图片仅支持png、jpg格式");
			return "redirect:edit";
		}
		
		// 生成图片名称
		String ctxPath = request.getSession().getServletContext().getRealPath("/")+""; 
		String coverImgPath = System.currentTimeMillis() + lastFix;
		logger.info("封面图片 coverImgPath={}", coverImgPath);
		
		// 保存图片到服务器
		saveFile(ctxPath, coverImgPath, collect.getCoverImgFile());
		// 设置Collect对中图片存储的路径
		collect.setCoverImgPath(coverImgPath);
		logger.info("封面图片存储成功");
		
		try {
			// collectService.create(collect);
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
		
		requestMessageProcess(request);
		
		if (StringUtils.isEmpty(collectid) || !Validation.isIntPositive(collectid)) {
			return "redirect:list";
		}
		
		Collect collect = collectService.queryDetailByCollectid(collectid);
		if (null == collect) {
			return "redirect:list";
		}
		
		List<Product> products = productService.queryProductsByCollectid(collectid);
		
		request.setAttribute("products", products);
		request.setAttribute("collect", collect);
		
		return "collect/detail";
	}
	
	/**
	 * 保存图片
	 * 
	 * @param imgFileName
	 *            上传照片文件名
	 * @param filedata
	 *            文件数据
	 */
	public void saveFile(String saveFilePath, String imgFileName, MultipartFile filedata) {
		// 构建文件目录
		File fileDir = new File(saveFilePath);
		if (!fileDir.exists()) {
			fileDir.mkdirs();
		}

		try {
			FileOutputStream out = new FileOutputStream(saveFilePath + "coverbg/" + imgFileName);
			// 写入文件
			out.write(filedata.getBytes());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
