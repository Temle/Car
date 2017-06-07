package com.car.drivingcompanion.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.dao.DrivingCorderHibDao;
import com.car.dao.DrivingCorderHibDaoImpl;
import com.car.domain.Drivingcorder;
import com.car.domain.Drivingcompanion;
import com.car.domain.Person;
import com.car.domain.User;
import com.car.util.HibernateUtil;
import com.car.util.PageBean;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class CompanionBackgroundOrderAction implements Action{
	private User u;
	private int personId;
	private int id;
	private PageBean pageBean=new PageBean();
	private int pageNo=1;
	private DrivingCorderHibDao dcod=new DrivingCorderHibDaoImpl(); 
	private List<Drivingcorder> dco=new ArrayList<Drivingcorder>();
	@Override
	public String execute() throws Exception {
		Session session=HibernateUtil.currentSession();
		Transaction tx=session.beginTransaction();
		ActionContext actionContext=ActionContext.getContext();
		Map map=actionContext.getSession();
		String username=(String)map.get("user");
		String hql="from User user where user.username = :name";		
		List<User> list= session.createQuery(hql).setParameter("name", username).list();
		tx.commit();
		for(User user:list)
		{
			u=user;
		}
		personId=u.getPerson().getId();
		id=Integer.parseInt(u.getStoreId());
		dco=dcod.findByPerson(personId);
		pageBean.data=dco;
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
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
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
	public DrivingCorderHibDao getDcod() {
		return dcod;
	}
	public void setDcod(DrivingCorderHibDao dcod) {
		this.dcod = dcod;
	}
	public List<Drivingcorder> getDco() {
		return dco;
	}
	public void setDco(List<Drivingcorder> dco) {
		this.dco = dco;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
