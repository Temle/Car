package com.car.dao;

import java.util.Date;
import java.util.List;

import com.car.domain.Vip;

public class VipHibDaoImpl extends BaseDaoHibImpl<Vip> implements VipHibDao {

	@Override
	public Vip findById(int id) {
		// TODO Auto-generated method stub
		return super.get(Vip.class,id);
	}

	@Override
	public List<Vip> findByLevel(int level) {
		// TODO Auto-generated method stub
		String hql="from Vip as v where v.level="+level;
		return super.find(hql);
	}

	@Override
	public List<Vip> findByDate(Date start, Date end) {
		// TODO Auto-generated method stub
		String hql="from Vip as v where v.endDate between "+start+" and "+end;
		return super.find(hql);
	}

	@Override
	public List<Vip> findByLevelByPage(int level, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String hql="from Vip as v where v.level="+level;
		return super.findByPage(hql, pageNo, pageSize);
	}

	@Override
	public List<Vip> findByDateByPage(Date start, Date end, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String hql="from Vip as v where v.endDate between "+start+" and "+end;
		return super.findByPage(hql, pageNo, pageSize);
	}

	@Override
	public Vip findByPersonId(int personId) {
		// TODO Auto-generated method stub
		String hql="select v from Vip as v where v.person.id="+personId;
		if(super.find(hql).size()>0)
			return super.find(hql).get(0);
		else
			return null;
	}

}
