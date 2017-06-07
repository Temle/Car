package com.car.storeBackstage.action;

import java.util.Map;

import com.car.domain.Store;
import com.car.domain.Storeproduct;
import com.car.service.store.StoreService;
import com.car.service.store.StoreServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowProductAction extends ActionSupport {
	private Store store;
	private Storeproduct product;
	private int type;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext actionContext=ActionContext.getContext();
		Map request=(Map)actionContext.get("request");
		StoreService storeService=new StoreServiceImpl();
		request.put("store", storeService.searchStoreInfo(store));
		switch (type) {
		case 0:
			request.put("product", storeService.showStoreProductInfo(product));
			return "info";
		
		case 1:
			request.put("product", storeService.showStoreProductInfo(product));
			return "modify";

		case 2:
			storeService.deleteStoreProductInfo(product);
			return SUCCESS;
		
		case 3:
			return "add";
			
		default:
			break;
		}
		
		 return SUCCESS;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Storeproduct getProduct() {
		return product;
	}

	public void setProduct(Storeproduct product) {
		this.product = product;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
