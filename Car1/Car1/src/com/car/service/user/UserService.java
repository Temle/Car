package com.car.service.user;

import java.util.List;

import com.car.domain.Drivingorder;
import com.car.domain.Drivingschool;
import com.car.domain.Person;
import com.car.domain.User;
import com.car.domain.Personcar;

public interface UserService {
	
	//修改密码功能;
	public boolean changePassword(int personId,String password);
	
	//修改个人信息;
	public boolean changePersonInfo(Person p);
	
	//查看个人信息;
	public Person searchInfo(int personId);
	
	//查看个人信息;
	public Person searchInfo(String phoneNum);
	
	//根据username查看个人信息;
	public Person searchPerson(String username);
	
	//查看消息通知;
	public List searchNofication();
	
	//开通会员;
	public boolean registerVIP(Person p);
	
	//VIP续费;
	public boolean goOnVIP(Person p);
	
	//查询停车场的订单;
	public List searchParkOrder(Person p,int pageNo,int pageSize);
	
	//查询商店订单;
	public List searchStoreOrder(Person p,int pageNo,int pageSize);
	
	//获取个人车辆信息;
	public List searchCar(Person p,int pageNo,int pageSize);
	
	//修改车辆信息;
	public boolean changeCarInfo(Personcar car);
	
	//获取驾校订单;
	public List searchDrivingSchooleOrder(Person p,int pageNo,int pageSize);
	
	//获取代价人员订单;
	public List searchDrivingPeopleOrder(Person p,int pageNo,int pageSize);
	
	//添加私家车;
	public boolean addCarInfo(Person p,Personcar car);
	
	//查看user的信息;
	public User searchUser(String username);
}
