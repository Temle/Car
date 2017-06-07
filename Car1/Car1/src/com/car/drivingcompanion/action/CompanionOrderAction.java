package com.car.drivingcompanion.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.beanvalidation.HibernateTraversableResolver;

import com.car.dao.DrivingCompanionHibDao;
import com.car.dao.DrivingCompanionHibDaoImpl;
import com.car.domain.Drivingcorder;
import com.car.domain.Drivingcompanion;
import com.car.domain.Person;
import com.car.domain.User;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class CompanionOrderAction implements Action{
	private DrivingCompanionHibDao dch=new DrivingCompanionHibDaoImpl();
    private Person person;
    private Double price;
    private Drivingcompanion dcompanion=new Drivingcompanion();
    private int companionid;
    private String remarks;
    private Drivingcorder dcod=new Drivingcorder();
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
			person=user.getPerson();
		}
		dcompanion=dch.findById(companionid); 
		dcod.setPerson(person);
		dcod.setPrice(price);
        dcod.setRemarks(remarks);
        dcod.setDate(new Date());
        session.save(dcod);
		// TODO 自动生成的方法存根
        tx.commit();
		return SUCCESS;
	}

	public DrivingCompanionHibDao getDch() {
		return dch;
	}
	public void setDsh(DrivingCompanionHibDao dch) {
		this.dch = dch;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Drivingcompanion getDcompanion() {
		return dcompanion;
	}
	public void setDcompanion(Drivingcompanion dcompanion) {
		this.dcompanion = dcompanion;
	}
	public int getCompanionid() {
		return companionid;
	}
	public void setCompanionid(int companionid) {
		this.companionid = companionid;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Drivingcorder getDcod() {
		return dcod;
	}
	public void setDcod(Drivingcorder dcod) {
		this.dcod = dcod;
	}

}
