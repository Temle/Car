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
 * 贴子
 */
@Entity
@Table(name = "post", catalog = "car")
public class Post implements java.io.Serializable {

	private Integer id;
	private Person person;
	private String title;
	private String type;
	private String content;
	private Integer nnumber;	//点赞数量
	private Integer pnumber;	//浏览数量
	private Date date;
	private int state;
	private Set<Postreport> postreports = new HashSet<Postreport>(0);
	private Set<Postconment> postconments = new HashSet<Postconment>(0);
	
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Post() {
	}

	public Post(int state,Person person, String title, String type, String content, Integer nnumber, Integer pnumber, Date date,
			Set<Postreport> postreports, Set<Postconment> postconments) {
		this.person = person;
		this.state = state;
		this.title = title;
		this.type = type;
		this.content = content;
		this.nnumber = nnumber;
		this.pnumber = pnumber;
		this.date = date;
		this.postreports = postreports;
		this.postconments = postconments;
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

	@Column(name = "title")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "type")
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "content")
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "nNumber")
	public Integer getNnumber() {
		return this.nnumber;
	}

	public void setNnumber(Integer nnumber) {
		this.nnumber = nnumber;
	}

	@Column(name = "pNumber")
	public Integer getPnumber() {
		return this.pnumber;
	}

	public void setPnumber(Integer pnumber) {
		this.pnumber = pnumber;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", length = 0)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
	public Set<Postreport> getPostreports() {
		return this.postreports;
	}

	public void setPostreports(Set<Postreport> postreports) {
		this.postreports = postreports;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
	public Set<Postconment> getPostconments() {
		return this.postconments;
	}
	
	public void setPostconments(Set<Postconment> postconments) {
		this.postconments = postconments;
	}
}
