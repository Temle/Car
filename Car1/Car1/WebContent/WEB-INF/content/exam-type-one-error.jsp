<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.car.Tool.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/head.jsp" %>
<title>页面标题</title>
</head>

<body>
<div class="container">
<%@include file="/navigation.jsp" %>
<div class="row clearfix">
		<div class="col-md-4">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<table class="table">
						<tbody>
							<tr>
								<td>
									驾照类型
								</td>
								<td>
									C1
								</td>
							</tr>
							<tr>
								<td>
									考试类型
								</td>
								<td>
									科目一
								</td>
							</tr>
							<tr>
								<td>
									考试模式
								</td>
								<td>
									模拟考试
								</td>
							</tr>
							<tr>
								<td>
									当前分数
								</td>
								<td>
									<%int num=(int)request.getAttribute("fsc") ;%>
									<label id="score" ><%=num %></label>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="col-md-8 column">
			<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="alert alert-success alert-dismissable">
				 <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
				<h4>
					考试结束
				</h4>  您本次得分为:<strong><%=num %></strong>
			</div>
		</div>
	</div>
		</div>


</div>
</body>
</html>
