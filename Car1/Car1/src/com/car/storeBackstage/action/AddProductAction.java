package com.car.storeBackstage.action;

import java.util.Map;

import com.car.domain.Store;
import com.car.domain.Storeproduct;
import com.car.service.store.StoreService;
import com.car.service.store.StoreServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddProductAction extends ActionSupport {

	private Storeproduct product;
	private Store s;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext actionContext=ActionContext.getContext();
		Map request=(Map)actionContext.get("request");
		StoreService storeService=new StoreServiceImpl();
		Store store=storeService.searchStoreInfo(s);
		product.setStore(store);
		storeService.addStoreProductInfo(product);
		request.put("store", store);
		return SUCCESS;
	}
	public Storeproduct getProduct() {
		return product;
	}
	public void setProduct(Storeproduct product) {
		this.product = product;
	}
	public Store getS() {
		return s;
	}
	public void setS(Store s) {
		this.s = s;
	}

}
