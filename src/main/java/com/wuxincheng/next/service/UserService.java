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
	
	/**
	 * 根据邮箱查询用户
	 */
	public User checkLogin(String loginEmail) {
		return userDao.queryByLoginEmail(loginEmail);
	}

	/**
	 * 新增用户
	 */
	public void register(User user) {
		user.setUserState(Constants.DEFAULT_STATE);
		user.setCollectPermission(Constants.DEFAULT_STATE);
		userDao.register(user);
	}

	/**
	 * 验证授权登录用户
	 */
	public User validateOAuthUser(User oauthUser) {
		User queryOAuthUser = userDao.queryByOAuthOpenid(oauthUser.getOpenID());
		
		if (queryOAuthUser == null) {
			// 记录这条信息
			this.register(oauthUser);
		} else {
			// 更新这条信息
			queryOAuthUser.setNickName(oauthUser.getNickName());
			queryOAuthUser.setSocialPicPath(oauthUser.getSocialPicPath());
			queryOAuthUser.setAccessToken(oauthUser.getAccessToken());
			queryOAuthUser.setTokenExpireIn(oauthUser.getTokenExpireIn());
			
			this.updateInfo(queryOAuthUser);
		}
		
		return queryOAuthUser;
	}

	/**
	 * 更新用户信息
	 */
	private void updateInfo(User user) {
		userDao.updateInfo(user);
	}

}
