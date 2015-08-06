package com.wuxincheng.next.my.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
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
import com.wuxincheng.next.util.Validation;

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
		
		requestMessageProcess(request);
		
		return "my/info";
	}
	
	@RequestMapping(value = "/modify")
	public String modify(Model model, HttpServletRequest request) {
		logger.info("修改个人信息");
		
		
		
		return "redirect:info";
	}
	
	@RequestMapping(value = "/password")
	public String password(Model model, HttpServletRequest request, User user) {
		logger.info("修改登录密码");
		
		// 获取登录用户的信息
		User sessionInfo = getCurrentUser(request);
		
		// 验证
		String reponseValidateMsg = validateUserChangePwdInfo(user, sessionInfo);
		if (StringUtils.isNotEmpty(reponseValidateMsg)) {
			model.addAttribute(Constants.MSG_WARN, reponseValidateMsg);
			return "redirect:info";
		}
		
		// 更新密码
		user.setPassword(MD5.encryptMD5Pwd(user.getPassword1()));
		user.setUserid(sessionInfo.getUserid());
		userService.changePassword(user);
		
		model.addAttribute(Constants.MSG_SUCCESS, "密码更新成功");
		
		return "redirect:info";
	}

	/**
	 * 验证修改密码参数
	 * 
	 * @param user
	 * @return
	 */
	private String validateUserChangePwdInfo(User user, User sessionInfo) {
		String responseValidateMsg = null;
		
		// 验证是否为空
		
		if (StringUtils.isEmpty(user.getLoginEmail())) {
			responseValidateMsg = "邮箱不能为空";
			return responseValidateMsg;
		}
		
		if (StringUtils.isEmpty(user.getPassword())) {
			responseValidateMsg = "当前密码不能为空";
			return responseValidateMsg;
		}
		
		if (StringUtils.isEmpty(user.getPassword1())) {
			responseValidateMsg = "新密码不能为空";
			return responseValidateMsg;
		}
		
		if (StringUtils.isEmpty(user.getPassword2())) {
			responseValidateMsg = "新确认密码不能为空";
			return responseValidateMsg;
		}
		
		// 验证字段长度
		
		if (user.getLoginEmail().length() > 50 || user.getLoginEmail().length() < 8) {
			responseValidateMsg = "邮箱长度无效";
			return responseValidateMsg;
		}
		
		if (user.getPassword().length() > 25 || user.getPassword().length() < 7) {
			responseValidateMsg = "当前密码长度无效";
			return responseValidateMsg;
		}
		
		if (user.getPassword1().length() > 25 || user.getPassword1().length() < 7) {
			responseValidateMsg = "新密码长度无效";
			return responseValidateMsg;
		}
		
		if (!user.getPassword1().equals(user.getPassword2())) {
			responseValidateMsg = "两次新密码输入不一致";
			return responseValidateMsg;
		}
		
		// 验证格式
		
		if (!Validation.checkEmail(user.getLoginEmail())) {
			responseValidateMsg = "邮箱格式不正确";
			return responseValidateMsg;
		}
		
		if (sessionInfo.getPassword().equals(user.getPassword())) {
			responseValidateMsg = "当前密码不正确";
			return responseValidateMsg;
		}
		
		return responseValidateMsg;
	}
	
}
