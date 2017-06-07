package com.car.drivingcompanion.action;
import java.util.ArrayList;
import java.util.List;

import com.car.domain.Drivingcompanion;
import com.car.util.HibernateUtil;
import com.car.util.PageBean;

import org.hibernate.Query;
import org.hibernate.Session;
import com.opensymphony.xwork2.Action;

public class CompanionListAction implements Action{
	private PageBean pageBean=new PageBean();
	private List<Drivingcompanion> drivingcompanion=new ArrayList<Drivingcompanion>();
	private int pageNo=1;
	@Override
	public String execute() throws Exception{
		Session session=HibernateUtil.currentSession();
		String hql="from Drivingcompanion dc";
		Query query=session.createQuery(hql);
		drivingcompanion=query.list();
		pageBean.data=drivingcompanion;
		pageBean.curPage=pageNo;
		pageBean.maxRowCount=200;
		pageBean.countMaxPage();
		pageBean.setRowsPerPage(10);
		return SUCCESS;
	}
	
	public PageBean getPageBean(){
		return pageBean;
	}
	
	public void setPageBean(PageBean pageBean){
		this.pageBean=pageBean;
	}
	
	public List<Drivingcompanion> getDrivingcompanion(){
		return drivingcompanion;
	}
	
	public void setDrivingcompanion(List<Drivingcompanion> drivingcompanion){
		this.drivingcompanion=drivingcompanion;
	}

	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
}
