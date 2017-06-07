package com.car.dao;

import java.util.List;

import org.hibernate.Query;

import com.car.domain.Drivingcorder;

public class DrivingCorderHibDaoImpl extends BaseDaoHibImpl<Drivingcorder> implements DrivingCorderHibDao{
	
	@Override
	//根据personID进行查询
	public Drivingcorder find(int id,int personId)
	{
		String hql="select dc from Drivingcorder as dc where dc.id="+id+" and dc.person.id="+personId;
		if(super.find(hql).size()>0)
			return super.find(hql).get(0);
		else
			return null;
	}
			
	@Override
	//根据任意一个ID查询
	public Drivingcorder findAny(int id,int personId,int dcID)
	{
		String hql="select dc from Drivingcorder as dc where dc.id="+id+" or dc.person.id="+personId+" or dc.dcId="+dcID;
		return super.find(hql).get(0);
	}
			
	@Override
	//根据价格区间(price2<p<price)查询
	public List<Drivingcorder> find(Double price,Double price2)
	{
		String hql="select dc from Drivingcorder as dc where dc.price<"+price+" and dc.price>"+price2;
		return super.find(hql);
	}
			
	@SuppressWarnings("unchecked")
	@Override
	//根据带占位符参数HQL语句查询实体
	public List<Drivingcorder> find(String hql, Object... params)
	{
		// 创建查询
		Query query = getSession().createQuery(hql);
		// 为包含占位符的HQL语句设置参数
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		return (List<Drivingcorder>) query.list();
	}
				
	@SuppressWarnings("unchecked")
	@Override
	//根据页面实现查询
	public List<Drivingcorder> findByPage(String hql, int pageNo, int pageSize)
	{
		// TODO Auto-generated method stub
		return getSession().createQuery(hql)
				// 执行分页
				.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize).list();
	}
			
	@SuppressWarnings("unchecked")
	@Override
	//根据Hql语句和页面查询
	public List<Drivingcorder> findByPage(String hql, int pageNo, int pageSize,Object... params)
	{
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
	public List<Drivingcorder> findByPerson(int personId) {
		// TODO Auto-generated method stub
		String hql="select dc from Drivingcorder as dc where dc.person.id="+personId;
		return super.find(hql);
	}

	@Override
	public Drivingcorder findByDcId(int dcId) {
		// TODO Auto-generated method stub
		String hql="select dc from Drivingcorder as dc where dc.dcId="+dcId;
		if(super.find(hql).size()>0)
			return super.find(hql).get(0);
		else
			return null;
	}

	@Override
	public List<Drivingcorder> findByPagePid(int personId,int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		String hql="select dc from Drivingcorder as dc where dc.person.id="+personId;
		return super.findByPage(hql, pageNo, pageSize);
	}

	@Override
	public List<Drivingcorder> findByPagePrice(Double price, Double price2,int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		String hql="select dc from Drivingcorder as dc where dc.price<"+price+" and dc.price>"+price2;
		return super.findByPage(hql, pageNo, pageSize);
	}

	@Override
	public Drivingcorder findById(int id) {
		// TODO Auto-generated method stub
		String hql="select dc from Drivingcorder as dc where dc.id="+id;
		if(super.find(hql).size()>0)
			return super.find(hql).get(0);
		else
			return null;
	}

}
