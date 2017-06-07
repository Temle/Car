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
import com.car.domain.User;
import com.car.service.forum.ForumService;
import com.car.service.forum.ForumServiceImpl;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ForumPostAction extends ActionSupport {

	private Post post;
	private ForumService forumService = new ForumServiceImpl();
	private PostHibDao postHib=new PostHibDaoImpl();
	private PostConmentHibDao postComment = new PostConmentHibDaoImpl();
	
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

		
		if(getPost().getType().equals("板块一")) post.setType("X");
		else if(getPost().getType().equals("板块二")) post.setType("Y");
		else post.setType("Z");
		post.setDate(new Date());
		post.setNnumber(0);
		post.setPerson(person);
		addPost(getPost());

		return SUCCESS;
	}

	public void addPost(Post post) {
		// TODO Auto-generated method stub
		postHib.addPost(post);
	}
	
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}
