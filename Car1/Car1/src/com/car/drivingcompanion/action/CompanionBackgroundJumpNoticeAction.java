package com.car.drivingcompanion.action;

import com.opensymphony.xwork2.Action;

public class CompanionBackgroundJumpNoticeAction implements Action{
	 private int Id;

	public int getId() {
		return Id;
	}
	public void setId(int Id) {
		this.Id = Id;
	}
	@Override
	public String execute() throws Exception {
		System.out.println(Id);
		return SUCCESS;
	}


}
