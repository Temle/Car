package com.car.domain;
// Generated 2017-5-4 20:49:12 by Hibernate Tools 5.2.1.Final

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 个人信息表 密码在user表里， 权限在 authority表里
 */
@Entity
@Table(name = "person", catalog = "car")
public class Person implements java.io.Serializable {

	private Integer id;
	private String name;
	private int age;
	private String sex;
	private String address;
	private String phoneNumber;
	private String email;
	private Date birthDate;
	private User user;
	private int state;
	

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Person() {
	}

	public Person(int state,String name, int age, String sex, String address, String phoneNumber, String email,User user) {
		this.name = name;
		this.state = state;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.user = user;
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

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "age", nullable = false)
	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Column(name = "sex", nullable = false, length = 2)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "address", nullable = false, length = 50)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "phoneNumber", nullable = false, length = 15)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "email", nullable = false, length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthDate", length = 0)
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="userId")
	public User getUser(){
		return this.user;
	}
	
	public void setUser(User user){
		this.user=user;
	}
}
