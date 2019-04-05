<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="js/jquery-1.7.2.js"></script>	
<script type="text/javascript" src="js/login.js"></script>
<title>登录界面</title>
<link href="css/login.css" rel="stylesheet" />
</head>
<body >
	<div id="container">
		<div id="image">
			<div id="form">
				<form action="${pageContext.request.contextPath }/Login" method="post">
					<div class="input">
						用    户:<input class="inputtext" id="account" type="text" name="account"/>
					</div>
					<div class="input">
						密    码:<input class="inputtext" id="password" type="password" name="password"/>
					</div>
					<div id="btn">
						<input class="btn" id="submit" type="submit" value="登录">
						<input class="btn" id="reset" type="reset" value="重置">
					</div>
				</form>
				<br/><br/><br/><br/><br/><br/><br/><br/>
				@神农大学生软件创新中心                                              版权所有<br/>
			</div>
		</div>
	</div>
</body>
</html>