<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="page-header">
				<h1>
					汽车综合服务平台
				</h1>
			</div>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<nav class="navbar navbar-default navbar-inverse" role="navigation">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> 
					 <span class="sr-only">Toggle navigation</span>
					 <span class="icon-bar"></span>
					 <span class="icon-bar"></span>
					 <span class="icon-bar">
					 </span></button> 
					 <a class="navbar-brand active" href="/Car/indexpage.jsp">首页</a>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li>
							 <a href="/Car/parking-list.action">停车场</a>
						</li>
						<li>
							 <a href="/Car/store-list.action">汽车服务</a>
						</li>
						<li class="dropdown">
							 <a href="#" class="dropdown-toggle" data-toggle="dropdown">驾考系统<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									 <a href="/Car/school-list.action">驾校报名</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a href="/Car/Exam/ExamIndex.jsp">模拟考试</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a href="/Car/companion-list.action">陪驾预约</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="/Car/forum.action">论坛</a>
						</li>
						<li>
							<a href="peccancy.jsp">违章查询</a>
						</li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li>
							<%String username=(String)session.getAttribute("user"); %>
							<a href="#">欢迎您：<%=username %></a>
						</li>
						<li>
							 <a href="/Car/user-infor.action">用户中心</a>
						</li>
					</ul>
				</div>
				
			</nav>
		</div>
	</div>
