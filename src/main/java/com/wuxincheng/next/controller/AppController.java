package com.wuxincheng.next.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 应用
 * 
 * @author wuxincheng
 *
 */
@Controller
@RequestMapping("/app")
public class AppController {

	private static Logger logger = LoggerFactory.getLogger(BlogInfoController.class);
	
	@RequestMapping(value = "/data")
	public String list(Model model, HttpServletRequest request, String currentPage) {
		logger.info("新成应用，生成图形报表");

		
		
		return "app/data";
	}
	
}
