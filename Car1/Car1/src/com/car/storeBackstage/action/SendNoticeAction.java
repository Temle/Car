package com.car.storeBackstage.action;

import java.util.Date;
import java.util.Map;

import com.car.domain.Notification;
import com.car.domain.Store;
import com.car.domain.Storenotification;
import com.car.service.store.StoreService;
import com.car.service.store.StoreServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SendNoticeAction extends ActionSupport {
	
	private Store store;
	private String content;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext actionContext=ActionContext.getContext();
		Map request=(Map)actionContext.get("request");
		StoreService service=new StoreServiceImpl();
		Store s=service.searchStoreInfo(store);
		Storenotification notification=new Storenotification();
		notification.setContent(content);
		notification.setDate(new Date());
		notification.setStoreId(s.getId().toString());
		notification.setType("2");
		service.sendNofication(notification);
		request.put("store", s);
		return SUCCESS;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
