package com.car.storeBackstage.action;

import java.util.Map;

import com.car.domain.Store;
import com.car.domain.Storeorder;
import com.car.service.store.StoreService;
import com.car.service.store.StoreServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowOrderAction extends ActionSupport {
	
	private Store store;
	private Storeorder storeorder;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext actionContext=ActionContext.getContext();
		Map request=(Map)actionContext.get("request");
		StoreService storeService=new StoreServiceImpl();
		request.put("order", storeService.searchOrder(storeorder.getId()));
		request.put("store", storeService.searchStoreInfo(store));
		return SUCCESS;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Storeorder getStoreorder() {
		return storeorder;
	}

	public void setStoreorder(Storeorder storeorder) {
		this.storeorder = storeorder;
	}

}
