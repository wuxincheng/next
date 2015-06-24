package com.wuxincheng.next.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.wuxincheng.next.dao.UserDao;
import com.wuxincheng.next.model.User;

@Repository("userService")
public class UserService {
	
	@Resource private UserDao userDao;

	public User query(String logiName) {
		User user = new User();
		user.setLogiName(logiName);
		return userDao.query(user);
	}
	
	public User login(String logiName, String loginPwd) {
		User user = new User();
		user.setLogiName(logiName);
		user.setLoginPwd(loginPwd);
		return userDao.query(user);
	}

	public void insert(User user) {
		this.userDao.insert(user);
	}

	public void update(User user) {
		this.userDao.update(user);
	}

	public void modifyPwd(User user) {
		this.userDao.modifyPwd(user);
	}

}
