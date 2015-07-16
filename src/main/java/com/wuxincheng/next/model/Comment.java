package com.wuxincheng.next.model;

import java.io.Serializable;

/**
 * 评论
 * 
 * @author wuxincheng(wxcking)
 * @date 2015年6月28日 下午11:34:42
 * 
 */
public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer commentid;

	private Integer commentRefid;

	private Integer productid;

	private Integer userid;

	private String content;

	private String createTime;

	private String commentState;

	private Integer likeSum;

	private Integer replySum;
	
	// ===== 用户信息 =====
	private String nickName;
	
	private String loginEmail;
	
	private String picPath;
	
	private String socialPicPath;
	
	private String userMemo;
	
	private String userGroup;
	
	private String postion;

	public Integer getCommentid() {
		return commentid;
	}

	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
	}

	public Integer getCommentRefid() {
		return commentRefid;
	}

	public void setCommentRefid(Integer commentRefid) {
		this.commentRefid = commentRefid;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCommentState() {
		return commentState;
	}

	public void setCommentState(String commentState) {
		this.commentState = commentState;
	}

	public Integer getLikeSum() {
		return likeSum;
	}

	public void setLikeSum(Integer likeSum) {
		this.likeSum = likeSum;
	}

	public Integer getReplySum() {
		return replySum;
	}

	public void setReplySum(Integer replySum) {
		this.replySum = replySum;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public String getSocialPicPath() {
		return socialPicPath;
	}

	public void setSocialPicPath(String socialPicPath) {
		this.socialPicPath = socialPicPath;
	}

	public String getUserMemo() {
		return userMemo;
	}

	public void setUserMemo(String userMemo) {
		this.userMemo = userMemo;
	}

	public String getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}

	public String getPostion() {
		return postion;
	}

	public void setPostion(String postion) {
		this.postion = postion;
	}

}
