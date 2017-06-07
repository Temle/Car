package com.car.drivingcompanion.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.car.domain.User;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class CompanionBackgroundNoticeAction implements Action{
	private User u;
	private int id;
	@Override
	public String execute() throws Exception {
		Session session=HibernateUtil.currentSession();
		Transaction tx=session.beginTransaction();
		ActionContext actionContext=ActionContext.getContext();
		Map map=actionContext.getSession();
		String username=(String)map.get("user");
		String hql="from User user where user.username = :name";		
		List<User> list= session.createQuery(hql).setParameter("name", username).list();
		for(User user:list)
		{
			u=user;
		}
		id=Integer.parseInt(u.getStoreId());
		
		tx.commit();
		// TODO 自动生成的方法存根
		return SUCCESS;
	}
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
