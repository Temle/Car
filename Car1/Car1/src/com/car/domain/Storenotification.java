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
 * 商家发布的自己主页的通知
 */
@Entity
@Table(name = "storenotification", catalog = "car")
public class Storenotification implements java.io.Serializable {

	private Integer id;
	private String storeId;
	private String content;
	private Date date;
	private String type;
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Storenotification() {
	}

	public Storenotification(int state,String storeId, String content, Date date, String type) {
		this.storeId = storeId;
		this.content = content;
		this.state = state;
		this.date = date;
		this.type = type;
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

	

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
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

	@Column(name = "type", length = 10)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
