<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>后台附件管理页面</title>
</head>
<body style="text-align:center;">
	<br/>
	<table width="90%" frame="border">
		<tr>
			<td>文件名称</td>
			<td>上传时间</td>
			<td>操作</td>
		</tr>
		<c:forEach var="upfile" items="${list }">
			<tr>
				<td>${upfile.filename}</td>
				<td>${upfile.uptime }</td>
				<td>
					<a href="${pageContext.request.contextPath }/DownLoadServlet?id=${upfile.id}">下载</a>
					<a href="${pageContext.request.contextPath }/DeleteUpfile?id=${upfile.id}">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>