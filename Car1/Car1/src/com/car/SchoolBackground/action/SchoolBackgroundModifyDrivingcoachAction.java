package com.car.SchoolBackground.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.dao.DrivingcoachHibDao;
import com.car.dao.DrivingcoachHibDaoImpl;
import com.car.domain.Drivingcoach;
import com.car.domain.Drivingschool;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.Action;

public class SchoolBackgroundModifyDrivingcoachAction implements Action {
    private int id;
    private int StoreId;
	private String name;
	private String sex;
	private String phoneNumber;
	private String description;
	private DrivingcoachHibDao dsh=new DrivingcoachHibDaoImpl();
	private Drivingcoach dcoach=new Drivingcoach();
	@Override
	public String execute() throws Exception {
		dcoach=dsh.findByID(id);
		StoreId=dcoach.getDrivingschool().getId();
		Session session=HibernateUtil.currentSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		dcoach.setName(name);
		dcoach.setSex(sex);
		dcoach.setPhoneNumber(phoneNumber);
		dcoach.setDescription(description);
		session.save(dcoach);
		tx.commit();
	    HibernateUtil.closeSession();
		
		// TODO 自动生成的方法存根
		return SUCCESS;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	

}
