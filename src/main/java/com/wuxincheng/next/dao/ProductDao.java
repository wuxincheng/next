package com.wuxincheng.next.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wuxincheng.next.model.Product;

@Repository("productDao")
public class ProductDao extends BaseDao {

	public void post(Product product) {
		this.getSqlMapClientTemplate().update("Product.post", product);
	}

	@SuppressWarnings("unchecked")
	public List<String> queryGroupByDate() {
		return this.getSqlMapClientTemplate().queryForList("Product.queryGroupByDate");
	}

	@SuppressWarnings("unchecked")
	public List<Product> queryByPostDate(String queryPostDate) {
		return this.getSqlMapClientTemplate().queryForList("Product.queryByPostDate", queryPostDate);
	}

	public Product queryDetailByProdid(String prodid) {
		return (Product) this.getSqlMapClientTemplate().queryForObject("Product.queryDetailByProdid", prodid);
	}

	public void plusCommentSum(Integer prodid) {
		this.getSqlMapClientTemplate().update("Product.plusCommentSum", prodid+"");
	}

	@SuppressWarnings("unchecked")
	public List<Product> queryProductsByCollectid(String collectid) {
		return this.getSqlMapClientTemplate().queryForList("Product.queryProductsByCollectid", collectid);
	}

}
