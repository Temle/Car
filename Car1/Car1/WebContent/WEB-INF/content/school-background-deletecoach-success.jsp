<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
 <body>
 <%
int id=(int)request.getAttribute("StoreId");
%>

<form action="/Car/school-background-coach.action?StoreId=<%=id%>" method="post" id="hiddenform">

</form>
<script type="text/javascript">
document.getElementById("hiddenform").submit();
</script> 
 </body>

 </html>