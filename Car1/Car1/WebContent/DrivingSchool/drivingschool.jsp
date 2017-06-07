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
			<table class="table table-hover" >
				<thead>
					<tr>
						<th>驾校名</th>
						<th>地址</th>
						<th>状态</th>
					</tr>
				</thead>
				<tbody>
					<%
						PageBean pageBean = (PageBean) request.getAttribute("pageBean"); 
						List<Drivingschool> list=pageBean.getData();
						for(Drivingschool drivingschool:list)
						{
				    %>
					
					
					
					<tr>
						<td><%=drivingschool.getName() %></td>
						<td><%=drivingschool.getAddress() %></td>
						<td>
							<a href="/Car/school-information.action?id=<%=drivingschool.getId() %>" class="btn btn-primary btn-sm" role="button">
							查看
							</a>
						</td>
					</tr>
					
				<%} %>
				</tbody>
			</table>
			
			<div id="pageButton" style="text-align:center;">
						<form name="PageForm" action="/Car/school-list.action" method="post">					
							<script>
							function gotoPage(pagenum){
							  document.PageForm.pageNo.value = pagenum;
							  document.PageForm.submit();
							  return ;
							}
							</script>
							<span class="label label-default">每页<%=pageBean.rowsPerPage%>行
							共<%=pageBean.maxRowCount%>行
							第<%=pageBean.curPage%>页
							共<%=pageBean.maxPage%>页</span>
							
							<br/>
							<% 
							   if(pageBean.curPage==1){ 
								   %>
									<a href="#" class="btn btn-default" role="button">首页</a>
									<a href="#" class="btn btn-default" role="button">上一页</a>   
								   <% 
							   }else{  
							 %>   
							<a href="javascript:gotoPage(1)" class="btn btn-default" role="button">首页</a>
							<a href="javascript:gotoPage(<%=pageBean.curPage-1%>)" class="btn btn-default" role="button">上一页</a>
							<%
								}
							%>
							<%
							   if(pageBean.curPage==pageBean.maxPage){ 
								   %>
									<a href="#" class="btn btn-default" role="button">下一页</A>
									<a href="#" class="btn btn-default" role="button">尾页</A>   
								   <% 
							   }else{  
							%>  
							  
							<a href="javascript:gotoPage(<%=pageBean.curPage+1%>)" class="btn btn-default" role="button">下一页</A>
							<a href="javascript:gotoPage(<%=pageBean.maxPage%>)" class="btn btn-default" role="button">尾页</A>
							<%
								}
							%>
							</br>
							<div style="display:none;">
								第<input type="text" name="pageNo" style="width:50px;"/>页
								<input type="submit" value="提交">
							</div>
							
		 
						</form>
			</div>
		</div>
	</div>

</div>
·
</body>
</html>
