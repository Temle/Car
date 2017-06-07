<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>商家注册</title>



</head>

<body>
<div class="container">

<%@include file="/navigation.jsp" %>
	
 
 <div class="row clearfix">
 		<div class="col-md-3 column"></div>
<div class="col-md-8 column">
			<form role="form" action="/Car/register-store.action" methon="post">
				<div class="form-group col-lg-7" >
				  <label for="exampleInputEmail1">商家名</label>
				  <input name="store.name" type="text" class="form-control" id="exampleInputEmail1"  />
				</div>
                
                <div class="row clearfix"></div>
                
				<div class="form-group col-lg-7">
					 <label for="exampleInputPassword1">城市</label>
					 <input name="store.city" type="text" class="form-control" id="exampleInputPassword1" />
				</div>
                
                <div class="row clearfix"></div>
                
                <div class="form-group col-lg-7" >
					 <label for="exampleInputEmail1">地址</label>
					 <input name="store.address" type="text" class="form-control" id="exampleInputEmail1"  />
				</div>
                
                
                <div class="row clearfix"></div>
                
                <div class="form-group col-lg-7" >
					 <label for="exampleInputEmail1">电话号码</label>
					 <input name="store.phoneNumber" type="text" class="form-control" id="exampleInputEmail1"  />
				</div>
                
                <div class="row clearfix"></div>
                
                
                <div class="form-group">
    			<label for="name" style="margin-left:15px;">描述</label>
   				 <textarea name="store.description" style=" width:410px; margin-left:15px" class="form-control" rows="3"></textarea>
  				</div>
                
                
                <div class="row clearfix"></div>
                
				<div class="row clearfix">
                 <div class="col-md-3 column"></div>
                 
                 <div class="col-md-2 column">
                  <button type="submit" class="btn btn-default">提交</button>
                 </div>
                
                <div class="col-md-2 column"></div>
                </div>
                
                
			 	
    </form>
		</div>
        <div class="col-md-1 column"></div>
	</div>





</div>
</body>
</html>