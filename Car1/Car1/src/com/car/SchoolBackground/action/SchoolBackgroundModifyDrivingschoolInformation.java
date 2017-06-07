package com.car.SchoolBackground.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.dao.DrivingschoolHibDao;
import com.car.dao.DrivingschoolHibDaoImpl;
import com.car.domain.Drivingschool;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.Action;

public class SchoolBackgroundModifyDrivingschoolInformation implements Action{
    private int StoreId;
    private String name;	
	private String address;
	private String phoneNumber;
	private double price;
	private String description;
	private String carType;
	private DrivingschoolHibDao dsh=new DrivingschoolHibDaoImpl();
	private Drivingschool dschool=new Drivingschool();
	@Override
	public String execute() throws Exception {
        dschool=dsh.findById(StoreId);
    	Session session=HibernateUtil.currentSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		dschool.setName(name);
		dschool.setAddress(address);
		dschool.setPhoneNumber(phoneNumber);
		dschool.setPrice(price);
		dschool.setDescription(description);
		dschool.setCarType(carType);
		session.save(dschool);
		tx.commit();
	    HibernateUtil.closeSession();
		
		return SUCCESS;
	}
	public int getStoreId() {
		return StoreId;
	}
	public void setStoreId(int storeId) {
		StoreId = storeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public DrivingschoolHibDao getDsh() {
		return dsh;
	}
	public void setDsh(DrivingschoolHibDao dsh) {
		this.dsh = dsh;
	}
	public Drivingschool getDschool() {
		return dschool;
	}
	public void setDschool(Drivingschool dschool) {
		this.dschool = dschool;
	}

}
