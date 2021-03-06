package com.wuxincheng.next.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuxincheng.next.Pager;
import com.wuxincheng.next.model.Comment;
import com.wuxincheng.next.model.ProdLike;
import com.wuxincheng.next.model.Product;
import com.wuxincheng.next.service.CommentService;
import com.wuxincheng.next.service.ProdLikeService;
import com.wuxincheng.next.service.ProductService;
import com.wuxincheng.next.util.Constants;
import com.wuxincheng.next.util.StringUtil;
import com.wuxincheng.next.util.Validation;

/**
 * 产品管理
 * 
 * @author wuxincheng(wxcking)
 * @date 2015年6月25日 下午7:01:02
 * 
 */
@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Resource 
	private CommentService commentService;
	
	@Resource
	private ProductService productService;
	
	@Resource
	private ProdLikeService prodLikeService;

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
		String userid = getCurrentUserid(request);
		
		// 每次分页只显示三个日期下发布的产品
		Pager pager = productService.queryProductsByDate(groupDates, userid);
		logger.info("查询到产品信息");
		
		model.addAttribute("pager", pager);
		
		return "product/list";
	}

	@RequestMapping(value = "/postUI")
	public String postUI(Model model, HttpServletRequest request, String collectid) {
		logger.info("显示发布分享新产品页");
		requestMessageProcess(request);
		
		if (StringUtils.isNotEmpty(collectid)) {
			if (StringUtils.isEmpty(collectid) || !Validation.isIntPositive(collectid)) {
				return "404";
			}
			
			model.addAttribute("collectid", collectid);
		}

		return "product/postUI";
	}

	@RequestMapping(value = "/doPost")
	public String doPost(Model model, HttpServletRequest request, Product product) {
		logger.info("处理发布分享新产品数据 product={}", StringUtil.toStringMultiLine(product));

		// 验证主要参数
		if (StringUtils.isEmpty(product.getProdName())) {
			model.addAttribute(Constants.MSG_WARN, "产品名称不能为空");
			return "product/postUI";
		}
		
		if (StringUtils.isEmpty(product.getProdUrl())) {
			model.addAttribute(Constants.MSG_WARN, "产品官网地址不能为空");
			return "product/postUI";
		}
		
		if (StringUtils.isEmpty(product.getMemo())) {
			model.addAttribute(Constants.MSG_WARN, "产品说明不能为空");
			return "product/postUI";
		}
		
		try {
			// 发布产品
			productService.post(product, getCurrentUserid(request));
			logger.info("产品信息发布成功");
			model.addAttribute(Constants.MSG_SUCCESS, "产品信息发布成功");
		} catch (Exception e) {
			logger.error("产品发布出现异常：", e);
			model.addAttribute(Constants.MSG_ERROR, "产品发布出现异常，请稍后重试！");
			return "product/postUI";
		}
		
		return product.getCollectid() == null ? "redirect:list"
				: "redirect:/collect/detail?collectid=" + product.getCollectid();
	}
	
	@RequestMapping(value = "/detail")
	public String detail(Model model, HttpServletRequest request, String prodid) {
		logger.info("显示产品详细页面 prodid={}", prodid);
		
		if (StringUtils.isEmpty(prodid) || !Validation.isIntPositive(prodid)) {
			return "404";
		}
		
		// 判断是否有用户登录
		String userid = getCurrentUserid(request);

		// 产品详细
		Product product = productService.queryDetailByProdid(prodid, userid);
		model.addAttribute("product", product);
		 
		// 评论列表
		List<Comment> comments = commentService.queryByProductid(prodid);
		model.addAttribute("comments", comments);
		
		// 赞列表
		List<ProdLike> prodLikes = prodLikeService.queryLikeUserDetail(prodid);
		model.addAttribute("prodLikes", prodLikes);
		
		return "product/detail";
	}
	
	/**
	 * 点赞属于异步操作
	 */
	@RequestMapping(value = "/like")
	@ResponseBody
	public Map<String, String> like(Model model, HttpServletRequest request, String prodid) {
		logger.info("点赞异步操作 prodid={}", prodid);
		
		// 验证prodid和userid的合法性
		if (StringUtils.isEmpty(prodid) || !Validation.isIntPositive(prodid)) {
			return null;
		}

		// 获取当前登录用户ID
		String userid = getCurrentUserid(request);
		if (StringUtils.isEmpty(userid)) {
			return null;
		}
		
		Map<String, String> result = prodLikeService.like(prodid, userid);
		
		logger.info("点赞操作结果 result={}", result);
		
		return result;
	}

}
