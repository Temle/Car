package com.car.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.domain.Person;
import com.car.domain.Postconment;
import com.car.util.HibernateUtil;

public class PostConmentHibDaoImpl extends BaseDaoHibImpl<Postconment> implements PostConmentHibDao{

	@Override
	public List findPageById(int pageNo,int rowsPerpage,int id) {
		// TODO Auto-generated method stub
		String hql = "from Postconment p where p.post.id="+id;
		return super.findByPage(hql, pageNo, rowsPerpage);
	}

	@Override
	public long findRowCount(int id) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Postconment p where p.post.id="+id;
		List l = super.find(hql);
		if (l != null && l.size()==1) {
			return (long) l.get(0);
		}
		return 0;
	}

	@Override
	public void addPostconment(Postconment postconment) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.currentSession();
		Transaction tx = s.beginTransaction();
		s.save(postconment);
		tx.commit();
	}

	@Override
	public List findPageByPerson(int pageNo, int rowsPerpage, Person person) {
		// TODO Auto-generated method stub
		Transaction tx = HibernateUtil.currentSession().beginTransaction();
		String hql = "from Postconment p where p.person.id="+person.getId();
		List list= super.findByPage(hql, pageNo, rowsPerpage);
		tx.commit();
		return list;
	}

	@Override
	public long findRowCount(Person person) {
		// TODO Auto-generated method stub
		
		Transaction tx = HibernateUtil.currentSession().beginTransaction();
		String hql = "select count(*) from Postconment p where p.person.id="+person.getId();
		List l = super.find(hql);
		tx.commit();
		if (l != null && l.size()==1) {
			return (long) l.get(0);
		}
		return 0;
	}

}
