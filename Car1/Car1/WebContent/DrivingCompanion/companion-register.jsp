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
			<form action="/Car/companion-register.action" role="form">

                
                <div class="row clearfix"></div>
                
				<div class="form-group col-lg-7">
					 <label for="exampleInputEmail1">驾龄</label>
					 <input name="drivingage" type="text" class="form-control" id="exampleInputEmail1" />
				</div>
                
                
                <div class="row clearfix"></div>
                
                
                <div class="form-group col-lg-7" >
					 <label for="exampleInputEmail1">价格</label>
					 <input name="price" type="text" class="form-control" id="exampleInputEmail1"  />
				</div>                
                
                
                <div class="form-group col-lg-7">
    			<label for="name"">描述</label>
   				 <textarea name="description" style=" width:410px" class="form-control" rows="3"></textarea>
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