package com.car.forum.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transaction;

import com.car.Tool.PageBean;
import com.car.dao.PostConmentHibDao;
import com.car.dao.PostConmentHibDaoImpl;
import com.car.dao.PostHibDao;
import com.car.dao.PostHibDaoImpl;
import com.car.domain.Post;
import com.car.service.forum.ForumService;
import com.car.service.forum.ForumServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.car.util.HibernateUtil;;

public class ForumAction extends ActionSupport {

	private int pageNoOne;
	private int pageNoTwo;
	private ForumService forumService = new ForumServiceImpl();
	private PostHibDao postHib=new PostHibDaoImpl();
	private PostConmentHibDao postComment = new PostConmentHibDaoImpl();
	private PageBean blockOneLeft=new PageBean();
	private PageBean blockOneRight=new PageBean();
	
	public String execute(){
		int pageNoOne=1;
		int pageNoTwo=1;
		
		
		if(getPageNoOne()!=0)
			pageNoOne=getPageNoOne();
		PageBean pageBean1 = getPost("A",pageNoOne,"X");
		blockOneLeft=pageBean1;
		
		if(getPageNoTwo()!=0)
			pageNoTwo=getPageNoTwo();
		PageBean pageBean2 = getPost("B",pageNoTwo,"X"); 
		blockOneRight=pageBean2;
		
		List<Post> list=blockOneLeft.getData();
		for (Post post:list)
		{
			System.out.println(post.getId()+" "+post.getTitle()+" "+post.getNnumber());
		}
		System.out.println("flush "+ new Date());
		
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
