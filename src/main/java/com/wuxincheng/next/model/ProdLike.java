package com.wuxincheng.next.model;

import java.io.Serializable;

/**
 * 用户产品点赞
 * 
 * @author wuxincheng(wxcking)
 * @date 2015年7月23日 下午5:31:03
 * 
 */
public class ProdLike implements Serializable {
	
	private static final long serialVersionUID = 5101762374272334624L;

	private Integer userid;

	private Integer prodid;

	private String likeTime;

	/** 点赞是否有效: 0-有效, 1-无效 */
	private String likeState;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getProdid() {
		return prodid;
	}

	public void setProdid(Integer prodid) {
		this.prodid = prodid;
	}

	public String getLikeTime() {
		return likeTime;
	}

	public void setLikeTime(String likeTime) {
		this.likeTime = likeTime;
	}

	public String getLikeState() {
		return likeState;
	}

	public void setLikeState(String likeState) {
		this.likeState = likeState;
	}

}
