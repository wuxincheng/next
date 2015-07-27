package com.wuxincheng.next.oauth.wechat.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wuxincheng.next.oauth.wechat.config.WechatConfig;
import com.wuxincheng.next.util.Constants;
import com.wuxincheng.next.util.HttpsConnection;

/**
 * 微信登录验证
 * 
 * @author wuxincheng(wxcking)
 * @date 2015年7月24日 上午10:31:37 
 *
 */
@Controller
@RequestMapping("/oauth/wechat")
public class WechatLoginController {
	private static final Logger logger = LoggerFactory.getLogger(WechatLoginController.class);
	
	/**
	 * 用户授权后QQ后台返回信息
	 */
	@RequestMapping(value = "/callback", method=RequestMethod.GET)
	public String callback(Model model, HttpServletRequest request) {
		logger.info("接收微信用户登录返回的信息");
		
		// 接收到自定义state参数和微信的Code
		String state = request.getParameter("state");
		logger.info("返回数据 state={}", state);
		
		String code = request.getParameter("code");
		logger.info("返回数据 code={}", code);
		
		// 若用户禁止授权，则重定向后不会带上code参数，仅会带上state参数
		if (StringUtils.isEmpty(code)) {
			model.addAttribute(Constants.MSG_WARN, "您取消了微信登录操作");
			return "redirect:/product/list";
		}
		
		logger.info("开始获取 access_token");
		
		// 通过code获取access_token
		String accessTokenUrl = WechatConfig.GET_ACCESS_TOKEN_URL.replace("CODE", code);
		
		logger.info("获取地址 accessTokenUrl={}", accessTokenUrl);
		
		try {
			String response = HttpsConnection.doGet(accessTokenUrl, null, 500, 1000);
			logger.info("接收的返回 response={}", response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/**
		// 发送GET请求并处理返回数据
		JSONObject responseJSON = HttpsClient.httpsRequest(accessTokenUrl, "GET", null);
		logger.info("请求的返回信息 responseJSONObject={}", responseJSON);
		if (null == responseJSON) {
			model.addAttribute(Constants.MSG_WARN, "微信返回数据为空");
			return "redirect:/product/list";
		}
		logger.info("已获取到access_token");

		String accessToken = responseJSON.getString("access_token");
		String openid = responseJSON.getString("openid");
		responseJSON.getString("refresh_token");
		
		logger.info("获取到 accessToken={}", accessToken);
		logger.info("获取到 openid={}", openid);
		
		logger.info("开始获取用户信息");
		// 获取用户信息
		String getUserinfoUrl = WeChatConfig.GET_USERINFO_URL.replaceAll("ACCESS_TOKEN", accessToken).replaceAll("OPENID", openid);
		
		JSONObject responseUserJSON = HttpsClient.httpsRequest(getUserinfoUrl, "GET", null);
		
		logger.info("获取用户信息 responseUserJSON={}", responseUserJSON);
		 */
		
		model.addAttribute(Constants.MSG_INFO, "微信登录成功");
		
		return "redirect:/product/list";
	}
}
