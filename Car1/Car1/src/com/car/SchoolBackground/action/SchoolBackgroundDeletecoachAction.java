package com.car.SchoolBackground.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.dao.DrivingcoachHibDao;
import com.car.dao.DrivingcoachHibDaoImpl;
import com.car.domain.Drivingcoach;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.Action;

public class SchoolBackgroundDeletecoachAction implements Action{
	private int StoreId;
	private int id;
	private DrivingcoachHibDao dsh=new DrivingcoachHibDaoImpl();
	private Drivingcoach dcoach=new Drivingcoach();
	@Override
	public String execute() throws Exception {
		dcoach=dsh.findByID(id);
		StoreId=dcoach.getDrivingschool().getId();
		Session session=HibernateUtil.currentSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		session.delete(dcoach);
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
	public int getStoreId() {
		return StoreId;
	}
	public void setStoreId(int storeId) {
		StoreId = storeId;
	}

}
