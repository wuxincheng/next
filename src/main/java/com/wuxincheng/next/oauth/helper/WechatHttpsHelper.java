package com.wuxincheng.next.oauth.helper;

import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.wuxincheng.next.oauth.config.WechatConfig;

/**
 * 微信Https请求
 * 
 * @author wuxincheng(wxcking)
 * @date 2015年7月27日 下午10:13:00 
 *
 */
@Component
public class WechatHttpsHelper {
	
	private static final Logger logger = LoggerFactory.getLogger(WechatHttpsHelper.class);

	@Resource WechatConfig wechatConfig;
	
	/**
	 * 根据code获取access_token
	 * 
	 * @param accessCode
	 * @return
	 */
	public Map<String, String> getAccessTokenByCode(String accessCode){
		logger.info("根据code获取access_token值 code={}", accessCode);
		if (StringUtils.isEmpty(accessCode)) {
			logger.warn("获取信息失败，参数不能为空");
			return null;
		}
		
		// 通过code获取access_token的URL
		String accessTokenUrl = wechatConfig.getAccessTokenUrl().replaceAll("APPID", wechatConfig.getAppid())
				.replaceAll("APPSECRET", wechatConfig.getAppSecret())
				.replaceAll("CODE", accessCode);
		logger.info("请求的URL地址 accessTokenUrl={}", accessTokenUrl);
		
		String response = null;
		try {
			response = HttpsConnection.doGet(accessTokenUrl);
			logger.debug("获取access_token请求发送成功");
		} catch (Exception e) {
			logger.error("获取access_token请求出现异常", e);
		}
		
		Map<String, String> responseMap = parseResponseMap(response);
		logger.info("获取access_token请求返回 responseMap={}", responseMap);
		
		return responseMap;
	}
	
	/**
	 * 获取个人用户信息（UnionID机制）
	 * 
	 * @param accessToken
	 * @param openid
	 * @return
	 */
	public Map<String, String> getUserInfoUnionID(String accessToken, String openid){
		logger.info("获取用户个人信息 accessToken={}, openid={}", accessToken, openid);
		if (StringUtils.isEmpty(accessToken) || StringUtils.isEmpty(openid)) {
			logger.warn("获取信息失败，参数不能为空");
			return null;
		}
		
		String userInfoUrl = wechatConfig.getUserInfoUrl().replaceAll("ACCESS_TOKEN", accessToken)
				.replaceAll("OPENID", openid);
		logger.info("请求的URL地址 userInfoUrl={}", userInfoUrl);
		
		String response = null;
		try {
			response = HttpsConnection.doGet(userInfoUrl);
			logger.debug("获取用户个人信息请求发送成功");
		} catch (Exception e) {
			logger.error("获取用户个人信息请求出现异常", e);
		}
		
		Map<String, String> responseMap = parseResponseMap(response);
		logger.info("获取用户个人信息请求返回 responseMap={}", responseMap);
		
		return responseMap;
	}
	
	/**
	 * 将返回的JSON字符串转换成Map
	 * 
	 * @param responseString
	 * @return
	 */
	private Map<String, String> parseResponseMap(String responseString){
		if (StringUtils.isEmpty(responseString)) {
			return null;
		}
		
		// 将返回JSON字符串转换成JSON对象
		JSONObject jsonObject = JSONObject.fromObject(responseString);
		
		// 将JSON转换成Map
		@SuppressWarnings("unchecked")
		Map<String, String> responseMap = jsonObject;
		
		return responseMap;
	}
	
}
