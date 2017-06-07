package com.car.domain;
// Generated 2017-5-4 20:49:12 by Hibernate Tools 5.2.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 陪驾
 */
@Entity
@Table(name = "drivingcompanion", catalog = "car")
public class Drivingcompanion implements java.io.Serializable {

	private Integer id;
	private Person person;	// 人员
	private Integer drivingAge;
	private String description;
	private Integer price;
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Drivingcompanion() {
	}

	public Drivingcompanion(Integer id,Person person, Integer drivingAge, String description, Integer price,int state) {
		this.id=id;
		this.person = person;
		this.drivingAge = drivingAge;
		this.description = description;
		this.price = price;
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

	@Column(name = "drivingAge")
	public Integer getDrivingAge() {
		return this.drivingAge;
	}

	public void setDrivingAge(Integer drivingAge) {
		this.drivingAge = drivingAge;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "price")
	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
