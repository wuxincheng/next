package com.wuxincheng.next.dao;

import org.springframework.stereotype.Repository;

import com.wuxincheng.next.model.User;

@Repository("userDao")
public class UserDao extends BaseDao {

	public User queryByLoginEmail(String loginEmail) {
		return (User) this.getSqlMapClientTemplate().queryForObject("User.queryByLoginEmail", loginEmail);
	}

	public void register(User user) {
		this.getSqlMapClientTemplate().update("User.register", user);
	}

	public void updateInfo(User user) {
		this.getSqlMapClientTemplate().update("User.updateInfo", user);
	}

	public User queryByOAuthOpenid(String openID) {
		return (User) this.getSqlMapClientTemplate().queryForObject("User.queryByOAuthOpenid", openID);
	}
	
}
