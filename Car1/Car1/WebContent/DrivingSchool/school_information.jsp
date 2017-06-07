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
		<div class="col-md-8 column">
			<table class="table">
				
				<tbody>
				<%
				Drivingschool drivingschool=(Drivingschool) request.getAttribute("drivingschool");	
				
				%>
					<tr>
						<td>驾校名</td>
						<td><%=drivingschool.getName() %></td>
					</tr>
					<tr>
						<td>地址</td>
						<td><%=drivingschool.getAddress() %></td>
					</tr>
					<tr >
						<td>价格</td>
						<td><%=drivingschool.getPrice() %></td>
					</tr>
					<tr >
						<td>电话号码</td>
						<td><%=drivingschool.getPhoneNumber() %></td>
					</tr>
					<tr >
						<td>描述</td>
						<td><%=drivingschool.getDescription() %></td>
					</tr>
                    <tr >
						<td>汽车类型</td>
						<td><%=drivingschool.getCarType() %></td>
					</tr>

				</tbody>
			</table>
		</div>

		
		
        <div class="col-md-4 column">
        <p>教练员列表</p>
        <table class="table">		
				<tbody>
					<%
						PageBean pageBean = (PageBean) request.getAttribute("pageBean"); 
						List<Drivingcoach> list1=pageBean.getData();
						for(Drivingcoach drivingcoach:list1)
						{
				    %>
				
					<tr>
						<td><%=drivingcoach.getName()%></td>
						<td><%=drivingcoach.getSex() %></td>
						<td>
							<a href="/Car/coach-iformation.action?id=<%=drivingcoach.getId() %>" class="btn btn-primary btn-sm" role="button">
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
	
	<div class="row clearfix">
		
		<div class="col-md-8 column">
		
			<div class="col-md-8 column">
	            <div class="row clearfix">
		        	<form role="form" action="/Car/driving-order.action" >
						<div class="form-group"> 
			    		<textarea class="form-control" rows="3" name="remarks"> 备注 </textarea> 
			 		    </div> 
			 		    <input type="hidden" value="<%=drivingschool.getId()%>" name="schoolid">

						<button type="submit" class="btn btn-default">预约<tton>
			 		    
				    </form>
	       		 </div>
	 
			</div>
	        
			<div class="col-md-4 column"> </div>
		</div>
	</div>
    

  

	<table class="table">		
				<tbody>
					<%
					PageBean pageBean1 = (PageBean) request.getAttribute("pageBean1"); 
					List<Conment> list2=pageBean1.getData();
					for(Conment comment:list2)
					{
				    %>
				
					<tr>
						<td><%=comment.getPerson().getName()%></td>
						<td><%=comment.getContent() %></td>
					</tr>
					
					<%} %>
				</tbody>
	</table>
        
        <div id="pageButton" style="text-align:center;">
						<form name="PageForm" action="/Car/parking-list.action" method="post">					
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




<div class="row clearfix">
		<div class="col-md-12 column">
			<form role="form" action="/Car/school-comment.action">
			<div class="form-group"> 
    		<textarea name="comments" class="form-control" rows="3"></textarea> 
 		   </div> 
 		    <input type="hidden" value="<%=drivingschool.getId()%>" name="schoolid">
  		   <button type="submit" class="btn btn-default">提交评论</button>
			</form>
			<div class="row clearfix">
				<div class="col-md-12 column">
				</div>
			</div>
		</div>
	</div>


</div>

</body>
</html>
