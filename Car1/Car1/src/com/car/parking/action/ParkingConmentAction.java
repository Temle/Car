package com.car.parking.action;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.domain.Conment;
import com.car.domain.Person;
import com.car.domain.User;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class ParkingConmentAction implements Action{
	
	private String parkid;
	private String content;
	private Person person;
	private Conment conment=new Conment();	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		Session session=HibernateUtil.currentSession();
		Transaction tx=session.beginTransaction();
		ActionContext actionContext=ActionContext.getContext();
		Map map=actionContext.getSession();
		String username=(String)map.get("user");
		String hql="from User user where user.username = :name";
		
		List<User> list= session.createQuery(hql).setParameter("name", username).list();
		for(User user:list)
		{
			person=user.getPerson();
		}
		

		conment.setContent(content);
		conment.setDate(new java.util.Date());
		conment.setPerson(person);
		conment.setStoreid(parkid);
		conment.setType(1);
		
		session.save(conment);
		tx.commit();
		HibernateUtil.closeSession();
		
		return SUCCESS;
	}

	public String getParkid() {
		return parkid;
	}

	public void setParkid(String parkid) {
		this.parkid = parkid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Conment getConment() {
		return conment;
	}

	public void setConment(Conment conment) {
		this.conment = conment;
	}
	
}
