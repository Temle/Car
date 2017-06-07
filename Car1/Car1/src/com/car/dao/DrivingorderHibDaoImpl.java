package com.car.dao;

import java.sql.Date;
import java.util.List;

import com.car.domain.Drivingorder;

public class DrivingorderHibDaoImpl extends BaseDaoHibImpl<Drivingorder> implements DrivingorderHibDao {

	@Override
	public Drivingorder findByID(int id) {
		// TODO Auto-generated method stub
		String hql="from Drivingorder dc where dc.id="+id;
		return super.find(hql).get(0);
	}
	
	@Override
	public Drivingorder findByDateAndPrice(Date date, Double price) {
		String hql="from Drivingorder as dc where dc.date="+date+" and dc.price="+price;
		return super.find(hql).get(0);
	}
	
	@Override
	public List findBydschoolID(int dschoolID) {
		// TODO Auto-generated method stub
		String hql="from Drivingorder dc where dc.drivingschool.id="+dschoolID;
		List<Drivingorder> list=this.find(hql);
		return list;
	}

	@Override
	public List findBypersonID(int personID) {
		// TODO Auto-generated method stub
		String hql="from Drivingorder dc where dc.person.id="+personID;
		List<Drivingorder> list=this.find(hql);
		return list;
	}

}
