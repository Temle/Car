package com.car.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.car.domain.User;
import com.car.util.HibernateUtil;

public class UserHibDaoImpl extends BaseDaoHibImpl<User> implements UserHibDao{

	@Override
	public User findPersonID(int personID) {
		// TODO Auto-generated method stub
		String sql = "from User user where user.person.id="+personID;
		if(super.find(sql).size()>0)
			return super.find(sql).get(0);
		else return null;
	}

	@Override
	public User findID(int ID) {
		// TODO Auto-generated method stub
		String sql = "from User user where user.id="+ID;
		if(super.find(sql).size()>0)
			return super.find(sql).get(0);
		else return null;
	}

	@Override
	public List findUsername(String username) {
		// TODO Auto-generated method stub
		String sql = "from User user where user.username='"+username+"'";
		return super.find(sql);
	}

	@Override
	public List findPageByUsername(String username, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String sql = "from User user where user.username='"+username+"'";
		return super.findByPage(sql, pageNo, pageSize);
	}

}
