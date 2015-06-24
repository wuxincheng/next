package com.wuxincheng.next.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wuxincheng.next.util.Constants;

@Controller
@RequestMapping("/update")
public class UpdateController {

	private static Logger logger = LoggerFactory.getLogger(UpdateController.class);
	
	@RequestMapping(value = "/")
	public String list(Model model) {
		logger.info("查询网站更新记录");

		// 其它参数设置
		model.addAttribute(Constants.TOP_NAV_FLAG, "update");
		
		return "update";
	}
	
}
