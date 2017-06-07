package com.car.service.store;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.util.PageBean;
import com.car.dao.CommentHibDao;
import com.car.dao.CommentHibDaoImpl;
import com.car.dao.PersonHibDao;
import com.car.dao.PersonHibDaoImpl;
import com.car.dao.StoreHibDao;
import com.car.dao.StoreHibDaoImpl;
import com.car.dao.StorenotificationHibDao;
import com.car.dao.StorenotificationHibDaoImpl;
import com.car.dao.StoreorderHibDao;
import com.car.dao.StoreorderHibDaoImpl;
import com.car.dao.StoreproductHibDao;
import com.car.dao.StoreproductHibDaoImpl;
import com.car.domain.Conment;
import com.car.domain.Person;
import com.car.domain.Store;
import com.car.domain.Storenotification;
import com.car.domain.Storeorder;
import com.car.domain.Storeproduct;
import com.car.util.HibernateUtil;

public class StoreServiceImpl implements StoreService{

	StoreorderHibDao storeOrderDao =new StoreorderHibDaoImpl();
	StoreHibDao storeDao = new StoreHibDaoImpl();
	PersonHibDao personDao = new PersonHibDaoImpl();
	StoreproductHibDao storeProductDao = new StoreproductHibDaoImpl();
	CommentHibDao conmentDao=new CommentHibDaoImpl();
	StorenotificationHibDao storenofiticationDao=new StorenotificationHibDaoImpl();
	
	@Override
	public Store searchStoreInfo(Store s) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		Store store=null;
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();
			store=storeDao.findById(s.getId());
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		if(store!=null)
			return store;
		else
			return null;
	}

	@Override
	public boolean changeStoreInfo(Store s) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		boolean flag=false;
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();
			
			Store store =storeDao.findById(s.getId());
			store.setAddress(s.getAddress());
			store.setCity(s.getCity());
			store.setDescription(s.getDescription());
			store.setName(s.getName());
			store.setPhoneNumber(s.getPhoneNumber());
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
	public boolean changeStoreProductInfo(Storeproduct sp) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		boolean flag=false;
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();
			
			Storeproduct storeproduct=storeProductDao.findById(sp.getId());
			if(storeproduct!=null)
			{
				storeproduct.setDescription(sp.getDescription());
				storeproduct.setName(sp.getName());
				storeproduct.setPrice(sp.getPrice());
				flag=true;
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

	@Override
	public boolean addStoreProductInfo(Storeproduct sp) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		boolean flag=false;
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();
	
			storeProductDao.save(sp);
			flag=true;
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
	public void deleteStoreProductInfo(Storeproduct sp) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();
			Storeproduct storeproduct=storeProductDao.findById(sp.getId());
			storeProductDao.delete(storeproduct);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	@Override
	public PageBean showStoreProductList(Store s,int pageNo) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		List storeProduct = null;
		PageBean pageBean = new PageBean();
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();
			storeProduct=storeProductDao.findByPageByStoreId(s.getId(), pageNo, 10);
			pageBean.setData(storeProduct);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		return pageBean;
	}

	@Override
	public boolean saveOrder(Person p,Store s,Storeproduct sp) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		boolean flag=false;
		Storeorder sorder=new Storeorder();
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();
			
			sorder.setPerson(p);
			sorder.setDate(new Date());
			sorder.setStore(s);
			sorder.setPrice(sp.getPrice());
			sorder.setStoreproduct(sp);
			sorder.setRemarks(p.getName()+"预约了该服务");
			storeOrderDao.save(sorder);
			flag=true;
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
	public PageBean searchStoreByCity(String city, int pageNo) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		PageBean pageBean = new PageBean();
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();		
			List store=storeDao.findByPageByCity(city, pageNo, 10);
			pageBean.setData(store);		
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		return pageBean;
	}

	@Override
	public PageBean searchStoreConment(Store s, int pageNo) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		PageBean pageBean = new PageBean();
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();	
			List list=conmentDao.findByPageByStoreId(s.getId().toString(), pageNo, 10);
			pageBean.setData(list);		
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		return pageBean;
	}

	@Override
	public boolean storeRemark(Person p,Store s, String conment) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		boolean flag=false;
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();	
			Conment c=new Conment();
			c.setPerson(p);
			c.setStoreid(s.getId().toString());
			c.setDate(new Date());
			c.setContent(conment);
			c.setType(2);
			conmentDao.save(c);
			flag=true;
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			flag=false;
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		return flag;
	}

	@Override
	public Storeproduct showStoreProductInfo(Storeproduct sp) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		Storeproduct storeproduct=null;
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();	
			storeproduct=storeProductDao.findById(sp.getId());
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		return storeproduct;
	}

	@Override
	public PageBean showStoreOrderList(Store s, int pageNo) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		List storeOrder = null;
		PageBean pageBean = new PageBean();
		try {
			System.out.println(s.getId());
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();
			storeOrder=storeOrderDao.findByStoreIdByPage(s.getId(), pageNo, 10);
			pageBean.setData(storeOrder);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		return pageBean;
	}

	@Override
	public boolean sendNofication(Storenotification notification) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();
			storenofiticationDao.save(notification);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		return true;
	}

	@Override
	public Storeorder searchOrder(int id) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		Storeorder storeorder=null;
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();	
			storeorder=storeOrderDao.findById(id);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		return storeorder;
	}

	@Override
	public boolean deleteOrder(int id) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		Storeorder storeorder=null;
		try {
			Session session=HibernateUtil.currentSession();
			tx=session.beginTransaction();
			storeorder=storeOrderDao.findById(id);
			storeOrderDao.delete(storeorder);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		return true;
	}
	
}
