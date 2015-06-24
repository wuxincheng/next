package com.wuxincheng.next.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wuxincheng.next.util.Constants;

@Controller
@RequestMapping("/photo")
public class PhotoController {

	private static Logger logger = LoggerFactory.getLogger(PhotoController.class);
	
	@RequestMapping(value = "/list")
	public String list(Model model) {
		logger.info("查询照片墙");

		// 其它参数设置
		model.addAttribute(Constants.TOP_NAV_FLAG, "photo");
		
		return "photo";
	}
	
}
