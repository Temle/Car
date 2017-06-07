package com.car.user.action;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.car.domain.User;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class UserStoreAction implements Action{

	private int type;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		Session session=HibernateUtil.currentSession();
		ActionContext actionContext=ActionContext.getContext();
		Map map=actionContext.getSession();
		String username=(String)map.get("user");
		String hql="from User user where user.username = :name";
		
		List<User> list= session.createQuery(hql).setParameter("name", username).list();
		for(User user:list)
		{
			type=user.getType();
		}
		if(type==0)
			return SUCCESS;
		else 
			return ERROR;

	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
