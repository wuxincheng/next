package com.wuxincheng.next.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wuxincheng.next.dao.UserDao;
import com.wuxincheng.next.model.User;
import com.wuxincheng.next.util.Constants;

@Service("userService")
public class UserService {

	@Resource
	private UserDao userDao;
	
	public User checkLogin(String loginEmail) {
		return userDao.queryByLoginEmail(loginEmail);
	}

	public void register(User user) {
		user.setUserState(Constants.DEFAULT_STATE);
		user.setCollectPermission(Constants.DEFAULT_STATE);
		userDao.register(user);
	}

}
