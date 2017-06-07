package com.car.drivingcompanion.action;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.dao.DrivingCompanionHibDao;
import com.car.dao.DrivingCompanionHibDaoImpl;
import com.car.domain.Drivingcompanion;
import com.car.domain.User;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class CompanionRegister implements Action{
	private int personid;
	private int drivingage;
	private int price;
	private String description;
	private User u=new User();
	private DrivingCompanionHibDao dch=new DrivingCompanionHibDaoImpl();
	private Drivingcompanion dcompanion=new Drivingcompanion();
	private Drivingcompanion dcompanion1=new Drivingcompanion();
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
		
		System.out.println(drivingage);
		dcompanion.setDrivingAge(drivingage);
		dcompanion.setPrice(price);
		dcompanion.setDescription(description);
		dcompanion.setPerson(u.getPerson());
		session.save(dcompanion);

		u.setType(4);
		u.setStoreId(dcompanion.getId()+"");
		session.update(u);
		tx.commit();
		
		return SUCCESS;
	}
	public int getpersonId() {
		return personid;
	}
	public void setpersonId(int personid) {
		this.personid = personid;
	}

	public int getPersonid() {
		return personid;
	}
	public void setPersonid(int personid) {
		this.personid = personid;
	}
	public int getDrivingage() {
		return drivingage;
	}
	public void setDrivingage(int drivingage) {
		this.drivingage = drivingage;
	}
	public void setDcompanion1(Drivingcompanion dcompanion1) {
		this.dcompanion1 = dcompanion1;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	public DrivingCompanionHibDao getDch() {
		return dch;
	}
	public void setDch(DrivingCompanionHibDao dch) {
		this.dch = dch;
	}
	public Drivingcompanion getDcompanion() {
		return dcompanion;
	}
	public void setDcompanion(Drivingcompanion dcompanion) {
		this.dcompanion = dcompanion;
	}
	public Drivingcompanion getDcompanion1() {
		return dcompanion1;
	}
	public void setDcompanioon1(Drivingcompanion dcompanion1) {
		this.dcompanion1 = dcompanion1;
	}

}
