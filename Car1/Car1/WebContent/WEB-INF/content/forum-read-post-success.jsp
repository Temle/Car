<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.car.domain.Post,com.car.domain.Postconment" %>
    <%@page import="com.car.Tool.PageBean,java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache"> 
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>看贴</title>
<%@ include file="/head.jsp" %>
</head>
<body>
<div class="container">
	<%@ include file="/Forum/forumHead.jsp" %>
	<div class="row clearfix">
		<div class="col-md-12 column text-center">
			<h4>帖子名称</h4>
		</div>
		<div class="col-md-12 column">
			<table class="table">
				<thead>
					<tr>
						<th></th>
						<th style="width:90%;"></th>
					</tr>
				</thead>
				<%
					Post post = (Post) request.getAttribute("post");
				%>
				<tbody>
					<%--贴子信息 --%>
					<tr>
						<td>发贴人</td>
						<td>发贴内容</td>
					</tr>
					
					<tr>
						<td><%=post.getPerson().getName() %>
						<td><%=post.getContent() %>
					</tr>
					
					<%--回贴列表 --%>
					<tr> 
						<td>回帖人</td>
						<td>回帖内容</td>
					</tr>
			<%
				PageBean pageBean1 = (PageBean) request.getAttribute("readPostPageBean"); //important!
				List<Postconment> postconment = pageBean1.getData();
				for (Postconment post1 : postconment) {
			%>
			<tr>
				<td><%=post1.getPerson().getName()%></td>
				<td><%=post1.getContent()%></td>
			</tr>
			<%
				}
			%>
			</tbody>
		</table>
		<form name="PageFormOne" action="/Car/forum-read-post.action?id=<%=post.getId() %>" method="post">
			<script>
			function gotoPageOne(pagenum){
			  document.PageFormOne.pageNo.value = pagenum;
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
			转到第<input type="text" name="pageNo" style="width:50px;"/>页
			<input type="submit" value="提交">
		</form>
		</div>
	</div>
	
		<%--回贴 --%>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form name="PageForm" action="/Car/forum-read-post-conment.action?id=<%=post.getId() %>" method="post">
				<div class="form-group">
					<label for="exampleInputArea1">回贴</label><textarea name="content" class="form-control" rows="4" id="exampleInputArea1" ></textarea>
				</div>
				<button type="submit" class="btn btn-default">发帖</button>
				<button type="reset" class ="btn btn-default">清空</button>
			</form>
		</div>
		
	</div>
</div>
</body>
</html>