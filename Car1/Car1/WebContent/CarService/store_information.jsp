<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.car.util.*" %>
<%@ page import="com.car.domain.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/head.jsp" %>
<title>页面标题</title>
</head>

<body>
<div class="container">
	
<%@ include file="/navigation.jsp" %>
<% Store store=(Store)request.getAttribute("store"); %>
<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="jumbotron">
				<h3>
					公告
				</h3>
				<p>
					This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.
				</p>

			</div>
		</div>
	</div>
    
    
    
    
    
    <div class="row clearfix">
		<div class="col-md-6 column">
		</div>
		<div class="col-md-6 column">
			<div class="row clearfix">
				<div class="col-md-4 column">
					<p>
						 <em>服务列表</em>
					</p>
				</div>
				<div class="col-md-4 column">
				</div>
				<div class="col-md-4 column">
				</div>
			</div>
		</div>
	</div>
    

    <div class="row clearfix">
		<div class="col-md-6 column">
			<table class="table">
				
				<tbody>
					<tr>

						<td>
							商家名</td>
						<td>
							<%=store.getName() %>
						</td>
					</tr>
					<tr class="success">


						<td>
							城市</td>
						<td>
							<%=store.getCity() %>
						</td>
					</tr>
					<tr class="error">


						<td>地址
							</td>
						<td>
							<%=store.getAddress() %>
						</td>
					</tr>
					<tr class="warning">


						<td>
							电话号码</td>
						<td>
							<%=store.getPhoneNumber() %>
						</td>
					</tr>
					<tr class="info">


						<td>描述</td>
						<td>
							<%=store.getDescription() %>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="col-md-6 column">
			<table class="table">
				
				<tbody>
				<%
						PageBean pageBean = (PageBean) request.getAttribute("pageBean"); 
						List<Storeproduct> list=pageBean.getData();
						for(Storeproduct storeproduct:list)
						{
						
						
		   			 %> 				
					<tr>
						<td>
							<%=storeproduct.getName() %></td>
						<td>
							<div >
							<form action="/Car/store-product.action">
								<input type="hidden" value="<%=store.getId() %>" name="s.id" />
								<input type="hidden" value="<%=storeproduct.getId() %>" name="storeproduct.id" />
								<input type="submit" value="查看">
							</form>
							</div> 		
						</td>
					</tr>
					<%} %>
				</tbody>
			</table>
			<div id="pageButton" style="text-align:center;">
						<form name="PageForm" action="/Car/store-info.action" method="post">					
							<script>
							function gotoPage1(pagenum){
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
							<a href="javascript:gotoPage1(1)" class="btn btn-default" role="button">首页</a>
							<a href="javascript:gotoPage1(<%=pageBean.curPage-1%>)" class="btn btn-default" role="button">上一页</a>
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
							  
							<a href="javascript:gotoPage1(<%=pageBean.curPage+1%>)" class="btn btn-default" role="button">下一页</A>
							<a href="javascript:gotoPage1(<%=pageBean.maxPage%>)" class="btn btn-default" role="button">尾页</A>
							<%
								}
							%>
							</br>
							<div style="display:none;">
								第<input type="text" name="pageNo" style="width:50px;"/>页
								<input type="hidden" value="<%=store.getId() %>" name="s.id" />
								<input type="submit" value="提交">
							</div> 		
						</form>
			</div>
		</div>
	</div>
    
    
    
    

<div align="center">
	<h3>店家评论</h3>
</div>


<div class="row clearfix">
		<div class="col-md-12 column">
		<%
						PageBean pageBean2 = (PageBean) request.getAttribute("pageBean2"); 
						List<Conment> comList=pageBean2.getData();
						for(Conment conment:comList)
						{
					
						
		   			 %> 	
			<div class="row clearfix">		
				<div class="col-md-12 column">
					<p>
						 <em>
						 <%=conment.getPerson().getName() %>:<%=conment.getContent() %>&nbsp;
						 发布于:<%=conment.getDate() %>
						 </em></p>
				</div>
			</div>
			<%} %>
			<div id="pageButton" style="text-align:center;">
						<form name="PageForm2" action="/Car/store-info.action" method="post">					
							<script>
							function gotoPage2(pagenum){
							  document.PageForm2.pageNo2.value = pagenum;
							  document.PageForm2.submit();
							  return ;
							}
							</script>
							<span class="label label-default">每页<%=pageBean2.rowsPerPage%>行
							共<%=pageBean2.maxRowCount%>行
							第<%=pageBean2.curPage%>页
							共<%=pageBean2.maxPage%>页</span>
							
							<br/>
							<% 
							   if(pageBean2.curPage==1){ 
								   %>
									<a href="#" class="btn btn-default" role="button">首页</a>
									<a href="#" class="btn btn-default" role="button">上一页</a>   
								   <% 
							   }else{  
							 %>   
							<a href="javascript:gotoPage2(1)" class="btn btn-default" role="button">首页</a>
							<a href="javascript:gotoPage2(<%=pageBean2.curPage-1%>)" class="btn btn-default" role="button">上一页</a>
							<%
								}
							%>
							<%
							   if(pageBean2.curPage==pageBean2.maxPage){ 
								   %>
									<a href="#" class="btn btn-default" role="button">下一页</A>
									<a href="#" class="btn btn-default" role="button">尾页</A>   
								   <% 
							   }else{  
							%>  
							  
							<a href="javascript:gotoPage2(<%=pageBean2.curPage+1%>)" class="btn btn-default" role="button">下一页</A>
							<a href="javascript:gotoPage2(<%=pageBean2.maxPage%>)" class="btn btn-default" role="button">尾页</A>
							<%
								}
							%>
							</br>
							<div style="display:none;">
								第<input type="text" name="pageNo2" style="width:50px;"/>页
								<input type="hidden" value="<%=store.getId() %>" name="s.id" />
								<input type="submit" value="提交">
							</div> 
							
		 
						</form>
			</div>
		</div>
	</div>




<div class="row clearfix">
		<div class="col-md-12 column">
			<form role="form" action="/Car/store-remark.action">
			<div class="form-group"> 
    			<textarea class="form-control" rows="3" name="conment"></textarea> 
 		   </div> 
 		  	<input type="hidden" value="<%=store.getId() %>" name="s.id" />
  		   <input type="submit" class="btn btn-default" value="提交" />
			</form>
			<div class="row clearfix">
				<div class="col-md-12 column">
				</div>
			</div>
		</div>
	</div>





</div>
·
</body>
</html>
