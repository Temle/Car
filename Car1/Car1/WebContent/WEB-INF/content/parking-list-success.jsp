<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.car.domain.*" %>
<%@ page import="com.car.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/head.jsp" %>
<title>页面标题</title>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=6rzptMIb8jDgfZCFy1giVAamRBOhYsdG"></script>
<!-- 加载百度地图样式信息窗口 -->
<script type="text/javascript" src="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.js"></script>
<link rel="stylesheet" href="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.css" />
<style type="text/css">
	table{
    table-layout:fixed;
}
td{  
    overflow:hidden;
    text-overflow:ellipsis;
    white-space:nowrap;
}
</style>
</head>

<body>
<div class="container">
<%@include file="/navigation.jsp" %>
<div class="row">
	<div class="col-md-4">
		<div class="table-responsive">
		  <table class="table table-hover table-striped table-condensed">
		    <caption>停车场列表</caption>
		    <thead>
		      <tr>
		        <th>名称</th>
		        <th>地址</th>
		        <th>操作</th></tr>
		    </thead>
		    <tbody>
		    <%
				PageBean pageBean = (PageBean) request.getAttribute("pageBean"); 
				List<Park> list=pageBean.getData();
				for(Park park:list)
				{
		    %>
		      <tr>
		        <td><%=park.getName() %></td>
		        <td><%=park.getPrice() %></td>
		        <td><a href="/Car/parking-order.action?id=<%=park.getId() %>" class="btn btn-primary btn-sm" role="button">查看</a></td></tr>
			<%
		    	}
			%>
		    </tbody>
		  </table>
		</div>
		<div id="pageButton" style="text-align:center;">
						<form name="PageForm" action="/Car/parking-list.action" method="post">					
							<script>
							function gotoPage(pagenum){
							  document.PageForm.pageNo.value = pagenum;
							  document.PageForm.submit();
							  return ;
							}
							</script>
							<span class="label label-default">每页<%=pageBean.rowsPerPage%>行
							共<%=pageBean.maxRowCount%>行
							第<%=pageBean.curPage%>页
							共<%=pageBean.maxPage%>页</span>
							
							<br/>
							<% 
							   if(pageBean.curPage==1){ 
								   %>
									<a href="#" class="btn btn-default" role="button">首页</a>
									<a href="#" class="btn btn-default" role="button">上一页</a>   
								   <% 
							   }else{  
							 %>   
							<a href="javascript:gotoPage(1)" class="btn btn-default" role="button">首页</a>
							<a href="javascript:gotoPage(<%=pageBean.curPage-1%>)" class="btn btn-default" role="button">上一页</a>
							<%
								}
							%>
							<%
							   if(pageBean.curPage==pageBean.maxPage){ 
								   %>
									<a href="#" class="btn btn-default" role="button">下一页</A>
									<a href="#" class="btn btn-default" role="button">尾页</A>   
								   <% 
							   }else{  
							%>  
							  
							<a href="javascript:gotoPage(<%=pageBean.curPage+1%>)" class="btn btn-default" role="button">下一页</A>
							<a href="javascript:gotoPage(<%=pageBean.maxPage%>)" class="btn btn-default" role="button">尾页</A>
							<%
								}
							%>
							</br>
							<div style="display:none;">
								第<input type="text" name="pageNo" style="width:50px;"/>页
								<input type="submit" value="提交">
							</div>
							
		 
						</form>
					</div>
	</div>
	<div id="right" claass="col-md-8" style="height:500px;">
			<div id="l-map" style="height:500px;"></div>
	<div id="result" style="display:none;">
		<button id="open" >打开</button><button id="close">关闭</button>
	</div>
	<!--城市列表-->
	<div class="sel_container" style="display:none;"><strong id="curCity">北京市</strong> [<a id="curCityText" href="javascript:void(0)">更换城市</a>]</div>
	<div class="map_popup" id="cityList" style="display:none;">
		<div class="popup_main">
			<div class="title">城市列表</div>
			<div class="cityList" id="citylist_container"></div>
			<button id="popup_close"></button>
		</div>
	</div>
	
	</div>
</div>

<div class="row">
	<div class="col-md-12" style="height:100px;"></div>
</div>

</div>
</body>
</html>
<script type="text/javascript">
	// 百度地图API功能
	var map = new BMap.Map("l-map");          // 创建地图实例
	var point = new BMap.Point(116.403694,39.927552);  // 创建点坐标
	map.centerAndZoom(point, 15);                 // 初始化地图，设置中心点坐标和地图级别
  
  		function myFun(result){
			var cityName = result.name;
			//map.setCenter(cityName);
			map.centerAndZoom(cityName,13);
		}
		var myCity = new BMap.LocalCity();
		myCity.get(myFun); 
	map.enableScrollWheelZoom();
	//map.addControl(new BMap.NavigationControl());  //添加默认缩放平移控件
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
	function callback(e)//单击热点图层
	{
			var customPoi = e.customPoi;//poi的默认字段
			var contentPoi=e.content;//poi的自定义字段
			var content = '<p style="width:280px;margin:0;line-height:20px;">地址：' + customPoi.address + '<br/>价格:'+contentPoi.price+'元'+'</p>';
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