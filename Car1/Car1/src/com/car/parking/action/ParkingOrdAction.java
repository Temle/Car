package com.car.parking.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.domain.Parkorder;
import com.car.domain.Person;
import com.car.domain.User;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class ParkingOrdAction implements Action{
	
	private String parkid;
	private Double price;
	private String remarks;
	private Person person;
	private Date date;
	
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

		
		
		Parkorder po=new Parkorder();
		po.setDate(new java.util.Date());
		po.setPerson(person);
		po.setParkId(parkid);
		po.setPrice(price);
		po.setRemarks(remarks);
		po.setType(0);
		session.save(po);
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	
	
}
