package com.car.forum.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.dao.PostConmentHibDao;
import com.car.dao.PostConmentHibDaoImpl;
import com.car.dao.PostHibDao;
import com.car.dao.PostHibDaoImpl;
import com.car.domain.Person;
import com.car.domain.Post;
import com.car.domain.Postconment;
import com.car.domain.User;
import com.car.service.forum.ForumService;
import com.car.service.forum.ForumServiceImpl;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ForumReadPostConmentAction extends ActionSupport {

	private Post post = new Post();
	private Postconment postConment= new Postconment();
	private int id;
	private String content;
	private PostHibDao postHib=new PostHibDaoImpl();
	private PostConmentHibDao postComment = new PostConmentHibDaoImpl();
	

	private ForumService forumService = new ForumServiceImpl();
	
	public String execute()
	{
		Session session=HibernateUtil.sessionFactory.getCurrentSession();
		
		ActionContext context = ActionContext.getContext();
		Map map=context.getSession();
		Person person=null;
		String username=(String)map.get("user");
		String hql="from User user where user.username = :name";
		
		Transaction tx=session.beginTransaction();
		List<User> list= session.createQuery(hql).setParameter("name", username).list();
		tx.commit();
		
		for(User user:list)
		{
			person=user.getPerson();
		}

		
		postConment.setContent(getContent());
		postConment.setDate(new Date());
		postConment.setPerson(person);
		postConment.setPost(readPost(getId()));
		addPostconment(postConment);

		post= readPost(getId());
		
		return SUCCESS;
	}

	
	public Post readPost(int id) {
		// TODO Auto-generated method stub
		return postHib.findPostById(id);
	}
	
	public void addPostconment(Postconment postconment) {
		// TODO Auto-generated method stub
		postComment.addPostconment(postconment);
	}
	
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Postconment getPostConment() {
		return postConment;
	}

	public void setPostConment(Postconment postConment) {
		this.postConment = postConment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
