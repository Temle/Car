package com.car.parking.action;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.Tool.HttpRequest;
import com.car.Tool.UrlCreateAdd;
import com.car.domain.Park;
import com.car.domain.Person;
import com.car.domain.Point;
import com.car.domain.User;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONObject;

public class ParkingAddAction implements Action{
	
	private Park park=new Park();
	private Point point=new Point();
	private double x;
	private double y;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		
		//添加用户信息到LBS
		UrlCreateAdd uc=new UrlCreateAdd();
		uc.setLatitude(y);
		uc.setLongitude(x);
		uc.setTitle(park.getName());
		uc.setAddress(park.getAddress());
		uc.setPrice(park.getPrice());
		uc.setTags(park.getDescription());
		uc.setIsPass("Y");
		uc.setRestNumber(park.getParkSpaceNumber());
		uc.setPhoneNumber(park.getPhoneNumber());
		uc.setParkSpaceNumber(park.getParkSpaceNumber());
		
		//输出请求url
		//System.out.println(uc.getUrl()+"?"+uc.getParam());
		String message=HttpRequest.sendPost(uc.getUrl(), uc.getParam());
		//输出响应
		//System.out.println(message);
		
		JSONObject jo=JSONObject.fromObject(message);
		String status=jo.get("status").toString();
		String id=jo.get("id").toString();
		if(status.equals("0"))
		{
			Session session=HibernateUtil.currentSession();
			Transaction tx=session.beginTransaction();
			ActionContext actionContext=ActionContext.getContext();
			Map map=actionContext.getSession();
			String username=(String)map.get("user");
			String hql="from User user where user.username = :name";
			
			List<User> list= session.createQuery(hql).setParameter("name", username).list();
			for(User user:list)
			{
				user.setType(1);
				user.setStoreId(id);
				session.update(user);
			}
	
			tx.commit();
			HibernateUtil.closeSession();
			return SUCCESS;
		}
		else
			return ERROR;
	}

	public Park getPark() {
		return park;
	}

	public void setPark(Park park) {
		this.park = park;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	
	
}
