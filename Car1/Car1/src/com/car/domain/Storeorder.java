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
 * 商家订单
 */
@Entity
@Table(name = "storeorder", catalog = "car")
public class Storeorder implements java.io.Serializable {

	private Integer id;
	private Person person;
	private Store store;
	private Storeproduct storeproduct;
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

	public Storeorder() {
	}

	public Storeorder(int state,Person person, Store store, Storeproduct storeproduct, double price, Date date, String remarks) {
		this.person = person;
		this.state = state;
		this.store = store;
		this.storeproduct = storeproduct;
		this.price = price;
		this.date = date;
		this.remarks = remarks;
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
	@JoinColumn(name = "personID", nullable = false)
	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "storeID", nullable = false)
	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "productID", nullable = false)
	public Storeproduct getStoreproduct() {
		return this.storeproduct;
	}

	public void setStoreproduct(Storeproduct storeproduct) {
		this.storeproduct = storeproduct;
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
