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
 * 驾校订单
 */
@Entity
@Table(name = "drivingorder", catalog = "car")
public class Drivingorder implements java.io.Serializable {

	private Integer id;
	private Drivingschool drivingschool;
	private Person person;
	private double price;
	private Date date;
	private String remarks;
	private int state;
	
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Drivingorder() {
	}

	public Drivingorder(Drivingschool drivingschool, Person person, double price, Date date, String remarks,int state) {
		this.drivingschool = drivingschool;
		this.person = person;
		this.price = price;
		this.date = date;
		this.remarks = remarks;
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
	@JoinColumn(name = "dschoolID", nullable = false)
	public Drivingschool getDrivingschool() {
		return this.drivingschool;
	}

	public void setDrivingschool(Drivingschool drivingschool) {
		this.drivingschool = drivingschool;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "personID", nullable = false)
	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Column(name = "price", nullable = false, precision = 22, scale = 0)
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Date", nullable = false, length = 0)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "Remarks", nullable = false)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
