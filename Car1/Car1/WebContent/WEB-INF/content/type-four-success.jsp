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
									科目四
								</td>
							</tr>
							<tr>
								<td>
									考试模式
								</td>
								<td>
									练习模式
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="col-md-8 column">
			<%List<Question> list=(List<Question>)request.getAttribute("list"); %>
			<%
				int pageNo=(int)request.getAttribute("pageNo");
				Question question=new Question();
				for(Question q:list)
				{
					question=q;
				}
			%>
			<div>
			<p><strong>问题：</strong> <%=question.getQuestion() %></p>
			</div>

			<div class="row" style="height:300px;">
				<img alt="" src="<%=question.getPic() %>" class="img-rounded" />
			</div>
			
			<%
			if(question.getOption1().equals(""))
			{
			%>
			<div class="row clearfix">
				<div class="col-md-6 column">
				
				<input type="radio" name="opt" id="optionsRadios1" value="对" > 正确
				</div>
				<div class="col-md-6 column">
				<input type="radio" name="opt" id="optionsRadios1" value="错" > 错误
				</div>
			</div>
			<%
			}
			else
			{
			%>

			<div class="row clearfix">
				<div class="col-md-6 column"><input type="radio" name="opt" value="A"><%=question.getOption1() %>
				</div>
				<div class="col-md-6 column"><input type="radio" name="opt" value="B"><%=question.getOption2() %>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-6 column"><input type="radio" name="opt" value="C"><%=question.getOption3() %>
				</div>
				<div class="col-md-6 column"><input type="radio" name="opt" value="D"><%=question.getOption4() %>
				</div>
			</div>

			<%
			}
			%>
			<div style="height:20px;"></div>
			<div class="row clearfix">
				<div class="col-md-8 column">
					<div class="row clearfix">
						<div class="col-md-4 column">
							 <a class="btn btn-primary btn-large" href="#modal-container-1" role="button" class="btn" data-toggle="modal">查看题解</a>
							<div class="modal fade" id="modal-container-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
											<h4 class="modal-title" id="myModalLabel">
												题目详解
											</h4>
										</div>
										<div class="modal-body">
											<p><strong>题目范围：</strong><%=question.getChapter() %></p>
											<p><strong>题目解释：</strong><%=question.getExplain() %></p>
											<p><strong>题目答案：</strong><%=question.getAnswer() %></p>
										</div>
										<div class="modal-footer">
											 <button type="button" class="btn btn-default" data-dismiss="modal">关闭
										</div>
									</div>
									
								</div>
								
							</div>
						</div>		
						
						<form name="PageForm" action="/Car/type-four.action">	
							<script>
								function gotoPage(pagenum){
								  document.PageForm.pageNo.value = pagenum;
								  document.PageForm.submit();
								  return ;
								}
							</script>
							<div class="col-md-4 column">
								<% 
								if(pageNo==1)
								{
								%>
								<a class="btn btn-primary btn-large" href="#" role="button" class="btn" data-toggle="modal">上一题</a>
								<%
								}
								else{
								%>
								<a class="btn btn-primary btn-large" href="javascript:gotoPage(<%=pageNo-1%>)" role="button">上一题</a>
								<%}%>
							</div>
							
							<div class="col-md-4 column">
								<a class="btn btn-primary btn-large" href="javascript:gotoPage(<%=pageNo+1%>)" role="button">下一题</a>
							</div>
							
							<div style="display:none;">
								第<input type="text" name="pageNo" style="width:50px;"/>页
								<input type="submit" value="提交">
							</div>
						</form>
						
					</div>
				</div>
				<div class="col-md-4 column">
				</div>
			</div>
		</div>


</div>
</body>
</html>
