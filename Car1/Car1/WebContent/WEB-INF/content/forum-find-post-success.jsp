<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.car.domain.Post,com.car.Tool.PageBean,java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache"> 
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索结果</title>
<%@ include file="/head.jsp" %>
</head>
<body>
<div class="container">
	<%@ include file="/Forum/forumHead.jsp" %>
	
	<div class="row clearfix">
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
					PageBean pageBean = (PageBean) request.getAttribute("findPostPageBean"); //important!
					List<Post> posts = pageBean.getData();
					for (Post post : posts) {
				%>
				<tr>
					<td><a href="/Car/forum-read-post.action?id=<%=post.getId()%>"><%=post.getTitle()%></a></td>
					<td><%=post.getPerson().getName()%></td>
					<td><%=post.getNnumber()%></td>
				</tr>
				<%
					}
				%>
				</tbody>
			</table>
			<form name="PageFormThree" action="/Car/forum-find-post.action" method="post">
				<script>
				function gotoPageThree(pagenum){
				  document.PageFormThree.pageNo.value = pagenum;
				  document.PageFormThree.submit();
				  return ;
				}
				</script>
				每页<%=pageBean.rowsPerPage%>行
				共<%=pageBean.maxRowCount%>行
				第<%=pageBean.curPage%>页
				共<%=pageBean.maxPage%>页
				<br/>
				<%
				   if(pageBean.curPage==1){ 
				        out.print(" 首页 上一页");   
				   }else{  
				 %>   
				<a href="javascript:gotoPageThree(1)">首页</a>
				<a href="javascript:gotoPageThree(<%=pageBean.curPage-1%>)">上一页</a>
				<%}%>
				<%
				   if(pageBean.curPage==pageBean.maxPage || pageBean.maxRowCount==0){ 
				        out.print("下一页 尾页");  
				   }else{  
				 %>   
				<a href="javascript:gotoPageThree(<%=pageBean.curPage+1%>)">下一页</A>
				<a href="javascript:gotoPageThree(<%=pageBean.maxPage%>)">尾页</A>
				<%}%>
				转到第<input type="text" name="pageNo" style="width:50px;"/>页
				<input type="submit" value="提交">
			</form>
	</div>
</div>
</body>
</html>