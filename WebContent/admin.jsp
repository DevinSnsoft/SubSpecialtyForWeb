<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>后台管理界面</title>
</head>
<body style="text-align: center;background-image:url(images/2.jpg); background-repeat:no-repeat;background-size:100%">
	<br/><br/><br/><br/><br/><br/><br/><br/><br/>
	<form action="${pageContext.request.contextPath }/AdminLogin" method="post">
		<div class="input">
			用    户:<input class="inputtext" id="account" type="text" name="account"/>
		</div>
		<div class="input">
			密    码:<input class="inputtext" id="password" type="password" name="passwordAdmin"/>
		</div>
		<div id="btn">
			<input class="btn" id="submit" type="submit" value="登录">
			<input class="btn" id="reset" type="reset" value="重置">
		</div>
	</form>

<!-- 	<a href="${pageContext.request.contextPath }/AdminLoad">下载</a> -->
</body>
</html>