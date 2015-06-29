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
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuxincheng.next.model.Comment;
import com.wuxincheng.next.service.CommentService;
import com.wuxincheng.next.util.StringUtil;
import com.wuxincheng.next.util.Validation;

/**
 * 评论管理
 * 
 * @author wuxincheng(wxcking) 
 * @date 2015年6月29日 下午3:04:31 
 *
 */
@Controller
@RequestMapping("/comment")
public class CommentController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

	@Resource 
	private CommentService commentService;
	
	@RequestMapping(value = "/post")
	public Integer post(Model model, HttpServletRequest request, Comment commment) {
		logger.info("保存评论数据 commment={}", StringUtil.toStringMultiLine(commment));
		return commentService.post(commment, getCurrentUserid(request));
	}
	
	@RequestMapping(value = "/list")
	@ResponseBody
	public List<Comment> list(String productid) {
		logger.info("查询所有评论 productid={}", productid);
		
		if (StringUtils.isEmpty(productid) || !Validation.isIntPositive(productid)) {
			return null;
		}
		
		return commentService.queryByProductid(productid);
	}
	
}