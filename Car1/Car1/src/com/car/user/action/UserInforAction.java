package com.car.user.action;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.domain.Person;
import com.car.domain.User;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class UserInforAction implements Action{
	
	private Person person=new Person();
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//获取用户id 获取用户详细信息
		
		
		Session session=HibernateUtil.currentSession();
		ActionContext actionContext=ActionContext.getContext();
		Map map=actionContext.getSession();
		String username=(String)map.get("user");
		String hql="from User user where user.username = :name";
		
		List<User> list= session.createQuery(hql).setParameter("name", username).list();
		for(User user:list)
		{
			person=user.getPerson();
		}
		
		return SUCCESS;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	

}
