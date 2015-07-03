package com.wuxincheng.next.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wuxincheng.next.dao.CollectionDao;
import com.wuxincheng.next.model.Collection;

@Service("collectionService")
public class CollectionService {
	
	@Resource 
	private CollectionDao collectionDao;

	/**
	 * 查询所有产品集
	 */
	public List<Collection> queryAll() {
		return collectionDao.queryAll();
	}

	/**
	 * 创建产品集
	 */
	public void create(Collection collection) {
		collectionDao.create(collection);
	}

	/**
	 * 根据产品集主键查询详细
	 */
	public Collection queryDetailByCollectionid(String collectionid) {
		return collectionDao.queryDetailByCollectionid(collectionid);
	}
	
}
