<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<title>停车场麻点图</title>

<style type="text/css">  
	html{height:100%}  
	body{height:100%;margin:0px;padding:0px}  
	#container{height:100%}  
</style>

<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=6rzptMIb8jDgfZCFy1giVAamRBOhYsdG"></script>
<!-- 加载百度地图样式信息窗口 -->
<script type="text/javascript" src="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.js"></script>
<link rel="stylesheet" href="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.css" />
</head>
<body>
<div id="container"></div> 
<div>
	<h1>asd</h1>
	<h1>asd</h1>
	<h1>asd</h1>
	<h1>asd</h1>
	<h1>asd</h1>
	<h1>asd</h1>
</div>
</body>
</html>
<script type="text/javascript"> 

//创建地图实例 
var map = new BMap.Map("container");          
function myFun(result){
	var cityName = result.name;
	//map.setCenter(cityName);
	map.centerAndZoom(cityName,13);
}
var myCity = new BMap.LocalCity();
myCity.get(myFun); 

//绘制麻点
var customLayer;
function addCustomLayer(keyword) {
	if (customLayer) {
	map.removeTileLayer(customLayer);
	}
	customLayer=new BMap.CustomLayer({
		geotableId: 168306,
		q: '', //检索关键字
		tags: '', //空格分隔的多字符串
		filter: '' //过滤条件,参考http://developer.baidu.com/map/lbs-geosearch.htm#.search.nearby
	});
	map.addTileLayer(customLayer);
	customLayer.addEventListener('hotspotclick',callback);
}
addCystinKayer();
</script> 