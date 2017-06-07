package com.car.store.action;

import java.util.Map;

import com.car.domain.Person;
import com.car.domain.Store;
import com.car.domain.Storeorder;
import com.car.domain.Storeproduct;
import com.car.service.store.StoreService;
import com.car.service.store.StoreServiceImpl;
import com.car.service.user.UserService;
import com.car.service.user.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ProductOrderAction extends ActionSupport{

	private Store store;
	private Storeproduct storeproduct;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext actionContext=ActionContext.getContext();
		Map session=(Map)actionContext.getSession();
		Map request=(Map)actionContext.get("request");
		UserService userService=new UserServiceImpl();
		StoreService storeService = new StoreServiceImpl();
		String username=(String)session.get("user");
		Person person=userService.searchPerson(username);
		Store s=storeService.searchStoreInfo(store);
		Storeproduct sp=storeService.showStoreProductInfo(storeproduct);
		storeService.saveOrder(person, s, sp);
		request.put("s", s);
		request.put("person", person);
		return "second";
	}
	
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public Storeproduct getStoreproduct() {
		return storeproduct;
	}
	public void setStoreproduct(Storeproduct storeproduct) {
		this.storeproduct = storeproduct;
	}

}
