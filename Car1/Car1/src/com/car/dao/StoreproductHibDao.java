package com.car.dao;

import java.util.List;

import com.car.domain.Storeproduct;

public interface StoreproductHibDao extends BaseHibDao<Storeproduct>{
	//产品通常是和店铺绑定的，所以查询时应该先确定店铺，然后从店铺中获取到产品的id，再进行查询
	//所以只提供id查询
	//按照产品id查询
	public Storeproduct findById(int id);
	
	//分页查找找
	//按照id查找
	public List findPageById(int id,int pageNo,int pageSize);
	
	
	//外键查询
	//按照StoreId查询
	public List findByStoreId(int storeId);
	
	//根据StoredId查找商家服务
	public List findByPageByStoreId(int stordId,int pageNo,int pageSize);
	
}
