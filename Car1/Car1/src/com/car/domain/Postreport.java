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
 * 举报贴子
 */
@Entity
@Table(name = "postreport", catalog = "car")
public class Postreport implements java.io.Serializable {

	private Integer id;
	private Person person;
	private Post post;
	private String content;
	private int state;

	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Postreport() {
	}

	public Postreport(int state,Person person, Post post, String content) {
		this.person = person;
		this.state = state;
		this.post = post;
		this.content = content;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID", unique = true, nullable = false)
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
	@JoinColumn(name = "PostID")
	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Column(name = "content")
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
