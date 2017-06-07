package com.car.store.action;

import java.util.Map;

import com.car.domain.Store;
import com.car.service.store.StoreService;
import com.car.service.store.StoreServiceImpl;
import com.car.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ProductOrderSecondAction extends ActionSupport{
	private PageBean pageBean=new PageBean();
	private PageBean pageBean2=new PageBean();
	private Store s;
	private int pageNo=1;
	private int pageNo2=1;
	 
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext act=ActionContext.getContext();
		Map request = (Map) act.get("request");
		s=(Store)request.get("s");
		StoreService storeService=new StoreServiceImpl();
		Store store=storeService.searchStoreInfo(s);
		request.put("store", store);
		pageBean=storeService.showStoreProductList(s, pageNo);
		pageBean.setCurPage(pageNo);
		pageBean.setMaxRowCount(200);
		pageBean.countMaxPage();
		
		pageBean2=storeService.searchStoreConment(s, pageNo2);
		pageBean2.setCurPage(pageNo2);
		pageBean2.setMaxRowCount(200);
		pageBean2.countMaxPage();
		request.put("pageBean", pageBean);
		request.put("pageBean2", pageBean2);
		request.put("store", store);
		return SUCCESS;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public Store getS() {
		return s;
	}

	public void setS(Store s) {
		this.s = s;
	}

	public PageBean getPageBean2() {
		return pageBean2;
	}

	public void setPageBean2(PageBean pageBean2) {
		this.pageBean2 = pageBean2;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageNo2() {
		return pageNo2;
	}

	public void setPageNo2(int pageNo2) {
		this.pageNo2 = pageNo2;
	}

}
