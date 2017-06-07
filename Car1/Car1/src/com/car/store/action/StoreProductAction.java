package com.car.store.action;

import java.util.Map;

import com.car.domain.Store;
import com.car.domain.Storeproduct;
import com.car.service.store.StoreService;
import com.car.service.store.StoreServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class StoreProductAction extends ActionSupport{

	private Store s;
	private Storeproduct storeproduct;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(s.getId()+"  "+storeproduct.getId());
		StoreService storeService = new StoreServiceImpl();
		Storeproduct sp=storeService.showStoreProductInfo(storeproduct);
		Store store = storeService.searchStoreInfo(s);
		ActionContext actionContext=ActionContext.getContext();
		Map request =(Map) actionContext.get("request");
		request.put("store", store);
		request.put("storeproduct", sp);
		return SUCCESS;
	}

	public Store getS() {
		return s;
	}

	public void setS(Store s) {
		this.s = s;
	}

	public Storeproduct getStoreproduct() {
		return storeproduct;
	}

	public void setStoreproduct(Storeproduct storeproduct) {
		this.storeproduct = storeproduct;
	}
	
}
