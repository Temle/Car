<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%int type=(int)request.getAttribute("type"); %>
	<%
	if(type==1)
	{
	%>
	<jsp:forward page="/BMap/parking-back.jsp"></jsp:forward>
	<%
	}
	else if(type==2)
	{
	%>
	<form action="/Car/show-store-info.action" method="post" id="hiddenform">
    </form>
    <script type="text/javascript">
    document.getElementById("hiddenform").submit();
    </script>
	<%
	}
	else if(type==3)
	{
	%>
	<form action="/Car/school-background-oder.action" method="post" id="hiddenform">
    </form>
    <script type="text/javascript">
    document.getElementById("hiddenform").submit();
    </script>
	<%
	}
	else if(type==4)
	{
	%>
	<form action="/Car/companion-background-order.action" method="post" id="hiddenform">
    </form>
    <script type="text/javascript">
    document.getElementById("hiddenform").submit();
    </script>
	<%
	}
	%>
</body>
</html>