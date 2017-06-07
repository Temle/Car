package com.car.drivingschool.action;
import java.util.ArrayList;
import java.util.List;
import com.car.Tool.HttpRequest;

import com.car.Tool.UrlCreateFind;
import com.car.domain.Drivingschool;
import com.car.domain.Park;
import com.car.util.HibernateUtil;
import com.car.util.PageBean;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.opensymphony.xwork2.Action;


public class SchoolListAction implements Action{
	private PageBean pageBean=new PageBean();
	private String city;
	private List<Drivingschool> drivingschool=new ArrayList<Drivingschool>();
	private int pageNo=1;
	@Override
	public String execute() throws Exception {
		Session session=HibernateUtil.currentSession();
		String hql="from Drivingschool ds";
		Query query=session.createQuery(hql);
		drivingschool=query.list();
		pageBean.data=drivingschool;
		pageBean.curPage=pageNo;
		pageBean.maxRowCount=200;
		pageBean.countMaxPage();
		pageBean.setRowsPerPage(10);
		return SUCCESS;
	}
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<Drivingschool> getDrivingschool() {
		return drivingschool;
	}
	public void setDrivingschool(List<Drivingschool> drivingschool) {
		this.drivingschool = drivingschool;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	
}