<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>汽车综合服务平台-首页</title>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=6rzptMIb8jDgfZCFy1giVAamRBOhYsdG"></script>
<%@include file="head.jsp" %>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="page-header">
				<h1>
					汽车综合服务平台 
				</h1>
			</div>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div >
		<img style="margin-left:0px;margin-top:0px" src="/Car/resource/image/car.png" class="img-rounded">
				<p>
					<!-- 遮拦窗体 -->
					<div class="row clearfix">
						<div class="col-md-12 column">
							 <a style="float:right;"class="btn btn-primary btn-large" href="#modal-container-1" role="button" class="btn" data-toggle="modal">登录</a>
					 		 <a style="float:right;"class="btn btn-primary btn-large" href="#modal-container-2" role="button" class="btn" data-toggle="modal">注册</a>
							 <!-- panel 1 -->
							<div class="modal fade" id="modal-container-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
											<h4 class="modal-title" id="myModalLabel">
												登录
											</h4>
										</div>
										<div class="modal-body">
											<div class="row clearfix">
												<div class="col-md-12 column">
													<form role="form" action="/Car/user-login.action">
														<div class="form-group">
															 <label for="exampleInputEmail1">用户名</label><input type="text" class="form-control" id="exampleInputEmail1" name="username"/>
														</div>
														<div class="form-group">
															 <label for="exampleInputPassword1">密码</label><input type="password" class="form-control" id="exampleInputPassword1" name="password"/>
														</div>
														
														<input type="hidden" id="cityname" value="" name="city">
														<script type="text/javascript">
															//用来获取用户的所在城市，并通过hiddenform表单提交到action。
															function myFun(result){
																var cityName = result.name;
																document.getElementById("cityname").value=cityName;
																document.getElementById("hiddenform").submit();
															}
															var myCity = new BMap.LocalCity();
															myCity.get(myFun); 
														</script>
														<button type="submit" class="btn btn-default">登录</button>
													</form>
												</div>
											</div>
										</div>
										<div class="modal-footer">
										</div>
									</div>
									
								</div>
								
							</div>
							<!-- panel 1 end -->
 							<!-- panel 2 -->
							<div class="modal fade" id="modal-container-2" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
											<h4 class="modal-title" id="myModalLabel">
												注册
											</h4>
										</div>
										<div class="modal-body">
											<div class="row clearfix">
												<div class="col-md-12 column">
													<form role="form" action="/Car/user-register.action">
														<div class="form-group">
															 <label for="exampleInputEmail1">账号</label><input type="text" class="form-control" id="exampleInputEmail1" name="username"/>
														</div>
														<div class="form-group">
															 <label for="exampleInputEmail1">密码</label><input type="text" class="form-control" id="exampleInputEmail1" name="password"/>
														</div>
														<div class="form-group">
															 <label for="exampleInputEmail1">姓名</label><input type="text" class="form-control" id="exampleInputEmail1" name="person.name"/>
														</div>	
														<div class="form-group">
															 <label for="exampleInputEmail1">年龄</label><input type="number" class="form-control" id="exampleInputEmail1" name="person.age"/>
														</div>	
														<div class="form-group">
															 <label for="exampleInputEmail1">性别</label>
														</div>		
														<div class="radio">
														  <label>
														    <input type="radio" name="person.sex" id="optionsRadios1" value="男" checked="true">男
														  </label>
														  <label>
														    <input type="radio" name="person.sex" id="optionsRadios2" value="女">女
														  </label>
														</div>
														<div class="form-group">
															 <label for="exampleInputEmail1">生日</label><input type="date" class="form-control" id="exampleInputEmail1" name="person.birthDate"/>
														</div>	
														<div class="form-group">
															 <label for="exampleInputEmail1">家庭地址</label><input type="text" class="form-control" id="exampleInputEmail1" name="person.address"/>
														</div>	
														<div class="form-group">
															 <label for="exampleInputEmail1">电话号码</label><input type="tel" class="form-control" id="exampleInputEmail1" name="person.phoneNumber"/>
														</div>	
														<div class="form-group">
															 <label for="exampleInputEmail1">邮箱</label><input type="email" class="form-control" id="exampleInputEmail1" name="person.email"/>
														</div>													
														<button type="submit" class="btn btn-default">注册</button>
														<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
													</form>
												</div>
											</div>
										</div>
										<div class="modal-footer">
											 
										</div>
									</div>
									
								</div>
								
							</div>
							<!-- panel 2 end -->							
						</div>
					</div>
				

				</p>
			</div>	
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-12" style="height:50px;">
		
		</div>
	</div>
	
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="row">
				<div class="col-md-4">
					<div class="thumbnail">
						<img alt="300x200" src="resource/image/botom1.jpg" />
						<div class="caption">
							<h3>
								管理员通知
							</h3>
							<p>
								本系统致力于给您带来全新体验！
							</p>
							<p>
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="thumbnail">
						<img alt="300x200" src="resource/image/botom2.jpg" />
						<div class="caption">
							<h3>
								管理员通知
							</h3>
							<p>
								欢迎进入云端汽车服务系统！
							<p>
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="thumbnail">
						<img alt="300x200" src="resource/image/botom3.jpg" />
						<div class="caption">
							<h3>
								管理员通知
							</h3>
							<p>
								您的支持就是对我们最大的帮助！
							</p>
							<p>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>