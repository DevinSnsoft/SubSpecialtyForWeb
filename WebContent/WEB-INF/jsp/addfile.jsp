<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>上传文件</title>
</head>
<body style="text-align:center;"> 
	<form action="${pageContext.request.contextPath }/UpfileServlet" method="post" enctype="multipart/form-data">
	<table width="50%" frame="border">
		<tr>
			<td>上传文件</td>
			<td>
				<input type="file" name="file">
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="submit" value="上传">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>