package com.car.forum.action;

import java.util.Map;

import com.car.Tool.PageBean;
import com.car.dao.PostConmentHibDao;
import com.car.dao.PostConmentHibDaoImpl;
import com.car.dao.PostHibDao;
import com.car.dao.PostHibDaoImpl;
import com.car.domain.Post;
import com.car.service.forum.ForumService;
import com.car.service.forum.ForumServiceImpl;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ForumTwoAction extends ActionSupport {
	
	private Post post = new Post();
	private int pageNoOne;
	private int pageNoTwo;	
	private PostHibDao postHib=new PostHibDaoImpl();
	private PostConmentHibDao postComment = new PostConmentHibDaoImpl();
	private ForumService forumService = new ForumServiceImpl();
	private PageBean blockOneLeft=new PageBean();
	private PageBean blockOneRight=new PageBean();
	
	public String execute()
	{
		int pageNoOne=1;
		int pageNoTwo=1;
		
		if(getPageNoOne()!=0)
			pageNoOne=getPageNoOne();
		PageBean pageBean1 = getPost("A",pageNoOne,"Y"); 
		HibernateUtil.session.get().flush();
		HibernateUtil.session.get().clear();
		blockOneLeft = pageBean1;
		
		if(getPageNoTwo()!=0)
			pageNoTwo=getPageNoTwo();
		PageBean pageBean2 = getPost("B",pageNoTwo,"Y"); 
		HibernateUtil.session.get().flush();
		HibernateUtil.session.get().clear();
		blockOneRight =pageBean2;
		return SUCCESS;
	}
	
	public PageBean getPost(String in,int pageNo,String type) {
		// TODO Auto-generated method stub
		PageBean pageBean=new PageBean();
		pageBean.data=postHib.findPostByPage(in,type,pageNo, pageBean.rowsPerPage);
		pageBean.curPage=pageNo;
		pageBean.maxRowCount=(int)postHib.findRowCount(in,type);
		pageBean.countMaxPage();
		return pageBean;
	}
	
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
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

	public ForumService getForumService() {
		return forumService;
	}

	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
	}

	public PageBean getBlockOneLeft() {
		return blockOneLeft;
	}

	public void setBlockOneLeft(PageBean blockOneLeft) {
		this.blockOneLeft = blockOneLeft;
	}

	public PageBean getBlockOneRight() {
		return blockOneRight;
	}

	public void setBlockOneRight(PageBean blockOneRight) {
		this.blockOneRight = blockOneRight;
	}

	
}
