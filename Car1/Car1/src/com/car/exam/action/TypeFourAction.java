package com.car.exam.action;

import java.util.List;

import com.car.Tool.ExamImpl;
import com.car.Tool.Question;
import com.opensymphony.xwork2.Action;

public class TypeFourAction implements Action{
	
	private List<Question> list;
	private int pageNo=1;
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ExamImpl ei=new ExamImpl();
		ei.setPagenum("1");
		ei.setPagesize("1");
		ei.setSort("rand");
		ei.setSubject("4");
		list=ei.dealJSON();
		
		
		
		return SUCCESS;
	}

	public List<Question> getList() {
		return list;
	}

	public void setList(List<Question> list) {
		this.list = list;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
}
