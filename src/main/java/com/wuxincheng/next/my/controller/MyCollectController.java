package com.wuxincheng.next.my.controller;

import java.util.ArrayList;
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
import com.wuxincheng.next.model.CollectUser;
import com.wuxincheng.next.service.CollectService;
import com.wuxincheng.next.service.CollectUserService;
import com.wuxincheng.next.util.Constants;

/**
 * 用户中心：个人收藏（收藏的榜单）
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
	private CollectUserService collectUserService;

	@Autowired
	private CollectService collectService;

	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request) {
		logger.info("显示个人收藏");

		// 获取当前用户
		String userid = getCurrentUseridStr(request);
		if (StringUtils.isEmpty(userid)) {
			model.addAttribute(Constants.MSG_WARN, "用户登录信息失效");
			return "redirect:/login/";
		}

		// 查询用户已经收藏的产品集
		List<CollectUser> collectUsers = collectUserService.queryCollects(userid);

		// 如果没有收藏，返回空
		if (null == collectUsers || collectUsers.size() < 1) {
			model.addAttribute(Constants.MSG_INFO, "您还没有收藏产品集");
			return "collect/list";
		}

		// 查询产品集信息
		List<Collect> collects = new ArrayList<Collect>();
		for (CollectUser collectUser : collectUsers) {
			collects.add(collectService.queryDetailByCollectid(collectUser.getCollectid() + ""));
		}

		request.setAttribute("collects", collects);

		return "collect/list";
	}

}
