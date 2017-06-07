package com.car.dao;

import java.util.Date;
import java.util.List;

import com.car.domain.Conment;

public interface CommentHibDao extends BaseHibDao<Conment> {
	//通过评论id查询
	Conment findById(int id);
	
	//通过personId查询
	List<Conment> findByPersonId(int personId);
	
	//通过psersonId和日期查询
	List<Conment> findByPersonIdAndDate(int psersonId,Date start,Date end);
	
	//通过personId查询
	List<Conment> findByPersonIdByPage(int personId,int pageNo,int pageSize);
		
	//通过psersonId和日期查询
	List<Conment> findByPersonIdAndDateByPage(int psersonId,Date start,Date end,int pageNo,int pageSize);

	//通过storeId查找商家的评论
	List findByPageByStoreId(String storeId,int pageNo,int pageSize);
	

	List<Conment> findByStoreId(int type,String storeid);
}
