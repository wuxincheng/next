package com.wuxincheng.next.oauth.wechat.model;

public class AccessToken {

	/** 接口调用凭证 */
	private String accessToken;

	/** access_token接口调用凭证超时时间，单位（秒） */
	private String expiresin;

	/** 用户刷新access_token */
	private String refreshToken;

	/** 授权用户唯一标识 */
	private String openid;

	/** 用户授权的作用域 */
	private String scope;

	/** 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段 */
	private String unionid;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getExpiresin() {
		return expiresin;
	}

	public void setExpiresin(String expiresin) {
		this.expiresin = expiresin;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

}
