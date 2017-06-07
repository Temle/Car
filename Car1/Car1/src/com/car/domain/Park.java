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
 * Park generated by hbm2java
 */
public class Park implements java.io.Serializable {

	private Integer id;
	private Point point;
	private String name;
	private String address;
	private String phoneNumber;
	private String description;
	private int parkSpaceNumber;
	private int restNumber;
	private double price;
	private String isPass;
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Park() {
	}

	public Park(int state,Point point, String name, String address, String phoneNumber, String description, int parkSpaceNumber,
			int restNumber, double price, String isPass) {
		this.point = point;
		this.state = state;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.description = description;
		this.parkSpaceNumber = parkSpaceNumber;
		this.restNumber = restNumber;
		this.price = price;
		this.isPass = isPass;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Point getPoint() {
		return this.point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getParkSpaceNumber() {
		return this.parkSpaceNumber;
	}

	public void setParkSpaceNumber(int parkSpaceNumber) {
		this.parkSpaceNumber = parkSpaceNumber;
	}

	public int getRestNumber() {
		return this.restNumber;
	}

	public void setRestNumber(int restNumber) {
		this.restNumber = restNumber;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getIsPass() {
		return this.isPass;
	}

	public void setIsPass(String isPass) {
		this.isPass = isPass;
	}

}
