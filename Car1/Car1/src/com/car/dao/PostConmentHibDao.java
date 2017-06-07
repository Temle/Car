package com.car.dao;

import java.util.List;

import com.car.domain.Person;
import com.car.domain.Postconment;

public interface PostConmentHibDao extends BaseHibDao<Postconment> {
	//根据id查找回帖
	public List findPageById(int pageNo,int rowsPerpage,int id);
	
	//回帖总条数
	public long findRowCount(int id);
	
	//回帖总条数（根据Person)
	public long findRowCount(Person person);
	
	//回帖
	public void addPostconment(Postconment postconment);
	
	//根据Person查找回帖
	public List findPageByPerson(int pageNo,int rowsPerpage,Person person);
}
