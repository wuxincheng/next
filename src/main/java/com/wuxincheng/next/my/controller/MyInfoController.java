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
		// 设置返回路径
		String returnPath = "redirect:info";
		
		// 验证
		String reponseValidateMsg = validateUserChangePwdInfo(user);
		if (StringUtils.isNotEmpty(reponseValidateMsg)) {
			model.addAttribute(Constants.MSG_WARN, reponseValidateMsg);
			return returnPath;
		}
		
		return returnPath;
	}

	/**
	 * 验证修改密码参数
	 * 
	 * @param user
	 * @return
	 */
	private String validateUserChangePwdInfo(User user) {
		String responseValidateMsg = null;
		
		if (StringUtils.isEmpty(user.getLoginEmail())) {
			responseValidateMsg = "邮箱不能为空";
			return responseValidateMsg;
		}
		
		if (!Validation.checkEmail(user.getLoginEmail())) {
			responseValidateMsg = "邮箱格式不正确";
			return responseValidateMsg;
		}
		
		return responseValidateMsg;
	}
	
}
