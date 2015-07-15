package com.wuxincheng.next.model;

import java.io.Serializable;

/**
 * 用户
 * 
 * @author wuxincheng(wxcking) 
 * @date 2015年7月15日 下午5:13:39 
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 用户主键 */
	private Integer userid;

	/** 昵称 */
	private String nickName;

	/** 登录密码 */
	private String password;

	/** 登录邮箱 */
	private String loginEmail;

	/** 自定义头像 */
	private String picPath;

	/** 社交平台头像 */
	private String socialPicPath;

	/** 个人简介 */
	private String memo;

	/** 用户组 */
	private String userGroup;

	/** 用户职位 */
	private String postion;

	/** 用户状态 */
	private String userState;

	/** 产品集权限 */
	private String collectPermission;

	/** 第三方授权Token */
	private String accessToken;

	/** 第三方授权expireIn */
	private long tokenExpireIn;

	/** 第三方授权Openid */
	private String openid;

	/** 第三方平台类型 */
	private String loginType;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getCollectPermission() {
		return collectPermission;
	}

	public void setCollectPermission(String collectPermission) {
		this.collectPermission = collectPermission;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public long getTokenExpireIn() {
		return tokenExpireIn;
	}

	public void setTokenExpireIn(long tokenExpireIn) {
		this.tokenExpireIn = tokenExpireIn;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

}
