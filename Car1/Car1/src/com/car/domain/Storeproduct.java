package com.car.domain;
// Generated 2017-5-4 20:49:12 by Hibernate Tools 5.2.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 商家服务、产品
 */
@Entity
@Table(name = "storeproduct", catalog = "car")
public class Storeproduct implements java.io.Serializable {

	private Integer id;
	private Store store;
	private String name;
	private double price;
	private String description;
	private String imgurl;
	private int state;
	private Set<Storeorder> storeorders = new HashSet<Storeorder>(0);

	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Storeproduct() {
	}

	public Storeproduct(int state, Store store, String name, double price, String description, String imgurl) {
		this.store = store;
		this.state = state;
		this.name = name;
		this.price = price;
		this.description = description;
		this.imgurl = imgurl;
	}

	public Storeproduct(Store store, String name, double price, String description,String imgurl, Set<Storeorder> storeorders) {
		this.store = store;
		this.name = name;
		this.price = price;
		this.description = description;
		this.imgurl = imgurl;
		this.storeorders = storeorders;
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
	@JoinColumn(name = "storeID", nullable = false)
	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "price", nullable = false, precision = 22, scale = 0)
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "storeproduct")
	public Set<Storeorder> getStoreorders() {
		return this.storeorders;
	}

	public void setStoreorders(Set<Storeorder> storeorders) {
		this.storeorders = storeorders;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
	
}
