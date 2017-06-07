package com.car.service.store;

import java.util.List;

import com.car.util.PageBean;
import com.sun.xml.internal.ws.wsdl.parser.InaccessibleWSDLException;
import com.car.domain.Person;
import com.car.domain.Store;
import com.car.domain.Storenotification;
import com.car.domain.Storeorder;
import com.car.domain.Storeproduct;

public interface StoreService {
	//显示所有商家;
	public PageBean searchStoreByCity(String city,int pageNo);
	
	//查看店铺信息;
	public Store searchStoreInfo(Store s);
	
	//修改店铺信息
	public boolean changeStoreInfo(Store s);
	
	//修改商品信息
	public boolean changeStoreProductInfo(Storeproduct sp);
	
	//添加商品
	public boolean addStoreProductInfo(Storeproduct sp);
	
	//显示单个商品
	public Storeproduct showStoreProductInfo(Storeproduct sp);
	
	//删除商品
	public void deleteStoreProductInfo(Storeproduct sp);
	
	//显示商品列表
	public PageBean showStoreProductList(Store s,int pageNo);
	
	//处理用户预约
	public boolean saveOrder(Person p,Store s,Storeproduct sp);
	
	//查看商店的评论
	public PageBean searchStoreConment(Store s,int pageNo);
	
	//评论商店
	public boolean storeRemark(Person p,Store s,String conment);
	
	//显示订单列表
	public PageBean showStoreOrderList(Store s,int pageNo);
	
	//商家发布通知
	public boolean sendNofication(Storenotification notification);
	
	//商家查看预约具体信息
	public Storeorder searchOrder(int id);
	
	//商家删除预约信息
	public boolean deleteOrder(int id);

}
