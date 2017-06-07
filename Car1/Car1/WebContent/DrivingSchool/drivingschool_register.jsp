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
 		<div class="col-md-3 column"></div>
<div class="col-md-8 column">
			<form action="/Car/drivingschool-register.action" role="form">
				<div class="form-group col-lg-7" >
				  <label for="exampleInputEmail1">驾校名</label>
				  <input name="name" type="text" class="form-control" id="exampleInputEmail1"  />
				</div>
                
                <div class="row clearfix"></div>
                
				<div class="form-group col-lg-7">
					 <label for="exampleInputPassword1">城市</label>
					 <input name="city" type="text" class="form-control" id="exampleInputPassword1" />
				</div>
                
                <div class="row clearfix"></div>
                
                <div class="form-group col-lg-7" >
					 <label for="exampleInputEmail1">地址</label>
					 <input name="address" type="text" class="form-control" id="exampleInputEmail1"  />
				</div>
                
                
                <div class="row clearfix"></div>
                
                <div class="form-group col-lg-7" >
					 <label for="exampleInputEmail1">电话号码</label>
					 <input name="phoneNumber" type="text" class="form-control" id="exampleInputEmail1"  />
				</div>
                
                <div class="row clearfix"></div>
                
                
                <div class="form-group col-lg-7" >
					 <label for="exampleInputEmail1">价格</label>
					 <input name="price" type="text" class="form-control" id="exampleInputEmail1"  />
				</div>
                
                <div class="row clearfix"></div>
                
                
                <div class="form-group col-lg-7" >
					 <label for="exampleInputEmail1">车型</label>
					 <input name="carType" type="text" class="form-control" id="exampleInputEmail1"  />
				</div>
                
                <div class="row clearfix"></div>
                
                
                <div class="form-group">
    			<label for="name" style="margin-left:15px;">描述</label>
   				 <textarea name="description" style=" width:410px; margin-left:15px" class="form-control" rows="3"></textarea>
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