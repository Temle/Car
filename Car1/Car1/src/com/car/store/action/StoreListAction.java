package com.car.store.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.car.util.PageBean;
import com.car.service.store.StoreService;
import com.car.service.store.StoreServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class StoreListAction extends ActionSupport {

	private PageBean pageBean;
	private int pageNo=1;
		
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext act=ActionContext.getContext();
		Map request = (Map) act.get("request");
		String city="福州";
		StoreService storeService=new StoreServiceImpl();
		pageBean=storeService.searchStoreByCity(city, pageNo);
		pageBean.setCurPage(pageNo);
		pageBean.setMaxRowCount(200);
		pageBean.countMaxPage();
		request.put("pageBean", pageBean);
		return SUCCESS;
	}




	public PageBean getPageBean() {
		return pageBean;
	}




	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}




	public int getPageNo() {
		return pageNo;
	}




	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
}
