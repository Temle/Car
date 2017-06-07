package com.car.drivingcompanion.action;

import com.car.dao.DrivingCompanionHibDao;
import com.car.dao.DrivingCompanionHibDaoImpl;
import com.car.domain.Drivingcompanion;
import com.opensymphony.xwork2.Action;

public class CompanionBackgroundInformationAction implements Action{
    private int Id;
    private DrivingCompanionHibDao dch=new DrivingCompanionHibDaoImpl();
    private Drivingcompanion dcompanion=new Drivingcompanion();
	@Override
	public String execute() throws Exception {
	
		dcompanion=dch.findById(Id);
		
		// TODO 自动生成的方法存根
		return SUCCESS;
	}
	public int getId() {
		return Id;
	}
	public void setId(int Id) {
		this.Id = Id;
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