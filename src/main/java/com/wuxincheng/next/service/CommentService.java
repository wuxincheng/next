package com.wuxincheng.next.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wuxincheng.next.dao.CommentDao;
import com.wuxincheng.next.dao.ProductDao;
import com.wuxincheng.next.model.Comment;
import com.wuxincheng.next.util.Constants;

/**
 * 评论
 * 
 * @author wuxincheng(wxcking) 
 * @date 2015年6月29日 下午3:17:13 
 *
 */
@Service("commentService")
public class CommentService {

	@Resource 
	private CommentDao commentDao;
	
	@Resource 
	private ProductDao productDao;
	
	/**
	 * 发表回复
	 */
	public Integer post(Comment comment, Integer userid) {
		// 发表评论
		comment.setUserid(userid);
		comment.setCommentState(Constants.DEFAULT_STATE);
		comment.setLikeSum(0);
		comment.setReplySum(0);
		commentDao.post(comment);
		
		// 更新产品的评论数
		productDao.plusCommentSum(comment.getProductid());
		
		return 1;
	}

	/**
	 * 根据产品ID查询评论列表
	 */
	public List<Comment> queryByProductid(String productid) {
		return commentDao.queryByProductid(productid);
	}

}
