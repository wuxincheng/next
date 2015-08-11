package com.wuxincheng.next.my.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wuxincheng.next.controller.BaseController;
import com.wuxincheng.next.model.Collect;
import com.wuxincheng.next.service.CollectService;
import com.wuxincheng.next.util.Constants;
import com.wuxincheng.next.util.Validation;

/**
 * 我的榜单（相当于榜单的后台管理）
 * 
 * @author wuxincheng(wxcking) 
 * @date 2015年8月10日 下午10:33:22 
 *
 */
@Controller
@RequestMapping("/my/collects")
public class MyCollectsController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(MyCollectsController.class);
	
	@Autowired
	private CollectService collectService;
	
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request) {
		logger.info("显示我的榜单列表");
		
		requestMessageProcess(request);
		
		String userid = getCurrentUseridStr(request);
		
		if (StringUtils.isEmpty(userid)) {
			model.addAttribute(Constants.MSG_WARN, "用户信息异常");
			logger.debug("用户信息异常，登录失效");
			return "redirect:list";
		}
		
		List<Collect> collects = collectService.queryByUserid(userid); 
		
		if (null == collects || collects.size() < 1) {
			model.addAttribute(Constants.MSG_INFO, "你还没有发布过榜单信息");
		}
		
		model.addAttribute("collects", collects);
		
		return "my/collects/list";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(Model model, HttpServletRequest request, String collectid) {
		logger.info("显示我的榜单修改页面 collectid={}", collectid);

		if (StringUtils.isEmpty(collectid) || !Validation.isIntPositive(collectid)) {
			logger.debug("修改页面显示失败：collectid为空");
			return "redirect:list";
		}
		
		Collect collect = collectService.queryDetailByCollectid(collectid);
		
		model.addAttribute("collect", collect);
		
		return "my/collects/edit";
	}
	
	@RequestMapping(value = "/modify")
	public String modify(Model model, HttpServletRequest request, Collect collect) {
		logger.info("处理榜单数据");

		collectService.createOrUpdate(collect);
		
		return "redirect:list";
	}
	
}
