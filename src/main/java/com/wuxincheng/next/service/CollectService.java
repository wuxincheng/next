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
	 * 根据产品集主键查询详细
	 */
	public Collect queryDetailByCollectid(String collectid) {
		return collectDao.queryDetailByCollectid(collectid);
	}

	/**
	 * 查询用户发布的榜单
	 */
	public List<Collect> queryByUserid(String userid) {
		return collectDao.queryByUserid(userid);
	}

	/**
	 * 创建或更新产品集（现命名为榜单）
	 */
	public void createOrUpdate(Collect collect) {
		if (null == collect) {
			return;
		}
		
		// TODO Auto-generated method stub
		
		if (collect.getCollectid() != null) {
			
		} else {
			String currentDate = DateUtil.getCurrentDate(new Date(), "yyyyMMdd HH:mm:ss");
			collect.setCollectSum(0);
			collect.setProductSum(0);
			collect.setCreateTime(currentDate);
			collect.setUpdateTime(currentDate);
			collect.setUpdateState(Constants.DEFAULT_STATE);
			collect.setCollectState(Constants.DEFAULT_STATE);
			collectDao.create(collect);
		}
		
	}
	
}
