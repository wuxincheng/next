package com.wuxincheng.next.model;

import java.io.Serializable;

/**
 * 产品
 * 
 * @author wuxincheng(wxcking)
 * @date 2015年6月25日 下午7:05:27
 * 
 */
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 产品主键 */
	private Integer prodid;

	/** 产品名称 */
	private String prodName;

	/** 产品管网 */
	private String prodUrl;

	/** 产品说明 */
	private String memo;

	/** 产品赞数 */
	private Integer likeSum;

	/** 产品评论数 */
	private Integer commentSum;

	/** 产品状态：默认：0-正常 */
	private String prodState;

	/** 产品发布日期 */
	private String postDate;

	/** 产品操作时间 */
	private String postDateTime;

	private Integer userid;

	/** 产品集主键 */
	private Integer collectid;
	
	// ===== 用户信息 =====
	private String nickName;
	
	private String loginEmail;
	
	private String picPath;
	
	private String socialPicPath;
	
	private String userMemo;
	
	private String userGroup;
	
	private String position;

	public Integer getProdid() {
		return prodid;
	}

	public void setProdid(Integer prodid) {
		this.prodid = prodid;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdUrl() {
		return prodUrl;
	}

	public void setProdUrl(String prodUrl) {
		this.prodUrl = prodUrl;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Integer getLikeSum() {
		return likeSum;
	}

	public void setLikeSum(Integer likeSum) {
		this.likeSum = likeSum;
	}

	public Integer getCommentSum() {
		return commentSum;
	}

	public void setCommentSum(Integer commentSum) {
		this.commentSum = commentSum;
	}

	public String getProdState() {
		return prodState;
	}

	public void setProdState(String prodState) {
		this.prodState = prodState;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getPostDateTime() {
		return postDateTime;
	}

	public void setPostDateTime(String postDateTime) {
		this.postDateTime = postDateTime;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getCollectid() {
		return collectid;
	}

	public void setCollectid(Integer collectid) {
		this.collectid = collectid;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
