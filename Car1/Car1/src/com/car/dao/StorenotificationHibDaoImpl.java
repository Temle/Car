package com.car.dao;

import java.util.List;
import com.car.domain.Storenotification;

public class StorenotificationHibDaoImpl extends BaseDaoHibImpl<Storenotification> implements StorenotificationHibDao{

	@Override
	public Storenotification findById(int id) {
		// TODO Auto-generated method stub
		String hql="from Storenotification s where s.id="+id;
		List<Storenotification> list=this.find(hql);
		for(Storenotification s:list)
			return s;
		return null;
	}

	@Override
	public List findPageById(int id, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String hql="from Storenotification s where s.id="+id;
		List<Storenotification> list=this.findByPage(hql, pageNo, pageSize);
		return list;
	}

	@Override
	public Storenotification findByStoreId(int storeId) {
		// TODO Auto-generated method stub
		String hql="from Storenotification s where s.store.id="+storeId;
		List<Storenotification> list=this.find(hql);
		for(Storenotification s:list)
			return s;
		return null;
	}
	
}
