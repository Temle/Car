package com.car.parking.action;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.domain.Storenotification;
import com.car.domain.User;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class BackNotifiAction implements Action{
	
	private String content;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(content);
		String id="";
		Session session=HibernateUtil.currentSession();
		Transaction tx=session.beginTransaction();
		ActionContext actionContext=ActionContext.getContext();
		Map map=actionContext.getSession();
		String username=(String)map.get("user");
		String hql="from User user where user.username = :name";
		
		List<User> list= session.createQuery(hql).setParameter("name", username).list();
		for(User user:list)
		{
			id=user.getStoreId();
		}
		Storenotification sn=new Storenotification();
		sn.setContent(content);
		sn.setDate(new java.util.Date());
		sn.setType("1");
		sn.setStoreId(id);
		session.save(sn);
		
		tx.commit();
		HibernateUtil.closeSession();
		
		
		return SUCCESS;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
