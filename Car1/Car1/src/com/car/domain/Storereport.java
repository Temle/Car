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

/**
 * 投诉商家 、驾校、停车场
 */
@Entity
@Table(name = "storereport", catalog = "car")
public class Storereport implements java.io.Serializable {

	private Integer id;
	private Person person;
	private String storeId;	////说明投诉属于类型 ：1停车场		2服务型商家	3驾校
	private String content;
	private String type;
	private Date date;
	private int state;

	public Storereport() {
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Storereport(int state, Person person, String storeId, String content, String type, Date date) {
		this.person = person;
		this.state = state;
		this.storeId = storeId;
		this.content = content;
		this.type = type;
		this.date = date;
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

	@Column(name = "type", length = 10)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", length = 0)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	
	
}
