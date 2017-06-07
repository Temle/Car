<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.car.domain.*" %>
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
		<div class="col-md-5 column">
			<div class="row">
				<div class="col-md-12">
							<%
				Park park = (Park)request.getAttribute("park"); 
		    	String province=(String)request.getAttribute("province");
		    	String city=(String)request.getAttribute("city");
		    	String district=(String)request.getAttribute("district");
		    	String not=(String)request.getAttribute("notfi");
		   	%>
			<table class="table table-hover table-condensed table-striped">
				<h3><span class="label label-info">停车场详细信息</span></h3>
				<tbody>
					<tr>
						<td>
							店铺名称
						</td>
						<td>
							<%=park.getName() %>
						</td>
					</tr>
					<tr>
						<td>
							店铺描述
						</td>
						<td>
							<%=park.getDescription() %>
						</td>
					</tr>
					<tr>
						<td>
							地址
						</td>
						<td>
							<%=province %><%=city %><%=district %><%=park.getAddress() %>
						</td>
					</tr>					
					<tr>
						<td>
							联系电话
						</td>
						<td>
							<%=park.getPhoneNumber() %>
						</td>
					</tr>					
					<tr>
						<td>
							价格
						</td>
						<td>
							<%=park.getPrice() %>
						</td>
					</tr>
					<tr>
						<td>
							总车位
						</td>
						<td>
							<%=park.getParkSpaceNumber() %>
						</td>
					</tr>
					<tr>
						<td>
							剩余车位
						</td>
						<td>
							<%=park.getRestNumber() %>
						</td>
					</tr>
										<tr>
						<td>
							公告
						</td>
						<td>

							<%=not%>
						</td>
					</tr>
				</tbody>
			</table>
				</div>
				<div class="col-md-12">
					<h3><span class="label label-info">停车场预约</span></h3>
			<form role="form" action="/Car/parking-ord.action">
				<div class="form-group">
					 <label for="exampleInputEmail1">姓名</label><input type="text" class="form-control" id="exampleInputEmail1" />
				</div>
								<div class="form-group">
					 <label for="exampleInputEmail1">备注</label><input type="text" class="form-control" id="exampleInputEmail1" name="remarks"/>
				</div>
				<input type="hidden" value="<%=park.getId()%>" name="parkid">
				<input type="hidden" value="<%=park.getPrice()%>" name="price">
				 <button type="submit" class="btn btn-default">预约</button>
			</form>
				</div>
				<div class="col-md-12" style="height:50px;">
					
				</div>
				<div class="col-md-12">
				<h3><span class="label label-info">停车场举报</span></h3>
					<form role="form" action="/Car/parking-report.action">
						<div class="form-group"><label for="exampleInputEmail1">店家名称</label><input type="text" class="form-control" id="exampleInputEmail1" /></div>
						<div class="form-group"><label for="exampleInputEmail1">举报内容</label><input type="text" class="form-control" id="exampleInputEmail1" name="content"/></div>				
						<input type="hidden" value="<%=park.getId()%>" name="parkid">
						<button type="submit" class="btn btn-default">举报</button>
					</form>
				</div>
			</div>

		</div>
		<div class="col-md-7 column">
			<h3><span class="label label-info">评论区</span></h3>
			
			<div class="panel-group" id="accordion">
			<%
				List<ConmentShow> list=(List<ConmentShow>)request.getAttribute("li");
				int i=0;
				for(ConmentShow c:list)
				{
					
			%>
				<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a data-toggle="collapse" data-parent="#accordion" 
				   href="#<%=i%>">
					<%=c.getDate()%>&nbsp;&nbsp;&nbsp;<%=c.getUsername() %>
				</a>
			</h4>
		</div>
		<div id="<%=i %>" class="panel-collapse collapse">
			<div class="panel-body">
				<%=c.getContent() %>
			</div>
		</div>
	</div>
			<%
				i++;
				}
			%>
			

</div>


			<form role="form" action="/Car/parking-conment.action">
				<div class="form-group">
					 <label for="exampleInputEmail1">评论内容</label><input type="text" class="form-control" id="exampleInputEmail1" name="content"/>
				</div>
				<input type="hidden" value="<%=park.getId()%>" name="parkid">
				<button type="submit" class="btn btn-default">提交评论</button>
			</form>
			
		</div>
	</div>
	<div class="row">
		<div class="col-md-12" style="height:70px"></div>
	</div>

		    

</div>
		    
</body>
</html>
