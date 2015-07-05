package com.wuxincheng.next.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wuxincheng.next.dao.CollectDao;
import com.wuxincheng.next.model.Collect;
import com.wuxincheng.next.util.Constants;
import com.wuxincheng.next.util.DateUtil;

@Service("collectService")
public class CollectService {
	
	@Resource 
	private CollectDao collectDao;

	/**
	 * 查询所有产品集
	 */
	public List<Collect> queryAll() {
		return collectDao.queryAll();
	}

	/**
	 * 创建产品集
	 */
	public void create(Collect collect) {
		String currentDate = DateUtil.getCurrentDate(new Date(), "yyyyMMdd HH:mm:ss");
		collect.setCollectSum(0);
		collect.setProductSum(0);
		collect.setCreateTime(currentDate);
		collect.setUpdateTime(currentDate);
		collect.setUpdateState(Constants.DEFAULT_STATE);
		collect.setCollectState(Constants.DEFAULT_STATE);
		collectDao.create(collect);
	}

	/**
	 * 根据产品集主键查询详细
	 */
	public Collect queryDetailByCollectid(String collectid) {
		return collectDao.queryDetailByCollectid(collectid);
	}
	
}
