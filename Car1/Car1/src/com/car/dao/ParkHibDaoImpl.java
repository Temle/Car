package com.car.dao;

import java.util.List;

import com.car.domain.Park;


public class ParkHibDaoImpl extends BaseDaoHibImpl<Park> implements ParkHibDao{

	@Override
	public List FindByNameBypage(String name,int pageNo,int pageSize) {
		String hql="from Park pk where pk.name="+name;
        List<Park> list=findByPage(hql,pageNo,pageSize);
    	
    	return list;
	}

	@Override
	public Park FindById(int id) {
		// TODO 自动生成的方法存根
		String hql="from Park pk where pk.id="+id;
		List<Park> pk=find(hql);
		if(pk==null)
			return null;
			else
				return pk.get(0);
	}
	
    public int RestNumber(int id,String name)
    {
    	String hql="from Park pk where pk.id="+id+" pk.name="+name;
        List<Park> list=this.find(hql);
        for(Park p:list)
        	return p.getRestNumber();
    	return 0;
    }

	@Override
	public Park FindBypointId(int id) {
		// TODO 自动生成的方法存根
		String hql="from Point pt where pt.id="+id;
		List<Park> pk=find(hql);
		if(pk==null)
			return null;
			else
				return pk.get(0);
	}
}
