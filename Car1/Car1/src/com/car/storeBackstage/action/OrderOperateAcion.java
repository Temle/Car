package com.car.storeBackstage.action;

import java.util.Map;

import com.car.domain.Store;
import com.car.domain.Storeorder;
import com.car.service.store.StoreService;
import com.car.service.store.StoreServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OrderOperateAcion extends ActionSupport {
	private int type=0;
	private Store store;
	private Storeorder order;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext actionContext=ActionContext.getContext();
		Map request=(Map)actionContext.get("request");
		StoreService service=new StoreServiceImpl();
		switch (type) {
		case 0:
			request.put("order", service.searchOrder(order.getId()));
			return "info";
			
		case 1:
			service.deleteOrder(order.getId());
			return SUCCESS;

		default:
			break;
		}
		
		request.put("store", store);
		return SUCCESS;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Storeorder getOrder() {
		return order;
	}

	public void setOrder(Storeorder order) {
		this.order = order;
	}
	
}
