package com.car.SchoolBackground.action;

import com.opensymphony.xwork2.Action;

public class JumpNoticeAction implements Action{
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
