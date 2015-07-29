package com.wuxincheng.next;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wuxincheng.next.controller.BaseController;
import com.wuxincheng.next.model.User;
import com.wuxincheng.next.service.UserService;
import com.wuxincheng.next.util.Constants;
import com.wuxincheng.next.util.MD5;
import com.wuxincheng.next.util.StringUtil;
import com.wuxincheng.next.util.Validation;

/**
 * 用户注册
 * 
 * @author wuxincheng(wxcking)
 * @date 2015年6月28日 下午7:30:49 
 *
 */
@Controller
@RequestMapping("/register")
public class Register extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(Register.class);
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/")
	public String login(Model model, HttpServletRequest request) {
		logger.info("显示用户登录页面");
		
		requestMessageProcess(request);
		
		return "register";
	}
	
	@RequestMapping(value = "/doRegister")
	public String doRegister(Model model, HttpServletRequest request, User user) {
		logger.info("用户注册 user={}", StringUtil.toStringMultiLine(user));
		
		// 验证空
		if (Validation.isBlank(user.getLoginEmail()) || Validation.isBlank(user.getPassword())
				|| Validation.isBlank(user.getPassword2())) {
			model.addAttribute(Constants.MSG_WARN, "用户邮箱和密码都不能为空");
			return "redirect:/register/";
		}
		
		// 验证邮箱的格式
		if (!Validation.checkEmail(user.getLoginEmail())) {
			model.addAttribute(Constants.MSG_WARN, "邮箱格式不正确");
			return "redirect:/register/";
		}
		
		// 验证两次密码输入是否一样
		if (!user.getPassword().equals(user.getPassword2())) {
			model.addAttribute(Constants.MSG_WARN, "两次密码输入的不一样");
			return "redirect:/register/";
		}
		
		// 验证邮箱长度
		if (user.getLoginEmail().length() < 10) {
			model.addAttribute(Constants.MSG_WARN, "请输入有效的邮箱");
			return "redirect:/register/";
		}
		
		// 验证密码长度
		if (user.getPassword().length() < 6 || user.getPassword().length() > 24) {
			model.addAttribute(Constants.MSG_WARN, "密码长度不符合（6至24位）");
			return "redirect:/register/";
		}
		
		// 验证邮箱的唯一性
		User userFlag = userService.checkLogin(user.getLoginEmail());
		
		if (userFlag != null) {
			model.addAttribute(Constants.MSG_WARN, "用户邮箱已经存在！");
			return "redirect:/register/";
		}
		
		// 登录密码加密
		user.setPassword(MD5.encryptMD5Pwd(user.getPassword()));
		userService.register(user);
		
		model.addAttribute(Constants.MSG_SUCCESS, "注册成功");
		
		user = userService.checkLogin(user.getLoginEmail());
		request.getSession().setAttribute(Constants.CURRENT_USER, user);
		
		return "redirect:/product/list";
	}
	
}
