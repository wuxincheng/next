package com.wuxincheng.next.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wuxincheng.next.model.Product;

/**
 * 产品管理
 * 
 * @author wuxincheng(wxcking) 
 * @date 2015年6月25日 下午7:01:02 
 *
 */
@Controller
@RequestMapping("/product")
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request, String currentPage) {
		logger.info("显示产品列表");
		
		return "product/list";
	}
	
	@RequestMapping(value = "/postUI")
	public String postUI(Model model) {
		logger.info("显示发布分享新产品页");
		
		return "product/postUI";
	}
	
	@RequestMapping(value = "/doPost")
	public String doPost(Model model, Product product) {
		logger.info("处理发布分享新产品数据");
		
		return "product/postUI";
	}
	
}
