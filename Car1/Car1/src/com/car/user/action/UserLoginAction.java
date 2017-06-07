package com.car.user.action;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.domain.User;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
public class UserLoginAction implements Action{
	
	private String city;
	private String username;
	private String password;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		Session session=HibernateUtil.currentSession();
		String hql="from User user where user.username = :uname";
		List<User> list= session.createQuery(hql).setParameter("uname", username).list();
		for(User u:list)
		{
			if(u.getPassword().equals(password))
			{
				ActionContext actionContext=ActionContext.getContext();
				Map map=actionContext.getSession();
				map.put("user", username);
				map.put("city", city);
				return SUCCESS;
			}
			else
				return ERROR;
		}
		
		HibernateUtil.closeSession();
		
		return ERROR;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	
	

}
