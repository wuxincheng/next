package com.wuxincheng.next.oauth.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wuxincheng.next.oauth.helper.WechatHttpsHelper;
import com.wuxincheng.next.util.Constants;

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
	
	@Resource WechatHttpsHelper wechatHttpsHelper;
	
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
		
		logger.debug("开始获取 access_token");
		// 通过code获取access_token
		Map<String, String> responseMap = wechatHttpsHelper.getAccessTokenByCode(code);
		if (null == responseMap) {
			model.addAttribute(Constants.MSG_WARN, "获取微信AccessToken失败");
			return "redirect:/product/list";
		}
		
		logger.debug("开始获取用户个人信息");
		Map<String, String> responseUserInfoMap = wechatHttpsHelper.getUserInfoUnionID(
				responseMap.get("access_token"), responseMap.get("openid"));

		logger.info("个人信息获取成功 responseUserInfoMap={}", responseUserInfoMap);
		
		model.addAttribute(Constants.MSG_INFO, "微信登录成功");
		
		return "redirect:/product/list";
	}
	
}
