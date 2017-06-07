<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.car.domain.*" %>
<%@ page import="com.car.Tool.*" %>   
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
			<%
				Park park = (Park)request.getAttribute("park"); 
		    	String province=(String)request.getAttribute("province");
		    	String city=(String)request.getAttribute("city");
		    	String district=(String)request.getAttribute("district"); 
	    	%> 	
				<form role="form" action="/Car/back-update-after.action">
					<div class="form-group">
						 <label for="exampleInputEmail1">名称</label><input type="text" class="form-control" id="exampleInputEmail1" name="park.name" value="<%=park.getName() %>"/>
					</div>
					<div class="form-group">
						 <label for="exampleInputEmail1">地址</label><input type="text" class="form-control" id="exampleInputEmail1" name="park.address" value="<%=park.getAddress() %>"/>
					</div>
					<div class="form-group">
						 <label for="exampleInputEmail1">联系电话</label><input type="text" class="form-control" id="exampleInputEmail1" name="park.phoneNumber" value="<%=park.getPhoneNumber() %>"/>
					</div>
					<div class="form-group">
						 <label for="exampleInputEmail1">停车场介绍</label><input type="text" class="form-control" id="exampleInputEmail1" name="park.description" value="<%=park.getDescription() %>"/>
					</div>
					<div class="form-group">
						 <label for="exampleInputEmail1">价格</label><input type="text" class="form-control" id="exampleInputEmail1" name="park.price" value="<%=park.getPrice() %>"/>
					</div>
					<div class="form-group">
						 <label for="exampleInputEmail1">停车场总的车位数目</label><input type="text" class="form-control" id="exampleInputEmail1" name="park.parkSpaceNumber" value="<%=park.getParkSpaceNumber() %>"/>
					</div>																		
	 				<button type="submit" class="btn btn-default">修改</button>
				</form>
			</div>
	</div>
		</div>
	</div>
</div>
</body>
</html>