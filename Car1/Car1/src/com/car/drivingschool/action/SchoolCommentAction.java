package com.car.drivingschool.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.dao.DrivingschoolHibDao;
import com.car.dao.DrivingschoolHibDaoImpl;
import com.car.domain.Conment;
import com.car.domain.Drivingschool;
import com.car.domain.Person;
import com.car.domain.User;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class SchoolCommentAction implements Action{
    private Person person;
    private Drivingschool dschool=new Drivingschool();
    private int schoolid;
    private String comments;
    private Conment comment=new Conment();
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
		comment.setContent(comments);
		comment.setDate(new Date());
		comment.setPerson(person);
		comment.setStoreid(schoolid+"");
		comment.setType(3);
		session.save(comment);	
         tx.commit();
         HibernateUtil.closeSession();
		return SUCCESS;
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
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Conment getComment() {
		return comment;
	}
	public void setComment(Conment comment) {
		this.comment = comment;
	}

}
