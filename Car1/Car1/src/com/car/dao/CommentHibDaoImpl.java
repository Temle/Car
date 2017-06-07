package com.car.dao;

import java.util.Date;
import java.util.List;

import com.car.domain.Conment;


public class CommentHibDaoImpl extends BaseDaoHibImpl<Conment> implements CommentHibDao {


	@Override
	public Conment findById(int id) {
		// TODO Auto-generated method stub
		return super.get(Conment.class, id);
	}

	@Override
	public List<Conment> findByPersonId(int personId) {
		// TODO Auto-generated method stub
		String hql="from Conment as c where c.person.id="+personId;
		return super.find(hql);
	}

	@Override
	public List<Conment> findByPersonIdAndDate(int psersonId, Date start, Date end) {
		// TODO Auto-generated method stub
		String hql="from Conment as c where c.date between "+start+" and "+end;
		return super.find(hql);
	}

	@Override
	public List<Conment> findByPersonIdByPage(int personId, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String hql="from Conment as c where c.person.id="+personId;
		return super.findByPage(hql, pageNo, pageSize);
	}

	@Override
	public List<Conment> findByPersonIdAndDateByPage(int psersonId, Date start, Date end, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String hql="from Conment as c where c.date between "+start+" and "+end;
		return super.findByPage(hql, pageNo, pageSize);
	}

	@Override
	public List findByPageByStoreId(String storeId, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String hql="select c from Conment as c where c.type=2 and c.storeid='"+storeId+"'";
		return super.findByPage(hql, pageNo, pageSize);
	}
	
	@Override
	public List<Conment> findByStoreId(int type, String storeid) {
		String hql="from Conment c where c.type="+type+" and c.storeid="+storeid;
		
		// TODO 自动生成的方法存根
		return super.find(hql);
	}
}
