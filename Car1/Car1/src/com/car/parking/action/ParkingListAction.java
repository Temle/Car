package com.car.parking.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.car.Tool.HttpRequest;
import com.car.Tool.UrlCreateFind;
import com.car.domain.Park;
import com.car.util.PageBean;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ParkingListAction implements Action{
	private PageBean pageBean=new PageBean();
	private String city;
	private List<Park> parklist=new ArrayList<Park>();
	private int pageNo=1;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		//TODO 这里的city需要从表单传输过来

		ActionContext actionContext=ActionContext.getContext();
		Map map=actionContext.getSession();
		city=(String)map.get("city");
		//System.out.println(city);
		String username=(String)map.get("user");
		//city="福州市";
		UrlCreateFind uc=new UrlCreateFind();
		String url=uc.getUrl();
		String param=uc.findByRegion(city,pageNo-1);
		String result=HttpRequest.sendGet(url, param);
		
		
		//输出URL和JSON返回字符串
		//System.out.println(url+"?"+param);
		//System.out.println(result);
		
		
		/**
		 * JSON解析
		 * 要把JSON lib文件加入项目   （这一步可以忽略，如果出现问题，再添加。）
		 * 要把JSON lib文件加入TomCat服务器的lib目录中
		 */
		JSONObject jo=JSONObject.fromObject(result);
		JSONArray info = jo.getJSONArray("contents");
		for(int i = 0; i < info.length(); i++)
        {
			Park park=new Park();
            JSONObject obj = info.getJSONObject(i);
            Iterator it = obj.keys();
            while(it.hasNext())
            {
                String key = (String) it.next();
                switch(key)
                {
                case "address":
                	park.setAddress(obj.get(key).toString());
                	break;
                case "title":
                	park.setName(obj.getString(key));
                	break;
                case "tags":
                	park.setDescription(obj.getString(key));
                	break;
                case "price":
                	park.setPrice(obj.getDouble(key));
                	break;
                case "isPass":
                	park.setIsPass(obj.getString(key));
                	break;
                case "parkSpaceNumber":
                	park.setParkSpaceNumber(obj.getInt(key));
                	break;
                case "restNumber":
                	park.setRestNumber(obj.getInt(key));
                	break;
                case "phoneNumber":
                	park.setPhoneNumber(obj.getString(key));
                	break;
                case "uid":
                	park.setId(obj.getInt(key));
                default:
                	break;
                }
            }
            parklist.add(park);
        }
		
		pageBean.data=parklist;
		pageBean.curPage=pageNo;
		pageBean.maxRowCount=200;
		pageBean.countMaxPage();
		
		return SUCCESS;
	}

	

	public List<Park> getParklist() {
		return parklist;
	}




	public void setParklist(List<Park> parklist) {
		this.parklist = parklist;
	}

	

	public PageBean getPageBean() {
		return pageBean;
	}



	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}



	public int getPageNo() {
		return pageNo;
	}



	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}



	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
