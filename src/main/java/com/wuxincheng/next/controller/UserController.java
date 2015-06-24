package com.wuxincheng.next.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wuxincheng.next.model.User;
import com.wuxincheng.next.service.UserService;

/**
 * 版权声明
 * 
 * @author wuxincheng
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired UserService userService;

	@RequestMapping(value = "/login")
	public String login(Model model) {
		logger.info("登录");
		
		return "user/login";
	}
	
	@RequestMapping(value = "/doLogin")
	public String doLogin(@RequestParam String logiName, @RequestParam String loginPwd, 
			HttpServletRequest request, Model model) {
		logger.info("处理登录数据");
		String defaultPage = "user/login";
		
		if (null == logiName || "".equals(logiName) || loginPwd == null || "".equals(loginPwd)) {
			model.addAttribute("errorMsg", "用户名和密码不能为空");
			return defaultPage;
		}
		
		User user = userService.login(logiName, loginPwd);
		if (null == user) {
			model.addAttribute("errorMsg", "用户名或密码错误");
			return defaultPage;
		}
		
		request.getSession().setAttribute("sessionUser", user);
		
		model.addAttribute("main", 1);
		
		return "user/main";
	}
	
	@RequestMapping(value = "/register")
	public String register(Model model) {
		logger.info("注册");
		
		return "user/register";
	}
	
	@RequestMapping(value = "/doRegister")
	public String doRegister(User user, Model model) {
		logger.info("处理注册数据");
		String defaultPage = "user/register";
		
		if (user == null) {
			model.addAttribute("errorMsg", "提交数据不能为空");
			return defaultPage;
		}
		
		String logiName = user.getLogiName();
		if (null == logiName || "".equals(logiName)) {
			model.addAttribute("errorMsg", "用户名不能为空");
			return defaultPage;
		}
		
		User userFlag = userService.query(logiName);
		if (userFlag != null && !"".equals(userFlag)) { // 
			model.addAttribute("errorMsg", "用户名已经存在");
			return defaultPage;
		}
		
		String loginPwd = user.getLoginPwd();
		String loginPwd2 = user.getLoginPwd2();
		if (null == loginPwd || "".equals(loginPwd) || loginPwd2 == null || "".equals(loginPwd2)) {
			model.addAttribute("errorMsg", "密码不能为空");
			return defaultPage;
		}
		
		if (!loginPwd.equals(loginPwd2)) {
			model.addAttribute("errorMsg", "两次密码输入不一样");
			return defaultPage;
		}
		
		user.setState("0"); // 0-正常
		
		userService.insert(user);

		model.addAttribute("successMsg", "注册成功，请登录");
		
		return "user/login";
	}
	
	@RequestMapping(value = "/main")
	public String main(Model model) {
		logger.info("个人主页");
		
		model.addAttribute("main", 1);
		
		return "user/main";
	}
	
	@RequestMapping(value = "/updateUserInfo")
	public String updateUserInfo(HttpServletRequest request, User user, Model model) {
		logger.info("处理个人主页修改数据");

		userService.update(user);
		
		// 
		
		// User userFlag = userService.query(user.getLogiName());
		
		request.getSession().setAttribute("sessionUser", user);
		
		model.addAttribute("main", 1);
		
		model.addAttribute("successMsg", "个人基本信息修改成功");
		
		return "user/main";
	}
	
	@RequestMapping(value = "/mainPwd")
	public String mainPwd(Model model) {
		logger.info("个人主页 - 修改密码");
		
		model.addAttribute("mainPwd", 1);
		
		return "user/main_pwd";
	}
	
	@RequestMapping(value = "/doMainPwd")
	public String doMainPwd(@RequestParam String oldPwd, @RequestParam String newPwd, 
			@RequestParam String newPwd2, HttpServletRequest request, Model model) {
		logger.info("个人主页 - 修改密码");
		String detaultPage = "user/main_pwd";
		
		if (newPwd == null || "".equals(newPwd) || newPwd == null || "".equals(newPwd) 
				|| newPwd == null || "".equals(newPwd)) {
			model.addAttribute("errorMsg", "密码输入都不能为空");
			return detaultPage;
		}
		
		User user = (User)request.getSession().getAttribute("sessionUser");
		String resOldPwd = user.getLoginPwd();
		
		if (!resOldPwd.equals(oldPwd)) {
			model.addAttribute("errorMsg", "原密码输入错误");
			return detaultPage;
		}
		
		if (!newPwd.equals(newPwd2)) {
			model.addAttribute("errorMsg", "两次新密码输入不正确");
			return detaultPage;
		}
		
		user.setLoginPwd(newPwd);
		
		userService.modifyPwd(user);
		
		model.addAttribute("successMsg", "密码修改成功");
		
		model.addAttribute("mainPwd", 1);
		
		return detaultPage;
	}
	
	@RequestMapping(value = "/mainMsg")
	public String mainMsg(Model model) {
		logger.info("个人主页 - 留言");
		
		model.addAttribute("mainMsg", 1);
		
		return "user/main_msg";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, Model model) {
		logger.info("退出");
		
		request.getSession().removeAttribute("sessionUser");
		
		return "user/login";
	}
	
}
