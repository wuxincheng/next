package com.wuxincheng.next.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 产品管理
 * 
 * @author wuxincheng(wxcking) 
 * @date 2015年6月24日 下午5:04:55 
 *
 */
@Controller
@RequestMapping("/post")
public class PostController {

	/**
	 * 产品列表（异步加载）
	 */
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request, String currentPage) {
		return "post/list";
	}
	
}
