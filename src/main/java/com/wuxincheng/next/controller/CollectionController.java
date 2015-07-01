package com.wuxincheng.next.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 产品集
 * 
 * @author wuxincheng(wxcking)
 * @date 2015年7月1日 下午10:30:45 
 *
 */
@Controller
@RequestMapping("/collection")
public class CollectionController {
	private static final Logger logger = LoggerFactory.getLogger(CollectionController.class);
	
	@RequestMapping(value = "/list")
	public String list(Model model) {
		logger.info("collection");
		
		return "collection/list";
	}

}
