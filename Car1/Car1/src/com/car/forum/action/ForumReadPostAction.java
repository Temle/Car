package com.car.forum.action;

import java.util.Map;

import com.car.Tool.PageBean;
import com.car.dao.PostConmentHibDao;
import com.car.dao.PostConmentHibDaoImpl;
import com.car.dao.PostHibDao;
import com.car.dao.PostHibDaoImpl;
import com.car.domain.Post;
import com.car.domain.Postconment;
import com.car.service.forum.ForumService;
import com.car.service.forum.ForumServiceImpl;
import com.car.util.HibernateUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ForumReadPostAction extends ActionSupport {
	private Post post= new Post();
	private int id;
	private int pageNo;
	private PostHibDao postHib=new PostHibDaoImpl();
	private PostConmentHibDao postComment = new PostConmentHibDaoImpl();
	private ForumService forumService = new ForumServiceImpl();
	private PageBean readPostPageBean = new PageBean();
	
	public String execute()
	{
		post = readPost(getId());
		HibernateUtil.session.get().flush();
		HibernateUtil.session.get().clear();
		
		int pageNo=1;
		if(getPageNo()!=0)
			pageNo=getPageNo();
		PageBean pageBean = showPostComment(pageNo, getId());
		HibernateUtil.session.get().flush();
		HibernateUtil.session.get().clear();
		
		readPostPageBean =pageBean;
		return SUCCESS;
	}
	
	
	public Post readPost(int id) {
		// TODO Auto-generated method stub
		return postHib.findPostById(id);
	}

	public PageBean showPostComment(int pageNo,int id) {
		// TODO Auto-generated method stub
		PageBean pageBean=new PageBean();
		pageBean.data = postComment.findPageById(pageNo, pageBean.rowsPerPage, id);
		pageBean.curPage = pageNo;
		pageBean.maxRowCount=(int)postComment.findRowCount(id);
		pageBean.countMaxPage();
		return pageBean;
	}
	
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
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


	public PageBean getReadPostPageBean() {
		return readPostPageBean;
	}


	public void setReadPostPageBean(PageBean readPostPageBean) {
		this.readPostPageBean = readPostPageBean;
	}
}
