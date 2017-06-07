package com.car.Tool;

public class UrlCreateOp {
	/**参数说明
	 * @param url 请求url method=post
	 * @param title	Poi名称
	 * @param Address	地址
	 * @param tags	标签
	 * @param Geotable_id	记录关联的geotable的标识
	 * @param Ak	用户的访问权限key
	 * @param coord_type  用户上传的坐标的类型
	 * 1.GPS经纬度坐标
	 * 2.国测局加密经纬度坐标
	 * 3.百度加密经纬度坐标
	 * 4.百度加密墨卡托坐标
	 * @param price 价格
	 */
	
	/**返回类型说明
	 * @param status	状态码
	 * @param message	响应的信息
	 * @param id	新增的数据的id
	 */
	
	private String Url;
	private int coord_type;
	private String Geotable_id;
	private String AK;
	
	private int restNumber;
	private String poid;
	
	
	public UrlCreateOp()
	{
		Url="http://api.map.baidu.com/geodata/v3/poi/update";
		AK="6rzptMIb8jDgfZCFy1giVAamRBOhYsdG";
		coord_type=3;
		Geotable_id="168306";
	}

	public String getParam()
	{
		String param="";
		param+="geotable_id="+Geotable_id;
		param=addConnector(param);
		param+="ak="+AK;
		param=addConnector(param);
		param+="coord_type="+coord_type;
		param=addConnector(param);
		param+="id="+poid;
		param=addConnector(param);
		param+="restNumber="+restNumber;
		return param;
		
	}
	
	public void paramEncode()
	{
		//URLEncoder.encode(s, "UTF-8");
	}
	
	public String addConnector(String param)
	{
		param+="&";
		return param;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public int getCoord_type() {
		return coord_type;
	}

	public void setCoord_type(int coord_type) {
		this.coord_type = coord_type;
	}

	public String getGeotable_id() {
		return Geotable_id;
	}

	public void setGeotable_id(String geotable_id) {
		Geotable_id = geotable_id;
	}

	public String getAK() {
		return AK;
	}

	public void setAK(String aK) {
		AK = aK;
	}

	public int getRestNumber() {
		return restNumber;
	}

	public void setRestNumber(int restNumber) {
		this.restNumber = restNumber;
	}

	public String getPoid() {
		return poid;
	}

	public void setPoid(String poid) {
		this.poid = poid;
	}
	
}
