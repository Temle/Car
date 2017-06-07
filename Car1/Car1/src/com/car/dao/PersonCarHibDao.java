package com.car.dao;

import java.util.List;

import com.car.domain.Personcar;

public interface PersonCarHibDao extends BaseHibDao<Personcar>{
	//根据personID返回Personcar对象
	List findPersonID(int personID);
	//根据ID返回Personcar对象
	Personcar findID(int ID);
	//根据ID返回PersonName对象
	List findPersonName(String name);
	
	//根据personID返回分页Personcar对象列表
	List findPageByPersonID(int personID, int pageNo,int pageSize);
	//根据personName返回分页Personcar对象列表
	List findPageByPersonName(String personName, int pageNo,int pageSize);
}
