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
			<table class="table">
			<%
			Park park=(Park)request.getAttribute("park");
			%>
				<thead>
					<tr>
						<th>
							名称
						</th>
						<th>
							状态
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							停车场车位总数目
						</td>
						<td>
							<%=park.getParkSpaceNumber() %>
						</td>
					</tr>
					<tr>
						<td>
							停车场当前剩余车位
						</td>
						<td>
							<%=park.getRestNumber() %>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form role="form" action="/Car/back-op-after.action">
				<div class="form-group">
					 <label for="exampleInputEmail1">当前剩余车位</label><input type="number" class="form-control" id="exampleInputEmail1" name="restnumber"/>
				</div>
				<button type="submit" class="btn btn-default">提交</button>
			</form>
			<div class="alert alert-success alert-dismissable">
				 <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
				<h4>
					注意!
				</h4>在上方输入框中输入停车场当前的剩余车位并且提交。</a>
			</div>
		</div>
	</div>
		</div>
	</div>
</div>
</body>
</html>