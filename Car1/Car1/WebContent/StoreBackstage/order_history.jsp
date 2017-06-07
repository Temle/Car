<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.car.util.PageBean"%>
<%@page import="com.car.domain.*"%>
<%@page import="java.util.*"%>
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
<%Store store=(Store)request.getAttribute("store"); %>

	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="page-header">
				<h1>
					后台管理
				</h1>
			</div>
		</div>
	</div>
	
				
				
	

	<div class="row clearfix">
		<div class="col-md-2 column">
              <ul class="list-group">
  			  <li class="list-group-item" style="line-height:30px;"><a href="/Car/StoreBackstage.action?type=1">未处理订单</a></li>
             <li class="list-group-item" style="line-height:30px;"><a href="/Car/StoreBackstage.action?type=0">基本信息</a></li>
    		 <li class="list-group-item" style="line-height:30px;"><a href="/Car/StoreBackstage.action?type=3">历史订单</a></li>
   			 <li class="list-group-item" style="line-height:30px;"><a href="/Car/StoreBackstage.action?type=2">产品服务</a></li>
   			 <li class="list-group-item" style="line-height:30px;"><a href="/Car/StoreBackstage.action?type=4">发布公告</a></li>
             <li class="list-group-item" style="line-height:30px;"><a href="/Car/indexpage.jsp">退出后台</a></li>
 			</ul>
		</div>
        
        
        
        
		<div class="col-md-10 column">
        <form>
        
         		 <div class="form-group col-lg-5" >	  
				  <input style="margin-left:520px;" type="text" placeholder="请输入订单号" class="form-control" id="exampleInputEmail1"  />			
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
							服务名称
                        </th>
						<th>
							价格
                         </th>
                         <th>
							订单者
						</th>
						<th>
							评论
						</th>
					</tr>
				</thead>
				<tbody>
				<%
						PageBean pageBean = (PageBean) request.getAttribute("pageBean"); 
						List<Storeorder> list=pageBean.getData();
						for(Storeorder storeorder:list)
						{
						
						
		   			 %> 			
					<tr>
						
						<td>
							<%=storeorder.getId() %>
						</td>
						<td>
							<%=storeorder.getStoreproduct().getName() %>
						</td>
						<td>
							<%=storeorder.getPrice() %>
						</td>
                        <td>
							<%=storeorder.getPerson().getName() %>
						</td>
						<td>
							<%=storeorder.getRemarks() %>
						</td>
						<td>
							<form action="/Car/order-operate.action?type=0">
								<input type="hidden" name="store" value="<%=store%>" />
								<input type="hidden" name="order.id" value="<%=storeorder.getId()%>" />
								<input type="submit" class="btn btn-primary btn-sm" value="查看"/>
							</form>
							<form action="/Car/order-operate.action?type=1">
								<input type="hidden" name="store" value="<%=store%>" />
								<input type="hidden" name="order.id" value="<%=storeorder.getId()%>" />
								<input style="margin-left:20px;" type="submit" class="btn btn-primary btn-sm" value="删除"/>
							</form>
						</td>
					</tr>
					
					<%} %>
					
				</tbody>
			</table>
			<div id="pageButton" style="text-align:center;">
						<form name="PageForm" action="/Car/StoreBackstage.action?type=3" method="post">					
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
</body>
</html>
