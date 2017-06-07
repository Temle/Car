package com.car.storeBackstage.action;

import java.util.List;
import com.car.util.*;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.Case;

import org.apache.struts2.convention.annotation.Action;

import com.car.dao.UserHibDao;
import com.car.dao.UserHibDaoImpl;
import com.car.domain.Store;
import com.car.domain.User;
import com.car.service.store.StoreService;
import com.car.service.store.StoreServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Action
public class StoreBackstageAction extends ActionSupport{
	private int type=0;
	private int pageNo=1;
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
		User user=(User)list.get(0);
		Store store=new Store();
		store.setId(Integer.parseInt(user.getStoreId()));
		Store s=storeService.searchStoreInfo(store);
		request.put("store", s);
		switch (type) {
		//导航栏转发到store_information.jsp的跳转action;
		case 0:
			return "storeinfo";
			
		//导航栏跳转到order_history.jsp和order_information.jsp的action;
		case 1:
			PageBean pagebean=storeService.showStoreOrderList(s, pageNo);
			pagebean.setCurPage(pageNo);
			pagebean.setMaxRowCount(200);
			pagebean.countMaxPage();
			request.put("pageBean", pagebean);
			return "orderlist";
			
		//导航栏跳转单商品列表
		case 2:
			PageBean pagebean2=storeService.showStoreProductList(s, pageNo);
			pagebean2.setCurPage(pageNo);
			pagebean2.setMaxRowCount(200);
			pagebean2.countMaxPage();
			request.put("pageBean", pagebean2);
			return "productlist";
		
		case 3:
			PageBean pagebean3=storeService.showStoreOrderList(s, pageNo);
			pagebean3.setCurPage(pageNo);
			pagebean3.setMaxRowCount(200);
			pagebean3.countMaxPage();
			request.put("pageBean", pagebean3);
			return "orderlist";
			
		//发布公告
		case 4:
			return "nofication";
			
		default:
			break;
		}
		return super.execute();
	}
	
	
	
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}




	public int getPageNo() {
		return pageNo;
	}




	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

}
