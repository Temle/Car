package com.car.dao;

import java.util.List;


import com.car.domain.Person;

public class PersonHibDaoImpl extends BaseDaoHibImpl<Person> implements PersonHibDao{

	@Override
	public Person findVip(int vipID) {
		// TODO Auto-generated method stub
		String sql = "from Person person where person.vip.id="+vipID;
		if(super.find(sql).size()>0)
			return super.find(sql).get(0);
		else return null;
	}

	@Override
	public Person findStore(int storeID) {
		// TODO Auto-generated method stub
		String sql = "from Person person where person.store.id="+storeID;
		if(super.find(sql).size()>0)
			return super.find(sql).get(0);
		else return null;
	}

	@Override
	public Person findPark(int parkID) {
		// TODO Auto-generated method stub
		String sql = "from Person person where person.park.id="+parkID;
		if(super.find(sql).size()>0)
			return super.find(sql).get(0);
		else return null;
	}

	@Override
	public Person findDivingSchool(int divingSchoolID) {
		// TODO Auto-generated method stub
		String sql = "from Person person where person.drivingschool.id="+divingSchoolID;
		if(super.find(sql).size()>0)
			return super.find(sql).get(0);
		else return null;
	}

	@Override
	public Person findID(int ID) {
		// TODO Auto-generated method stub
		String sql = "from Person person where person.id="+ID;
		if(super.find(sql).size()>0)
			return super.find(sql).get(0);
		else return null;
	}

	@Override
	public List findName(String name) {
		// TODO Auto-generated method stub
		String sql = "from Person person where person.name='"+name+"'";
		return super.find(sql);
	}

	@Override
	public List findPageByName(String name, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String sql = "from Person person where person.name='"+name+"'";
		return super.findByPage(sql, pageNo, pageSize);
	}

	@Override
	public Person findByPhoneNum(String phoneNum) {
		// TODO Auto-generated method stub
		String sql = "from Person person where person.phoneNumber="+phoneNum;
		if(super.find(sql).size()>0)
			return super.find(sql).get(0);
		else return null;
	}


}
