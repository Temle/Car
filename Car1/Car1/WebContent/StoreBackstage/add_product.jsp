<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<%Store store=(Store)request.getAttribute("store"); 
  %>
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
        <form action="/Car/add-product.action">
        <table class="table">
				
				<tbody>
					<tr>
						
						<td>服务产品名称</td>
						<td>
							 <input name="product.name"  style="margin-left:;" type="text"  class="form-control" id="exampleInputEmail1"  />	
						</td>
					</tr>
					<tr >
						
						<td>价格</td>
						<td>
							<input name="product.price" style="margin-left:;" type="text"  class="form-control" id="exampleInputEmail1"  />	
						</td>
					</tr>
					<tr >
						
						<td>描述</td>
						<td>
							 <textarea name="product.description" style=" width:410px;class="form-control" rows="3"></textarea>
						</td>
					</tr>
					
				</tbody>
			</table>
			<input type="hidden" name="s.id" value="<%=store.getId() %>" />
            <h3 style=" text-align:center">
					 <button type="submit" class="btn btn-default">确认添加</button>
			</h3>
         </form>		
		</div>
	</div>




</div>
</body>
</html>
