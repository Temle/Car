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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 驾校
 */
@Entity
@Table(name = "drivingschool", catalog = "car")
public class Drivingschool implements java.io.Serializable {

	private Integer id;
	private String name;
	private String city;	//驾校所属城市
	private String address;
	private String phoneNumber;
	private double price;
	private String description;
	private String carType;
	private String isPass;
	private Person owener;
	private int state;
	private Set<Drivingorder> drivingorders = new HashSet<Drivingorder>(0);
	private Set<Drivingcoach> drivingcoaches = new HashSet<Drivingcoach>(0);

	
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Drivingschool() {
	}

	public Drivingschool(int state,String name,String city,Person owener, String address, String phoneNumber, double price, String description,
			String carType, String isPass) {
		this.name = name;
		this.state = state;
		this.owener = owener;
		this.city = city;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.price = price;
		this.description = description;
		this.carType = carType;
		this.isPass = isPass;
	}

	public Drivingschool(String city, String name,Person owener, String address, String phoneNumber, double price, String description,
			String carType, String isPass, Set<Drivingorder> drivingorders,
			Set<Drivingcoach> drivingcoaches) {
		this.name = name;
		this.city = city;
		this.owener = owener;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.price = price;
		this.description = description;
		this.carType = carType;
		this.isPass = isPass;
		this.drivingorders = drivingorders;
		this.drivingcoaches = drivingcoaches;
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

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "address", nullable = false, length = 50)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "phoneNumber", nullable = false, length=15)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	@Column(name = "carType", nullable = false, length = 50)
	public String getCarType() {
		return this.carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	@Column(name = "isPass", nullable = false, length = 2)
	public String getIsPass() {
		return this.isPass;
	}

	public void setIsPass(String isPass) {
		this.isPass = isPass;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "drivingschool")
	public Set<Drivingorder> getDrivingorders() {
		return this.drivingorders;
	}

	public void setDrivingorders(Set<Drivingorder> drivingorders) {
		this.drivingorders = drivingorders;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "drivingschool")
	public Set<Drivingcoach> getDrivingcoaches() {
		return this.drivingcoaches;
	}

	public void setDrivingcoaches(Set<Drivingcoach> drivingcoaches) {
		this.drivingcoaches = drivingcoaches;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="owenerId")
	public void setOwener(Person owener){
		this.owener = owener;
	}
	public Person getOwener(){
		return this.owener;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
