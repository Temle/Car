package com.car.Tool;

import java.util.Date;

public class ConmentShow implements java.io.Serializable {

	private String username;
	private String content;	//评论内容
	private Date date;	//评论日期
	
	public ConmentShow() {
	}
	public ConmentShow(String username,String content,Date date)
	{
		this.username=username;
		this.content=content;
		this.date=date;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
