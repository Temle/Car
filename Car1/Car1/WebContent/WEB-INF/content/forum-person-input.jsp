    pageEncoding="UTF-8"%>
    <%@page import="com.car.Tool.PageBean"%>
<%@page import="java.util.List,com.car.domain.Post,com.car.domain.Postconment"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache"> 
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="0">
<%@ include file="/head.jsp" %>
<title>个人中心</title>
</head>
<body>
<div class="container">
 
	<%@ include file="/Forum/forumHead.jsp" %>

	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="tabbable" id="tabs-380779">
				<ul class="nav nav-tabs">
					<li>
						 <a href="#panel-557995" data-toggle="tab">我的发贴</a>
					</li>
					<li>
						 <a href="#panel-830969" data-toggle="tab">我的回贴</a>
					</li>
					<li class="active">
						<a href="#panel-134290" data-toggle="tab">我的精品贴</a>
					</li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane" id="panel-557995">
						<p>
							<%--我的发贴 --%>
							<div class="col-md-12 column">
								<table class="table">
									<thead>
										<tr>
											<th>板块</th>
											<th style="width:50%;">贴子</th>
											<th>发贴时间</th>
											<th>点赞</th>
										</tr>
									</thead>
									<tbody>
						<%
							PageBean pageBean1 = (PageBean) request.getAttribute("left"); //important!
							PageBean pageBean3 = (PageBean) request.getAttribute("right"); //important!
							List<Post> posts1 = pageBean1.getData();
							List<Post> posts3 = pageBean3.getData();
							for (Post post : posts1) {
						%>
						<tr>
						<%if(post.getType().equals("X")){ %>
							<td><%="经验分享"%></td>	<%} else if(post.getType().equals("Y")){%>
							<td><%="车友交流"%></td>	<%} else {%>
							<td><%="交友区"%></td>	<%} %>
							<td><a href="/Car/forum-read-post.action?id=<%=post.getId()%>"><%=post.getTitle()%></a></td>
							<td><%=post.getDate()%></td>
							<td><%=post.getNnumber()%></td>
						</tr>
						<%
							}
						%>
						<% 
							for (Post post : posts3) {
						%>
							<tr>
							<%if(post.getType().equals("X")){ %>
								<td><%="经验分享"%></td>	<%} else if(post.getType().equals("Y")){%>
								<td><%="车友交流"%></td>	<%} else {%>
								<td><%="交友区"%></td>	<%} %>
								<td><a href="/Car/forum-read-post.action?id=<%=post.getId()%>"><%=post.getTitle()%></a></td>
								<td><%=post.getDate()%></td>
								<td><%=post.getNnumber()%></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
					<form name="PageFormOne" action="/Car/forum-person.action?id=1" method="post">
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
						</p>
					</div>	
						
					<div class="tab-pane" id="panel-830969">
						<p>
							<%--我的回贴 --%>
							<div class="col-md-12 column">
								<table class="table">
									<tbody>
									<%
										PageBean pageBean2 = (PageBean) request.getAttribute("middle"); //important!
										List<Postconment> postconments = pageBean2.getData();
										for (Postconment postconment : postconments) {
									%>
									<tr>
										<td>
										<div class="col-md-12 column">
											<div class="col-md-10 column">
												<a href="#" class="btn btn-info btn-sm">
									          		<span class="glyphicon glyphicon-comment">
									          		</span>
									          		名字<%=postconment.getPerson().getName() %> 回复了
									          	</a>
											</div>
											<div class="col-md-2 column"><%=postconment.getDate() %>></div>
										</div>
										<div class="col-md-12 column">
											回复内容:<%=postconment.getContent() %>
										</div>
										<div class="col-md-12 column">
											<div class="col-md-8 column" style="background:#F0F0F0;">
												<a href="/Car/forum-read-post.action?id=<%=postconment.getPost().getId() %>">
													<div class="col-md-10 column">
														原贴：<%=postconment.getPost().getTitle() %>
													</div>
													<div class="col-md-2 column pull-right">
														作者: <%=postconment.getPost().getPerson().getName() %>
													</div>
												</a>
											</div>
										</div>
										</td>
									</tr>
									<%
										}
									%>
									</tbody>
								</table>
								<form name="PageFormTwo" action="/Car/forum-person.action?id=2" method="post">
								<script>
								function gotoPageTwo(pagenum){
								  document.PageFormTwo.pageNoTwo.value = pagenum;
								  document.PageFormTwo.submit();
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
								<a href="javascript:gotoPageTwo(1)">首页</a>
								<a href="javascript:gotoPageTwo(<%=pageBean2.curPage-1%>)">上一页</a>
								<%}%>
								<%
								   if(pageBean2.curPage==pageBean2.maxPage || pageBean2.maxRowCount==0){ 
								        out.print("下一页 尾页");  
								   }else{  
								 %>   
								<a href="javascript:gotoPageTwo(<%=pageBean2.curPage+1%>)">下一页</A>
								<a href="javascript:gotoPageTwo(<%=pageBean2.maxPage%>)">尾页</A>
								<%}%>
								转到第<input type="text" name="pageNoTwo" style="width:50px;"/>页
								<input type="submit" value="提交">
							</form>
							</div>
						</p>
						
						
					</div>
					<div class="tab-pane active" id="panel-134290">
						<p>
							<%--我的精品贴 --%>
							<div class="col-md-12 column">
								<table class="table">
									<thead>
										<tr>
											<th>板块</th>
											<th style="width:50%;">贴子</th>
											<th>发贴时间</th>
											<th>点赞</th>
										</tr>
									</thead>
									<tbody>
						<%
							for (Post post : posts3) {
						%>
						<tr>
						<%if(post.getType().equals("X")){ %>
							<td><%="经验分析"%></td>	<%} else if(post.getType().equals("Y")){%>
							<td><%="车友交流"%></td>	<%} else {%>
							<td><%="交友区"%></td>	<%} %>
							<td><a href="/Car/forum-read-post.action?id=<%=post.getId()%>"><%=post.getTitle()%></a></td>
							<td><%=post.getDate()%></td>
							<td><%=post.getNnumber()%></td>
						</tr>
						<%
							}
						%>
						</tbody>
					</table>
					<form name="PageFormThree" action="/Car/forum-person.action?id=3" method="post">
						<script>
						function gotoPageThree(pagenum){
						  document.PageFormThree.pageNoThree.value = pagenum;
						  document.PageFormThree.submit();
						  return ;
						}
						</script>
						每页<%=pageBean3.rowsPerPage%>行
						共<%=pageBean3.maxRowCount%>行
						第<%=pageBean3.curPage%>页
						共<%=pageBean3.maxPage%>页
						<br/>
						<%
						   if(pageBean3.curPage==1){ 
						        out.print(" 首页 上一页");   
						   }else{  
						 %>   
						<a href="javascript:gotoPageThree(1)">首页</a>
						<a href="javascript:gotoPageThree(<%=pageBean3.curPage-1%>)">上一页</a>
						<%}%>
						<%
						   if(pageBean3.curPage==pageBean3.maxPage || pageBean3.maxRowCount==0){ 
						        out.print("下一页 尾页");  
						   }else{  
						 %>   
						<a href="javascript:gotoPageThree(<%=pageBean3.curPage+1%>)">下一页</A>
						<a href="javascript:gotoPageThree(<%=pageBean3.maxPage%>)">尾页</A>
						<%}%>
						转到第<input type="text" name="pageNoThree" style="width:50px;"/>页
						<input type="submit" value="提交">
					</form>
							</div>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</div>
</body>
</html>