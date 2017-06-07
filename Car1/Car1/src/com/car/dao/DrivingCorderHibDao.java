package com.car.dao;

import java.util.List;

import com.car.domain.Drivingcorder;

public interface DrivingCorderHibDao extends BaseHibDao<Drivingcorder> {
	
		//根据主键查询
		public Drivingcorder findById(int id);
	
		//根据personID进行查询
		public Drivingcorder find(int id,int personId);
		
		//根据任意一个ID查询
		public Drivingcorder findAny(int id,int personId,int dcID);
		
		//根据personId单独查询
		public List<Drivingcorder> findByPerson(int personId);
		
		//根据personId分页查询
		public List<Drivingcorder> findByPagePid(int personId,int pageNo,int pageSize);
		
		//根据dcID单独查询
		public Drivingcorder findByDcId(int dcId);
		
		//根据价格区间(price2<p<price)查询
		public List<Drivingcorder> find(Double price,Double price2);
		
		//根据价格区间(price2<p<price)查询
		public List<Drivingcorder> findByPagePrice(Double price,Double price2,int pageNo,int pageSize);
		
		
		//根据带占位符参数HQL语句查询实体
		public List<Drivingcorder> find(String hql, Object... params);
			
		//根据页面实现查询
		public List<Drivingcorder> findByPage(String hql, int pageNo, int pageSize);
		
		//根据Hql语句和页面查询
		public List<Drivingcorder> findByPage(String hql, int pageNo, int pageSize,Object... params);
}
