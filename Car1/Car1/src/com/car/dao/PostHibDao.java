package com.car.dao;

import java.util.List;

import com.car.domain.Person;
import com.car.domain.Post;

public interface PostHibDao extends BaseHibDao<Post> {
	//根据页面号查找
	public List findPostByPage(String in,String type,int pageNo,int rowsPerpage);
	
	//查找数据库中的记录条数
	public long findRowCount(String in,String type);
	
	//发贴
	public void addPost(Post post);
	
	//根据主键查找帖子
	public Post findPostById(int id);
	
	//根据标题查找帖子
	public List findPostByTitle(String title,int pageNo, int rowsPerpage);
	
	//根据页面好查找(不分板块)
	public List findPostByPage(String in,int pageNo,int rowsPerpage,Person person);
	
	//查找数据库中的记录条数(不分板块)
	public long findRowCount(String in,Person person);
	
	//查找数据库中的记录条数
	public long findRowCount(String title);
	
	//点赞
	public void nnumber(Post post);
}
