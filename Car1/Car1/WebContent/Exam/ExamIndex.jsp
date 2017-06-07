<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<div class="col-md-12 column">
			<table class="table">
				<thead>
					<tr>
						<th>
							编号
						</th>
						<th>
							考试类型
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							1
						</td>
						<td>
							科目一练习
						</td>
						<td>
							<a href="/Car/type-one.action" class="btn btn-primary btn-sm" role="button">查看</a>
						</td>
					</tr>
					<tr class="success">
						<td>
							2
						</td>
						<td>
							科目一模拟考试
						</td>
						<td>
							<a href="/Car/exam-type-one.action" class="btn btn-primary btn-sm" role="button">查看</a>
						</td>
					</tr>
					<tr class="warning">
						<td>
							3
						</td>
						<td>
							科目四练习
						</td>
						<td>
							<a href="	/Car/type-four.action" class="btn btn-primary btn-sm" role="button">查看</a>
						</td>
					</tr>
					<tr class="info">
						<td>
							4
						</td>
						<td>
							科目四模拟考试
						</td>
						<td>
							<a href="/Car/exam-type-four.action" class="btn btn-primary btn-sm" role="button">查看</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

</div>
</body>
</html>
