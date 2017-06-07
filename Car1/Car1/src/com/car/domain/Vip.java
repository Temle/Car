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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Vip表
 */
@Entity
@Table(name = "vip", catalog = "car")
public class Vip implements java.io.Serializable {

	private Integer id;
	private int level;
	private int integral;
	private Date startDate;
	private Date endDate;
	private Person person;
	private int state;

	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Vip() {
	}

	public Vip(int state, int level, int integral, Date startDate, Date endDate, Person person) {
		this.level = level;
		this.state = state;
		this.integral = integral;
		this.startDate = startDate;
		this.endDate = endDate;
		this.person =person;
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

	@Column(name = "level", nullable = false)
	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Column(name = "integral", nullable = false)
	public int getIntegral() {
		return this.integral;
	}

	public void setIntegral(int integral) {
		this.integral = integral;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "StartDate", nullable = false, length = 0)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EndDate", nullable = false, length = 0)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "personID")
	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
