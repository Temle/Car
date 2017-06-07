package com.car.Tool;

public class UrlCreateFind {

	
	/**参数说明
	 * @param url 请求url地址
	 * @param ak 用户ak
	 * @param region 本地检索，城市名称 默认值“北京”
	 * @param geotable_id 表id
	 * 
	 */
	
	private String url;
	private String ak;
	private String region;
	private String geotable_id;
	
	
	public UrlCreateFind()
	{
		this.url="http://api.map.baidu.com/geosearch/v3/local";
		this.ak="6rzptMIb8jDgfZCFy1giVAamRBOhYsdG";
		this.region="北京";
		this.geotable_id="168306";
	}
	
	//本地检索
	public String findByRegion(String cityName,int pageindex)
	{
		this.region=cityName;
		String param="region="+region;
		param+="&ak="+ak;
		param+="&geotable_id="+geotable_id;
		param+="&page_size=9";//查询每一页的记录 数
		param+="&page_index="+pageindex;
		return param;
	}
	
	//Id检索
	public String findById(int id)
	{
		String param="ak="+ak;
		param+="&geotable_id="+geotable_id;
		param+="&id="+id;
		return param;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAk() {
		return ak;
	}
	public void setAk(String ak) {
		this.ak = ak;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getGeotable_id() {
		return geotable_id;
	}
	public void setGeotable_id(String geotable_id) {
		this.geotable_id = geotable_id;
	}
	
	
	
	
	
}
