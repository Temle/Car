package com.car.SchoolBackground.action;

import com.car.dao.DrivingcoachHibDao;
import com.car.dao.DrivingcoachHibDaoImpl;
import com.car.domain.Drivingcoach;
import com.opensymphony.xwork2.Action;

public class SchoolBackgroundCoachInformationAction implements Action{
	private int id;
	private int StoreId;
	private Drivingcoach drivingcoach=new Drivingcoach();
	private DrivingcoachHibDao dch=new DrivingcoachHibDaoImpl();
	@Override
	public String execute() throws Exception {

		drivingcoach=dch.findByID(id);
		StoreId=drivingcoach.getDrivingschool().getId();
		return SUCCESS;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Drivingcoach getDrivingcoach() {
		return drivingcoach;
	}
	public void setDrivingcoach(Drivingcoach drivingcoach) {
		this.drivingcoach = drivingcoach;
	}
	public DrivingcoachHibDao getDch() {
		return dch;
	}
	public void setDch(DrivingcoachHibDao dch) {
		this.dch = dch;
	}
	public int getStoreId() {
		return StoreId;
	}
	public void setStoreId(int storeId) {
		StoreId = storeId;
	}

}
