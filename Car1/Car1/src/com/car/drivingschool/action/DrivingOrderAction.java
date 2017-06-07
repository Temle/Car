package com.car.drivingschool.action;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.beanvalidation.HibernateTraversableResolver;

import com.car.dao.DrivingschoolHibDao;
import com.car.dao.DrivingschoolHibDaoImpl;
import com.car.domain.Drivingorder;
import com.car.domain.Drivingschool;
import com.car.domain.Person;
import com.car.domain.User;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;


public class DrivingOrderAction implements Action{

	private DrivingschoolHibDao dsh=new DrivingschoolHibDaoImpl();
    private Person person;
    private Drivingschool dschool=new Drivingschool();
    private int schoolid;
    private String remarks;
    private Drivingorder dod=new Drivingorder();
	@Override
	public String execute() throws Exception {
		Session session=HibernateUtil.currentSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		ActionContext actionContext=ActionContext.getContext();
		Map map=actionContext.getSession();
		String username=(String)map.get("user");
		String hql="from User user where user.username = :name";
		
		List<User> list= session.createQuery(hql).setParameter("name", username).list();
		for(User user:list)
		{
			person=user.getPerson();
		}
		
		 dschool=dsh.findById(schoolid);
		 
		 dod.setDrivingschool(dschool);
		 dod.setPerson(person);
		 dod.setPrice(dschool.getPrice());
         dod.setRemarks(remarks);
         dod.setDate(new Date());
         session.save(dod);
		// TODO 自动生成的方法存根
         tx.commit();
         HibernateUtil.closeSession();
         
         
		return SUCCESS;
	}

	public DrivingschoolHibDao getDsh() {
		return dsh;
	}
	public void setDsh(DrivingschoolHibDao dsh) {
		this.dsh = dsh;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Drivingschool getDschool() {
		return dschool;
	}
	public void setDschool(Drivingschool dschool) {
		this.dschool = dschool;
	}
	public int getSchoolid() {
		return schoolid;
	}
	public void setSchoolid(int schoolid) {
		this.schoolid = schoolid;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Drivingorder getDod() {
		return dod;
	}
	public void setDod(Drivingorder dod) {
		this.dod = dod;
	}

}
