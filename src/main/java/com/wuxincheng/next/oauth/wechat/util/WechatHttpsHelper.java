package com.wuxincheng.next.oauth.wechat.util;

import org.springframework.stereotype.Component;

import com.wuxincheng.next.oauth.wechat.model.AccessToken;

/**
 * 微信Https请求
 * 
 * @author wuxincheng(wxcking)
 * @date 2015年7月27日 下午10:13:00 
 *
 */
@Component
public class WechatHttpsHelper {

	public static AccessToken getAccessTokenByCode(String accessCode){
		AccessToken accessToken = new AccessToken();
		
		return accessToken;
	}
	
}
