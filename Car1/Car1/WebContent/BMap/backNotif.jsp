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
			<form role="form" action="/Car/back-notifi.action">
				<div class="form-group">
					 <label for="exampleInputEmail1">通知内容</label><input type="text" class="form-control" id="exampleInputEmail1" name="content"/>
				</div>

				<button type="submit" class="btn btn-default">发布</button>
			</form>
			
		</div>
	</div>
</div>
</body>
</html>