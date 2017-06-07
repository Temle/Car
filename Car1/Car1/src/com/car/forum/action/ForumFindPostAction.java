package com.car.forum.action;

import java.util.Map;

import org.apache.commons.lang3.ObjectUtils.Null;

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

public class ForumFindPostAction extends ActionSupport {

	private String title;
	private int pageNo;
	private Post post= new Post();
	private PostHibDao postHib=new PostHibDaoImpl();
	private PostConmentHibDao postComment = new PostConmentHibDaoImpl();
	private ForumService forumService = new ForumServiceImpl();
	private PageBean findPostPageBean = new PageBean();
	
	public String execute()
	{
		int pageNo =1;

		if(getPageNo()!=0)
			pageNo=getPageNo();
		if(findPost(getTitle(), pageNo)==null) return ERROR;
		findPostPageBean = findPost(getTitle(), pageNo); 
		return SUCCESS;
	}
	
	public PageBean findPost(String title,int pageNo) {
		// TODO Auto-generated method stub
		PageBean pageBean=new PageBean();
		pageBean.data = postHib.findPostByTitle(title, pageNo, pageBean.rowsPerPage);
		pageBean.curPage = pageNo;
		pageBean.maxRowCount=(int)postHib.findRowCount(title);
		pageBean.countMaxPage();
		return pageBean;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
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

	public PageBean getFindPostPageBean() {
		return findPostPageBean;
	}

	public void setFindPostPageBean(PageBean findPostPageBean) {
		this.findPostPageBean = findPostPageBean;
	}
}
