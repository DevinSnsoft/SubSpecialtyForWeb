<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>附件下载</title>
</head>
<body>
	<br/>
	<table width="100%" frame="border">
		<tr>
			<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp文件名称</td>
			<td></td>
			<td>操作</td>
		</tr>
		<c:forEach var="upfile" items="${list }">
			<tr>
				<td>${upfile.filename}</td>
				<td></td>
				<td>
					<a href="${pageContext.request.contextPath }/DownLoadServlet?id=${upfile.id}">下载</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>