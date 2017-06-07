package com.car.parking.action;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.car.Tool.HttpRequest;
import com.car.Tool.UrlCreateOp;
import com.car.Tool.UrlCreateUpdate;
import com.car.domain.User;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONObject;

public class BackOpAfterAction implements Action{
	
	private int restnumber;

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

		HibernateUtil.closeSession();
		
		UrlCreateOp uc=new UrlCreateOp();

		uc.setPoid(id);
		uc.setRestNumber(restnumber);
		String message=HttpRequest.sendPost(uc.getUrl(), uc.getParam());
		JSONObject jo=JSONObject.fromObject(message);
		String status=jo.get("status").toString();
		
		if(status.equals("0"))
			return SUCCESS;
		else
		{
			System.out.println(status);
			return ERROR;
		}
	}

	public int getRestnumber() {
		return restnumber;
	}

	public void setRestnumber(int restnumber) {
		this.restnumber = restnumber;
	}
	
}
