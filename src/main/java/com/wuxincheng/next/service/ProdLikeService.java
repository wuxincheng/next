package com.wuxincheng.next.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wuxincheng.next.dao.ProdLikeDao;
import com.wuxincheng.next.model.ProdLike;

@Service("prodLikeService")
public class ProdLikeService {

	@Resource
	private ProdLikeDao prodLikeDao;

	public void insert(ProdLike prodLike) {
		prodLikeDao.insert(prodLike);
	}

	public void delete(ProdLike prodLike) {
		prodLikeDao.delete(prodLike);
	}

}
