package com.wuxincheng.next.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录
 * 
 * @author wuxincheng(wxcking) 
 * @date 2015年6月24日 下午6:44:52 
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	/**
	 * 产品列表（异步加载）
	 */
	@RequestMapping(value = "/show")
	public String list(Model model, HttpServletRequest request, String currentPage) {
		return "login/show";
	}
	
}
