package com.wuxincheng.next.model;

import java.io.Serializable;

/**
 * 用户收藏产品集
 * 
 * @author wuxincheng(wxcking)
 * @date 2015年7月24日 下午2:06:08
 * 
 */
public class CollectUser implements Serializable {

	private static final long serialVersionUID = -361294005914978730L;

	private Integer collectid;

	private Integer userid;

	private String createTime;

	private String collectState;

	public Integer getCollectid() {
		return collectid;
	}

	public void setCollectid(Integer collectid) {
		this.collectid = collectid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCollectState() {
		return collectState;
	}

	public void setCollectState(String collectState) {
		this.collectState = collectState;
	}

}
