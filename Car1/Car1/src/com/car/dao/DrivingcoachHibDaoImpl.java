package com.car.dao;

import java.util.List;

import com.car.domain.Drivingcoach;

public class DrivingcoachHibDaoImpl extends BaseDaoHibImpl<Drivingcoach> implements DrivingcoachHibDao {

	@Override
	public Drivingcoach findByID(int id) {
		// TODO Auto-generated method stub
		String hql="from Drivingcoach as dc where dc.id="+id;
		return super.find(hql).get(0);
	}

	@Override
	public Drivingcoach findByName(String name) {
		String hql="from Drivingcoach as dc where dc.name="+name;
		return super.find(hql).get(0);
	}

	@Override
	public List findBydschoolID(int dschoolID) {
		// TODO Auto-generated method stub
		String hql="from Drivingcoach dc where dc.dschool.ID="+dschoolID;
		List<Drivingcoach> list=this.find(hql);
		return list;
	}

}