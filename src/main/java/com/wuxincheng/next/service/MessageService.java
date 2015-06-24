package com.wuxincheng.next.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.wuxincheng.next.dao.MessageDao;
import com.wuxincheng.next.model.Message;

/**
 * 用户留言
 * 
 * @author wuxincheng
 *
 */
@Repository("messageService")
public class MessageService {
	
	@Resource MessageDao messageDao;

	public void insert(Message message) {
		messageDao.insert(message);
	}

	public Integer queryMaxId() {
		return messageDao.queryMaxId();
	}
	
}
