<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/head.jsp" %>
<title>停车场注册</title>
</head>

<body>
<div class="container">
<%@include file="/navigation.jsp" %>

	<div class="row clearfix">
			<div class="col-md-4 column">
				<form role="form" action="/Car/parking-add.action">
					<div class="form-group">
						 <label for="exampleInputEmail1">名称</label><input type="text" class="form-control" id="exampleInputEmail1" name="park.name"/>
					</div>
					<div class="form-group">
						 <label for="exampleInputEmail1">地址</label><input type="text" class="form-control" id="exampleInputEmail1" name="park.address"/>
					</div>
					<input type="hidden" value="" name="x" id="pointx">
					<input type="hidden" value="" name="y" id="pointy">
					
					<div class="form-group">
						 <label for="exampleInputEmail1">联系电话</label><input type="text" class="form-control" id="exampleInputEmail1" name="park.phoneNumber"/>
					</div>
					<div class="form-group">
						 <label for="exampleInputEmail1">停车场介绍</label><input type="text" class="form-control" id="exampleInputEmail1" name="park.description"/>
					</div>
					<div class="form-group">
						 <label for="exampleInputEmail1">价格</label><input type="text" class="form-control" id="exampleInputEmail1" name="park.price"/>
					</div>
					<div class="form-group">
						 <label for="exampleInputEmail1">停车场总的车位数目</label><input type="text" class="form-control" id="exampleInputEmail1" name="park.parkSpaceNumber"/>
					</div>																		
	 				<button type="submit" class="btn btn-default">注册</button>
				</form>
			</div>
			<h3><span class="label label-info">请在下面地图中选中停车场的具体位置</span></h3>
			<div class="col-md-8" id="allmap" style="height:400px;">
			
			</div>
	</div>

</div>
</body>
<script type="text/javascript">
	//百度地图API功能
	function loadJScript() {
		var script = document.createElement("script");
		script.type = "text/javascript";
		script.src = "http://api.map.baidu.com/api?v=2.0&ak=6rzptMIb8jDgfZCFy1giVAamRBOhYsdG&callback=init";
		document.body.appendChild(script);
	}
	function init() {
		var map = new BMap.Map("allmap");            
		//map.centerAndZoom("重庆",12);                 

 		//定位用户当前所在的城市
		function myFun(result){
			var cityName = result.name;
			//map.setCenter(cityName);
			map.centerAndZoom(cityName,13);
		}
		var myCity = new BMap.LocalCity();
		myCity.get(myFun); 
		
		//单击获取点击的经纬度
		map.addEventListener("click",function(e){
			document.getElementById("pointx").value=e.point.lng;
			document.getElementById("pointy").value=e.point.lat;
			map.clearOverlays(); 
			var marker = new BMap.Marker(new BMap.Point(e.point.lng, e.point.lat));
			map.addOverlay(marker); 
		});
		
		map.enableScrollWheelZoom();//启用滚轮放大缩小
	}  
	window.onload = loadJScript;  //异步加载地图
</script>
</html>
