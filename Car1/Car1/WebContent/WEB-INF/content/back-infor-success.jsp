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
			<table class="table table-bordered table-hover table-striped">
			<%
				Park park = (Park)request.getAttribute("park"); 
		    	String province=(String)request.getAttribute("province");
		    	String city=(String)request.getAttribute("city");
		    	String district=(String)request.getAttribute("district"); 
	    	%> 		
				<tbody>
					<tr>
						<td>
							停车场名称
						</td>
						<td>
							<%=park.getName() %>
						</td>
					</tr>
					<tr>
						<td>
							停车场地址
						</td>
						<td>
							<%=province%><%=city%><%=district%><%=park.getAddress() %>
						</td>
					</tr>
					<tr>
						<td>
							停车场联系方式
						</td>
						<td>
							<%=park.getPhoneNumber() %>
						</td>
					</tr>
					<tr>
						<td>
							停车场描述
						</td>
						<td>
							<%=park.getDescription() %>
						</td>
					</tr>
					<tr>
						<td>
							停车场价格
						</td>
						<td>
	    					<%=park.getPrice() %>
						</td>
					</tr>
					<tr>
						<td>
							停车场总车位
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

		</div>
	</div>
</div>
</body>
</html>