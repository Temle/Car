package com.car.dao;

import java.util.List;

import com.car.domain.Storeorder;

public class StoreorderHibDaoImpl extends BaseDaoHibImpl<Storeorder> implements StoreorderHibDao{

	@Override
	public Storeorder findById(int id) {
		// TODO Auto-generated method stub
		String hql="from Storeorder s where s.id="+id;
		List<Storeorder> list=this.find(hql);
		for(Storeorder s:list)
			return s;
		return null;
	}

	@Override
	public List findPageById(int id, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String hql="from Storeorder s where s.id="+id;
		List<Storeorder> list=this.findByPage(hql, pageNo, pageSize);
		return list;
	}

	@Override
	public List findByPersonId(int personId) {
		// TODO Auto-generated method stub
		String hql="from Storeorder s where s.person.id="+personId;
		List<Storeorder> list=this.find(hql);
		return list;
	}

	@Override
	public List findByStoreId(int storeId) {
		// TODO Auto-generated method stub
		String hql="from Storeorder s where s.store.id="+storeId;
		List<Storeorder> list=this.find(hql);
		return list;
	}

	@Override
	public List findBySotreProductId(int storeProductId) {
		// TODO Auto-generated method stub
		String hql="from Storeorder s where s.storeproduct.id="+storeProductId;
		List<Storeorder> list=this.find(hql);
		return list;
	}

	@Override
	public List findByPersonIdByPage(int personId, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String hql="select s from Storeorder as s where s.person.id="+personId;
		return super.findByPage(hql, pageNo, pageSize);
	}

	@Override
	public List findByStoreIdByPage(int storeId, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String hql="select s from Storeorder as s where s.store.id="+storeId;
		return super.findByPage(hql, pageNo, pageSize);
	}

}
