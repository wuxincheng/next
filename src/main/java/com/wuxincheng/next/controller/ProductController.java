package com.wuxincheng.next.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wuxincheng.next.Pager;
import com.wuxincheng.next.model.Product;
import com.wuxincheng.next.service.ProductService;
import com.wuxincheng.next.util.Constants;
import com.wuxincheng.next.util.StringUtil;
import com.wuxincheng.next.util.Validation;

/**
 * 产品管理
 * 
 * @author wuxincheng(wxcking)
 * @date 2015年6月25日 下午7:01:02
 * 
 */
@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Resource
	private ProductService productService;

	@RequestMapping(value = "/list")
	public String list(Model model, String currentPage) {
		logger.info("显示产品列表");

		// 根据产品发布的日期分组
		List<String> groupDates = productService.queryGroupByDate();
		
		if (null == groupDates || groupDates.size() < 1) {
			return "product/list";
		}
		
		// 每次分页只显示三个日期下发布的产品
		Pager pager = productService.queryProductsByDate(groupDates);
		
		model.addAttribute("pager", pager);
		
		return "product/list";
	}

	@RequestMapping(value = "/postUI")
	public String postUI(Model model) {
		logger.info("显示发布分享新产品页");

		return "product/postUI";
	}

	@RequestMapping(value = "/doPost")
	public String doPost(Model model, Product product) {
		logger.info("处理发布分享新产品数据 product={}", StringUtil.toStringMultiLine(product));

		// 验证主要参数
		if (StringUtils.isEmpty(product.getProdName())) {
			model.addAttribute(Constants.MSG_WARN, "产品名称不能为空");
			return "product/postUI";
		}
		
		if (StringUtils.isEmpty(product.getProdUrl())) {
			model.addAttribute(Constants.MSG_WARN, "产品官网地址不能为空");
			return "product/postUI";
		}
		
		if (StringUtils.isEmpty(product.getMemo())) {
			model.addAttribute(Constants.MSG_WARN, "产品说明不能为空");
			return "product/postUI";
		}

		try {
			// 发布产品
			productService.post(product);
			logger.info("产品信息发布成功");
			model.addAttribute(Constants.MSG_INFO, "产品信息发布成功");
		} catch (Exception e) {
			logger.error("产品发布出现异常：", e);
			model.addAttribute(Constants.MSG_ERROR, "产品发布出现异常，请稍后重试！");
			return "product/postUI";
		}

		return list(model, null);
	}
	
	@RequestMapping(value = "/detail")
	public String detail(Model model, String prodid) {
		logger.info("显示产品详细页面 prodid={}", prodid);
		
		if (StringUtils.isEmpty(prodid) || !Validation.isIntPositive(prodid)) {
			return "404";
		}

		Product product = productService.queryDetailByProdid(prodid);
		
		if (null == product) {
			return "404";
		}
		
		model.addAttribute("product", product);
		
		return "product/detail";
	}

}
