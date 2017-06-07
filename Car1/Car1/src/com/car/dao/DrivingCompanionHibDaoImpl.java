package com.car.dao;

import java.util.List;

import org.hibernate.Query;

import com.car.domain.Drivingcompanion;

public class DrivingCompanionHibDaoImpl extends BaseDaoHibImpl<Drivingcompanion> implements DrivingCompanionHibDao {

	@Override
	public Drivingcompanion find(int id, int personId) {
		// TODO Auto-generated method stub
		String hql="select dc from Drivingcompanion as dc where dc.id="+id+" and dc.person.id="+personId;
		if(super.find(hql).size()>0)
			return super.find(hql).get(0);
		else
			return null;
	}

	@Override
	public List<Drivingcompanion> findByAP(int age, Double price) {
		String hql="select dc from Drivingcompanion as dc where dc.drivingAge="+age+" and dc.price="+price;
		return super.find(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Drivingcompanion> find(String hql, Object... params) {
		// TODO Auto-generated method stub
		// 创建查询
		Query query = getSession().createQuery(hql);
		// 为包含占位符的HQL语句设置参数
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		return (List<Drivingcompanion>) query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Drivingcompanion> findByPage(String hql, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return getSession().createQuery(hql)
				// 执行分页
				.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Drivingcompanion> findByPage(String hql, int pageNo, int pageSize, Object... params) {
		// TODO Auto-generated method stub
		// 创建查询
		Query query = getSession().createQuery(hql);
		// 为包含占位符的HQL语句设置参数
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		// 执行分页，并返回查询结果
		return query.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize).list();
	}

	@Override
	public List<Drivingcompanion> findByPrice(Double price, Double price2) {
		// TODO Auto-generated method stub
		String hql="select dc from Drivingcompanion as dc where dc.price>"+price+" and dc.price2<"+price2;
		return super.find(hql);
	}

	@Override
	public List<Drivingcompanion> findByPerson(int personId) {
		// TODO Auto-generated method stub
		String hql="select dc from Drivingcompanion as dc where dc.person.id="+personId;
		return super.find(hql);
	}

	@Override
	public List<Drivingcompanion> findByAge(int starAge, int endAge) {
		// TODO Auto-generated method stub
		String hql="select dc from Drivingcompanion as dc where dc.drivingAge>"+starAge+" and dc.drivingAge<"+endAge;
		return super.find(hql);
	}

	@Override
	public List<Drivingcompanion> findByPagePid(int personId, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String hql="select dc from Drivingcompanion as dc where dc.person.id="+personId;
		return super.findByPage(hql, pageNo, pageSize);
	}

	@Override
	public List<Drivingcompanion> findByPageAge(int starAge, int endAge, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String hql="select dc from Drivingcompanion as dc where dc.drivingAge>"+starAge+" and dc.drivingAge<"+endAge;
		return super.findByPage(hql, pageNo, pageSize);
	}

	@Override
	public List<Drivingcompanion> findByPagePrice(Double price, Double price2, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String hql="select dc from Drivingcompanion as dc where dc.price>"+price+" and dc.price<"+price2;
		return super.findByPage(hql, pageNo, pageSize);
	}

	@Override
	public Drivingcompanion findById(int id) {
		// TODO Auto-generated method stub
		String hql="select dc from Drivingcompanion as dc where dc.id="+id;
		if(super.find(hql).size()>0)
			return super.find(hql).get(0);
		else
			return null;
	}


}
