package com.car.SchoolBackground.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.car.domain.Drivingcoach;
import com.car.util.HibernateUtil;
import com.car.util.PageBean;
import com.opensymphony.xwork2.Action;

public class SchoolBackgroundCoachAction implements Action{
	private int StoreId;
	private PageBean pageBean=new PageBean();
	private int pageNo=1;
	private List<Drivingcoach> drivingcoach=new ArrayList<Drivingcoach>();
	@Override
	public String execute() throws Exception {
		    Session session=HibernateUtil.currentSession();
	 		String hql="from Drivingcoach dc where dc.drivingschool.id="+StoreId;
	 		Query query=session.createQuery(hql);
	 		drivingcoach=query.list();
	 		pageBean.data=drivingcoach;
			pageBean.curPage=pageNo;
			pageBean.maxRowCount=50;
			pageBean.countMaxPage();
			pageBean.setRowsPerPage(5);
		// TODO 自动生成的方法存根
		return SUCCESS;
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
	public List<Drivingcoach> getDrivingcoach() {
		return drivingcoach;
	}
	public void setDrivingcoach(List<Drivingcoach> drivingcoach) {
		this.drivingcoach = drivingcoach;
	}

}
