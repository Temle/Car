package com.car.domain;
// Generated 2017-5-4 20:49:12 by Hibernate Tools 5.2.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//店铺、停车场、驾校的评价
@Entity
@Table(name = "conment", catalog = "car")
public class Conment implements java.io.Serializable {

	private Integer id;
	private Person person;	//发表人员
	private String content;	//评论内容
	private Date date;	//评论日期
	private int type;	//说明评论属于类型 ：1停车场		2服务型商家	3驾校
	private String storeid;		//店铺、停车场、驾校 id
	private int state;
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Conment() {
	}

	public Conment(Person person, String content, Date date,int type,String storeid,int state) {
		this.person = person;
		this.content = content;
		this.date = date;
		this.type = type;
		this.storeid = storeid;
		this.state = state;
	}
	
	@Column(name = "type", nullable = false)
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	@Column(name = "storeid", nullable = false)
	public String getStoreid() {
		return storeid;
	}

	public void setStoreid(String storeid) {
		this.storeid = storeid;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "personID")
	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Column(name = "content")
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", length = 0)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
