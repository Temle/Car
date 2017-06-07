package com.car.dao;

import java.util.List;

import com.car.domain.Park;

public interface ParkHibDao extends BaseHibDao<Park>{
	 
	List FindByNameBypage(String name,int pageNo,int pageSize);
	Park FindById(int id);
	Park FindBypointId(int id);
	int RestNumber(int id,String name);
}
