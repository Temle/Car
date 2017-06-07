package com.car.Tool;

public class UrlCreateUpdate {
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
	private String title;
	private String Address;
	private String tags;
	
	private double price;
	private String isPass;
	private int restNumber;
	private int parkSpaceNumber;
	private String phoneNumber;
	private String poid;
	
	
	public UrlCreateUpdate()
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
		param+="title="+title;
		param=addConnector(param);
		param+="tags="+tags;
		param=addConnector(param);
		param+="address="+Address;
		param=addConnector(param);
		param+="price="+price;
		param=addConnector(param);
		param+="phoneNumber="+phoneNumber;
		param=addConnector(param);
		param+="parkSpaceNumber="+parkSpaceNumber;
		param=addConnector(param);
		param+="id="+poid;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getIsPass() {
		return isPass;
	}

	public void setIsPass(String isPass) {
		this.isPass = isPass;
	}

	public int getRestNumber() {
		return restNumber;
	}

	public void setRestNumber(int restNumber) {
		this.restNumber = restNumber;
	}

	public int getParkSpaceNumber() {
		return parkSpaceNumber;
	}

	public void setParkSpaceNumber(int parkSpaceNumber) {
		this.parkSpaceNumber = parkSpaceNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPoid() {
		return poid;
	}

	public void setPoid(String poid) {
		this.poid = poid;
	}
	
	
	
}
