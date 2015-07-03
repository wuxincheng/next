package com.wuxincheng.next.model;

import java.io.Serializable;

/**
 * 产品集
 * 
 * @author wuxincheng(wxcking)
 * @date 2015年7月3日 下午2:47:08
 * 
 */
public class Collection implements Serializable {

	private static final long serialVersionUID = -2048622308852729384L;

	/** 产品集主键 */
	private Integer collectionid;

	/** 产品集名称 */
	private String collectionName;

	/** 集封面路径 */
	private String coverImgPath;

	/** 用户创建ID */
	private Integer userid;

	/** 产品总数 */
	private Integer productSum;

	/** 被收藏次数 */
	private Integer collectSum;

	/** 说明 */
	private String memo;

	/** 更新标志 */
	private String updateState;

	/** 更新时间 */
	private String updateTime;

	/** 创建时间 */
	private String createTime;

	/** 产品集状态 */
	private String state;

	public Collection() {
	}

	public Integer getCollectionid() {
		return collectionid;
	}

	public void setCollectionid(Integer collectionid) {
		this.collectionid = collectionid;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public String getCoverImgPath() {
		return coverImgPath;
	}

	public void setCoverImgPath(String coverImgPath) {
		this.coverImgPath = coverImgPath;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getProductSum() {
		return productSum;
	}

	public void setProductSum(Integer productSum) {
		this.productSum = productSum;
	}

	public Integer getCollectSum() {
		return collectSum;
	}

	public void setCollectSum(Integer collectSum) {
		this.collectSum = collectSum;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getUpdateState() {
		return updateState;
	}

	public void setUpdateState(String updateState) {
		this.updateState = updateState;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
