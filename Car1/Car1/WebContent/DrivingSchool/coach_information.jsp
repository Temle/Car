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
				Drivingcoach drivingcoach=(Drivingcoach) request.getAttribute("drivingcoach");
		    	%>
					<tr>
						<td>姓名</td>
						<td><%=drivingcoach.getName() %></td>
					</tr>
					
					<tr >
						<td>性别</td>
						<td>
							<%=drivingcoach.getSex()%>
						</td>
					</tr>
                    
                    <tr >
						<td>电话号码</td>
						<td>
						<%=drivingcoach.getPhoneNumber()%>
						</td>
					</tr>                    
					<tr >
						<td>描述</td>
						<td><%=drivingcoach.getDescription()%></td>
					</tr>
					
				
				</tbody>
			</table>
		</div>
		
		
		
	</div>

</div>
</body>
</html>