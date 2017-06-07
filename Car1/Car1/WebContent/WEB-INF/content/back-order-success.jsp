<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.car.domain.*" %>
<%@ page import="java.util.*" %>
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
			<%
				List<Parkorder> list1=(List<Parkorder>)request.getAttribute("list1");
				List<Parkorder> list2=(List<Parkorder>)request.getAttribute("list2");
			%>
				<div class="row clearfix">
		<div class="col-md-12 column">
		<h3><span class="label label-info">未处理订单</span></h3>
			<table class="table">
				<thead>
					<tr>
						<th>
							下单用户
						</th>
						<th>
							价格
						</th>
						<th>
							备注
						</th>
						<th>
							日期
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
				<%
					for(Parkorder p: list1)
					{
				%>
				
					<tr>
						<td>
							<%=p.getPerson().getName() %>
						</td>
						<td>
							<%=p.getPrice() %>
						</td>
						<td>
							<%=p.getRemarks() %>
						</td>
						<td>
							<%=p.getDate() %>
						</td>
												<td>
							<a href="/Car/back-order-acc.action?id=<%=p.getId() %>" class="btn btn-primary btn-sm" role="button">接受</a>
							<a href="/Car/back-order-ref.action?id=<%=p.getId() %>" class="btn btn-primary btn-sm" role="button">拒绝</a>
						</td>
					</tr>
					<%
					}
					%>
					
				</tbody>
			</table>
		</div>
	</div>
					<div class="row clearfix">
		<div class="col-md-12 column">
			<table class="table">
			<h3><span class="label label-info">历史订单</span></h3>
				<thead>
					<tr>
						<th>
							下单用户
						</th>
						<th>
							价格
						</th>
						<th>
							备注
						</th>
						<th>
							日期
						</th>
						<th>
							状态
						</th>						
					</tr>
				</thead>
				<tbody>
				<%
					for(Parkorder p:list2)
					{
				%>
				
					<tr>
						<td>
							<%=p.getPerson().getName() %>
						</td>
						<td>
							<%=p.getPrice() %>
						</td>
						<td>
							<%=p.getRemarks() %>
						</td>
						<td>
							<%=p.getDate() %>
						</td>
						<th>
							<%
								if(p.getType()==1)
								{
							%>
								已接受
							<%
								}
							else if(p.getType()==2)
							{
							%>
								已拒绝
							<%} %>
						</th>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>		
			
			
		</div>
	</div>
</div>
</body>
</html>