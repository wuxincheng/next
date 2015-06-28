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
 * 登录
 * 
 * @author wuxincheng(wxcking)
 * @date 2015年6月28日 下午6:15:26 
 *
 */
@Controller
@RequestMapping("/login")
public class Login {

	private static final Logger logger = LoggerFactory.getLogger(Login.class);
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/")
	public String login(Model model) {
		logger.info("显示用户登录页面");
		
		return "login";
	}
	
	@RequestMapping(value = "/doLogin")
	public String doLogin(Model model, HttpServletRequest request, User user) {
		logger.info("用户登录 user={}", StringUtil.toStringMultiLine(user));
		
		if (Validation.isBlank(user.getLoginEmail()) || Validation.isBlank(user.getPassword())) {
			model.addAttribute(Constants.MSG_WARN, "用户邮箱和密码都不能为空");
			return "login";
		}
		
		User userFlag = userService.checkLogin(user.getLoginEmail());
		
		if (null == userFlag) {
			model.addAttribute(Constants.MSG_WARN, "用户邮箱不存在！");
			return "login";
		}
		
		String passwordFlag = userFlag.getPassword(); // 数据库中的密码
		
		// 登录密码加密
		String adminsPwdMD5Str = MD5.encryptMD5Pwd(user.getPassword());
		
		if (!Validation.isBlank(passwordFlag) && passwordFlag.equals(adminsPwdMD5Str)) {
			request.getSession().setAttribute("user", userFlag);
		} else {
			model.addAttribute(Constants.MSG_ERROR, "用户密码不正确");
			return "login";
		}
		
		return "redirect:/user/main";
	}
	
}
