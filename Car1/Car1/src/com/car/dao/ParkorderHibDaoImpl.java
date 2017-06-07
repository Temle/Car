package com.car.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.car.domain.Park;
import com.car.domain.Parkorder;

public class ParkorderHibDaoImpl extends BaseDaoHibImpl<Parkorder> implements ParkorderHibDao{

	@Override
	public Parkorder FindByid(int id) {
		String hql="from Parkorder pko where pko.id="+id;
		List<Parkorder> pko=find(hql);
		if(pko==null)
			return null;
			else
				return pko.get(0);
		
	}

	@Override
	public List FindByParkIdBypage(int pid,int pageNo,int pageSize) {
		// TODO 自动生成的方法存根
		String hql="from Park pk where pko.parkID="+pid;
		List<Parkorder>list=super.findByPage(hql, pageNo, pageSize);		
			return list;
	}

	
	

	@Override
	public List FindByDate(Date startDate,Date endDate)  {
		// TODO 自动生成的方法存根
		String hql="from Park pk where pko.Date between"+startDate+" and "+endDate+""; ;
		List<Parkorder>list=find(hql);		
			return list;
	}

	@Override
	public List FindByPersonIdBypage(int perid, int pageNo, int pageSize) {
		String hql="from Park pk where pko.parkID="+perid;
		List<Parkorder>list=findByPage(hql, pageNo, pageSize);		
			return list;
	}


}
