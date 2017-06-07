package com.car.dao;

import java.util.Date;
import java.util.List;

import com.car.domain.Vip;

public interface VipHibDao extends BaseHibDao<Vip>{
	
	//通过Vip主键id查询
	Vip findById(int id);
	
	//通过PersonId查询
	Vip findByPersonId(int personId);
	
	//查询指定等级的会员
	List<Vip> findByLevel(int level);
	
	//查询结束时间在指定时间内的Vip
	List<Vip> findByDate(Date start,Date end);
	
	//查询指定等级的会员
	List<Vip> findByLevelByPage(int level,int pageNo,int pageSize);
	
	//查询结束时间在指定时间内的Vip
	List<Vip> findByDateByPage(Date start,Date end,int pageNo,int pageSize);
}
