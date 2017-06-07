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
			<script type="text/javascript">
			function check(browser)
			  {
			  		var opt="<%=question.getAnswer()%>";
			  		if(opt!=browser)
			  		{
						alert("答案错误！");
			  			var label=document.getElementById("score"); 
				  		var value=label.innerText; 
				  		 document.PageForm.fsc.value = parseInt(value);
				  		gotoPage(<%=pageNo+1%>);
			  			
			  		}
			  		else
			  		{
			  			var label=document.getElementById("score"); 
			  			var value=label.innerText; 
			  			label.innerText=parseInt(value)+1;
			  			document.PageForm.fsc.value = parseInt(value)+1;
			  			gotoPage(<%=pageNo+1%>);	
			  		}
			  }
			</script>
			<div class="row clearfix">
				<div class="col-md-6 column">
				
				<input type="radio" name="opt" id="optionsRadios1" value="对" onclick="check(this.value)"> 正确
				</div>
				<div class="col-md-6 column">
				<input type="radio" name="opt" id="optionsRadios1" value="错" onclick="check(this.value)"> 错误
				</div>
			</div>
			<%
			}
			else
			{
			%>
			<script type="text/javascript">
			function check(browser)
			  {
			  			var opt="<%=question.getAnswer()%>";
			  			if(opt==browser)
			  			{
			  			var label=document.getElementById("score"); 
			  			var value=label.innerText; 
			  			label.innerText=parseInt(value)+1;
			  			document.PageForm.fsc.value = parseInt(value)+1;
			  			gotoPage(<%=pageNo+1%>);
			  			}
			  			else
			  			{
			  			 alert("答案错误！");
				  		var label=document.getElementById("score"); 
				  		var value=label.innerText; 
				  		 document.PageForm.fsc.value = parseInt(value);
				  		 gotoPage(<%=pageNo+1%>);
			  			}
			  }
			</script>
			<div class="row clearfix">
				<div class="col-md-6 column"><input type="radio" name="opt" value="A" onclick="check(this.value)"><%=question.getOption1() %>
				</div>
				<div class="col-md-6 column"><input type="radio" name="opt" value="B" onclick="check(this.value)"><%=question.getOption2() %>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-6 column"><input type="radio" name="opt" value="C" onclick="check(this.value)"><%=question.getOption3() %>
				</div>
				<div class="col-md-6 column"><input type="radio" name="opt" value="D" onclick="check(this.value)"><%=question.getOption4() %>
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

						</div>		
						
						<form name="PageForm" action="/Car/exam-type-one.action">	
							<script>
								function gotoPage(pagenum){
								  document.PageForm.pageNo.value = pagenum;
								  document.PageForm.submit();
								  return ;
								}
							</script>
							<div class="col-md-4 column">

							</div>
							
							<div class="col-md-4 column">
								
							</div>
							
							<div style="display:none;">
								<input type="text" name="fsc"/>
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
