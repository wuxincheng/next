package com.wuxincheng.next;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
public class Register {

	private static final Logger logger = LoggerFactory.getLogger(Register.class);
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/")
	public String login(Model model) {
		logger.info("显示用户登录页面");
		
		return "register";
	}
	
	@RequestMapping(value = "/doRegister")
	public String doRegister(Model model, HttpServletRequest request, User user) {
		logger.info("用户注册 user={}", StringUtil.toStringMultiLine(user));
		
		if (Validation.isBlank(user.getLoginEmail()) || Validation.isBlank(user.getPassword())) {
			model.addAttribute(Constants.MSG_WARN, "用户邮箱和密码都不能为空");
			return "register";
		}
		
		User userFlag = userService.checkLogin(user.getLoginEmail());
		
		if (userFlag != null) {
			model.addAttribute(Constants.MSG_WARN, "用户邮箱已经存在！");
			return "register";
		}
		
		// 登录密码加密
		user.setPassword(MD5.encryptMD5Pwd(user.getPassword()));
		userService.register(user);
		
		model.addAttribute(Constants.MSG_SUCCESS, "注册成功");
		
		request.getSession().setAttribute("user", user);
		
		return "user/main";
	}
	
}
