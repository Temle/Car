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
 * 驾校教练 ，不属于系统 ，由驾校添加教练信息
 */
@Entity
@Table(name = "drivingcoach", catalog = "car")
public class Drivingcoach implements java.io.Serializable {

	private Integer id;
	private Drivingschool drivingschool;	// 所属驾校
	private String name;
	private String sex;
	private String phoneNumber;
	private String description;
	private int state;
	
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Column(name = "sex", nullable = false)
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public Drivingcoach() {
	}

	public Drivingcoach(Drivingschool drivingschool,String name, String phoneNumber, String description, int state) {
		this.drivingschool = drivingschool;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.description = description;
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

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "phoneNumber", nullable = false)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
