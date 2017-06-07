package com.car.dao;

import java.util.List;

import com.car.domain.Storenotification;

public interface StorenotificationHibDao extends BaseHibDao<Storenotification>{
	//按照id查询
	public Storenotification findById(int id);
	
	//分页查找
	//按照id查找
	public List findPageById(int id,int pageNo,int pageSize);
	
	//外键查询
	//按照商店id查询
	public Storenotification findByStoreId(int storeId);
	
}
