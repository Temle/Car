<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.car.domain.*" %>
<%@ page import="com.car.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/head.jsp" %>
<title>页面标题</title>
</head>

<body>
<div class="container">
	<%@ include file="/navigation.jsp" %>    
    <div class="row clearfix">
		<div class="col-md-12 column">
			<table class="table">
				
				<tbody>
					<%
					Drivingcompanion drivingcompanion = (Drivingcompanion)request.getAttribute("drivingcompanion"); 
				    %>
					<tr>
						<td>姓名</td>
						<td><%=drivingcompanion.getPerson().getName()%></td>
					</tr>
					<tr >
						<td>驾龄</td>
						<td><%=drivingcompanion.getDrivingAge() %></td>
					</tr>
					<tr >
						<td>价格</td>
						<td><%=drivingcompanion.getPrice() %></td>
					</tr>
					<tr >
						<td>描述</td>
						<td><%=drivingcompanion.getDescription() %></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form role="form" action="/Car/companion-order.action">
				<div class="form-group"><label for="exampleInputEmail1">备注</label><input type="text" class="form-control" id="exampleInputEmail1" name="remarks" /></div>		
				<input type="hidden" value="<%=drivingcompanion.getId() %>" name="companionid">
				<button type="submit" class="btn btn-default">预约</button>
			</form>
		</div>
	</div>
    
    <div class="row clearfix">
		<div class="col-md-12 column">
			<form role="form" action="/Car/companion-order.action">
				<div class="form-group"><label for="exampleInputEmail1">评论内容</label><input type="text" class="form-control" id="exampleInputEmail1" name="comments"/></div>
				<input type="hidden" value="<%=drivingcompanion.getId() %>" name="companionid">
				<button type="submit" class="btn btn-default">评论</button>
			</form>		
		</div>
	</div>
    
</div>

</body>
</html>
