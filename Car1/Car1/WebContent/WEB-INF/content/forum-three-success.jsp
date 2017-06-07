<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="com.car.Tool.PageBean"%>
<%@page import="java.util.List,com.car.domain.Post"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache"> 
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="0">
<%@ include file="/head.jsp" %>
<title>交友区</title>
<style type="text/css">
	table{
    table-layout:fixed;
}
td{  
    overflow:hidden;
    text-overflow:ellipsis;
    white-space:nowrap;
}
</style>
</head>
<body>
<div class="container">

	<%@ include file="/Forum/forumHead.jsp" %>
	
	<div class="row clearfix">
		
		<div class="col-md-12 column">
			<h3 class="text-center">交友区</h3>
			<dl class="dl-horizontal">
				<dt>板块介绍</dt>
				<dd>
					当前板块是用来交友
				</dd>
				<dt>关键字</dt>
				<dd>
					交友
				</dd>
			</dl>
		</div>
	
		<div class="col-md-4 column">
			<div class="text-center">精品贴子</div>
					<table class="table table-hover">
						<thead>
							<tr>
								<th style="width:50%;">帖子名</th>
								<th>发帖人</th>
								<th>点赞</th>
							</tr>
						</thead>
						<tbody>
							<%
							PageBean pageBean1 = (PageBean) request.getAttribute("blockOneLeft"); //important!
							List<Post> posts1 = pageBean1.getData();
							for (Post post : posts1) {
						%>
						<tr>
							<td><a href="/Car/forum-read-post.action?id=<%=post.getId()%>"><%=post.getTitle()%></a></td>
							<td><%=post.getPerson().getName()%></td>
							<td><a href="/Car/forum-nnumber.action?id=<%=post.getId()%>"><%=post.getNnumber()%></a></td>
						</tr>
						<%
							}
						%>
						</tbody>
					</table>
					<form name="PageFormOne" action="/Car/forum-three.action" method="post">
						<script>
						function gotoPageOne(pagenum){
						  document.PageFormOne.pageNoOne.value = pagenum;
						  document.PageFormOne.submit();
						  return ;
						}
						</script>
						每页<%=pageBean1.rowsPerPage%>行
						共<%=pageBean1.maxRowCount%>行
						第<%=pageBean1.curPage%>页
						共<%=pageBean1.maxPage%>页
						<br/>
						<%
						   if(pageBean1.curPage==1){ 
						        out.print(" 首页 上一页");   
						   }else{  
						 %>   
						<a href="javascript:gotoPageOne(1)">首页</a>
						<a href="javascript:gotoPageOne(<%=pageBean1.curPage-1%>)">上一页</a>
						<%}%>
						<%
						   if(pageBean1.curPage==pageBean1.maxPage || pageBean1.maxRowCount==0){ 
						        out.print("下一页 尾页");  
						   }else{  
						 %>   
						<a href="javascript:gotoPageOne(<%=pageBean1.curPage+1%>)">下一页</A>
						<a href="javascript:gotoPageOne(<%=pageBean1.maxPage%>)">尾页</A>
						<%}%>
						转到第<input type="text" name="pageNoOne" style="width:50px;"/>页
						<input type="submit" value="提交">
					</form>
		</div>
		
		
		<div class="col-md-8 column">
			<div class="text-center">普通贴子</div>
			<table class="table table-hover">
						<thead>
							<tr>
								<th style="width:60%">帖子名</th>
								<th>发帖人</th>
								<th>时间</th>
								<th>点赞</th>
							</tr>
						</thead>
						<tbody>
							<%
							PageBean pageBean2 = (PageBean) request.getAttribute("blockOneRight"); //important!
							List<Post> posts2 = pageBean2.getData();
							for (Post post : posts2) {
						%>
						<tr>
							<td><a href="/Car/forum-read-post.action?id=<%=post.getId()%>"><%=post.getTitle()%></a></td>
							<td><%=post.getPerson().getName()%></td>
							<td><%=post.getDate()%></td>
							<td><a href="/Car/forum-nnumber.action?id=<%=post.getId()%>"><%=post.getNnumber()%></a></td>
						</tr>
						<%
							}
						%>
						</tbody>
					</table>
					<form name="PageForm" action="/Car/forum-three.action" method="post">
						<script>
						function gotoPage(pagenum){
						  document.PageForm.pageNoTwo.value = pagenum;
						  document.PageForm.submit();
						  return ;
						}
						</script>
						每页<%=pageBean2.rowsPerPage%>行
						共<%=pageBean2.maxRowCount%>行
						第<%=pageBean2.curPage%>页
						共<%=pageBean2.maxPage%>页
						<br/>
						<%
						   if(pageBean2.curPage==1){ 
						        out.print(" 首页 上一页");   
						   }else{  
						 %>   
						<a href="javascript:gotoPage(1)">首页</a>
						<a href="javascript:gotoPage(<%=pageBean2.curPage-1%>)">上一页</a>
						<%}%>
						<%
						   if(pageBean2.curPage==pageBean2.maxPage || pageBean2.maxRowCount==0){ 
						        out.print("下一页 尾页");  
						   }else{  
						 %>   
						<a href="javascript:gotoPage(<%=pageBean2.curPage+1%>)">下一页</A>
						<a href="javascript:gotoPage(<%=pageBean2.maxPage%>)">尾页</A>
						<%}%>
						转到第<input type="text" name="pageNoTwo" style="width:50px;"/>页
						<input type="submit" value="提交">
					</form>
		</div>
	</div>
</div>
</body>
</html>