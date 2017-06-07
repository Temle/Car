package com.car.drivingschool.action;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.dao.DrivingschoolHibDao;
import com.car.dao.DrivingschoolHibDaoImpl;
import com.car.domain.Drivingschool;
import com.car.domain.User;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class DrivingschoolRegister implements Action{
	private String name;
	private String city;
	private String address;
    private String phoneNumber;
	private double price;
	private String description;
	private String carType;
	private String isPass;
	private User u=new User();
	private DrivingschoolHibDao dsh=new DrivingschoolHibDaoImpl();
	private Drivingschool dschool=new Drivingschool();
	private Drivingschool dschool1=new Drivingschool();
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
		dschool.setName(name);
		dschool.setCity(city);
		dschool.setAddress(address);
		dschool.setPhoneNumber(phoneNumber);
		dschool.setPrice(price);
		dschool.setDescription(description);
		dschool.setCarType(carType);
		dschool.setIsPass("N");
		session.save(dschool);
	
        dschool1=dsh.findByphoneNumber(phoneNumber);
		u.setType(3);
		u.setStoreId(dschool1.getId()+"");
		tx.commit();
	    HibernateUtil.closeSession();
		
		return SUCCESS;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
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
	public String getIsPass() {
		return isPass;
	}
	public void setIsPass(String isPass) {
		this.isPass = isPass;
	}
	public Drivingschool getDschool1() {
		return dschool1;
	}
	public void setDschool1(Drivingschool dschool1) {
		this.dschool1 = dschool1;
	}

}
