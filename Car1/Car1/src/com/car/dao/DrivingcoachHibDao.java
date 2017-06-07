package com.car.dao;

import java.util.List;

import com.car.domain.Drivingcoach;

public interface DrivingcoachHibDao extends BaseHibDao<Drivingcoach>{
	
	//根据ID进行查询
	public Drivingcoach findByID(int id);
	
	//根据教练姓名进行查询
	public Drivingcoach findByName(String name);
	
	//外键查询
	//按照dschoolID查询
	public List findBydschoolID(int dschoolID);

}
