package com.wuxincheng.next.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wuxincheng.next.model.Collection;
import com.wuxincheng.next.model.Product;
import com.wuxincheng.next.service.CollectionService;
import com.wuxincheng.next.service.ProductService;
import com.wuxincheng.next.util.Constants;
import com.wuxincheng.next.util.StringUtil;
import com.wuxincheng.next.util.Validation;

/**
 * 产品集
 * 
 * @author wuxincheng(wxcking)
 * @date 2015年7月1日 下午10:30:45 
 *
 */
@Controller
@RequestMapping("/collection")
public class CollectionController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(CollectionController.class);
	
	@Autowired
	CollectionService collectionService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request) {
		logger.info("显示产品集列表");
		
		requestMessageProcess(request);
		
		List<Collection> collections = collectionService.queryAll();
		
		request.setAttribute("collections", collections);
		
		return "collect/list";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(HttpServletRequest request) {
		logger.info("显示添加产品集页面");
		
		request.setAttribute(Constants.CURRENT_USERID, getCurrentUserid(request));
		
		return "collect/edit";
	}
	
	@RequestMapping(value = "/create")
	public String create(Model model, Collection collection) {
		logger.info("添加新的产品集 collection={}", StringUtil.toStringMultiLine(collection));
		
		// 基本验证
		
		try {
			collectionService.create(collection);
		} catch (Exception e) {
			
		}
		
		return "redirect:detail";
	}
	
	@RequestMapping(value = "/detail")
	public String detail(HttpServletRequest request, String collectionid) {
		logger.info("显示产品集 collectionid={}", collectionid);
		
		requestMessageProcess(request);
		
		if (StringUtils.isEmpty(collectionid) || !Validation.isIntPositive(collectionid)) {
			return "redirect:list";
		}
		
		Collection collection = collectionService.queryDetailByCollectionid(collectionid);
		if (null == collection) {
			return "redirect:list";
		}
		
		List<Product> products = productService.queryProductsByCollectionid(collectionid);
		
		request.setAttribute("products", products);
		request.setAttribute("collection", collection);
		
		return "collect/detail";
	}

}
