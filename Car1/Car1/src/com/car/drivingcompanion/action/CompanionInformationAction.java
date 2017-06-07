package com.car.drivingcompanion.action;

import java.util.ArrayList;
import java.util.List;

import com.car.dao.CommentHibDao;
import com.car.dao.CommentHibDaoImpl;
import com.car.dao.DrivingCompanionHibDao;
import com.car.dao.DrivingCompanionHibDaoImpl;
import com.car.domain.Conment;
import com.car.domain.Drivingcompanion;
import com.car.domain.Person;
import com.car.util.PageBean;
import com.opensymphony.xwork2.Action;

public class CompanionInformationAction implements Action{
	private int id;
	private PageBean pageBean=new PageBean();
	private Drivingcompanion drivingcompanion;
	private List<Conment> comment=new ArrayList<Conment>();
	private int pageNo=1;
	private CommentHibDao chd=new CommentHibDaoImpl();
	private DrivingCompanionHibDao dch=new DrivingCompanionHibDaoImpl();
	@Override	
	public String execute() throws Exception{
		//陪驾信息
		drivingcompanion=dch.findById(id);
		//评论信息
	    comment=chd.findByPersonId(id);
	    pageBean.data=comment;
		pageBean.curPage=pageNo;
		pageBean.maxRowCount=50;
		pageBean.countMaxPage();
		pageBean.setRowsPerPage(5);
		List<Conment> list=pageBean.getData();
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
	
	public Drivingcompanion getDrivingcompanion() {
		return drivingcompanion;
	}
	
	public void setDrivingcompanion(Drivingcompanion drivingcompanion) {
		this.drivingcompanion = drivingcompanion;
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

	public CommentHibDao getChd() {
		return chd;
	}
	
	public void setChd(CommentHibDao chd) {
		this.chd = chd;
	}
	
	public DrivingCompanionHibDao getDch() {
		return dch;
	}
	public void setDch(DrivingCompanionHibDao dch) {
		this.dch = dch;
	}


}
