package com.car.storeBackstage.action;

import java.util.Map;

import com.car.dao.StoreHibDao;
import com.car.dao.StoreHibDaoImpl;
import com.car.domain.Store;
import com.car.service.store.StoreService;
import com.car.service.store.StoreServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ModifyStoreInfoAction extends ActionSupport {
	private Store store;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext actionContext=ActionContext.getContext();
		Map request=(Map)actionContext.get("request");
		StoreService storeService=new StoreServiceImpl();
		storeService.changeStoreInfo(store);
		request.put("store", store);
		return SUCCESS;
	}
	
	
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
}
