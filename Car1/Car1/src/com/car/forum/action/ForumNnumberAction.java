package com.car.forum.action;

import javax.transaction.Transaction;

import com.car.dao.PostHibDao;
import com.car.dao.PostHibDaoImpl;
import com.car.domain.Post;
import com.car.service.forum.ForumService;
import com.car.service.forum.ForumServiceImpl;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;

public class ForumNnumberAction extends ActionSupport {

	private int id;
	private ForumService forumService = new ForumServiceImpl();
	private PostHibDao postHibDao= new PostHibDaoImpl();
	
	public String execute()
	{
		Post post=forumService.readPost(id);
		System.out.println("enter "+post.getNnumber());
		postHibDao.nnumber(post);
		System.out.println("out "+post.getNnumber());
		
		Post post2 = forumService.readPost(id);
		System.out.println("res "+post2.getNnumber());
		
		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
