package com.wuxincheng.next.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wuxincheng.next.model.Collect;

@Repository("collectDao")
public class CollectDao extends BaseDao {

	@SuppressWarnings("unchecked")
	public List<Collect> queryAll() {
		return this.getSqlMapClientTemplate().queryForList("Collect.queryAll");
	}

	public void create(Collect collect) {
		this.getSqlMapClientTemplate().update("Collect.create", collect);
	}

	public Collect queryDetailByCollectid(String collectid) {
		return (Collect) this.getSqlMapClientTemplate().queryForObject("Collect.queryDetailByCollectid", collectid);
	}

}
