package com.wuxincheng.next.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 博客类型
 * 
 * @author wuxincheng
 *
 */
public class Type implements Serializable {

	private static final long serialVersionUID = -2245998103101886883L;
	
	/** 博客类型主键 */
	private Integer typeId;
	/** 博客类型名称 */
	private String typeName;
	/** 博客类型创建时间 */
	private Date createTime;
	/** 博客类型状态: 0-正常, 1-禁用 */
	private String typeState;
	/** 博客类型说明 */
	private String typeMemo;
	/** 博客类型创建时间 */
	private String createTimeStr;

	public Type() {
	}
	
	public Type(Integer typeId, String typeName, Date createTime,
			String typeState, String typeMemo, String createTimeStr) {
		this.typeId = typeId;
		this.typeName = typeName;
		this.createTime = createTime;
		this.typeState = typeState;
		this.typeMemo = typeMemo;
		this.createTimeStr = createTimeStr;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getTypeState() {
		return typeState;
	}

	public void setTypeState(String typeState) {
		this.typeState = typeState;
	}

	public String getTypeMemo() {
		return typeMemo;
	}

	public void setTypeMemo(String typeMemo) {
		this.typeMemo = typeMemo;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
	
}
