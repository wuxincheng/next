package com.wuxincheng.next.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alipay")
public class AlipayController {
	private static Logger logger = LoggerFactory.getLogger(AlipayController.class);

	@RequestMapping(value = "/")
	public String about(Model model) {
		logger.info("alipay");
		
		return "alipay/show";
	}
}
