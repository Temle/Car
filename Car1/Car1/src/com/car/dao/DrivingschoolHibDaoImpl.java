package com.car.dao;

import java.util.List;

import com.car.domain.Drivingschool;

public class DrivingschoolHibDaoImpl extends BaseDaoHibImpl<Drivingschool> implements DrivingschoolHibDao {

	@Override
	public Drivingschool findById(int id) {
		// TODO Auto-generated method stub
		String hql="from Drivingschool dc where dc.id="+id;
		List<Drivingschool> list=super.find(hql);
		for(Drivingschool ds:list)
			return ds;
		return null;
	}

	@Override
	public Drivingschool findByNameAndAddress(String name, String address) {
		// TODO Auto-generated method stub
		String hql="from Drivingschool dc where dc.name="+name+" and dc.address="+address;
		return super.find(hql).get(0);
	}

	@Override
	public Drivingschool findByPriceAndType(Double price, String type) {
		// TODO Auto-generated method stub
		String hql="from Drivingschool as dc where dc.price="+price+" and dc.type="+type;
		return super.find(hql).get(0);
	}

	@Override
	public List findBypointID(int pointID) {
		// TODO Auto-generated method stub
		String hql="from Drivingschool dc where dc=dc.point.ID="+pointID;
		List<Drivingschool> list=this.find(hql);
		return list;
	}

	@Override
	public Drivingschool findByphoneNumber(String phoneNumber) {
		String hql="from Drivingschool dc where dc.phoneNumber="+phoneNumber;
		List<Drivingschool> list=super.find(hql);
		for(Drivingschool ds:list)
			return ds;
		return null;
	}

}
