package com.car.SchoolBackground.action;

import com.car.dao.DrivingschoolHibDao;
import com.car.dao.DrivingschoolHibDaoImpl;
import com.car.domain.Drivingschool;
import com.opensymphony.xwork2.Action;

public class JumpAddcoachAction implements Action{
	 private int StoreId;

	public int getStoreId() {
		return StoreId;
	}
	public void setStoreId(int storeId) {
		StoreId = storeId;
	}
	@Override
	public String execute() throws Exception {
		System.out.println(StoreId);
		return SUCCESS;
	}

}
