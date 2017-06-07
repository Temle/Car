<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/head.jsp" %>
<title>发帖</title>
<script language="javascript">
	function checkNull() {
		/*判断是否有空内容*/
			if (form1.elements[3].value == "") {
				alert(form1.elements[3].title + "不能为空!");
				form1.elements[3].focus();
				return false;
			}
		}
	}
</script>
</head>
<body>
<div class="container">
	<%@ include file="forumHead.jsp" %>
	
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form name="form1" action="/Car/forum-post.action" method="post" onSubmit="return checkNull()">
				<div class="form-group">
					<label for="exampleInputText1">标题</label><input name="post.title" type="text" class="form-control" id="exampleInputText1" />
				</div>
				<div class="form-group">
					<label for="exampleInputText2">板块</label>
					<select class="form-control" id="exampleInputText2" name="post.type">
						<option>板块一</option>
						<option>板块二</option>
						<option>板块三</option>
					</select>
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">内容</label><textarea name="post.content" class="form-control" rows="15" id="exampleInputPassword1" ></textarea>
				</div>
				<button type="submit" class="btn btn-default">发帖</button>
				<button type="reset" class ="btn btn-default">清空</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>