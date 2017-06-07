package com.car.storeBackstage.action;

import java.util.List;
import java.util.Map;
import com.car.domain.Store;
import com.car.domain.User;
import com.car.service.store.StoreService;
import com.car.service.store.StoreServiceImpl;
import com.car.dao.StoreHibDao;
import com.car.dao.StoreHibDaoImpl;
import com.car.dao.UserHibDao;
import com.car.dao.UserHibDaoImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowStoreInfoAction extends ActionSupport {
	private int type=1;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext actionContext=ActionContext.getContext();
		Map session=actionContext.getSession();
		Map request=(Map)actionContext.get("request");
		String username=(String)session.get("user");
		UserHibDao userDao=new UserHibDaoImpl();
		StoreService storeService=new StoreServiceImpl();
		List list=userDao.findUsername(username);
		if (list.size()>0) {
			User user=(User)list.get(0);
			Store store=new Store();
			store.setId(Integer.parseInt(user.getStoreId()));
			Store s=storeService.searchStoreInfo(store);
			request.put("store", s);
			if(type==1)
				return SUCCESS;
			else
				return "detail";
		}else {
			return ERROR;
		}
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

}
