package com.wuxincheng.next.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 联系方式
 * 
 * @author wuxincheng
 *
 */
@Controller
@RequestMapping("/contact")
public class ContactController {
	
	private static Logger logger = LoggerFactory.getLogger(ContactController.class);

	@RequestMapping(value = "/")
	public String about(Model model) {
		logger.info("查询博客联系方式页面");
		
		return "menu/contact";
	}
	
}
