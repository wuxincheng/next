package com.wuxincheng.next.interceptor;

import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wuxincheng.next.model.Request;
import com.wuxincheng.next.service.RequestService;
import com.wuxincheng.next.util.Constants;
import com.wuxincheng.next.util.Validation;

/**
 * 访问拦截器
 * 
 * @author wuxincheng
 *
 */
public class RequestInterceptor implements HandlerInterceptor {

	private static Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);
	
	private String mappingURL; // 利用正则映射到需要拦截的路径
	
	@Resource private RequestService requestService;

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, 
			Object arg2, Exception arg3) throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) {
		String url = request.getRequestURL().toString();
		String remoteAddress = request.getRemoteAddr();
		
		if (!(mappingURL == null || url.matches(mappingURL))) {
			logger.info("mappingURL：" + mappingURL);
        }
		
		String requestIp = url.substring(url.indexOf("//")+2, url.length());
		String requestSystemPath = requestIp.substring(requestIp.indexOf('/'), requestIp.length());
		
		if ("/".equals(requestSystemPath)) {
			return true;
		}
		
		String blogId = request.getParameter("blogId");
		String stype = request.getParameter("stype");
		Map<String, String[]> params = request.getParameterMap();
		
		StringBuffer requestOtherParam = new StringBuffer("");
		if (params != null && params.size() > 0) {
			for (Entry<String, String[]> entry : params.entrySet()) {
				requestOtherParam.append(entry.getKey()).append("=");
				String[] ss = entry.getValue();
				for (String string : ss) {
					requestOtherParam.append(string).append("&");
				}
				requestOtherParam.deleteCharAt(requestOtherParam.length()-1);
				requestOtherParam.append(",");
			}
			requestOtherParam.deleteCharAt(requestOtherParam.length()-1);
		}
		
		// 1. 记录访问日志
		logger.info("拦截访客信息：{IP地址=" + remoteAddress + ", 访问路径=" + requestSystemPath
				+ ", 接收到的访问参数=[" + requestOtherParam.toString() + "]}");
		
		if (requestOtherParam.length() > 200) { // 如果参数过大, 则进行截短处理
			requestOtherParam.delete(200, requestOtherParam.length()-1);
		}
		
		// 2. 记录到数据库: ip / 时间 / url / url参数
		Request requestInfo = new Request();
		requestInfo.setWebType(Constants.BLOG_MODE);
		requestInfo.setRequestIp(remoteAddress);
		
		/*
		// 在后台管理中会处理这个
		Map<String, String> ipInfo = IPUtil.getAddressByIp(remoteAddress);
		requestInfo.setIpAddress(ipInfo.get("address"));
		requestInfo.setCountry(ipInfo.get("country"));
		requestInfo.setRegion(ipInfo.get("region"));
		requestInfo.setCity(ipInfo.get("city"));
		 */
		
		requestInfo.setSystemPath(requestSystemPath);
		requestInfo.setBlogId(blogId);
		
		String socialType = null; // 来源类型
		
		if (!Validation.isBlank(stype)) { // stype社交平台类型不为空
			if (Constants.SOCIAL_GOOGLE_PLUS.equals(stype)) {
				socialType = Constants.SOCIAL_GOOGLE_PLUS;
			} else if (Constants.SOCIAL_FACEBOOK.equals(stype)) {
				socialType = Constants.SOCIAL_FACEBOOK;
			} else if (Constants.SOCIAL_TWITTER.equals(stype)) {
				socialType = Constants.SOCIAL_TWITTER;
			} else if (Constants.SOCIAL_LINKEDIN.equals(stype)) {
				socialType = Constants.SOCIAL_LINKEDIN;
			} else if (Constants.SOCIAL_QZONE.equals(stype)) {
				socialType = Constants.SOCIAL_QZONE;
			} else if (Constants.SOCIAL_TWEIBO.equals(stype)) {
				socialType = Constants.SOCIAL_TWEIBO;
			} else if (Constants.SOCIAL_WEIBO.equals(stype)) {
				socialType = Constants.SOCIAL_WEIBO;
			} else if (Constants.SOCIAL_WEIXIN.equals(stype)) {
				socialType = Constants.SOCIAL_WEIXIN;
			} else if (Constants.SOCIAL_RENREN.equals(stype)) {
				socialType = Constants.SOCIAL_RENREN;
			} else if (Constants.SOCIAL_TIEBA.equals(stype)) {
				socialType = Constants.SOCIAL_TIEBA;
			} else {
				socialType = Constants.SOCIAL_OTHER;
			}
		} else {
			socialType = "wuxincheng";
		}
		
		requestInfo.setSocialType(socialType);
		
		requestInfo.setParam(requestOtherParam.toString());
		requestInfo.setState("0");

		try {
			requestService.insert(requestInfo);
		} catch (Exception e) {
			
		}
		
		return true;
	}
	
	public void setMappingURL(String mappingURL) {
		this.mappingURL = mappingURL;
	}
	
}
