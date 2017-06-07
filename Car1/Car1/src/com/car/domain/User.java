package com.car.domain;
// Generated 2017-5-4 20:49:12 by Hibernate Tools 5.2.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 存储密码
 */
@Entity
@Table(name = "user", catalog = "car")
public class User implements java.io.Serializable {

	private Integer id;
	private Person person;
	private String username;
	private String password;
	private int type;	// 0没有		1停车场		2服务型商家	3驾校      4陪驾员
	private String storeId;	// 店铺id
	private Vip vip;
	private int state;
	
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public User() {
	}

	public User(int state, Person person, int type, String storeId, Vip vip,String username, String password) {
		this.person = person;
		this.state = state;
		this.type = type;
		this.storeId = storeId;
		this.vip = vip;
		this.username = username;
		this.password = password;
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

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "personID")
	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Column(name = "username", unique=true, nullable = false, length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="vidId")
	public Vip getVip() {
		return vip;
	}

	public void setVip(Vip vip) {
		this.vip = vip;
	}
	
	
}
