package com.car.service.forum;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.Tool.PageBean;
import com.car.dao.PostConmentHibDao;
import com.car.dao.PostConmentHibDaoImpl;
import com.car.dao.PostHibDao;
import com.car.dao.PostHibDaoImpl;
import com.car.domain.Person;
import com.car.domain.Post;
import com.car.domain.Postconment;
import com.car.util.HibernateUtil;

public class ForumServiceImpl implements ForumService{

	private PostHibDao postHib=new PostHibDaoImpl();
	private PostConmentHibDao postComment = new PostConmentHibDaoImpl();
	@Override
	public PageBean getPost(String in,int pageNo,String type) {
		// TODO Auto-generated method stub
		PageBean pageBean=new PageBean();
		pageBean.data=postHib.findPostByPage(in,type,pageNo, pageBean.rowsPerPage);
		pageBean.curPage=pageNo;
		pageBean.maxRowCount=(int)postHib.findRowCount(in,type);
		pageBean.countMaxPage();
		return pageBean;
	}
	@Override
	public void addPost(Post post) {
		// TODO Auto-generated method stub
		postHib.addPost(post);
	}
	@Override
	public Post readPost(int id) {
		// TODO Auto-generated method stub
		
		HibernateUtil.currentSession().clear();
		Transaction tx= HibernateUtil.currentSession().beginTransaction();
		Post post=postHib.findPostById(id);
		tx.commit();
		return post;
	}
	@Override
	public PageBean showPostComment(int pageNo,int id) {
		// TODO Auto-generated method stub
		PageBean pageBean=new PageBean();
		pageBean.data = postComment.findPageById(pageNo, pageBean.rowsPerPage, id);
		pageBean.curPage = pageNo;
		pageBean.maxRowCount=(int)postComment.findRowCount(id);
		pageBean.countMaxPage();
		return pageBean;
	}
	@Override
	public void addPostconment(Postconment postconment) {
		// TODO Auto-generated method stub
		postComment.addPostconment(postconment);
	}
	@Override
	public PageBean findPost(String title,int pageNo) {
		// TODO Auto-generated method stub
		PageBean pageBean=new PageBean();
		pageBean.data = postHib.findPostByTitle(title, pageNo, pageBean.rowsPerPage);
		pageBean.curPage = pageNo;
		pageBean.maxRowCount=(int)postHib.findRowCount(title);
		pageBean.countMaxPage();
		return pageBean;
	}
	@Override
	public PageBean showPostComment(int pageNo, Person person) {
		// TODO Auto-generated method stub
		PageBean pageBean=new PageBean();
		pageBean.data = postComment.findPageByPerson(pageNo, pageBean.rowsPerPage, person);
		pageBean.curPage = pageNo;
		pageBean.maxRowCount=(int)postComment.findRowCount(person);
		pageBean.countMaxPage();
		return pageBean;
	}
	@Override
	public PageBean getPost(String in, int pageNo, Person person) {
		// TODO Auto-generated method stub
		PageBean pageBean=new PageBean();
		pageBean.data=postHib.findPostByPage(in,pageNo, pageBean.rowsPerPage,person);
		pageBean.curPage=pageNo;
		pageBean.maxRowCount=(int)postHib.findRowCount(in,person);
		pageBean.countMaxPage();
		return pageBean;
	}
	/*

	@Override
	public List postOfModuel(String type) {
		// TODO Auto-generated method stub
		return postHib.findByType(type);
	}

	@Override
	public Post watchPost(String id) {
		// TODO Auto-generated method stub
		return postHib.findById(Integer.parseInt(id));
	}
	
	@Override
	public List postComment(String personID) {
		// TODO Auto-generated method stub
		return postComment.findByPost(Integer.parseInt(personID));
	}

	@Override
	public void reportPost(String id) {
		// TODO Auto-generated method stub
		Post post =watchPost(id);
		Session s =HibernateUtil.currentSession();
		Transaction trans = s.beginTransaction();
		post.setType("B");
		s.save(post);
		trans.commit();
		HibernateUtil.closeSession();
	}

	@Override
	public void commentPost(String content,Person person) {
		// TODO Auto-generated method stub
		Postconment com = new Postconment();
		Session s = HibernateUtil.currentSession();
		Transaction tx = s.beginTransaction();
		com.setContent(content);
		com.setPerson(person);
		s.save(com);
		tx.commit();
		HibernateUtil.closeSession();
	}

	@Override
	public void postPost(String title,String content) {
		// TODO Auto-generated method stub
		Post com = new Post();
		Session s = HibernateUtil.currentSession();
		Transaction tx = s.beginTransaction();
		com.setContent(content);
		com.setTitle(title);
		s.save(com);
		tx.commit();
		HibernateUtil.closeSession();
	}
	
	@Override
	public List myPost(String personID,int pageNo,int pageSize)
	{
		return postHib.findByPagePid(Integer.parseInt(personID), pageNo, pageSize);
	}

	@Override
	public void deletePost(String id) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.currentSession();
		Transaction tx = s.beginTransaction();
		String hqlUpdate = "delete Post where Person p.id = ?0 ";
		int updatedEntities = s.createQuery( hqlUpdate )
				.setString( "0", id )
				.executeUpdate();
		tx.commit();
		HibernateUtil.closeSession();
	}

	@Override
	public void deleteComment(String id) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.currentSession();
		Transaction tx = s.beginTransaction();
		String hqlUpdate = "delete Postconment where Person p.id = ?0 ";
		int updatedEntities = s.createQuery( hqlUpdate )
				.setString( "0", id )
				.executeUpdate();
		tx.commit();
		HibernateUtil.closeSession();
		
	}

	@Override
	public List watchReportedPost() {
		// TODO Auto-generated method stub
		return postHib.findByType("B");
	}*/


}
