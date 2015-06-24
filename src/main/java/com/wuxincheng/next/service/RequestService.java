package com.wuxincheng.next.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wuxincheng.next.dao.RequestDao;
import com.wuxincheng.next.model.Request;

@Service("requestService")
public class RequestService {

	@Resource RequestDao requestDao;
	
	public void insert(Request request) {
		requestDao.insert(request);
	}

}
