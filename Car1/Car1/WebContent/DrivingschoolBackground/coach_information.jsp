<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%> 
<%@ page import="com.car.domain.*" %>
<%@ page import="com.car.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>页面标题</title>



</head>

<body>
<div class="container">


	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="page-header">
				<h1>
					后台管理
				</h1>
			</div>
		</div>
	</div>
	
	<%
    int id=(int)request.getAttribute("StoreId");
    %>
		
	

	<div class="row clearfix">
		<div class="col-md-2 column">
              <ul class="list-group">
   		     <li class="list-group-item" style="line-height:30px;"><a href="/Car/school-background-oder.action?StoreId=<%=id%>">未处理订单</a></li>
             <li class="list-group-item" style="line-height:30px;"><a href=	"/Car/school-background-school-information.action?StoreId=<%=id%>">基本信息</a></li>
    		 <li class="list-group-item" style="line-height:30px;"><a href="/Car/school-background-order-history.action?StoreId=<%=id%>">历史订单</a></li>
   			 <li class="list-group-item" style="line-height:30px;"><a href="/Car/school-background-coach.action?StoreId=<%=id%>">教练列表</a></li>
   			 <li class="list-group-item" style="line-height:30px;"><a href="/Car/jump-notice.action?StoreId=<%=id%>">发布公告</a></li>
             <li class="list-group-item" style="line-height:30px;"><a href="/Car/indexpage.jsp">退出后台</a></li>
			</ul>
		</div>
        
        
        
        
		<div class="col-md-10 column">
        
        <table class="table">
				
				<tbody>
				<%
				Drivingcoach drivingcoach=(Drivingcoach) request.getAttribute("drivingcoach");
	
		    	%>
					<tr>
						
						<td>姓名</td>
						<td>
							<%=drivingcoach.getName() %>
						</td>
					</tr>
                    <tr>
						
						<td>性别</td>
						<td>
							<%=drivingcoach.getSex() %>
						</td>
					</tr>
					<tr >
						
						<td>电话号码</td>
						<td>
							<%=drivingcoach.getPhoneNumber() %>
						</td>
					</tr>
					<tr >
						
						<td>描述</td>
						<td>
							<%=drivingcoach.getDescription() %>
						</td>
					</tr>
					
				</tbody>
			</table>
            		
		</div>
	</div>




</div>
</body>
</html>
