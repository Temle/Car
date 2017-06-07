package com.car.service.forum;

import java.util.List;

import com.car.Tool.PageBean;
import com.car.domain.Person;
import com.car.domain.Post;
import com.car.domain.Postconment;

public interface ForumService {
	/*
		用户自己所属的帖子type为A
		用户举报的别人的帖子type为B
		帖子所属模块分为X、Y、Z
	*/
	/*普通用户：
	1）看帖模块：点击相应模块出现相应模块的帖子
	2）看帖：点击帖子出现相应帖子：具体内容、评论、点赞人数、浏览人数等信息
	3) 帖子相关内容
	4）举报帖子：点击举报帖子功能
	5）评论帖子：评论帖子功能
	6）发帖：发帖功能
	7) 查看个人发表的所有帖子*/
	/*public List postOfModuel(String type);
	public Post watchPost(String id);
	public List postComment(String id);
	public void reportPost(String id);
	public void commentPost(String content,Person person);
	public void postPost(String title,String content);
	public List myPost(String personID,int pageNo,int pageSize);
	*/
	
	/*管理人员：
	1）删除帖子
	2）删除帖子下的不合法内容
	3) 查看被举报的帖子*/
	/*public void deletePost(String id);
	public void deleteComment(String id);
	public List watchReportedPost();
	*/
	
	//获取相应版块的帖子
	public PageBean getPost(String in,int pageNo,String type);
	//获取帖子
	public PageBean getPost(String in,int pageNo,Person person);
	//发帖
	public void addPost(Post post);
	//读帖
	public Post readPost(int id);
	//根据帖子id查找回帖
	public PageBean showPostComment(int pageNo,int id);
	//根据Person查找回帖
	public PageBean showPostComment(int pageNo,Person person);
	//回帖
	public void addPostconment(Postconment postconment);
	//查找帖子
	public PageBean findPost(String title,int pageNo);
	
}
