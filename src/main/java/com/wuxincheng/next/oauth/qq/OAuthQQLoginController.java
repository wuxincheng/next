package com.wuxincheng.next.oauth.qq;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.PageFans;
import com.qq.connect.api.qzone.Topic;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.GeneralResultBean;
import com.qq.connect.javabeans.qzone.PageFansBean;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.javabeans.weibo.Company;
import com.qq.connect.oauth.Oauth;

/**
 * QQ授权登录
 * 
 * @author wuxincheng(wxcking) 
 * @date 2015年7月14日 下午5:46:49 
 *
 */
@Controller
@RequestMapping("/oauth/qq")
public class OAuthQQLoginController {

	private static final Logger logger = LoggerFactory.getLogger(OAuthQQLoginController.class);

	@RequestMapping(value = "/login")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");

		try {
			response.sendRedirect(new Oauth().getAuthorizeURL(request));
		} catch (Exception e) {
			logger.error("连接登录QQ异常", e);
		}
	}

	@RequestMapping(value = "/afterLogin")
	public void afterLogin(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");

		try {
			PrintWriter out = response.getWriter();

			AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(request);

			String accessToken = null, openID = null;
			long tokenExpireIn = 0L;

			if (accessTokenObj.getAccessToken().equals("")) {
				// 我们的网站被CSRF攻击了或者用户取消了授权
				// 做一些数据统计工作
				System.out.print("没有获取到响应参数");
			} else {
				accessToken = accessTokenObj.getAccessToken();
				tokenExpireIn = accessTokenObj.getExpireIn();

				request.getSession().setAttribute("demo_access_token", accessToken);
				request.getSession().setAttribute("demo_token_expirein",
						String.valueOf(tokenExpireIn));

				// 利用获取到的accessToken 去获取当前用的openid -------- start
				OpenID openIDObj = new OpenID(accessToken);
				openID = openIDObj.getUserOpenID();

				out.println("欢迎你，代号为 " + openID + " 的用户!");
				request.getSession().setAttribute("demo_openid", openID);
				out.println("<a href=" + "/shuoshuoDemo.html"
						+ " target=\"_blank\">去看看发表说说的demo吧</a>");
				// 利用获取到的accessToken 去获取当前用户的openid --------- end

				out.println("<p> start -----------------------------------利用获取到的accessToken,openid 去获取用户在Qzone的昵称等信息 ---------------------------- start </p>");
				UserInfo qzoneUserInfo = new UserInfo(accessToken, openID);
				UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
				out.println("<br/>");
				if (userInfoBean.getRet() == 0) {
					out.println(userInfoBean.getNickname() + "<br/>");
					out.println(userInfoBean.getGender() + "<br/>");
					out.println("黄钻等级： " + userInfoBean.getLevel() + "<br/>");
					out.println("会员 : " + userInfoBean.isVip() + "<br/>");
					out.println("黄钻会员： " + userInfoBean.isYellowYearVip() + "<br/>");
					out.println("<image src=" + userInfoBean.getAvatar().getAvatarURL30()
							+ "/><br/>");
					out.println("<image src=" + userInfoBean.getAvatar().getAvatarURL50()
							+ "/><br/>");
					out.println("<image src=" + userInfoBean.getAvatar().getAvatarURL100()
							+ "/><br/>");
				} else {
					out.println("很抱歉，我们没能正确获取到您的信息，原因是： " + userInfoBean.getMsg());
				}
				out.println("<p> end -----------------------------------利用获取到的accessToken,openid 去获取用户在Qzone的昵称等信息 ---------------------------- end </p>");

				out.println("<p> start ----------------------------------- 验证当前用户是否为认证空间的粉丝------------------------------------------------ start <p>");
				PageFans pageFansObj = new PageFans(accessToken, openID);
				PageFansBean pageFansBean = pageFansObj.checkPageFans("97700000");
				if (pageFansBean.getRet() == 0) {
					out.println("<p>验证您" + (pageFansBean.isFans() ? "是" : "不是")
							+ "QQ空间97700000官方认证空间的粉丝</p>");
				} else {
					out.println("很抱歉，我们没能正确获取到您的信息，原因是： " + pageFansBean.getMsg());
				}
				out.println("<p> end ----------------------------------- 验证当前用户是否为认证空间的粉丝------------------------------------------------ end <p>");

				out.println("<p> start -----------------------------------利用获取到的accessToken,openid 去获取用户在微博的昵称等信息 ---------------------------- start </p>");
				com.qq.connect.api.weibo.UserInfo weiboUserInfo = new com.qq.connect.api.weibo.UserInfo(
						accessToken, openID);
				com.qq.connect.javabeans.weibo.UserInfoBean weiboUserInfoBean = weiboUserInfo
						.getUserInfo();
				if (weiboUserInfoBean.getRet() == 0) {
					// 获取用户的微博头像----------------------start
					out.println("<image src=" + weiboUserInfoBean.getAvatar().getAvatarURL30()
							+ "/><br/>");
					out.println("<image src=" + weiboUserInfoBean.getAvatar().getAvatarURL50()
							+ "/><br/>");
					out.println("<image src=" + weiboUserInfoBean.getAvatar().getAvatarURL100()
							+ "/><br/>");
					// 获取用户的微博头像 ---------------------end

					// 获取用户的生日信息 --------------------start
					out.println("<p>尊敬的用户，你的生日是： " + weiboUserInfoBean.getBirthday().getYear()
							+ "年" + weiboUserInfoBean.getBirthday().getMonth() + "月"
							+ weiboUserInfoBean.getBirthday().getDay() + "日");
					// 获取用户的生日信息 --------------------end

					StringBuffer sb = new StringBuffer();
					sb.append("<p>所在地:" + weiboUserInfoBean.getCountryCode() + "-"
							+ weiboUserInfoBean.getProvinceCode() + "-"
							+ weiboUserInfoBean.getCityCode() + weiboUserInfoBean.getLocation());

					// 获取用户的公司信息---------------------------start
					ArrayList<Company> companies = weiboUserInfoBean.getCompanies();
					if (companies.size() > 0) {
						// 有公司信息
						for (int i = 0, j = companies.size(); i < j; i++) {
							sb.append("<p>曾服役过的公司：公司ID-" + companies.get(i).getID() + " 名称-"
									+ companies.get(i).getCompanyName() + " 部门名称-"
									+ companies.get(i).getDepartmentName() + " 开始工作年-"
									+ companies.get(i).getBeginYear() + " 结束工作年-"
									+ companies.get(i).getEndYear());
						}
					} else {
						// 没有公司信息
					}
					// 获取用户的公司信息---------------------------end

					out.println(sb.toString());

				} else {
					out.println("很抱歉，我们没能正确获取到您的信息，原因是： " + weiboUserInfoBean.getMsg());
				}
				out.println("<p> end -----------------------------------利用获取到的accessToken,openid 去获取用户在微博的昵称等信息 ---------------------------- end </p>");
			}
		} catch (QQConnectException e) {
		} catch (IOException e) {
		}
	}

	@RequestMapping(value = "/loginCheck")
	public void loginCheck(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
		}
		String con = request.getParameter("con");
		HttpSession session = request.getSession();
		String accessToken = (String) session.getAttribute("demo_access_token");
		String openID = (String) session.getAttribute("demo_openid");
		System.out.println(accessToken);
		System.out.println(openID);
		// 请开发者自行校验获取的con值是否有效
		if (con != "") {
			Topic topic = new Topic(accessToken, openID);
			try {
				GeneralResultBean grb = topic.addTopic(con);
				if (grb.getRet() == 0) {
					response.getWriter()
							.println(
									"<a href=\"http://www.qzone.com\" target=\"_blank\">您的说说已发表成功，请登录Qzone查看</a>");
				} else {
					response.getWriter().println("很遗憾的通知您，发表说说失败！原因： " + grb.getMsg());
				}
			} catch (Exception e) {
				System.out.println("抛异常了？");
			}
		} else {
			System.out.println("获取到的值为空？");
		}
	}

}