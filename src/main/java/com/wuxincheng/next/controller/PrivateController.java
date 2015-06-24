package com.wuxincheng.next.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 版权声明
 * 
 * @author wuxincheng
 *
 */
@Controller
@RequestMapping("/private")
public class PrivateController {
	
	private static Logger logger = LoggerFactory.getLogger(PrivateController.class);

	@RequestMapping(value = "/")
	public String about(Model model) {
		logger.info("查询博客版权声明页面");
		
		return "menu/private";
	}
	
}
