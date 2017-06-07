package com.car.service.user;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.dao.DrivingCorderHibDao;
import com.car.dao.DrivingCorderHibDaoImpl;
import com.car.dao.DrivingorderHibDao;
import com.car.dao.DrivingorderHibDaoImpl;
import com.car.dao.ParkHibDao;
import com.car.dao.ParkHibDaoImpl;
import com.car.dao.ParkorderHibDao;
import com.car.dao.ParkorderHibDaoImpl;
import com.car.dao.PersonCarHibDao;
import com.car.dao.PersonCarHibDaoImpl;
import com.car.dao.PersonHibDao;
import com.car.dao.PersonHibDaoImpl;
import com.car.dao.StoreorderHibDao;
import com.car.dao.StoreorderHibDaoImpl;
import com.car.dao.UserHibDao;
import com.car.dao.UserHibDaoImpl;
import com.car.dao.VipHibDao;
import com.car.dao.VipHibDaoImpl;
import com.car.domain.Drivingschool;
import com.car.domain.Person;
import com.car.domain.Personcar;
import com.car.domain.User;
import com.car.domain.Vip;
import com.car.util.HibernateUtil;

public class UserServiceImpl implements UserService {

	PersonHibDao personDao = new PersonHibDaoImpl();
	UserHibDao userDao = new UserHibDaoImpl();
	VipHibDao vipDao = new VipHibDaoImpl();
	PersonCarHibDao personCarDao = new PersonCarHibDaoImpl();
	ParkorderHibDao parkOrderDao = new ParkorderHibDaoImpl();
	StoreorderHibDao storeOrderDao = new StoreorderHibDaoImpl();
	DrivingorderHibDao drivingOrderDao = new DrivingorderHibDaoImpl();
	DrivingCorderHibDao drivingCOrderDao = new DrivingCorderHibDaoImpl();
	
	@Override
	public boolean changePassword(int personId, String password) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		boolean flag=false;
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();
			
			User user = userDao.findPersonID(personId);
			if(user!=null)
			{
				user.setPassword(password);
				flag=true;
			}
			else
				flag=false;
			
			tx.commit();	
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		return flag;
	}

	@Override
	public boolean changePersonInfo(Person p) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		boolean flag=false;
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();
			
			Person person =personDao.findID(p.getId());
			if(person!=null)
			{
				person=p;
				flag=true;
			}
			else
				flag=false;
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		return flag;
	}

	@Override
	public Person searchInfo(int personId) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		Person person=null;
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();
			
			person=personDao.findID(personId);
			
			tx.commit();
		
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		if(person!=null)
			return person;
		else
			return null;
		
	}

	@Override
	public Person searchInfo(String phoneNum) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		Person person=null;
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();
			
			person=personDao.findByPhoneNum(phoneNum);
			
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		if(person!=null)
			return person;
		else
			return null;
	}

	@Override
	public List searchNofication() {
		// TODO Auto-generated method stub
		Transaction tx=null;
		try {
			
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	
	@Override
	public boolean registerVIP(Person p) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		boolean flag=false;
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();
			
			Person person=personDao.findID(p.getId());
			Vip v=vipDao.findByPersonId(p.getId());
			if(person!=null&&v==null)
			{
				Vip vip=new Vip();
				vip.setIntegral(10);
				vip.setLevel(1);
				vip.setPerson(person);
				Calendar calendar=Calendar.getInstance();
				int year=calendar.get(Calendar.YEAR);
				int month=calendar.get(Calendar.MONTH);
				int day=calendar.get(Calendar.DATE);
				int hour=calendar.get(Calendar.HOUR_OF_DAY);
				int minute=calendar.get(Calendar.MINUTE);
				int second=calendar.get(Calendar.SECOND);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date startDate=new Date(year, month, day, hour, minute, second);
				Date endDate=new Date(year+1, month, day, hour, minute, second);
				vip.setStartDate(sdf.parse(sdf.format(startDate)));
				vip.setEndDate(sdf.parse(sdf.format(endDate)));
				vipDao.save(vip);
				
				
				flag=true;
			}
			else {
				flag=false;
			}
			
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		return flag;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean goOnVIP(Person p) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		boolean flag=false;
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();
			
			Person person=personDao.findID(p.getId());
			Vip vip=vipDao.findByPersonId(p.getId());
			if(person!=null&&vip!=null)
			{
				vip.setIntegral(vip.getIntegral()+10);
				vip.setLevel(vip.getLevel()+1);
				Date date=vip.getEndDate();
				date.setYear(date.getYear()+1);
				vip.setEndDate(date);
				flag=true;
			}else {
				flag=false;
			}
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		return flag;
	}

	@Override
	public List searchParkOrder(Person p,int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		List parkOrder=null;
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();
			
			parkOrder = parkOrderDao.FindByPersonIdBypage(p.getId(), pageNo, pageSize);
			
			tx.commit();
			if(parkOrder.size()>0)
				return parkOrder;
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession();
		}
		if(parkOrder.size()>0)
			return parkOrder;
		else {
			return null;
		}
	}

	@Override
	public List searchStoreOrder(Person p,int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		List storeOrder=null;
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();
			
			storeOrder=storeOrderDao.findByPersonIdByPage(p.getId(), pageNo, pageSize);
			
			tx.commit();
			if(storeOrder.size()>0)
				return storeOrder;
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession();
		}
		if(storeOrder.size()>0)
			return storeOrder;
		else
			return null;
	}

	@Override
	public List searchCar(Person p,int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		List cars=null;
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();
			
			cars=personCarDao.findPageByPersonID(p.getId(), pageNo, pageSize);
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession();
		}
		if(cars.size()>0)
			return cars;
		else
			return null;
	}

	@Override
	public boolean changeCarInfo(Personcar car) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		boolean flag=false;
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();
			
			Personcar personcar = personCarDao.findID(car.getId());
			personcar=car;
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession();
		}
		return flag;
	}

	@Override
	public List searchDrivingSchooleOrder(Person p,int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		List order = null;
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();
			
			order=drivingOrderDao.findBypersonID(p.getId());
			tx.commit();

		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession();
		}
		if(order.size()>0)
			return order;
		else 
			return null;
	}

	@Override
	public List searchDrivingPeopleOrder(Person p,int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		List order=null;
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();
			
			order=drivingCOrderDao.findByPerson(p.getId());
			if(order.size()>0)
				return order;
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession();
		}
		if(order.size()>0)
			return order;
		else {
			return null;
		}
	}

	@Override
	public boolean addCarInfo(Person p, Personcar car) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		boolean flag=false;
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();
			if(personDao.findID(p.getId())!=null)
			{
				car.setPerson(p);
				personCarDao.save(car);
				flag=true;
			}
			else
				flag=false;
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		return flag;
	}

	@Override
	public Person searchPerson(String username) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		Person person=null;
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();
			List list=userDao.findUsername(username);
			if (list.size()>0) {
				User user=(User)list.get(0);
				person=personDao.findID(user.getPerson().getId());
			}
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		return person;
	}

	@Override
	public User searchUser(String username) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		User user=null;
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();
			List list=userDao.findUsername(username);
			if (list.size()>0) {
				user=(User)list.get(0);
			}
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		return user;
	}

}
