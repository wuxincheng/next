package com.wuxincheng.next.model;

import java.io.Serializable;

/**
 * 博客类型
 * 
 * @author wuxincheng
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = -2245998103101886883L;
	
	private String logiName;
	
	private String loginPwd;
	private String loginPwd2;
	
	private String realName;
	
	private String sex;
	
	private String mobile;
	
	private String email;
	
	private String address;
	
	private String code;
	
	private String qq;
	
	private String privateWeb;
	
	private String privateMsg;
	
	private String state;
	
	public User() {
	}

	public String getLogiName() {
		return logiName;
	}

	public void setLogiName(String logiName) {
		this.logiName = logiName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public String getLoginPwd2() {
		return loginPwd2;
	}

	public void setLoginPwd2(String loginPwd2) {
		this.loginPwd2 = loginPwd2;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPrivateMsg() {
		return privateMsg;
	}

	public void setPrivateMsg(String privateMsg) {
		this.privateMsg = privateMsg;
	}

	public String getPrivateWeb() {
		return privateWeb;
	}

	public void setPrivateWeb(String privateWeb) {
		this.privateWeb = privateWeb;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
