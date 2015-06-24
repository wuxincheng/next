package com.wuxincheng.next.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wuxincheng.next.model.BlogInfo;

@Repository("blogInfoDao")
public class BlogInfoDao extends BaseDao {

	@SuppressWarnings("unchecked")
	public List<BlogInfo> queryPager(Map<String, Object> params) {
		return this.getSqlMapClientTemplate().queryForList("BlogInfo.queryPager", params);
	}
	
	@SuppressWarnings("unchecked")
	public List<BlogInfo> queryAll() {
		return this.getSqlMapClientTemplate().queryForList("BlogInfo.queryAll");
	}
	
	public BlogInfo queryByBlogId(String blogId) {
		return (BlogInfo) this.getSqlMapClientTemplate().queryForObject("BlogInfo.queryByBlogId", blogId);
	}

	public void updateReadCount(String blogId) {
		this.getSqlMapClientTemplate().update("BlogInfo.updateReadCount", blogId);
	}

	@SuppressWarnings("unchecked")
	public List<BlogInfo> queryTopRead(Integer top) {
		return this.getSqlMapClientTemplate().queryForList("BlogInfo.queryTopRead");
	}

	@SuppressWarnings("unchecked")
	public List<BlogInfo> queryFooterRead(Integer top) {
		return this.getSqlMapClientTemplate().queryForList("BlogInfo.queryFooterRead");
	}
	
	public Integer queryCount() {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("BlogInfo.queryCount");
	}

}
