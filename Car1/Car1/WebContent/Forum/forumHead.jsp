<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="page-header">
				<h1>
					汽车综合服务平台论坛
				</h1>
			</div>
		</div>
	</div>
	
	<div class="row clearfix">
		<div class="col-md-12 column">
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					 <span class="sr-only">Toggle navigation</span>
					 <span class="icon-bar"></span>
					 <span class="icon-bar"></span><span class="icon-bar">
					 </span></button> <a class="navbar-brand" href="#">论坛首页</a>
				</div>				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li>
							<a href="/Car/forum.action">经验分享</a>
						</li>
						<li>
							<a href="/Car/forum-two.action">车友交流</a>
						</li>
						<li>
							<a href="/Car/forum-three.action">交友区</a>
						</li>
						<li>
							<a href="/Car/Forum/post.jsp">发帖</a>
						</li>
						
					</ul>
					
					<form  action="/Car/forum-find-post.action" class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input name="title" type="text" class="form-control" />
						</div> <button type="submit" class="btn btn-default">搜索帖子</button>
					</form>
					
					<ul class="nav navbar-nav navbar-right">
						<li>
							 <a href="/Car/indexpage.jsp">系统首页</a>
						</li>
						<li>
							<a href="/Car/forum-person.action?id=2">个人中心</a>
						</li>
					</ul>
				</div>
				
			</nav>
		</div>
	</div>