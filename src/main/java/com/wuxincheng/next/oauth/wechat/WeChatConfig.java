package com.wuxincheng.next.oauth.wechat;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 微信相关配置
 * 
 * @author wuxincheng(wxcking)
 * @date 2015年7月27日 下午2:19:23
 * 
 */
public class WeChatConfig {
	/** 应用唯一标识 appid */
	public static final String APPID = "wx8bc224d6280b4ace";

	/** AppSecret */
	public static final String APP_SECRET = "9c32c2593dae71344bc1cb1973e0969e";

	/** 返回地址 */
	public static final String REDIRECT_URI = "http://www.zhuanlemei.com/top/oauth/wechat/callback";

	/** 应用授权作用域, 网页应用 */
	public static final String SCOPE = "snsapi_login";

	public static final String STATE = "";

	/** 请求CODE地址 */
	public static String REQUEST_CODE_URL = "https://open.weixin.qq.com/connect/qrconnect?appid="
			+ APPID + "&redirect_uri=" + REDIRECT_URI + "&response_type=code&scope=" + SCOPE
			+ "&state=STATE#wechat_redirect";

	/** 获取access_token地址 */
	public static String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
			+ APPID + "&secret=" + APP_SECRET + "&code=CODE&grant_type=authorization_code";
	
	/** 获取用户个人信息（UnionID机制） */
	public static String GET_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";

	public static void main(String[] args) {
		try {
			System.out.println(URLEncoder.encode(REDIRECT_URI, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(REQUEST_CODE_URL);
	}

}
