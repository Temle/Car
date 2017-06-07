package com.car.SchoolBackground.action;

import java.util.ArrayList;
import java.util.List;

import com.car.dao.DrivingorderHibDao;
import com.car.dao.DrivingorderHibDaoImpl;
import com.car.domain.Drivingorder;
import com.car.domain.User;
import com.car.util.PageBean;
import com.opensymphony.xwork2.Action;

public class SchoolBackgroundOrderHistory implements Action {
	private User u;
	private int StoreId;
	private PageBean pageBean=new PageBean();
	private int pageNo=1;
	private DrivingorderHibDao dod=new DrivingorderHibDaoImpl(); 
	private List<Drivingorder> dro=new ArrayList<Drivingorder>();
	@Override
	public String execute() throws Exception {
		dro=dod.findBydschoolID(StoreId);
		pageBean.data=dro;
		pageBean.curPage=pageNo;
		pageBean.maxRowCount=50;
		pageBean.countMaxPage();
		pageBean.setRowsPerPage(5);
		return SUCCESS;
	}
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	public int getStoreId() {
		return StoreId;
	}
	public void setStoreId(int storeId) {
		StoreId = storeId;
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
	public DrivingorderHibDao getDod() {
		return dod;
	}
	public void setDod(DrivingorderHibDao dod) {
		this.dod = dod;
	}
	public List<Drivingorder> getDro() {
		return dro;
	}
	public void setDro(List<Drivingorder> dro) {
		this.dro = dro;
	}

}
