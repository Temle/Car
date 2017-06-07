package com.car.storeBackstage.action;

import java.util.Map;

import com.car.domain.Store;
import com.car.domain.Storeproduct;
import com.car.service.store.StoreService;
import com.car.service.store.StoreServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ModifyProductInfoAction extends ActionSupport {

	Storeproduct product;
	Store store;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext actionContext=ActionContext.getContext();
		Map request=(Map)actionContext.get("request");
		StoreService storeService=new StoreServiceImpl();
		storeService.changeStoreProductInfo(product);
		request.put("store", storeService.searchStoreInfo(store));
		request.put("product", product);
		return SUCCESS;
	}

	public Storeproduct getProduct() {
		return product;
	}

	public void setProduct(Storeproduct product) {
		this.product = product;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
	
	

}
