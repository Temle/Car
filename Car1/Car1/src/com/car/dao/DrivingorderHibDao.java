package com.car.dao;

import java.sql.Date;
import java.util.List;

import com.car.domain.Drivingorder;

public interface DrivingorderHibDao extends BaseHibDao<Drivingorder>{
	
	//根据id查找
	public Drivingorder findByID(int id);
	
	//根据日期和价格查找
	public Drivingorder findByDateAndPrice(Date date,Double price);
	
	//外键查询
	//根据dschoolID进行查询
	public List findBydschoolID(int dschoolID);
	
	//根据personID进行查询
	public List findBypersonID(int personID);
}
