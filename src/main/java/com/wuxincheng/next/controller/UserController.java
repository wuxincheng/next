package com.wuxincheng.next.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wuxincheng.next.model.Product;
import com.wuxincheng.next.model.User;
import com.wuxincheng.next.service.ProductService;
import com.wuxincheng.next.service.UserService;
import com.wuxincheng.next.util.Validation;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource
	private ProductService productService;
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/main")
	public String main(Model model, HttpServletRequest request, String userid) {
		logger.info("显示用户中心 userid={}", userid);

		// 验证userid
		if (StringUtils.isEmpty(userid) || !Validation.isIntPositive(userid)) {
			return "404";
		}

		User user = userService.queryByUserid(userid);
		
		if (null == user) {
			return "404";
		}
		
		List<Product> products = productService.queryUserHome(userid);
		
		model.addAttribute("products", products);
		model.addAttribute("user", user); // 和session中的user冲突
		
		return "my/main";
	}
	
}
