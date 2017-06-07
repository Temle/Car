package com.car.service.user;

import com.car.domain.Drivingschool;
import com.car.domain.Park;
import com.car.domain.Person;
import com.car.domain.Personcar;
import com.car.domain.Store;
import com.car.domain.User;

public interface RegisterLoginService {
	//注册普通用户处理;
	public boolean registerPerson(Person p,User u);
	
	//填写个人车辆信息;
	public boolean registerCar(int personId,Personcar p);
	
	//注册停车场;
	public boolean registerPark(int personId,Park p);
	
	//注册驾校;
	public boolean registerDrivingSchool(int personId,Drivingschool ds);
	
	//注册服务商家;
	public boolean registerStore(User u,Store s);
	
	//User登录服务;
	public boolean userLogin(String phoneNum,String password);
}
