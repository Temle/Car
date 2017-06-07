package com.car.parking.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.Tool.ConmentShow;
import com.car.Tool.HttpRequest;
import com.car.Tool.UrlCreateFind;
import com.car.domain.Conment;
import com.car.domain.Park;
import com.car.domain.Parkorder;
import com.car.domain.User;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONObject;

public class BackInforAction implements Action{

	private String id;
	private Park park=new Park();
	private String city;
	private String province;
	private String district;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
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
		
		UrlCreateFind uc=new UrlCreateFind();
		String url="http://api.map.baidu.com/geodata/v3/poi/detail";
		String param=uc.findById(Integer.parseInt(id));
		String result=HttpRequest.sendGet(url, param);
		
		JSONObject json=JSONObject.fromObject(result);
		String res=json.getString("poi");
		JSONObject jo=JSONObject.fromObject(res);
		Iterator it = jo.keys();
        while(it.hasNext())
        {
            String key = (String) it.next();
            switch(key)
            {
            case "address":
            	park.setAddress(jo.get(key).toString());
            	break;
            case "title":
            	park.setName(jo.getString(key));
            	break;
            case "tags":
            	park.setDescription(jo.getString(key));
            	break;
            case "price":
            	park.setPrice(jo.getDouble(key));
            	break;
            case "isPass":
            	park.setIsPass(jo.getString(key));
            	break;
            case "parkSpaceNumber":
            	park.setParkSpaceNumber(jo.getInt(key));
            	break;
            case "restNumber":
            	park.setRestNumber(jo.getInt(key));
            	break;
            case "phoneNumber":
            	park.setPhoneNumber(jo.getString(key));
            	break;
            case "id":
            	park.setId(jo.getInt(key));
            	break;
            case "city":
            	this.city=jo.getString(key);
            	break;
            case "province":
            	this.province=jo.getString(key);
            	break;
            case "district":
            	this.district=jo.getString(key);
            	break;
            default:
            	break;
            }
        }
        
        
		return SUCCESS;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public Park getPark() {
		return park;
	}

	public void setPark(Park park) {
		this.park = park;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

}
