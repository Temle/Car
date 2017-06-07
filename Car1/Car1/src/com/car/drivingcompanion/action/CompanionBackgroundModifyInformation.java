package com.car.drivingcompanion.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.dao.DrivingCompanionHibDao;
import com.car.dao.DrivingCompanionHibDaoImpl;
import com.car.domain.Drivingcompanion;
import com.car.domain.Person;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.Action;

public class CompanionBackgroundModifyInformation implements Action{
    private int Id;
    private Person person;	
	private int drivingAge;
	private String description;
	private int price;
	private DrivingCompanionHibDao dch=new DrivingCompanionHibDaoImpl();
	private Drivingcompanion dcompanion=new Drivingcompanion();
	@Override
	public String execute() throws Exception {
        dcompanion=dch.findById(Id);
    	Session session=HibernateUtil.currentSession();
		Transaction tx=session.beginTransaction();
		dcompanion.setPerson(person);
		dcompanion.setDrivingAge(drivingAge);
		dcompanion.setDescription(description);
		dcompanion.setPrice(price);
		session.save(dcompanion);
		tx.commit();
		
		return SUCCESS;
	}
	public int getId() {
		return Id;
	}
	public void setId(int Id) {
		this.Id = Id;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public int getDrivingAge() {
		return drivingAge;
	}
	public void setDrivingAge(int drivingAge) {
		this.drivingAge = drivingAge;
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

}
