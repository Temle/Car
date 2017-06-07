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
        <form action="/Car/companion-background-order-information.action">
        
         		 <div class="form-group col-lg-5" >	  
				  <input name="id" style="margin-left:520px;" type="text" placeholder="请输入订单号" class="form-control" id="exampleInputEmail1"  />			
                  <button style="margin-left:820px;" type="submit" class="btn btn-default">查询</button>
				</div>
        </form>
        <div class="row clearfix"></div>
        <table class="table table-hover" >
				<thead>
					<tr>
						
						<th>
							订单号
                        </th>
						<th>
							日期
                         </th>
                         <th>
							预定者
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
		 		<tbody>
				<%
						PageBean pageBean = (PageBean) request.getAttribute("pageBean"); 
						List<Drivingcorder> list=pageBean.getData();
						for(Drivingcorder drivingcorder:list)
						{
				    %>
					<tr>
						
						<td>
							<%=drivingcorder.getId() %>
						</td>
						<td>
							<%=drivingcorder.getDate() %>
						</td>
                        <td>
							<%=drivingcorder.getPerson().getName() %>
						</td>
						<td>
							<a  href="/Car/companion-background-order-information.action?id=<%=drivingcorder.getId()%>" class="btn btn-primary btn-sm" role="button">查看</a>
                            <a  style="margin-left:20px;" href="/Car/companion-background-order.action" class="btn btn-primary btn-sm" role="button">删除 </a>

						</td>
					</tr>
				<%} %>
				</tbody>
			</table>
			<div id="pageButton" style="text-align:center;">
						<form name="PageForm" action="/Car/companion-list.action" method="post">					
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
</body>
</html>