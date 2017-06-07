package com.car.dao;

import java.util.List;

import com.car.domain.Personcar;

public interface PersonCarHibDao extends BaseHibDao<Personcar>{
	//����personID����Personcar����
	List findPersonID(int personID);
	//����ID����Personcar����
	Personcar findID(int ID);
	//����ID����PersonName����
	List findPersonName(String name);
	
	//����personID���ط�ҳPersoncar�����б�
	List findPageByPersonID(int personID, int pageNo,int pageSize);
	//����personName���ط�ҳPersoncar�����б�
	List findPageByPersonName(String personName, int pageNo,int pageSize);
}
