package com.wuxincheng.next.dao;

import org.springframework.stereotype.Repository;

import com.wuxincheng.next.model.ProdLike;

@Repository("prodLikeDao")
public class ProdLikeDao extends BaseDao {

	public void insert(ProdLike prodLike) {
		this.getSqlMapClientTemplate().update("ProdLike.insert", prodLike);
	}
	
	public void delete(ProdLike prodLike) {
		this.getSqlMapClientTemplate().delete("ProdLike.delete", prodLike);
	}
	
	public ProdLike query(ProdLike prodLike) {
		return (ProdLike)this.getSqlMapClientTemplate().queryForObject("ProdLike.query", prodLike);
	}
	
}
