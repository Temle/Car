package com.car.parking.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.car.domain.Parkorder;
import com.car.domain.User;
import com.car.util.HibernateUtil;
import com.car.util.PageBean;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class BackOrderAction implements Action{

	private PageBean pb=new PageBean();
	private List<Parkorder> list1=new ArrayList<Parkorder>();
	private List<Parkorder> list2=new ArrayList<Parkorder>();
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		String id="";
		Session session=HibernateUtil.currentSession();
		ActionContext actionContext=ActionContext.getContext();
		Map map=actionContext.getSession();
		String username=(String)map.get("user");
		String hql="from User user where user.username = :name";
		
		List<User> list= session.createQuery(hql).setParameter("name", username).list();
		for(User user:list)
		{
			id=user.getStoreId();
		}
		
		String hql1="from Parkorder p where p.parkId="+id;
		List <Parkorder> list3=session.createQuery(hql1).list();
		for(Parkorder p : list3)
		{
			String name=p.getPerson().getName();
			if(p.getType()==0)
				list1.add(p);
			else
				list2.add(p);
		}
		
		HibernateUtil.closeSession();
		
		
		return SUCCESS;
	}
	public PageBean getPb() {
		return pb;
	}
	public void setPb(PageBean pb) {
		this.pb = pb;
	}
	public List<Parkorder> getList1() {
		return list1;
	}
	public void setList1(List<Parkorder> list1) {
		this.list1 = list1;
	}
	public List<Parkorder> getList2() {
		return list2;
	}
	public void setList2(List<Parkorder> list2) {
		this.list2 = list2;
	}
	
}
