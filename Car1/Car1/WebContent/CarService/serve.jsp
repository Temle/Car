<%@page import="com.car.domain.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/head.jsp" %>
<title>页面标题</title>
</head>

<body>
<div class="container">

<%@ include file="/navigation.jsp" %>
<% Store store=(Store)request.getAttribute("store");
	Storeproduct storeproduct=(Storeproduct)request.getAttribute("storeproduct");
%>
<div class="row clearfix">
		<div class="col-md-12 column">
			<table class="table">			
				<tbody>
					<tr>			
						<td>
							服务名</td>
						<td>
							<%=storeproduct.getName() %>
						</td>
					</tr>
					<tr >	
						<td>
							价格</td>
						<td>
							<%=storeproduct.getPrice() %>
						</td>
					</tr>
					<tr class="error">
						
						<td>描述</td>
						<td>
							<%=storeproduct.getDescription() %>
						</td>
					</tr>
					
				</tbody>
			</table>
		</div>
	</div>
			<div class="row clearfix">
				<div class="col-md-4 column">
			  </div>
				<div class="col-md-4 column">
					<h3>
						
<!-- 						<a href="/Car/product-order.action" class="btn btn-primary btn-sm" role="button">预约</a> -->
						<div>
						<form action="/Car/product-order.action">
								<input type="hidden" value="<%=store.getId() %>" name="store.id" />
								<input type="hidden" value="<%=storeproduct.getId() %>" name="storeproduct.id" />
								<input type="submit" class="btn btn-primary btn-sm" value="预约">
						</form>
						</div> 
					</h3>
				</div>
				<div class="col-md-4 column">
				</div>
		  </div>
	</div>
  </div>


</div>
</body>
</html>
