package com.car.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.car.domain.Personcar;
import com.car.util.HibernateUtil;

public class PersonCarHibDaoImpl extends BaseDaoHibImpl<Personcar> implements PersonCarHibDao{

	@Override
	public List findPersonID(int personID) {
		// TODO Auto-generated method stub
		String sql = "from Personcar personcar where personcar.person.id="+personID;
		return super.find(sql);
	}

	@Override
	public Personcar findID(int ID) {
		// TODO Auto-generated method stub
		String sql = "from Personcar personcar where personcar.id="+ID;
		if(super.find(sql).size()>0)
			return super.find(sql).get(0);
		else return null;
	}

	@Override
	public List findPageByPersonID(int personID, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String sql = "from Personcar personcar where personcar.person.id="+personID;
		return super.findByPage(sql, pageNo, pageSize);
	}

	@Override
	public List findPersonName(String name) {
		// TODO Auto-generated method stub
		String sql = "from Personcar personcar where personcar.person.name='"+name+"'";
		return super.find(sql);
	}

	@Override
	public List findPageByPersonName(String personName, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String sql = "from Personcar personcar where personcar.person.name='"+personName+"'";
		return super.findByPage(sql, pageNo, pageSize);
	}

}
