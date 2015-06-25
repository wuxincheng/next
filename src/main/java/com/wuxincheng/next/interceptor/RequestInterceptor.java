package com.wuxincheng.next.interceptor;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 访问拦截器
 * 
 * @author wuxincheng
 *
 */
public class RequestInterceptor implements HandlerInterceptor {

	private static Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);
	
	private String mappingURL; // 利用正则映射到需要拦截的路径

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

		try {
			// requestService.insert(requestInfo);
		} catch (Exception e) {
			
		}
		
		return true;
	}
	
	public void setMappingURL(String mappingURL) {
		this.mappingURL = mappingURL;
	}
	
}
