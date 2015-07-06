package com.wuxincheng.next.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

/**
 * 产品集
 * 
 * @author wuxincheng(wxcking)
 * @date 2015年7月3日 下午2:47:08
 * 
 */
public class Collect implements Serializable {

	private static final long serialVersionUID = -2048622308852729384L;

	/** 产品集主键 */
	private Integer collectid;

	/** 产品集名称 */
	private String collectName;

	/** 集封面路径 */
	private String coverImgPath;

	/** 封面图片文件 */
	private MultipartFile coverImgFile;

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
	private String collectState;

	public Collect() {
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

	public Integer getCollectid() {
		return collectid;
	}

	public void setCollectid(Integer collectid) {
		this.collectid = collectid;
	}

	public String getCollectName() {
		return collectName;
	}

	public void setCollectName(String collectName) {
		this.collectName = collectName;
	}

	public String getCollectState() {
		return collectState;
	}

	public void setCollectState(String collectState) {
		this.collectState = collectState;
	}

	public MultipartFile getCoverImgFile() {
		return coverImgFile;
	}

	public void setCoverImgFile(MultipartFile coverImgFile) {
		this.coverImgFile = coverImgFile;
	}

}