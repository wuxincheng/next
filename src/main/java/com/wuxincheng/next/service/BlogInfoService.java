package com.wuxincheng.next.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wuxincheng.next.dao.BlogInfoDao;
import com.wuxincheng.next.model.BlogInfo;
import com.wuxincheng.next.util.Constants;
import com.wuxincheng.next.util.Validation;

/**
 * 博客信息
 * 
 * @author wuxincheng
 *
 */
@Service("blogInfoService")
public class BlogInfoService {

	@Resource private BlogInfoDao blogInfoDao;
	
	public Map<String, Object> queryPager(int start, int end) {
		// 返回结果
		Map<String, Object> reault = new HashMap<String, Object>();
		
		// 查询条件
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", start);
		params.put("end", end);
		
		int totalCount = blogInfoDao.queryCount(); // 总记录数
		List<BlogInfo> blogInfos = blogInfoDao.queryPager(params); // 当前页的数据
		
		reault.put("blogInfos", blogInfos);
		reault.put("totalCount", totalCount);
		
		return reault;
	}
	
	public List<BlogInfo> queryAll() {
		return blogInfoDao.queryAll();
	}
	
	public BlogInfo queryByBlogId(String blogId) {
		return blogInfoDao.queryByBlogId(blogId);
	}

	public void updateReadCount(String blogId) {
		blogInfoDao.updateReadCount(blogId);
	}

	public List<BlogInfo> queryRead(String line, String orderby) {
		// 判断是否为正整数, 如果是则返回空
		if (!Validation.isInt(line, "+")) {
			return null;
		}
		
		Integer intLine = Integer.parseInt(line);
		
		if (Constants.ORDER_BY_DESC.equals(orderby)) {
			return blogInfoDao.queryTopRead(intLine);
		} else if (Constants.ORDER_BY_ASC.equals(orderby)) {
			return blogInfoDao.queryFooterRead(intLine);
		} else {
			return null;
		}
	}

}
