package com.car.dao;

import java.util.List;

import com.car.domain.Storeproduct;

public class StoreproductHibDaoImpl extends BaseDaoHibImpl<Storeproduct> implements StoreproductHibDao{

	@Override
	public Storeproduct findById(int id) {
		// TODO Auto-generated method stub
		String hql="from Storeproduct s where s.id="+id;
		if(super.find(hql).size()>0)
			return super.find(hql).get(0);
		else
			return null;
	}

	@Override
	public List findPageById(int id, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String hql="from Storeproduct s where s.id="+id;
		List<Storeproduct> list=this.findByPage(hql, pageNo, pageSize);
		return list;
	}

	@Override
	public List findByStoreId(int storeId) {
		// TODO Auto-generated method stub
		String hql="from Storeproduct s where s.store.id="+storeId;
		List<Storeproduct> list=this.find(hql);
		return list;
	}

	@Override
	public List findByPageByStoreId(int stordId, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String hql="select s from Storeproduct as s where s.store.id="+stordId; 
		return super.findByPage(hql, pageNo, pageSize);
	}

}
