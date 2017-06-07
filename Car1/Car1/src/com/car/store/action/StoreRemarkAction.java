package com.car.store.action;

import java.util.Map;

import com.car.domain.Person;
import com.car.domain.Store;
import com.car.service.store.StoreService;
import com.car.service.store.StoreServiceImpl;
import com.car.service.user.UserService;
import com.car.service.user.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class StoreRemarkAction extends ActionSupport{

	private String conment;
	private Store s;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext actionContext=ActionContext.getContext();
		Map session=(Map)actionContext.getSession();
		Map request=(Map)actionContext.get("request");
		UserService userService=new UserServiceImpl();
		StoreService service=new StoreServiceImpl();
		System.out.println(s.getId());
		Store store=service.searchStoreInfo(s);	
		String username=(String)session.get("user");
		Person person=userService.searchPerson(username);
		boolean flag=service.storeRemark(person, store, conment);
		request.put("s", store);
		request.put("person", person);
		return "list";
	}
	
	public String getConment() {
		return conment;
	}
	public void setConment(String conment) {
		this.conment = conment;
	}
	
	public Store getS() {
		return s;
	}

	public void setS(Store s) {
		this.s = s;
	}
}
