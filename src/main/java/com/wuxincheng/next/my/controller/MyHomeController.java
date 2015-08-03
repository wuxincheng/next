package com.wuxincheng.next.my.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wuxincheng.next.Pager;
import com.wuxincheng.next.controller.BaseController;
import com.wuxincheng.next.service.ProductService;

/**
 * 个人中心：我的主页
 * 
 * @author wuxincheng(wxcking) 
 * @date 2015年8月3日 下午5:39:04 
 *
 */
@Controller
@RequestMapping("/my/home")
public class MyHomeController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(MyHomeController.class);
	
	@Resource
	private ProductService productService;
	
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request, String currentPage) {
		logger.info("显示产品列表");
		requestMessageProcess(request);

		// 根据产品发布的日期分组
		List<String> groupDates = productService.queryGroupByDate();
		
		if (null == groupDates || groupDates.size() < 1) {
			logger.info("没有查询到产品发布日期");
			return "product/list";
		}
		
		// 判断是否有用户登录
		String userid = getCurrentUseridStr(request);
		
		// 每次分页只显示三个日期下发布的产品
		Pager pager = productService.queryProductsByDate(groupDates, userid);
		logger.info("查询到产品信息");
		
		model.addAttribute("pager", pager);
		
		return "product/list";
	}
}
