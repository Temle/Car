package com.car.dao;

import java.util.List;

import com.car.domain.Drivingcompanion;

public interface DrivingCompanionHibDao extends BaseHibDao<Drivingcompanion>{
	
	//根据主键查找
	public Drivingcompanion findById(int id);
	
	//分页根据personID查询
	public List<Drivingcompanion> findByPagePid(int personId,int pageNo,int pageSize);
	
	//根据年龄区间进行查询
	public List<Drivingcompanion> findByPageAge(int starAge,int endAge,int pageNo,int pageSize);
	
	//根据价格区间查找
	public List<Drivingcompanion> findByPagePrice(Double price,Double price2,int pageNo,int pageSize);
	
	//根据personID进行查询
	public Drivingcompanion find(int id,int personId);
	
	//根据personId单独进行查询
	public List<Drivingcompanion> findByPerson(int personId);
	
	//根据年龄区间进行查询
	public List<Drivingcompanion> findByAge(int starAge,int endAge);
	
	//根据年龄和价格查找
	public List<Drivingcompanion> findByAP(int age,Double price);
		
	//根据价格区间查找
	public List<Drivingcompanion> findByPrice(Double price,Double price2);
	
	//根据带占位符参数HQL语句查询实体
	public List<Drivingcompanion> find(String hql, Object... params);
				
	//根据页面实现查询
	public List<Drivingcompanion> findByPage(String hql, int pageNo, int pageSize);
			
	//根据Hql语句和页面查询
	public List<Drivingcompanion> findByPage(String hql, int pageNo, int pageSize,Object... params);
}
