<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.car.domain.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/head.jsp" %>
<title>页面标题</title>
</head>

<body>
<div class="container">
	<%@include file="/userhead.jsp" %>


	<div class="col-md-3">
	<%@include file="/userleft.jsp" %>
	</div>
	<div class="col-md-9">
			<%
				Person person=(Person)request.getAttribute("person");
			%>
		
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>
							用户信息
						</th>
					</tr>
				</thead>
				<tbody>
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
							性别
						</td>
						<td>
							<%=person.getSex() %>
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
							生日
						</td>
						<td>
							<%=person.getBirthDate() %>
						</td>
					</tr>	
					<tr>
						<td>
							联系方式
						</td>
						<td>
							<%=person.getPhoneNumber() %>
						</td>
					</tr>	
					<tr>
						<td>
							地址
						</td>
						<td>
							<%=person.getAddress() %>
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
				<div class="row clearfix">
		<div class="col-md-12 column">
			 <a class="btn btn-primary btn-large" href="#modal-container-1" role="button" class="btn" data-toggle="modal">修改信息</a>
			
			<div class="modal fade" id="modal-container-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								修改信息
							</h4>
						</div>
						<div class="modal-body">
							<form role="form" action="/Car/user-update.action">
								<div class="form-group">
									 <label for="exampleInputEmail1">姓名</label><input type="text" class="form-control" id="exampleInputEmail1" value="<%=person.getName() %>" name="person.name"/>
								</div>
								<div class="form-group">
									 <label for="exampleInputEmail1">年龄</label><input type="number" class="form-control" id="exampleInputEmail1" value="<%=person.getAge() %>" name="person.age"/>
								</div>
								<div class="form-group">
									 <label for="exampleInputEmail1">生日</label><input type="date" class="form-control" id="exampleInputEmail1" value="<%=person.getBirthDate() %>" name="person.birthDate"/>
								</div>
								<div class="form-group">
									 <label for="exampleInputEmail1">联系方式</label><input type="text" class="form-control" id="exampleInputEmail1" value="<%=person.getPhoneNumber() %>" name="person.phoneNumber"/>
								</div>
								<div class="form-group">
									 <label for="exampleInputEmail1">地址</label><input type="text" class="form-control" id="exampleInputEmail1" value="<%=person.getAddress() %>" name="person.address"/>
								</div>
								<div class="form-group">
									 <label for="exampleInputEmail1">邮箱</label><input type="email" class="form-control" id="exampleInputEmail1" value="<%=person.getEmail() %>" name="person.email"/>
								</div>
								<button type="submit" class="btn btn-default">修改</button>
							</form>
						</div>
						<div class="modal-footer">
						</div>
					</div>
					
				</div>
				
			</div>
			
		</div>
	</div>
			
			
	</div>


	



</div>
</body>
</html>
