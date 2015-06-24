package com.wuxincheng.next.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wuxincheng.next.model.Message;
import com.wuxincheng.next.model.User;
import com.wuxincheng.next.service.MessageService;
import com.wuxincheng.next.util.Constants;

/**
 * 用户留言
 * 
 * @author wuxincheng
 *
 */
@Controller
@RequestMapping("/message")
public class MessageController {
	
	private static Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Autowired MessageService messageService;
	
	@RequestMapping(value = "/")
	public String message(Model model) {
		// 其它参数设置
		model.addAttribute(Constants.TOP_NAV_FLAG, "message");
		
		return "message";
	}
	
	@RequestMapping(value = "/doMessage")
	public String doUserMsg(@RequestParam String email, @RequestParam String context, 
			HttpServletRequest request, Model model) {
		logger.info("处理用户留言数据");
		String defaultPage = "message";
		
		if (null == email || "".equals(email) || context == null || "".equals(context)) {
			model.addAttribute("errorMsg", "邮箱和留言内容都不能为空");
			return defaultPage;
		}
		
		User user = (User)request.getSession().getAttribute("sessionUser");
		String username = user.getLogiName();
		
		Message message = new Message();
		message.setMsgId(messageService.queryMaxId());
		message.setMsgTitle(email);
		message.setMsgContent(context);
		message.setState("0");
		message.setUsername(username);
		
		messageService.insert(message);
		
		model.addAttribute("successMsg", "留言已经提交");
		
		model.addAttribute("mainMsg", 1);
		
		return defaultPage;
	}
	
}
