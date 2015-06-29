package com.wuxincheng.next.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wuxincheng.next.dao.CommentDao;
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
	
	/**
	 * 发表回复
	 */
	public Integer post(Comment commment, Integer userid) {
		commment.setUserid(userid);
		commment.setCommentState(Constants.DEFAULT_STATE);
		commment.setLikeSum(0);
		commment.setReplySum(0);
		return commentDao.post(commment);
	}

	/**
	 * 根据产品ID查询评论列表
	 */
	public List<Comment> queryByProductid(String productid) {
		return commentDao.queryByProductid(productid);
	}

}
