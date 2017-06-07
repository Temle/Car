package com.car.parking.action;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.Tool.HttpRequest;
import com.car.Tool.UrlCreateAdd;
import com.car.Tool.UrlCreateUpdate;
import com.car.domain.Park;
import com.car.domain.User;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONObject;

public class BackUpdateAfterAction implements Action{

	private Park park=new Park();
	
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
		
		UrlCreateUpdate uc=new UrlCreateUpdate();

		uc.setPoid(id);
		uc.setTitle(park.getName());
		uc.setAddress(park.getAddress());
		uc.setPrice(park.getPrice());
		uc.setTags(park.getDescription());
		uc.setPhoneNumber(park.getPhoneNumber());
		uc.setParkSpaceNumber(park.getParkSpaceNumber());
		String message=HttpRequest.sendPost(uc.getUrl(), uc.getParam());
		JSONObject jo=JSONObject.fromObject(message);
		String status=jo.get("status").toString();
		
		if(status.equals("0"))
			return SUCCESS;
		else
		{
			return ERROR;
		}
	}

	public Park getPark() {
		return park;
	}

	public void setPark(Park park) {
		this.park = park;
	}

}
