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
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=6rzptMIb8jDgfZCFy1giVAamRBOhYsdG"></script>
	<script type="text/javascript" src="BMapTool/RichMarker_min.js"></script>
	
	<title>汽车综合服务平台--停车场</title>
</head>
	
<body>
<div> 
	<jsp:forward page="/Car/parking/parking-marker.action"></jsp:forward>
	<button onclick="showMarker()">显示坐标</button>
</div>
<div id="allmap"></div>

<script type="text/javascript">
	// 百度地图API功能
	var map = new BMap.Map("allmap");          // 创建地图实例
	var point = new BMap.Point(116.403694,39.927552);  // 创建点坐标
	map.centerAndZoom(point, 15);                 // 初始化地图，设置中心点坐标和地图级别
	map.enableScrollWheelZoom();
	map.addControl(new BMap.NavigationControl());  //添加默认缩放平移控件
	var customLayer;
	function addCustomLayer(keyword) {
		if (customLayer) {
			map.removeTileLayer(customLayer);
		}
		customLayer=new BMap.CustomLayer({
			geotableId: 168295,
			q: '', //检索关键字
			tags: '', //空格分隔的多字符串
			filter: '' //过滤条件,参考http://developer.baidu.com/map/lbs-geosearch.htm#.search.nearby
		});
		map.addTileLayer(customLayer);
		customLayer.addEventListener('hotspotclick',callback);
	}
	function callback(e)//单击热点图层
	{
			var customPoi = e.customPoi;//poi的默认字段
			var contentPoi=e.content;//poi的自定义字段
			var content = '<p style="width:280px;margin:0;line-height:20px;">地址：' + customPoi.address + '<br/>价格:'+contentPoi.dayprice+'元'+'</p>';
			var searchInfoWindow = new BMapLib.SearchInfoWindow(map, content, {
				title: customPoi.title, //标题
				width: 290, //宽度
				height: 40, //高度
				panel : "panel", //检索结果面板
				enableAutoPan : true, //自动平移
				enableSendToPhone: true, //是否显示发送到手机按钮
				searchTypes :[
					BMAPLIB_TAB_SEARCH,   //周边检索
					BMAPLIB_TAB_TO_HERE,  //到这里去
					BMAPLIB_TAB_FROM_HERE //从这里出发
				]
			});
			var point = new BMap.Point(customPoi.point.lng, customPoi.point.lat);
			searchInfoWindow.open(point);
	}
	document.getElementById("open").onclick = function(){
		addCustomLayer();
	};
	document.getElementById("open").click();
	document.getElementById("close").onclick = function(){
		if (customLayer) {
			map.removeTileLayer(customLayer);
		}
	};
	// 创建CityList对象，并放在citylist_container节点内
	var myCl = new BMapLib.CityList({container : "citylist_container", map : map});

	// 给城市点击时，添加相关操作
	myCl.addEventListener("cityclick", function(e) {
		// 修改当前城市显示
		document.getElementById("curCity").innerHTML = e.name;

		// 点击后隐藏城市列表
		document.getElementById("cityList").style.display = "none";
	});
	// 给“更换城市”链接添加点击操作
	document.getElementById("curCityText").onclick = function() {
		var cl = document.getElementById("cityList");
		if (cl.style.display == "none") {
			cl.style.display = "";
		} else {
			cl.style.display = "none";
		}	
	};
	// 给城市列表上的关闭按钮添加点击操作
	document.getElementById("popup_close").onclick = function() {
		var cl = document.getElementById("cityList");
		if (cl.style.display == "none") {
			cl.style.display = "";
		} else {
			cl.style.display = "none";
		}	
	};
</script>

</body>
</html>