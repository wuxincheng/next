package com.wuxincheng.next.my.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wuxincheng.next.controller.BaseController;
import com.wuxincheng.next.model.Collect;
import com.wuxincheng.next.service.CollectService;

/**
 * 用户中心：个人收藏
 * 
 * @author wuxincheng(wxcking) 
 * @date 2015年8月3日 下午5:34:03 
 *
 */
@Controller
@RequestMapping("/my/collect")
public class MyCollectController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(MyCollectController.class);
	
	@Autowired
	private CollectService collectService;
	
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request) {
		logger.info("显示个人收藏");
		
		List<Collect> collects = collectService.queryAll();
		
		request.setAttribute("collects", collects);
		
		return "collect/list";
	}
	
}
