package com.car.dao;

import java.util.List;

import com.car.domain.Store;

public class StoreHibDaoImpl extends BaseDaoHibImpl<Store> implements StoreHibDao{

	@Override
	public Store findById(int id) {
		// TODO Auto-generated method stub
		String hql="from Store s where s.id="+id;
		List<Store> list=this.find(hql);
		if(list.size()>0)
			return list.get(0);
		return null;
	}

	//TODO
	//要使用该方法，数据库最好添加一个City字段用来保存店铺所属城市
	@Override
	public List findByCity(String city) {
		// TODO Auto-generated method stub
		String hql="from Store s where s.address="+city;
		List<Store> list=this.find(hql);
		return list;
	}

	@Override
	public List findByName(String name) {
		// TODO Auto-generated method stub
		String hql="from Store s where s.name="+name;
		List<Store> list=this.find(hql);
		return list;
	}

	@Override
	public List findByIsPass(String isPass) {
		// TODO Auto-generated method stub
		String hql="from Store s where s.isPass="+isPass;
		List<Store> list=this.find(hql);
		return list;
	}

	@Override
	public List findPageById(int id, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String hql="from Store s where s.id="+id;
		List<Store> list=this.findByPage(hql, pageNo, pageSize);
		return list;
	}

	@Override
	public List findPageByCity(String city, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String hql="from Store s where s.city="+city;
		List<Store> list=this.findByPage(hql, pageNo, pageSize);
		return list;
	}

	@Override
	public List findPageByName(String name, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String hql="from Store s where s.name="+name;
		List<Store> list=this.findByPage(hql, pageNo, pageSize);
		return list;
	}

	@Override
	public Store findByPointId(int pointId) {
		// TODO Auto-generated method stub
		String hql="from Store s where s.point.id="+pointId;
		List<Store> list=this.find(hql);
		for(Store store:list)
			return store;
		return null;
	}

	@Override
	public List findByPageByCity(String city,int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		String hql="select s from Store as s where s.city=?0";
		return super.findByPage(hql, pageNo, pageSize, city);
	}

}
