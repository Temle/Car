package com.car.dao;

import java.util.List;

import com.car.domain.User;

public interface UserHibDao extends BaseHibDao<User>{
	//����personID����User����
	public User findPersonID(int personID);
	//����ID����User����
	public User findID(int ID);
	//����username����User����
	public List findUsername(String username);
	
	
	//����username���ط�ҳUser�����б�
	public List findPageByUsername(String username, int pageNo,int pageSize);
}

