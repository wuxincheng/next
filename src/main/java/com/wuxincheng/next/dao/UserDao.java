package com.wuxincheng.next.dao;

import org.springframework.stereotype.Repository;

import com.wuxincheng.next.model.User;

@Repository("userDao")
public class UserDao extends BaseDao {

	public User query(User user) {
		return (User)this.getSqlMapClientTemplate().queryForObject("User.query", user);
	}

	public void insert(User user) {
		this.getSqlMapClientTemplate().insert("User.insert", user);
	}

	public void update(User user) {
		this.getSqlMapClientTemplate().update("User.update", user);
	}

	public void modifyPwd(User user) {
		this.getSqlMapClientTemplate().update("User.modifyPwd", user);
	}

}
