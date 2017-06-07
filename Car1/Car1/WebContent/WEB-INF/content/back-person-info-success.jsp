<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.car.domain.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/head.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>停车场管理</title>
</head>
<body>
<div class="container">
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
		<div class="col-md-3 column">
		<%@include file="/BMap/backleft.jsp" %>
		</div>
		<div class="col-md-9 column">
		<div class="row clearfix">
		<div class="col-md-12 column">
			<table class="table table-striped table-bordered table-hover">
				<tbody>
				<%Person person=(Person)request.getAttribute("person"); %>
					<tr>
						<td>
							姓名
						</td>
						<td>
							<%=person.getName() %>
						</td>
					</tr>
					<tr>
						<td>
							住址
						</td>
						<td>
							<%=person.getAddress() %>
						</td>
					</tr>
										<tr>
						<td>
							年龄
						</td>
						<td>
							<%=person.getAge() %>
						</td>
					</tr>
										<tr>
						<td>
							电话
						</td>
						<td>
							<%= person.getPhoneNumber() %>
						</td>
					</tr>
										<tr>
						<td>
							出生日期
						</td>
						<td>
							<%=person.getBirthDate() %>
						</td>
					</tr>
										<tr>
						<td>
							邮箱
						</td>
						<td>
							<%=person.getEmail() %>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
				<div class="col-md-12 column">
			<div class="alert alert-success alert-dismissable">
				 <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
				<h4>
					注意!
				</h4> <strong></strong> 个人信息修改前往用户端修改！ <a href="/Car/user-infor.action" class="alert-link">个人中心</a>
			</div>
		</div>
	</div>
		
		</div>
	</div>
</div>
</body>
</html>