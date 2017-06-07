package com.car.Tool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ExamImpl {
	
	/**
	 * 驾校模拟考试题目
	 * 调用地址 http://jisujiakao.market.alicloudapi.com/driverexam/query
	 * 请求方式	GET
	 * 返回类型 JSON
	 * 请求参数
	 * @param pagenum	STRING	必选	当前页数
	 * @param pagesize	STRING	必选	每页数量 默认1
	 * @param sort		STRING	必选	排序方式 正常排序normal 随机排序rand 默认normal
	 * @param subject	STRING	必选	科目类别 1为科目一 4为科目四 默认1
	 * @param type		STRING	必选	题目类型 分为A1,A3,B1,A2,B2,C1,C2,C3,D,E,F 默认C1
	 * 
	 * 属性说明
	 * @param host
	 * @param path
	 * @method
	 * host、path、method构成url
	 * appcode 用户appcode，使用接口的权限
	 * 
	 */
	private String url;
	private String param;
	private String host;
	private String path;
	private String method;
	private String appcode;
	private String pagenum;
	private String pagesize;
	private String subject;
	private String sort;
	private String type;
	
	
	public ExamImpl()
	{
		this.url="http://jisujiakao.market.alicloudapi.com/driverexam/query";
		this.host="http://jisujiakao.market.alicloudapi.com";
		this.path="/driverexam/query";
		this.method="GET";
		this.pagenum="";
		this.pagesize="";
		this.subject="";
		this.sort="";
		this.type="c1";
		this.appcode="9dbeb103973b485f820fb95543e93c1a";
	}
	//根据参数获取JSON字符串
	public String start() throws Exception
	{
		Map<String, String> headers = new HashMap<String, String>();
		//最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
		headers.put("Authorization", "APPCODE " + appcode);
		Map<String, String> querys = new HashMap<String, String>();
		querys.put("pagenum", pagenum);
		querys.put("pagesize", pagesize);
		querys.put("sort", sort);
		querys.put("subject", subject);
		querys.put("type", type);
		HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
		//System.out.println("响应:"+response.toString());
		//System.out.println("response的body:"+EntityUtils.toString(response.getEntity()));
		String responseBody=EntityUtils.toString(response.getEntity());
		return responseBody;
	}
	
	//解析JSON字符串
	public List dealJSON() throws Exception
	{
		List<Question> list=new ArrayList<Question>();
		String json=start();
		JSONObject jo=JSONObject.fromObject(json);
		
		//status=0 表示获取JSON成功
		//String status=jo.get("status").toString();
		//System.out.println("status="+status);
		String result=jo.get("result").toString();
		JSONObject resultJo=JSONObject.fromObject(result);
		JSONArray info = resultJo.getJSONArray("list");
		for(int i = 0; i < info.length(); i++)
        {
			Question question=new Question();
            JSONObject obj = info.getJSONObject(i);
            Iterator it = obj.keys();
            while(it.hasNext())
            {
                String key = (String) it.next();
                switch(key)
                {
                case "explain":
                	question.setExplain(obj.get(key).toString());
                	break;
                case "chapter":
                	question.setChapter(obj.get(key).toString());
                	break;
                case "question":
                	question.setQuestion(obj.get(key).toString());
                	break;
                case "answer":
                	question.setAnswer(obj.get(key).toString());
                	break;
                case "option1":
                	question.setOption1(obj.get(key).toString());
                	break;
                case "option2":
                	question.setOption2(obj.get(key).toString());
                	break;
                case "option3":
                	question.setOption3(obj.get(key).toString());
                	break;
                case "option4":
                	question.setOption4(obj.get(key).toString());
                	break;
                case "pic":
                	question.setPic(obj.get(key).toString());
                	break;
                case "type":
                	question.setType(obj.get(key).toString());
                	break;
                default:
                	break;
                }
            }
            list.add(question);
        }
		return list;
	}
	
	public void createParam()
	{
		param+="pagenum="+pagenum;
		param+="&pagesize="+pagesize;
		param+="&subject="+subject;
		param+="&sort="+sort;
		param+="&type="+type;
	}
	
	public String getPagenum() {
		return pagenum;
	}

	public void setPagenum(String pagenum) {
		this.pagenum = pagenum;
	}

	public String getPagesize() {
		return pagesize;
	}

	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
}
