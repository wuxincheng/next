package com.wuxincheng.next.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wuxincheng.next.dao.CollectDao;
import com.wuxincheng.next.dao.CollectUserDao;
import com.wuxincheng.next.model.CollectUser;
import com.wuxincheng.next.util.Constants;
import com.wuxincheng.next.util.DateUtil;

@Service("collectUserService")
public class CollectUserService {

	@Resource
	private CollectUserDao collectUserDao;
	
	@Resource
	private CollectDao collectDao;

	public void insert(CollectUser collectUser) {
		collectUserDao.insert(collectUser);
	}

	public void delete(CollectUser collectUser) {
		collectUserDao.delete(collectUser);
	}
	
	public CollectUser query(Integer collectid, Integer userid) {
		CollectUser collectUser = new CollectUser();
		collectUser.setCollectid(collectid);
		collectUser.setUserid(userid);
		return collectUser = collectUserDao.query(collectUser);
	}

	public void collect(Integer collectid, Integer userid) {
		CollectUser deleteOrQueryCollectUser = new CollectUser();
		deleteOrQueryCollectUser.setCollectid(collectid);
		deleteOrQueryCollectUser.setUserid(userid);
		
		CollectUser querycu = collectUserDao.query(deleteOrQueryCollectUser);
		if (null == querycu) { // 收藏
			CollectUser collectUser = new CollectUser();
			collectUser.setCollectid(collectid);
			collectUser.setUserid(userid);
			collectUser.setCreateTime(DateUtil.getCurrentDate(new Date(), "yyyyMMdd HH:mm:ss"));
			collectUser.setCollectState(Constants.DEFAULT_STATE);
			
			collectUserDao.insert(collectUser);
			
			// 产品集收藏+1
			collectDao.addCollectSum(collectid+"");
		} else { // 取消收藏
			collectUserDao.delete(deleteOrQueryCollectUser);
			
			// 产品集收藏-1
			collectDao.cutCollectSum(collectid+"");
		}
	}

}
