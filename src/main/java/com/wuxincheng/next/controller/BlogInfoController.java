package com.wuxincheng.next.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuxincheng.next.model.BlogInfo;
import com.wuxincheng.next.model.Type;
import com.wuxincheng.next.service.BlogInfoService;
import com.wuxincheng.next.service.TypeService;
import com.wuxincheng.next.util.Constants;
import com.wuxincheng.next.util.Validation;

@Controller
@RequestMapping("/blog")
public class BlogInfoController {

	private static Logger logger = LoggerFactory.getLogger(BlogInfoController.class);
	
	@Resource private BlogInfoService blogInfoService;
	
	@Resource private TypeService typeService;
	
	/** 每页显示条数 */
	private final Integer pageSize = 10;
	private final Integer pageSizeMobile = 10;
	
	/**
	 * 首次访问首页
	 * 
	 * @param model
	 * @param request
	 * @param currentPage
	 * @return
	 */
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request, String currentPage) {
		logger.info("查询所有博客信息");

		if (Validation.isBlank(currentPage) || !Validation.isInt(currentPage, "0+")) {
			currentPage = "1";
		}
		
		Integer current = Integer.parseInt(currentPage);
		Integer start = null;
		Integer end = null;
		if (current > 1) {
			start = (current - 1) * pageSize;
			end = pageSize;
		} else {
			start = 0;
			end = pageSize;
		}
		
		Map<String, Object> pager = blogInfoService.queryPager(start, end);
		
		try {
			if (pager != null && pager.size() > 0) {
				pager.put("currentPage", currentPage);
				pager.put("pageSize", pageSize);
				
				Integer totalCount = (Integer)pager.get("totalCount");
				Integer lastPage = (totalCount/pageSize);
				Integer flag = (totalCount%pageSize)>0?1:0;
				pager.put("lastPage", lastPage + flag);
				model.addAttribute("pager", pager);
			} else {
				model.addAttribute("blogInfos", Collections.EMPTY_LIST);
				logger.info("没有查询到博客信息");
			}
		} catch (Exception e) {
			logger.error("在查询博客列表时出现异常", e);
		}

		// 其它参数设置
		model.addAttribute(Constants.TOP_NAV_FLAG, "blog");
		readList(request);
		
		return "blog";
	}
	
	/**
	 * 首页
	 */
	@RequestMapping(value = "/mobileList")
	public String mobileList(Model model, HttpServletRequest request, String currentPage) {
		logger.info("查询所有博客信息");

		if (Validation.isBlank(currentPage) || !Validation.isInt(currentPage, "0+")) {
			currentPage = "1";
		}
		
		Integer current = Integer.parseInt(currentPage);
		Integer start = null;
		Integer end = null;
		if (current > 1) {
			start = (current - 1) * pageSizeMobile;
			end = pageSizeMobile;
		} else {
			start = 0;
			end = pageSizeMobile;
		}
		
		Map<String, Object> pager = blogInfoService.queryPager(start, end);
		
		try {
			if (pager != null && pager.size() > 0) {
				pager.put("currentPage", currentPage);
				pager.put("pageSize", pageSizeMobile);
				
				Integer totalCount = (Integer)pager.get("totalCount");
				Integer lastPage = (totalCount/pageSizeMobile);
				Integer flag = (totalCount%pageSizeMobile)>0?1:0;
				pager.put("lastPage", lastPage + flag);
				model.addAttribute("pager", pager);
			} else {
				model.addAttribute("blogInfos", Collections.EMPTY_LIST);
				logger.info("没有查询到博客信息");
			}
		} catch (Exception e) {
			logger.error("在查询博客列表时出现异常", e);
		}
		
		return "mobileList";
	}
	
	/**
	 * Ajax请求加载更多
	 * 
	 * @param model
	 * @param request
	 * @param currentPage
	 * @return
	 */
	@RequestMapping(value = "/load", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> load(String currentPage) {
		if (Validation.isBlank(currentPage) || !Validation.isInt(currentPage, "0+")) {
			currentPage = "1";
		}
		
		Integer current = Integer.parseInt(currentPage);
		Integer start = null;
		Integer end = null;
		if (current > 1) {
			start = (current - 1) * pageSize;
			end = pageSize;
		} else {
			start = 0;
			end = pageSize;
		}
		
		Map<String, Object> pager = blogInfoService.queryPager(start, end);
		
		try {
			if (pager != null && pager.size() > 0) {
				pager.put("currentPage", currentPage);
				pager.put("pageSize", pageSize);
				pager.put("nextPage", current+1);
				
				Integer totalCount = (Integer)pager.get("totalCount");
				Integer lastPage = (totalCount/pageSize);
				Integer flag = (totalCount%pageSize)>0?1:0;
				pager.put("lastPage", lastPage + flag);
			} else {
				logger.info("没有查询到博客信息");
			}
		} catch (Exception e) {
			logger.error("在查询博客列表时出现异常", e);
		}
		
		return pager;
	}
	
	@RequestMapping(value = "/detail")
	public String detail(HttpServletRequest request, String blogId, Model model) {
		logger.info("查询博客详细信息，blogId=" + blogId);
		
		if (Validation.isBlank(blogId)) {
			return "404";
		}
		
		if (!Validation.isInt(blogId, "0+")) {
			return "404";
		}
		
		BlogInfo blogInfo = null;
		
		blogInfo = blogInfoService.queryByBlogId(blogId);

		if (null == blogInfo) {
			logger.warn("博客信息信息，blogId=" + blogId + "，已跳转到404页面");
			return "404";
		}
		
		// 更新博客访问量
		blogInfoService.updateReadCount(blogId);
		
		model.addAttribute("blogInfo", blogInfo);
		
		readList(request);
		
		return "blog/detail";
	}
	
	private void readList(HttpServletRequest request){
		// 阅读量排行前5
		@SuppressWarnings("unchecked")
		List<BlogInfo> topBlogInfos = (List<BlogInfo>) request.getSession().getAttribute("topBlogInfos");
		if (!(topBlogInfos != null && topBlogInfos.size() > 0)) {
			topBlogInfos = blogInfoService.queryRead("10", Constants.ORDER_BY_DESC);
			request.getSession().setAttribute("topBlogInfos", topBlogInfos);
		}
		
		// 阅读量排行前5
		@SuppressWarnings("unchecked")
		List<BlogInfo> footerBlogInfos = (List<BlogInfo>) request.getSession().getAttribute("footerBlogInfos");
		if (!(footerBlogInfos != null && footerBlogInfos.size() > 0)) {
			footerBlogInfos = blogInfoService.queryRead("5", Constants.ORDER_BY_ASC);
			request.getSession().setAttribute("footerBlogInfos", footerBlogInfos);
		}
		
		List<Type> types = typeService.queryAll();
		request.getSession().setAttribute("types", types);
	}
	
	@RequestMapping(value = "/detailMobile")
	public String detailMobile(HttpServletRequest request, String blogId, Model model) {
		logger.info("查询博客详细信息，blogId=" + blogId);
		
		if (Validation.isBlank(blogId)) {
			return "404";
		}
		
		if (!Validation.isInt(blogId, "0+")) {
			return "404";
		}
		
		BlogInfo blogInfo = null;
		
		blogInfo = blogInfoService.queryByBlogId(blogId);

		if (null == blogInfo) {
			logger.warn("博客信息信息，blogId=" + blogId + "，已跳转到404页面");
			return "404";
		}
		
		// 更新博客访问量
		blogInfoService.updateReadCount(blogId);
		
		model.addAttribute("blogInfo", blogInfo);
		
		return "blog/detail_mobile";
	}
	
}
