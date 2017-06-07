package com.car.dao;

import java.util.List;

import com.car.domain.User;

public interface UserHibDao extends BaseHibDao<User>{
	//根据personID返回User对象
	public User findPersonID(int personID);
	//根据ID返回User对象
	public User findID(int ID);
	//根据username返回User对象
	public List findUsername(String username);
	
	
	//根据username返回分页User对象列表
	public List findPageByUsername(String username, int pageNo,int pageSize);
}

