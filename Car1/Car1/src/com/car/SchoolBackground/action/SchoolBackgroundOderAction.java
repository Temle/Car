package com.car.SchoolBackground.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.dao.DrivingorderHibDao;
import com.car.dao.DrivingorderHibDaoImpl;
import com.car.domain.Drivingorder;
import com.car.domain.Drivingschool;
import com.car.domain.Person;
import com.car.domain.User;
import com.car.util.HibernateUtil;
import com.car.util.PageBean;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class SchoolBackgroundOderAction implements Action{
	private User u;
	private int StoreId;
	private PageBean pageBean=new PageBean();
	private int pageNo=1;
	private DrivingorderHibDao dod=new DrivingorderHibDaoImpl(); 
	private List<Drivingorder> dro=new ArrayList<Drivingorder>();
	@Override
	public String execute() throws Exception {
		Session session=HibernateUtil.currentSession();
		Transaction tx=session.beginTransaction();
		ActionContext actionContext=ActionContext.getContext();
		Map map=actionContext.getSession();
		String username=(String)map.get("user");
		String hql="from User user where user.username = :name";		
		List<User> list= session.createQuery(hql).setParameter("name", username).list();
		for(User user:list)
		{
			u=user;
		}
		StoreId=Integer.parseInt(u.getStoreId());
		dro=dod.findBydschoolID(StoreId);
		pageBean.data=dro;
		pageBean.curPage=pageNo;
		pageBean.maxRowCount=50;
		pageBean.countMaxPage();
		pageBean.setRowsPerPage(5);
		
		
		// TODO 自动生成的方法存根
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
