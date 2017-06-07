package com.car.store.action;

import java.util.Map;

import com.car.dao.UserHibDao;
import com.car.dao.UserHibDaoImpl;
import com.car.domain.Person;
import com.car.domain.Store;
import com.car.domain.User;
import com.car.service.user.RegisterLoginService;
import com.car.service.user.RegisterLoginServiceImpl;
import com.car.service.user.UserService;
import com.car.service.user.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterStoreAction extends ActionSupport{
	private Store store;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext actionContext=ActionContext.getContext();
		Map session=(Map)actionContext.getSession();
		Map request=(Map)actionContext.get("request");
		UserService userService=new UserServiceImpl();
		RegisterLoginService service=new RegisterLoginServiceImpl();
		String username=(String)session.get("user");
		store.setIsPass("Y");
		User user=userService.searchUser(username);
		service.registerStore(user, store);
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
