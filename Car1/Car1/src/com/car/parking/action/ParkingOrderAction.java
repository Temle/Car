package com.car.parking.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.Tool.ConmentShow;
import com.car.Tool.HttpRequest;
import com.car.Tool.UrlCreateFind;
import com.car.domain.Conment;
import com.car.domain.Park;
import com.car.domain.Storenotification;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.Action;

import net.sf.json.JSONObject;

public class ParkingOrderAction implements Action{
	private int id;
	private Park park=new Park();
	private String city;
	private String province;
	private String district;
	private String notfi;


	private List<Conment> list=new ArrayList<Conment>();
	private List<ConmentShow> li=new ArrayList<ConmentShow>();
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		UrlCreateFind uc=new UrlCreateFind();
		String url="http://api.map.baidu.com/geodata/v3/poi/detail";
		String param=uc.findById(id);
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
        
        
        String parkid=id+"";
        String hql="from Conment c where c.type = :type and c.storeid = :parkid";
        Session session = HibernateUtil.currentSession();
        Transaction tx=session.beginTransaction();
        list=session.createQuery(hql).setParameter("type", 1).setParameter("parkid", parkid).list();

        
        for(Conment c:list)
        {
        	ConmentShow cs=new ConmentShow();
        	cs.setContent(c.getContent());
        	cs.setDate(c.getDate());
        	cs.setUsername(c.getPerson().getUser().getUsername());
        	li.add(cs);
        }
        notfi="";
        String hql1="from Storenotification s where s.storeId = :sid and s.type = :type";
        List<Storenotification> list2=session.createQuery(hql1).setParameter("type", "1").setParameter("sid", parkid).list();
        for(Storenotification s : list2)
        {
        	
        	notfi=s.getContent();
        }
        tx.commit();
        HibernateUtil.closeSession();
        

		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public List<Conment> getList() {
		return list;
	}

	public void setList(List<Conment> list) {
		this.list = list;
	}

	public List<ConmentShow> getLi() {
		return li;
	}

	public void setLi(List<ConmentShow> li) {
		this.li = li;
	}

	public String getNotfi() {
		return notfi;
	}

	public void setNotfi(String notfi) {
		this.notfi = notfi;
	}


	
	
}
