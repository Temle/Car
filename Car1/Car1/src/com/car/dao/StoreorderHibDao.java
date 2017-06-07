package com.car.dao;

import java.util.List;

import com.car.domain.Storeorder;

public interface StoreorderHibDao extends BaseHibDao<Storeorder>{
	//按照id查询
	public Storeorder findById(int id);
	
	//分页查找
	//按照id查找
	public List findPageById(int id,int pageNo,int pageSize);
	
	//外键查询
	//按照PersonId查询
	public List findByPersonId(int personId);
	//按照StoreId查询
	public List findByStoreId(int storeId);
	//按照StoreProductId查询
	public List findBySotreProductId(int storeProductId);
	
	//根据personID分页查找
	public List findByPersonIdByPage(int personId,int pageNo,int pageSize);
	
	//根据storeID分页查找
	public List findByStoreIdByPage(int storeId,int pageNo,int pageSize);

}
