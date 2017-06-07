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
 * 陪驾订单
 */
@Entity
@Table(name = "drivingcorder", catalog = "car")
public class Drivingcorder implements java.io.Serializable {

	private Integer id;
	private Person person;	//下订单的用户
	private Integer dcId;	//	陪驾人id
	private Double price;	
	private Date date;
	private String remarks;	//备注
	private int state;
	

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Drivingcorder() {
	}

	public Drivingcorder(Person person, Integer dcId, Double price, Date date, int state) {
		this.person = person;
		this.dcId = dcId;
		this.price = price;
		this.date = date;
		this.state = state;
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

	@Column(name = "dcID")
	public Integer getDcId() {
		return this.dcId;
	}

	public void setDcId(Integer dcId) {
		this.dcId = dcId;
	}

	@Column(name = "price", precision = 22, scale = 0)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", length = 0)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
