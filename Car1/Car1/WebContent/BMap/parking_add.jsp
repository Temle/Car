<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<style type="text/css">
	body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
</style>
<title>停车场用户注册</title>
</head>
<body>
	<div id="form">
		<form name="parking_add" action="../parking-add.action" method="post">
			name:<input type="text" name="park.name" value="yang">
			<br>
			address:<input type="text" name="park.address" value="beijing">
			<br>
			point.x:<input type="text" name="x" readonly="readonly" id="pointx">
			<br>
			point.y:<input type="text" name="y" readonly="readonly" id="pointy">
			<br>
			phoneNumber:<input type="text" name="park.phoneNumber" value="223123123">
			<br>
			description:<input type="text" name="park.description" value="bit">
			<br>
			spaceNumber:<input type="text" name="park.parkSpaceNumber" value="2">
			<br>
			restNumber:<input type="text" name="park.restNumber" value="1">
			<br>
			price:<input type="text" name="park.price" value="5">
			<br>
			isPass:<input type="text" name="park.isPass" value="yes">
			<br>
			<input type="submit" value="注册">
		</form>
	</div>
	<div>
		<p>在下面的地图中选择你的停车场的位置：</p>
	</div>
	<div id="allmap">

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