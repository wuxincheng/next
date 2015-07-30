package com.wuxincheng.next.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户中心
 * 
 * @author wuxincheng(wxcking)
 * @date 2015年6月28日 下午10:22:28 
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/main")
	public String main(Model model) {
		logger.info("显示用户中心-我的主页");

		return "user/main";
	}
	
	@RequestMapping(value = "/collect")
	public String collect(Model model) {
		logger.info("显示用户中心-我的收藏");

		return "user/collect";
	}
	
	@RequestMapping(value = "/info")
	public String info(Model model) {
		logger.info("显示用户中心-个人设置");

		return "user/info";
	}
	
}
