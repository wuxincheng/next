package com.wuxincheng.next.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import com.wuxincheng.next.model.User;
import com.wuxincheng.next.util.Constants;

/**
 * Controller基类
 * 
 * @author wuxincheng(wxcking) 
 * @date 2015年6月29日 下午3:55:44 
 *
 */
@Controller
public class BaseController {

	/**
	 * 获取当前Session下的用户信息
	 */
	protected User getCurrentUser(HttpServletRequest request){
		return (User)request.getSession().getAttribute(Constants.CURRENT_USER);
	}
	
	/**
	 * 获取当前Session下的用户ID
	 */
	protected Integer getCurrentUserid(HttpServletRequest request){
		User user = getCurrentUser(request);
		return user.getUserid();
	}
	
}
