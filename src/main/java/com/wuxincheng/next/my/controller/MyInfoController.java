package com.wuxincheng.next.my.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wuxincheng.next.controller.BaseController;
import com.wuxincheng.next.service.UserService;

/**
 * 个人中心：个人信息
 * 
 * @author wuxincheng(wxcking) 
 * @date 2015年8月3日 下午5:38:32 
 *
 */
@Controller
@RequestMapping("/my/info")
public class MyInfoController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(MyInfoController.class);
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/query")
	public String query(Model model, HttpServletRequest request) {
		logger.info("显示个人信息页");
		
		
		
		return "my/info";
	}
	
	@RequestMapping(value = "/modify")
	public String modify(Model model, HttpServletRequest request) {
		logger.info("修改个人信息");
		
		
		
		return "redirect:info";
	}
	
	@RequestMapping(value = "/password")
	public String password(Model model, HttpServletRequest request) {
		logger.info("修改登录密码");
		
		
		return "redirect:info";
	}
	
}
