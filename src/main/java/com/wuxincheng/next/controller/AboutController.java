package com.wuxincheng.next.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wuxincheng.next.util.Constants;

/**
 * 关于网站
 * 
 * @author wuxincheng
 *
 */
@Controller
@RequestMapping("/about")
public class AboutController {
	
	private static Logger logger = LoggerFactory.getLogger(AboutController.class);

	@RequestMapping(value = "/")
	public String about(Model model) {
		logger.info("关于网站");
		model.addAttribute(Constants.TOP_NAV_FLAG, "about");
		
		return "about";
	}
	
}
