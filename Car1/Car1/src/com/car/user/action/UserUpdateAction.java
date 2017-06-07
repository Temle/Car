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

public class UserUpdateAction implements Action{

	private Person person=new Person();

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println(person.getName());
		System.out.println(person.getAge());
		
		System.out.println(person.getAddress());
		System.out.println(person.getEmail());
		System.out.println(person.getPhoneNumber());
		
		System.out.println(person.getBirthDate());
		
		Session session=HibernateUtil.currentSession();
		Transaction tx=session.beginTransaction();
		ActionContext actionContext=ActionContext.getContext();
		Map map=actionContext.getSession();
		String username=(String)map.get("user");
		String hql="from User user where user.username = :name";
		
		Person p=new Person();
		List<User> list= session.createQuery(hql).setParameter("name", username).list();
		for(User user:list)
		{
			p=user.getPerson();
		}
		
		p.setAddress(person.getAddress());
		p.setBirthDate(person.getBirthDate());
		p.setEmail(person.getEmail());
		p.setName(person.getName());
		p.setPhoneNumber(person.getPhoneNumber());
		p.setAge(person.getAge());
		
		session.update(p);
		tx.commit();
		HibernateUtil.closeSession();
		return SUCCESS;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
