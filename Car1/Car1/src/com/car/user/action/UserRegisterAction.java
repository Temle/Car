package com.car.user.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.domain.Person;
import com.car.domain.User;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.Action;

public class UserRegisterAction implements Action{
	
	private String username;
	private String password;
	private Person person=new Person();
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		User user=new User();
		user.setPassword(password);
		user.setPerson(person);
		user.setUsername(username);
		user.setType(0);
		user.setVip(null);
		
		person.setUser(user);
		
		Session session=HibernateUtil.currentSession();
		Transaction tx=session.beginTransaction();
		try{
			session.save(person);
			session.save(user);
			tx.commit();
		}
		catch(RuntimeException e){
			tx.rollback();
		}
		if(session!=null)
			HibernateUtil.closeSession();
		
		
		return SUCCESS;
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

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	
}
