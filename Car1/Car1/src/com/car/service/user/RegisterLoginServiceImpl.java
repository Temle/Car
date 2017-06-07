package com.car.service.user;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.dao.DrivingschoolHibDao;
import com.car.dao.DrivingschoolHibDaoImpl;
import com.car.dao.ParkHibDao;
import com.car.dao.ParkHibDaoImpl;
import com.car.dao.PersonCarHibDao;
import com.car.dao.PersonCarHibDaoImpl;
import com.car.dao.PersonHibDao;
import com.car.dao.PersonHibDaoImpl;
import com.car.dao.StoreHibDao;
import com.car.dao.StoreHibDaoImpl;
import com.car.dao.UserHibDao;
import com.car.dao.UserHibDaoImpl;
import com.car.domain.Drivingschool;
import com.car.domain.Park;
import com.car.domain.Person;
import com.car.domain.Personcar;
import com.car.domain.Store;
import com.car.domain.User;
import com.car.util.HibernateUtil;

public class RegisterLoginServiceImpl implements RegisterLoginService {

	PersonHibDao personDao = new PersonHibDaoImpl();
	UserHibDao userDao = new UserHibDaoImpl();
	PersonCarHibDao pCarDao = new PersonCarHibDaoImpl();
	ParkHibDao parkDao = new ParkHibDaoImpl();
 	DrivingschoolHibDao dSchoolDao = new DrivingschoolHibDaoImpl();
	StoreHibDao storeDao = new StoreHibDaoImpl();
 	
	@Override
	public boolean registerPerson(Person p, User u) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		boolean flag=false;
		try {
			Session session = HibernateUtil.currentSession();
			transaction = session.beginTransaction();
			
			Person person=personDao.findByPhoneNum(p.getPhoneNumber());   //查看是否有该对象
			if(person==null)
			{
				personDao.save(p);
				u.setPerson(p);
				u.setUsername(p.getPhoneNumber());
				userDao.save(u);
				flag=true;
			}
			else
				flag=false;
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		return flag;
	}

	@Override
	public boolean registerCar(int personId, Personcar p) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		boolean flag=false;
		try {
			Session session = HibernateUtil.currentSession();
			transaction = session.beginTransaction();
			
			
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		return flag;
	}

	@Override
	public boolean registerPark(int personId, Park p) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		boolean flag=false;
		try {
			Session session = HibernateUtil.currentSession();
			transaction = session.beginTransaction();
			
			
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		return flag;
	}

	@Override
	public boolean registerDrivingSchool(int personId, Drivingschool ds) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		boolean flag=false;
		try {
			Session session = HibernateUtil.currentSession();
			transaction = session.beginTransaction();
			
			
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		return flag;
	}

	@Override
	public boolean registerStore(User u, Store s) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		boolean flag=false;
		try {
			Session session = HibernateUtil.currentSession();
			transaction = session.beginTransaction();
			s.setIsPass("Y");
			storeDao.save(s);
			User user=userDao.findID(u.getId());
			user.setStoreId(s.getId().toString());
			user.setType(2);
			userDao.update(user);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		return flag;
	}

	@Override
	public boolean userLogin(String phoneNum,String password) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		boolean flag=false;
		try {
			Session session = HibernateUtil.currentSession();
			transaction = session.beginTransaction();
			
			Person person=personDao.findByPhoneNum(phoneNum);
			if(person!=null)
			{
				User user=userDao.findPersonID(person.getId());
				if(user.getPassword().equals(password))
					flag=true;
				else
					flag=false;
			}
			else
				flag=false;
			
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		return flag;
	}
}
