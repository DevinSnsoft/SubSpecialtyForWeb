<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<link href="css/common.css" rel="stylesheet" />
<link href="css/mui.min.css" rel="stylesheet" />
<title>大类分流系统后台管理员页面</title>
</head>
<body style="text-align: center;">
<header class="mui-bar mui-bar-nav">
		<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
		<h1 class="mui-title">大类分流后台管理系统</h1>
</header>  
	<form action="${pageContext.request.contextPath }/UpfileServlet" method="post" enctype="multipart/form-data" style="margin-top:80px;">
	<table width="100%" frame="border">
		<!-- <tr>上传文件</tr> -->
		<tr>
			<td>
				<input type="file" name="file">
			</td>
		</tr>
		<tr>
			<td style="center;">
				<input type="submit" value="上传&nbsp;">
			</td>
		</tr>
	</table>
	</form>
	<div style="font-size:30px;margin-top:20px">
	<button type="button" class="mui-btu downloa"><a href="${pageContext.request.contextPath }/AdminLoad">导出所有学生报名信息</a></button>
	<button type="button" class="mui-btu downloa"><a href="${pageContext.request.contextPath }/CheckUpfile">查看上传</a></button>
	</div>
</body>
</html>