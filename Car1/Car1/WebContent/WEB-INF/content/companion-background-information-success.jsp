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
    int id=(int)request.getAttribute("Id");
    %>

	<div class="row clearfix">
		<div class="col-md-2 column">
             <ul class="list-group">
   			 <li class="list-group-item" style="line-height:30px;"><a href="/Car/companion-background-order.action?Id=<%=id%>">未处理订单</a></li>
             <li class="list-group-item" style="line-height:30px;"><a href=	"/Car/companion-background-information.action?Id=<%=id%>">基本信息</a></li>
    		 <li class="list-group-item" style="line-height:30px;"><a href="/Car/companion-background-order-history.action?Id=<%=id%>">历史订单</a></li>
   			 <li class="list-group-item" style="line-height:30px;"><a href="/Car/companion-background-notice.action?Id=<%=id%>">发布公告</a></li>
              <li class="list-group-item" style="line-height:30px;"><a href="/Car/indexpage.jsp">退出后台</a></li>
			</ul>
		</div>
        
        
        
        
		<div class="col-md-10 column">
        
        <table class="table">
				
				<tbody>
				<%
				Drivingcompanion drivingcompanion=(Drivingcompanion) request.getAttribute("dcompanion");
	
		    	%>
					<tr>
						
						<td>
							陪驾员名</td>
						<td>
							<%=drivingcompanion.getPerson().getName() %>
						</td>
					</tr>
					<tr >
						
						<td>价格</td>
						<td>
							<%=drivingcompanion.getPrice() %>
						</td>
					</tr>
					<tr >
						
						<td>驾龄</td>
						<td>
							<%=drivingcompanion.getDrivingAge() %>
						</td>
					</tr>
					<tr>
						
						
						<td>描述</td>
						<td>
							<%=drivingcompanion.getDescription() %>
						</td>
					</tr>
                   
				</tbody>
			</table>
            	 <a  style="margin-left:400px;" href="/Car/companion-background-modify-information.action?Id=<%=id %>" class="btn btn-primary btn-sm" role="button">修改信息 </a>	
		</div>
	</div>




</div>
</body>
</html>