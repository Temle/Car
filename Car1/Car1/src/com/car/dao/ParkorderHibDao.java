package com.car.dao;

import java.util.Date;
import java.util.List;

import com.car.domain.Parkorder;

public interface ParkorderHibDao extends BaseHibDao<Parkorder>{
	Parkorder FindByid(int id);
	List FindByParkIdBypage(int pid,int pageNo,int pageSize);
	List FindByPersonIdBypage(int perid,int pageNo,int pageSize);
    List FindByDate(Date startDate,Date endDate); 
 }
