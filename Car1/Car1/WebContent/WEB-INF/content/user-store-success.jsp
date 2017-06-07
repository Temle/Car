<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/head.jsp" %>
<title>页面标题</title>
</head>

<body>
<div class="container">
	<%@include file="/userhead.jsp" %>


	<div class="col-md-3">
	<%@include file="/userleft.jsp" %>
	</div>
	<div class="col-md-9">
		<div class="row">
			<div class="col-md-12">
			<table class="table">
				<tbody>
					<tr>
						<td>
							停车场用户注册
						</td>
						<td>
							<a href="/Car/BMap/parking-register.jsp" class="btn btn-primary btn-sm" role="button">注册</a>
						</td>
					</tr>
										<tr>
						<td>
							服务商家用户注册
						</td>
						<td>
							<a href="/Car/StoreBackstage/store_register.jsp" class="btn btn-primary btn-sm" role="button">注册</a>
						</td>
					</tr>
										<tr>
						<td>
							驾校用户注册
						</td>
						<td>
							<a href="/Car/DrivingSchool/drivingschool_register.jsp" class="btn btn-primary btn-sm" role="button">注册</a>
						</td>
					</tr>
															<tr>
						<td>
							陪驾员注册
						</td>
						<td>
							<a href="/Car/DrivingCompanion/companion-register.jsp" class="btn btn-primary btn-sm" role="button">注册</a>
						</td>
					</tr>
				</tbody>
			</table>
			</div>
		</div>
	
		<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="alert alert-success alert-dismissable">
				 <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
				<h4>
					提示!
				</h4> <strong>提示!</strong>您还不是商家用户，点击上方操作，注册成为商家用户。
			</div>
		</div>
	</div>
	</div>






</div>
</body>
</html>
