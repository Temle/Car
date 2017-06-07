package com.car.forum.action;

import java.util.List;
import java.util.Map;

import javax.transaction.Transaction;

import org.hibernate.Session;

import com.car.Tool.PageBean;
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

public class ForumPersonAction extends ActionSupport {

	private Post post=new Post();
	private Postconment postconment= new Postconment();
	private ForumService forumService = new ForumServiceImpl();
	private int pageNoOne;
	private int pageNoTwo;
	private int pageNoThree;
	private int id;
	private PostHibDao postHib=new PostHibDaoImpl();
	private PostConmentHibDao postComment = new PostConmentHibDaoImpl();
	private PageBean left=new PageBean();
	private PageBean middle=new PageBean();
	private PageBean right=new PageBean();
	
	public String execute()
	{
		int pageNoOne=1;
		int pageNoTwo=1;
		int pageNoThree=1;
		
		Session session=HibernateUtil.sessionFactory.getCurrentSession();
		ActionContext context = ActionContext.getContext();
		Map map=context.getSession();
		Person person=null;
		String username=(String)map.get("user");
		String hql="from User user where user.username = :name";
		
		org.hibernate.Transaction tx=session.beginTransaction();
		List<User> list= session.createQuery(hql).setParameter("name", username).list();
		tx.commit();
		
		for(User user:list)
		{
			person=user.getPerson();
		}
		
		if(getPageNoOne()!=0)
			pageNoOne=getPageNoOne();
		PageBean pageBean1 = getPost("A",pageNoOne,person); 
		
		left = pageBean1;
		
		if(getPageNoTwo()!=0)
			pageNoTwo=getPageNoTwo();
		PageBean pageBean2 = showPostComment(pageNoTwo, person); 
		HibernateUtil.session.get().flush();
		HibernateUtil.session.get().clear();
		middle = pageBean2;
		
		if(getPageNoThree()!=0)
			pageNoThree=getPageNoThree();
		PageBean pageBean3 = getPost("B",pageNoThree,person); 
		
		right = pageBean3;
		if(getId()==2)
			return SUCCESS;
		else if(getId()==1)
			return ERROR;
		else return INPUT;
	}
	
	
	
	public PageBean getPost(String in, int pageNo, Person person) {
		// TODO Auto-generated method stub
		PageBean pageBean=new PageBean();
		pageBean.data=postHib.findPostByPage(in,pageNo, pageBean.rowsPerPage,person);
		pageBean.curPage=pageNo;
		pageBean.maxRowCount=(int)postHib.findRowCount(in,person);
		pageBean.countMaxPage();
		return pageBean;
	}
	
	public PageBean showPostComment(int pageNo, Person person) {
		// TODO Auto-generated method stub
		PageBean pageBean=new PageBean();
		pageBean.data = postComment.findPageByPerson(pageNo, pageBean.rowsPerPage, person);
		pageBean.curPage = pageNo;
		pageBean.maxRowCount=(int)postComment.findRowCount(person);
		pageBean.countMaxPage();
		return pageBean;
	}
	
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Postconment getPostconment() {
		return postconment;
	}

	public void setPostconment(Postconment postconment) {
		this.postconment = postconment;
	}

	public int getPageNoOne() {
		return pageNoOne;
	}

	public void setPageNoOne(int pageNoOne) {
		this.pageNoOne = pageNoOne;
	}

	public int getPageNoTwo() {
		return pageNoTwo;
	}

	public void setPageNoTwo(int pageNoTwo) {
		this.pageNoTwo = pageNoTwo;
	}

	public int getPageNoThree() {
		return pageNoThree;
	}

	public void setPageNoThree(int pageNoThree) {
		this.pageNoThree = pageNoThree;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public ForumService getForumService() {
		return forumService;
	}



	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
	}



	public PostHibDao getPostHib() {
		return postHib;
	}



	public void setPostHib(PostHibDao postHib) {
		this.postHib = postHib;
	}



	public PostConmentHibDao getPostComment() {
		return postComment;
	}



	public void setPostComment(PostConmentHibDao postComment) {
		this.postComment = postComment;
	}



	public PageBean getLeft() {
		return left;
	}



	public void setLeft(PageBean left) {
		this.left = left;
	}



	public PageBean getMiddle() {
		return middle;
	}



	public void setMiddle(PageBean middle) {
		this.middle = middle;
	}



	public PageBean getRight() {
		return right;
	}



	public void setRight(PageBean right) {
		this.right = right;
	}
	
}
