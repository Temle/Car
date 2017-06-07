package com.car.drivingcompanion.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.dao.DrivingCompanionHibDao;
import com.car.dao.DrivingCompanionHibDaoImpl;
import com.car.domain.Conment;
import com.car.domain.Drivingcompanion;
import com.car.domain.Person;
import com.car.domain.User;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
public class CompanionCommentAction implements Action{
	private Person person;
	private Drivingcompanion dcompanion=new Drivingcompanion();
	private int companionid;
	private String comments;
	private Conment comment=new Conment();
	@Override
	public String execute() throws Exception{
		Session session=HibernateUtil.currentSession();
		Transaction tx=session.beginTransaction();
		ActionContext actionContext=ActionContext.getContext();
		Map map=actionContext.getSession();
		String username=(String)map.get("user");
		String hql="from User user where user.username=:name";
		List<User> list=session.createQuery(hql).setParameter("name", username).list();
		for(User user:list)
		{
			person=user.getPerson();
		}
		comment.setContent(comments);
		comment.setDate(new Date());
		comment.setPerson(person);
		comment.setId(companionid);
		comment.setType(3);
		session.save(comment);	
		tx.commit();
		
		return SUCCESS;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Drivingcompanion getDcompanion(){
		return dcompanion;
	}
	
	public void setDschool(Drivingcompanion dcompanion) {
		this.dcompanion = dcompanion;
	}
	
	public int getCompanionid() {
		return companionid;
	}
	
	public void setCompanionid(int companionid) {
		this.companionid = companionid;
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
