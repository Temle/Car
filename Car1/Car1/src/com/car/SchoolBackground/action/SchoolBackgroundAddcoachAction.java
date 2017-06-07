package com.car.SchoolBackground.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.dao.DrivingcoachHibDao;
import com.car.dao.DrivingcoachHibDaoImpl;
import com.car.dao.DrivingschoolHibDao;
import com.car.dao.DrivingschoolHibDaoImpl;
import com.car.domain.Drivingcoach;
import com.car.domain.Drivingschool;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.Action;

public class SchoolBackgroundAddcoachAction implements Action{
	private int StoreId;
	private String name;
	private String sex;
	private String phoneNumber;
	private String description;
	private DrivingcoachHibDao dsh=new DrivingcoachHibDaoImpl();
	private Drivingcoach dcoach=new Drivingcoach();
	private Drivingschool dschool=new Drivingschool();
	private DrivingschoolHibDao ds=new DrivingschoolHibDaoImpl();
	@Override
	public String execute() throws Exception {
		Session session=HibernateUtil.currentSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		dcoach.setName(name);
		dcoach.setSex(sex);
		dschool=ds.findById(StoreId);
		StoreId=dschool.getId();
		dcoach.setDrivingschool(dschool);
		dcoach.setPhoneNumber(phoneNumber);
		dcoach.setDescription(description);
		session.save(dcoach);
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public DrivingcoachHibDao getDsh() {
		return dsh;
	}
	public void setDsh(DrivingcoachHibDao dsh) {
		this.dsh = dsh;
	}
	public Drivingcoach getDcoach() {
		return dcoach;
	}
	public void setDcoach(Drivingcoach dcoach) {
		this.dcoach = dcoach;
	}
	public Drivingschool getDschool() {
		return dschool;
	}
	public void setDschool(Drivingschool dschool) {
		this.dschool = dschool;
	}
	public DrivingschoolHibDao getDs() {
		return ds;
	}
	public void setDs(DrivingschoolHibDao ds) {
		this.ds = ds;
	}

}
