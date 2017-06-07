package com.car.user.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.car.Tool.HttpUtils;
import com.opensymphony.xwork2.Action;

public class PeccancyAction implements Action{

	private String carCode;
	private String carNumber;
	private String carEngineCode;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		  String host = "https://ali-carlaw.showapi.com";
		    String path = "/break-rules";
		    String method = "POST";
		    String appcode = "9dbeb103973b485f820fb95543e93c1a";
		    Map<String, String> headers = new HashMap<String, String>();
		    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
		    headers.put("Authorization", "APPCODE " + appcode);
		    //根据API的要求，定义相对应的Content-Type
		    headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		    headers.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		    Map<String, String> querys = new HashMap<String, String>();
		    Map<String, String> bodys = new HashMap<String, String>();
		    bodys.put("carCode", carCode);
		    bodys.put("carNumber", carNumber);
		    bodys.put("carType", "02");
		    bodys.put("carEngineCode", carEngineCode);

		    try {
		    	HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
		    	System.out.println(response.toString());
		    	String result=EntityUtils.toString(response.getEntity());
		    	System.out.println(result);
		    	
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		return ERROR;
	}

	public String getCarEngineCode() {
		return carEngineCode;
	}

	public void setCarEngineCode(String carEngineCode) {
		this.carEngineCode = carEngineCode;
	}

	public String getCarCode() {
		return carCode;
	}

	public void setCarCode(String carCode) {
		this.carCode = carCode;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

}
