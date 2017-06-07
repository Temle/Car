package com.car.SchoolBackground.action;

import com.car.dao.DrivingcoachHibDao;
import com.car.dao.DrivingcoachHibDaoImpl;
import com.car.domain.Drivingcoach;
import com.opensymphony.xwork2.Action;

public class JumpCoachAction implements Action{
	private int id;
	private int StoreId;
	private DrivingcoachHibDao dsh=new DrivingcoachHibDaoImpl();
	private Drivingcoach dcoach=new Drivingcoach();
	@Override
	public String execute() throws Exception {
		dcoach=dsh.findByID(id);
		StoreId=dcoach.getDrivingschool().getId();
		return SUCCESS;
	}
	
	public int getStoreId() {
		return StoreId;
	}

	public void setStoreId(int storeId) {
		StoreId = storeId;
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
	
}
