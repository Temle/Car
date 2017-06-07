package com.car.dao;

import java.util.List;

import com.car.domain.Store;

public interface StoreHibDao extends BaseHibDao<Store>{
	//TYPE 普通查询
	//按照Id查找
	public Store findById(int id);
	//按照城市查找
	public List findByCity(String city);
	//按照店铺名字查找
	public List findByName(String name);
	//按照是否通过审核查找
	//主要是辨别该店铺信息应该呈现给管理员审核 还是呈现给普通用户
	public List findByIsPass(String isPass);
	
	//按照城市分页查找
	public List findByPageByCity(String city,int pageNo,int pageSize);
	
	//TYPE 分页查找
	//按照id分页查找
	public List findPageById(int id,int pageNo,int pageSize);
	//按照城市查找
	public List findPageByCity(String city,int pageNo,int pageSize);
	//按照名字查找
	public List findPageByName(String name,int pageNo,int pageSize);
	
	//TYPE 外键查询
	//按照PointId查询
	public Store findByPointId(int pointId);
}
