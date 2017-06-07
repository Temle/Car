<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String parkid=(String)request.getAttribute("parkid");
%>

<form action="/Car/parking-order.action?id=<%=parkid %>" method="post" id="hiddenform">
</form>
<script type="text/javascript">
document.getElementById("hiddenform").submit();
</script>
</body>
</html>