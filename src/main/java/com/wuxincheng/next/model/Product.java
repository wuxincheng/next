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

	/** 产品发布时间 */
	private String postDate;

	/** 产品更新时间 */
	private String postDateTime;

	/** 周几 */
	private String weekday;

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

	public String getWeekday() {
		return weekday;
	}

	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}

}
