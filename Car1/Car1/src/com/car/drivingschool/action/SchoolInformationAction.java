package com.car.drivingschool.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.dao.CommentHibDao;
import com.car.dao.CommentHibDaoImpl;
import com.car.dao.DrivingschoolHibDao;
import com.car.dao.DrivingschoolHibDaoImpl;
import com.car.domain.Conment;
import com.car.domain.Drivingcoach;
import com.car.domain.Drivingschool;
import com.car.util.HibernateUtil;
import com.car.util.PageBean;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class SchoolInformationAction implements Action {
	private int id;
	private PageBean pageBean=new PageBean();
	private PageBean pageBean1=new PageBean();
	private Drivingschool drivingschool;	
	private List<Conment> comment=new ArrayList<Conment>();
	private int pageNo=1;
	private List<Drivingcoach> drivingcoach=new ArrayList<Drivingcoach>();
	private CommentHibDao chd=new CommentHibDaoImpl();
	private DrivingschoolHibDao dsh=new DrivingschoolHibDaoImpl();
	@Override
	public String execute() throws Exception {
		drivingschool=dsh.findById(id);	
		//驾校信息
		 Session session=HibernateUtil.currentSession();
	 		String hql="from Drivingcoach dc where dc.drivingschool.id="+drivingschool.getId();
	 		Query query=session.createQuery(hql);
	 		drivingcoach=query.list();
	 		pageBean.data=drivingcoach;
			pageBean.curPage=pageNo;
			pageBean.maxRowCount=50;
			pageBean.countMaxPage();
			pageBean.setRowsPerPage(5);
			//教练信息
		    comment=chd.findByStoreId(3, id+"");
		    pageBean1.data=comment;
			pageBean1.curPage=pageNo;
			pageBean1.maxRowCount=50;
			pageBean1.countMaxPage();
			pageBean1.setRowsPerPage(5);
			List<Conment> list2=pageBean1.getData();
	
			//评论信息
		// TODO 自动生成的方法存根
		return SUCCESS;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	public Drivingschool getDrivingschool() {
		return drivingschool;
	}
	public void setDrivingschool(Drivingschool drivingschool) {
		this.drivingschool = drivingschool;
	}
	public List<Conment> getComment() {
		return comment;
	}
	public void setComment(List<Conment> comment) {
		this.comment = comment;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public List<Drivingcoach> getDrivingcoach() {
		return drivingcoach;
	}
	public void setDrivingcoach(List<Drivingcoach> drivingcoach) {
		this.drivingcoach = drivingcoach;
	}
	public CommentHibDao getChd() {
		return chd;
	}
	public void setChd(CommentHibDao chd) {
		this.chd = chd;
	}
	public DrivingschoolHibDao getDsh() {
		return dsh;
	}
	public void setDsh(DrivingschoolHibDao dsh) {
		this.dsh = dsh;
	}
	public PageBean getPageBean1() {
		return pageBean1;
	}
	public void setPageBean1(PageBean pageBean1) {
		this.pageBean1 = pageBean1;
	}

}
