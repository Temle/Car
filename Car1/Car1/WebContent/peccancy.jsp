<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="head.jsp" %>
<title>页面标题</title>
</head>

<body>
<div class="container">
<%@include file="navigation.jsp" %>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="alert alert-success alert-dismissable">
				 <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
				<h4>
					注意!
				</h4> <strong>Warning!</strong> 请准确输入您车辆的<strong>车架号</strong>和<strong>车牌号</strong>！
			</div>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form class="form-horizontal" role="form" action="/Car/peccancy.action">
				<div class="form-group">
					 <label for="inputEmail3" class="col-sm-2 control-label">车架号</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3" name="carCode"/>
					</div>
				</div>
								<div class="form-group">
					 <label for="inputEmail3" class="col-sm-2 control-label">发动机号</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3" name="carEngineCode"/>
					</div>
				</div>
				<div class="form-group">
					 <label for="inputEmail3" class="col-sm-2 control-label">车牌号</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3" name="carNumber"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						 <button type="submit" class="btn btn-default">查询</button>
					</div>
				</div>
			</form>
		</div>
	</div>


</div>
</body>
</html>
