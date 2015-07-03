package com.wuxincheng.next.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wuxincheng.next.model.Collection;

@Repository("productDao")
public class CollectionDao extends BaseDao {

	@SuppressWarnings("unchecked")
	public List<Collection> queryAll() {
		return this.getSqlMapClientTemplate().queryForList("Collection.queryAll");
	}

	public void create(Collection collection) {
		this.getSqlMapClientTemplate().update("Collection.create", collection);
	}

	public Collection queryDetailByCollectionid(String collectionid) {
		return (Collection) this.getSqlMapClientTemplate().queryForObject("Collection.queryDetailByCollectionid", collectionid);
	}

}
