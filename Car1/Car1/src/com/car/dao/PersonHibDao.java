package com.car.dao;

import java.util.List;

import com.car.domain.Person;

public interface PersonHibDao extends BaseHibDao<Person>{
	//����vipID����User����
	Person findVip(int vipID);
	//����storeID����User����
	Person findStore(int storeID);
	//����parkID����User����
	Person findPark(int parkID);
	//����divingSchoolID����User����
	Person findDivingSchool(int divingSchoolID);
	//����ID����User����
	Person findID(int ID);
	//����name����User����
	List findName(String name);
	
	//根据电话号码来查找
	Person findByPhoneNum(String phoneNum);
	
	//����name���ط�ҳUser�����б�
	public List findPageByName(String name, int pageNo,int pageSize);
}
