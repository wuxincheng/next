package com.wuxincheng.next.oauth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 微信相关配置
 * 
 * @author wuxincheng(wxcking)
 * @date 2015年7月27日 下午2:19:23
 * 
 */
@Component
public class WechatConfig {

	/** 应用唯一标识 appid */
	@Value("#{wechatSettings.appid}")
	private String appid;

	@Value("#{wechatSettings.appSecret}")
	private String appSecret;

	/** 应用授权作用域, 网页应用 */
	@Value("#{wechatSettings.scope}")
	private String scope;

	/** 登录返回地址 */
	@Value("#{wechatSettings.redirectUrl}")
	private String redirectUrl;

	/** 获取Code请求地址 */
	@Value("#{wechatSettings.requestCodeUrl}")
	private String requestCodeUrl;

	/** 获取AccessToken请求地址 */
	@Value("#{wechatSettings.accessTokenUrl}")
	private String accessTokenUrl;

	/** 获取用户信息地址 */
	@Value("#{wechatSettings.userInfoUrl}")
	private String userInfoUrl;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public String getRequestCodeUrl() {
		return requestCodeUrl;
	}

	public void setRequestCodeUrl(String requestCodeUrl) {
		this.requestCodeUrl = requestCodeUrl;
	}

	public String getAccessTokenUrl() {
		return accessTokenUrl;
	}

	public void setAccessTokenUrl(String accessTokenUrl) {
		this.accessTokenUrl = accessTokenUrl;
	}

	public String getUserInfoUrl() {
		return userInfoUrl;
	}

	public void setUserInfoUrl(String userInfoUrl) {
		this.userInfoUrl = userInfoUrl;
	}

}