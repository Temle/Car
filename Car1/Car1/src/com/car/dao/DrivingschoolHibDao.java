package com.car.dao;

import java.util.List;

import com.car.domain.Drivingschool;

public interface DrivingschoolHibDao extends BaseHibDao<Drivingschool>{
	
	//根据id进行查询
	public Drivingschool findById(int id);
	
	//根据驾校名称和地址进行查询
	public Drivingschool findByNameAndAddress(String name,String address);
	
	//根据价格和类型查找
	public Drivingschool findByPriceAndType(Double price,String type);
	
	public Drivingschool findByphoneNumber(String phoneNumber);
	//外键查询
	//根据驾校坐标查找
	public List findBypointID(int pointID);

}