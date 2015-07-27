package com.wuxincheng.next.oauth.wechat;

/**
 * 微信请求返回参数
 *
 * @author wuxincheng
 * @date 2015年6月3日 上午11:05:56
 * @version V1.0
 */
public class WechatResponseParam {

	/** 返回错误码 */
	public static final String ERRCODE = "errcode";
	
	/** 返回错误信息 */
	public static final String ERRMSG = "errmsg";
	
	/** 获取到的凭证 */
	public static final String ACCESS_TOKEN = "access_token";
	
	/** 凭证有效时间，单位：秒 */
	public static final String EXPIRES_IN = "expires_in";
	
	/** 公众号的唯一标识 */
	public static final String APPID = "appid";
	
	/** 授权后重定向的回调链接地址 */
	public static final String REDIRECTURI = "redirect_uri";
	
	/** 返回类型，请填写code */
	public static final String RESPONSE_TYPE = "code";
	
	/** 应用授权作用域 */
	public static final String SCOPE = "scope";
	
	/** 任意参数值 */
	public static final String STATE = "state";
	
	/** 直接在微信打开链接, 可以不填此参数, 做页面302重定向时候, 必须带此参数 */
	public static final String WECHAT_REDIRECT = "wechat_redirect";
	
	/** 任意参数值 */
	public static final String CODE = "code";
	
	/** 用户唯一标识. 请注意: 在未关注公众号时, 用户访问公众号的网页, 也会产生一个用户和公众号唯一的OpenID */
	public static final String OPENID = "openid";
	
	/** 用户刷新access_token */
	public static final String REFRESH_TOKEN = "refresh_token";
	
	/** 用户昵称 */
	public static final String NICKNAME = "nickname";
	
	/** 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知 */
	public static final String SEX = "sex";
	
	/** 用户个人资料填写的省份 */
	public static final String PROVINCE = "province";
	
	/** 普通用户个人资料填写的城市 */
	public static String CITY = "city";

	/** 国家，如中国为CN */
	public static String COUNTRY = "country";

	/**
	 * 用户头像， 最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
	 */
	public static String HEADIMGURL = "headimgurl";

	/** 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom） */
	public static String PRIVILEGE = "privilege";
	
	/** 消息类型 */
	public static String MSG_TYPE = "MsgType";
	
	/** 事件类型 */
	public static String EVENT = "Event";
	
	public static String TICKET = "ticket";
	
}
