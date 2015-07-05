package com.wuxincheng.next.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wuxincheng.next.Pager;
import com.wuxincheng.next.dao.ProductDao;
import com.wuxincheng.next.model.Product;
import com.wuxincheng.next.util.Constants;
import com.wuxincheng.next.util.DateUtil;

/**
 * 产品Service
 * 
 * @author wuxincheng(wxcking)
 * @date 2015年6月26日 下午8:25:13
 * 
 */
@Service("productService")
public class ProductService {
	
	@Resource private ProductDao productDao;
	
	/**
	 * 发布产品
	 */
	public void post(Product product, Integer userid) throws Exception {
		Date date = new Date();
		
		product.setCommentSum(0);
		product.setLikeSum(0);
		product.setPostDate(DateUtil.getCurrentDate(date, Constants.DEFAULT_DATE));
		product.setProdState(Constants.DEFAULT_STATE);
		product.setPostDateTime(DateUtil.getCurrentDate(date, Constants.DEFAULT_DATE_FORMAT));
		product.setUserid(userid);
		
		productDao.post(product);
	}

	/**
	 * 根据日期分组统计
	 */
	public List<String> queryGroupByDate() {
		return productDao.queryGroupByDate();
	}

	/**
	 * 查询产品
	 */
	public Pager queryProductsByDate(List<String> groupDates) {
		Pager pager = new Pager();
		
		List<Map<String, List<Product>>> productMapList = new ArrayList<Map<String, List<Product>>>();
		
		for (String queryPostDate : groupDates) {
			List<Product> products = productDao.queryByPostDate(queryPostDate);
			Map<String, List<Product>> productMap = new HashMap<String, List<Product>>();
			productMap.put(queryPostDate, products);
			
			productMapList.add(productMap);
		}
		
		pager.setProductMapList(productMapList);
		
		return pager;
	}

	/**
	 * 根据产品编号查询详细信息
	 */
	public Product queryDetailByProdid(String prodid) {
		return productDao.queryDetailByProdid(prodid);
	}

	/**
	 * 根据产品集主键查询产品列表
	 */
	public List<Product> queryProductsByCollectid(String collectid) {
		return productDao.queryProductsByCollectid(collectid);
	}

}
