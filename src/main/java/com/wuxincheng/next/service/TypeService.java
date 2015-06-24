package com.wuxincheng.next.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wuxincheng.next.dao.TypeDao;
import com.wuxincheng.next.model.Type;

@Service("typeService")
public class TypeService {

	@Resource private TypeDao typeDao;
	
	public List<Type> queryAll() {
		return typeDao.queryAll();
	}

}
