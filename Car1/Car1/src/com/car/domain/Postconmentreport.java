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
 * 	举报贴子回复
 */
@Entity
@Table(name = "postconmentreport", catalog = "car")
public class Postconmentreport implements java.io.Serializable {

	private Integer id;
	private Person person;
	private Postconment postconment;
	private String content;
	private Date date;
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Postconmentreport() {
	}

	public Postconmentreport(int state,Person person,Postconment postconment, String content, Date date) {
		this.person = person;
		this.state = state;
		this.postconment = postconment;
		this.content = content;
		this.date = date;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PostConmentID")
	public Postconment getPostconment() {
		return this.postconment;
	}

	public void setPostconment(Postconment postconment) {
		this.postconment = postconment;
	}

	@Column(name = "content")
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", length = 0)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
