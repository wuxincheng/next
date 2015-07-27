package com.wuxincheng.next.dao;

import java.util.List;
import java.util.Map;

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
	public List<Product> queryByPostDate(Map<String, String> queryMap) {
		return this.getSqlMapClientTemplate().queryForList("Product.queryByPostDate", queryMap);
	}

	public Product queryDetailByProdid(Map<String, String> queryMap) {
		return (Product) this.getSqlMapClientTemplate().queryForObject("Product.queryDetailByProdid", queryMap);
	}

	public void plusCommentSum(Integer prodid) {
		this.getSqlMapClientTemplate().update("Product.plusCommentSum", prodid+"");
	}

	@SuppressWarnings("unchecked")
	public List<Product> queryProductsByCollectid(String collectid) {
		return this.getSqlMapClientTemplate().queryForList("Product.queryProductsByCollectid", collectid);
	}

	public void score(Map<String, Object> like) {
		this.getSqlMapClientTemplate().update("Product.score", like);
	}

}
