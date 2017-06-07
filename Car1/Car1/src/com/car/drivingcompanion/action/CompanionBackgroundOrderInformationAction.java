package com.car.drivingcompanion.action;

import com.car.dao.DrivingCorderHibDao;
import com.car.dao.DrivingCorderHibDaoImpl;

import com.car.domain.Drivingcorder;
import com.opensymphony.xwork2.Action;

public class CompanionBackgroundOrderInformationAction implements Action{	
	private int id;
	private int personId;
	private Drivingcorder dco=new Drivingcorder();
	private DrivingCorderHibDao dch=new DrivingCorderHibDaoImpl();
	@Override
	public String execute() throws Exception {
		dco=dch.findById(id);
		personId=dco.getId();
		// TODO 自动生成的方法存根
		return SUCCESS;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Drivingcorder getDco() {
		return dco;
	}
	public void setDco(Drivingcorder dco) {
		this.dco = dco;
	}
	public DrivingCorderHibDao getDch() {
		return dch;
	}
	public void setDch(DrivingCorderHibDao dch) {
		this.dch = dch;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}

}
