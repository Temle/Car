package com.car.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.domain.Person;
import com.car.domain.Post;
import com.car.util.HibernateUtil;

public class PostHibDaoImpl extends BaseDaoHibImpl<Post> implements PostHibDao{

	@Override
	public List findPostByPage(String in,String type,int pageNo, int rowsPerpage) {
		// TODO Auto-generated method stub
		
		List list=new ArrayList();
		HibernateUtil.currentSession().clear();
		Transaction tx=HibernateUtil.currentSession().beginTransaction();
		
		if(in.equals("A")) {
			String sql = "from Post post where post.type='"+type+"' and post.nnumber>=10";
			list = super.findByPage(sql, pageNo, rowsPerpage);
		} else {
			String sql = "from Post post where post.type='"+type+"'and post.nnumber<10";
			list = super.findByPage(sql, pageNo, rowsPerpage);
		}
		tx.commit();
		return list;
	}

	@Override
	public long findRowCount(String in,String type) {
		// TODO Auto-generated method stub
		
		HibernateUtil.currentSession().clear();
		Transaction tx = HibernateUtil.currentSession().beginTransaction();
		if(in.equals("A")) {
			String sql = "select count(*) from Post post where post.type='"+type+"' and post.nnumber>=10";
			List l = super.find(sql);
			tx.commit();
			if (l != null && l.size() == 1) {
				return (long) l.get(0);
			}
			return 0;
		} else {
			String sql = "select count(*) from Post post where post.type='"+type+"' and post.nnumber<10";
			List l = super.find(sql);
			tx.commit();
			if (l != null && l.size() == 1) {
				return (long) l.get(0);
			}
			return 0;
		}
	}

	@Override
	public void addPost(Post post) {
		// TODO Auto-generated method stub
		Transaction tx = HibernateUtil.currentSession().beginTransaction();
		super.save(post);
		tx.commit();
	}

	@Override
	public Post findPostById(int id) {
		// TODO Auto-generated method stub
		String hql = "from Post post where post.id="+id;
			return super.find(hql).get(0);
	}

	@Override
	public List findPostByTitle(String title,int pageNo, int rowsPerpage) {
		// TODO Auto-generated method stub
		Transaction tx = HibernateUtil.currentSession().beginTransaction();
		String hql = "from Post post where post.title='"+title+"'";
		List list= super.findByPage(hql, pageNo, rowsPerpage);
		tx.commit();
		return list;
	}

	@Override
	public List findPostByPage(String in, int pageNo, int rowsPerpage,Person person) {
		// TODO Auto-generated method stub
		
		Transaction tx= HibernateUtil.currentSession().beginTransaction();
		List list=new ArrayList();
		if(in.equals("B")) {
			String sql = "from Post post where post.nnumber>=10 and post.person.id="+person.getId();
			list= super.findByPage(sql, pageNo, rowsPerpage);
		} else {
			String sql = "from Post post where post.nnumber<10 and post.person.id="+person.getId();
			list= super.findByPage(sql, pageNo, rowsPerpage);
		}
		tx.commit();
		return list;
	}

	@Override
	public long findRowCount(String in,Person person) {
		// TODO Auto-generated method stub
		
		Transaction tx= HibernateUtil.currentSession().beginTransaction();
		if(in.equals("B")) {
			String sql = "select count(*) from Post post where post.nnumber>=10 and post.person.id="+person.getId();
			List l = super.find(sql);
			tx.commit();
			if (l != null && l.size() == 1) {
				return (long) l.get(0);
			}
			return 0;
		} else {
			String sql = "select count(*) from Post post where post.nnumber<10 and post.person.id="+person.getId();
			List l = super.find(sql);
			tx.commit();
			if (l != null && l.size() == 1) {
				return (long) l.get(0);
			}
			return 0;
		}
	}

	@Override
	public long findRowCount(String title) {
		// TODO Auto-generated method stub
			String sql = "select count(*) from Post post where post.title='"+title+"'";
			List l = super.find(sql);
			if (l != null && l.size() == 1) {
				return (long) l.get(0);
			}
			return 0;
	}

	@Override
	public void nnumber(Post post) {
		// TODO Auto-generated method stub
		HibernateUtil.currentSession().clear();
		Transaction tx= HibernateUtil.currentSession().beginTransaction();
		post.setNnumber(post.getNnumber()+1);
		super.update(post);
		tx.commit();
	}

}
