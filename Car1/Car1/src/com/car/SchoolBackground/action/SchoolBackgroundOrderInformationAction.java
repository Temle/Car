package com.car.SchoolBackground.action;

import com.car.dao.DrivingorderHibDao;
import com.car.dao.DrivingorderHibDaoImpl;

import com.car.domain.Drivingorder;
import com.opensymphony.xwork2.Action;

public class SchoolBackgroundOrderInformationAction implements Action{	
	private int id;
	private int StoreId;
	private Drivingorder dro=new Drivingorder();
	private DrivingorderHibDao dsh=new DrivingorderHibDaoImpl();
	@Override
	public String execute() throws Exception {
		dro=dsh.findByID(id);
		StoreId=dro.getDrivingschool().getId();
		// TODO 自动生成的方法存根
		return SUCCESS;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Drivingorder getDro() {
		return dro;
	}
	public void setDro(Drivingorder dro) {
		this.dro = dro;
	}
	public DrivingorderHibDao getDsh() {
		return dsh;
	}
	public void setDsh(DrivingorderHibDao dsh) {
		this.dsh = dsh;
	}
	public int getStoreId() {
		return StoreId;
	}
	public void setStoreId(int storeId) {
		StoreId = storeId;
	}

}
