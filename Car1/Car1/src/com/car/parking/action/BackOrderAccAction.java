package com.car.parking.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.domain.Parkorder;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.Action;

public class BackOrderAccAction implements Action{

	private int id;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		Session session=HibernateUtil.currentSession();
		Transaction tx=session.beginTransaction();
		String hql="from Parkorder p where p.id="+id;
		List<Parkorder> list=session.createQuery(hql).list();
		for(Parkorder p:list)
		{
			p.setType(1);
		}
		tx.commit();
		HibernateUtil.closeSession();
		
		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
