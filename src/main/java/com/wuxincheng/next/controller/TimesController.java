package com.wuxincheng.next.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wuxincheng.next.util.Constants;

/**
 * 时间轴
 * 
 * @author wuxincheng
 *
 */
@Controller
@RequestMapping("/times")
public class TimesController {
	
	private static Logger logger = LoggerFactory.getLogger(TimesController.class);

	@RequestMapping(value = "/show")
	public String show(Model model) {
		logger.info("查询博客时间轴");
		
		model.addAttribute(Constants.TOP_NAV_FLAG, "times");
		
		return "menu/times";
	}
	
}
