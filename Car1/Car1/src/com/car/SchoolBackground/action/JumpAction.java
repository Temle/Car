package com.car.SchoolBackground.action;

import com.car.dao.DrivingschoolHibDao;
import com.car.dao.DrivingschoolHibDaoImpl;
import com.car.domain.Drivingschool;
import com.opensymphony.xwork2.Action;

public class JumpAction implements Action{
    private int StoreId;
    private DrivingschoolHibDao dsh=new DrivingschoolHibDaoImpl();
	private Drivingschool dschool=new Drivingschool();
	public int getStoreId() {
		return StoreId;
	}
	public void setStoreId(int storeId) {
		StoreId = storeId;
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
	@Override
	public String execute() throws Exception {

        dschool=dsh.findById(StoreId);
		return SUCCESS;
	}

}
