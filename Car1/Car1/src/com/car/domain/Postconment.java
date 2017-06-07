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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 贴子评论
 */
@Entity
@Table(name = "postconment", catalog = "car")
public class Postconment implements java.io.Serializable {

	private Integer id;
	private Person person;
	private String content;
	private Date date;
	private Set<Postconmentreport> postconmentreports = new HashSet<Postconmentreport>(0);
	private Post post;
	private int state;
	
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Postconment() {
	}

	public Postconment(int state,Person person, String content, Date date, Post post, Set<Postconmentreport> postconmentreports) {
		this.person = person;
		this.state = state;
		this.content = content;
		this.date = date;
		this.post = post;
		this.postconmentreports = postconmentreports;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "postconment")
	public Set<Postconmentreport> getPostconmentreports() {
		return this.postconmentreports;
	}

	public void setPostconmentreports(Set<Postconmentreport> postconmentreports) {
		this.postconmentreports = postconmentreports;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "postID")
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}
