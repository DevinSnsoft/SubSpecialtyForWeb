<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查看排名</title>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<link href="css/mui.min.css" rel="stylesheet" />
<script src="js/jquery-1.7.2.js"></script>
</head>
<body>
	<div class="mui-card">
		<ul class="mui-table-view">
			<li class="mui-table-view-cell"><font size="4"><b>本大类共<%=request.getAttribute("sum") %>人,已有<%=request.getAttribute("Enrollsum") %>人完成填报</b></font></li>
			<li class="mui-table-view-cell"><font size="3"><b>第一志愿:【<%=request.getAttribute("firstvoluntary") %>】</b></font></li>
			<li class="mui-table-view-cell">一、二、三志愿报此专业共<%=request.getAttribute("listSize")%>人，你的排名:<%=request.getAttribute("sort1")%></li>
			<li class="mui-table-view-cell"><font size="3"><b>第二志愿:【<%=request.getAttribute("secondvoluntary")%>】</b></font></li>
			<li class="mui-table-view-cell">一、二、三志愿报此专业共<%=request.getAttribute("listSize2")%>人，你的排名:<%=request.getAttribute("sort2")%></li>
			<li class="mui-table-view-cell"><font size="3"><b>第三志愿:【<%=request.getAttribute("thirdvoluntary") %>】</b></font></li>
			<li class="mui-table-view-cell">一、二、三志愿报此专业共<%=request.getAttribute("listSize3")%>人，你的排名:<%=request.getAttribute("sort3")%></li>
			<li class="mui-table-view-cell">注:按照学分绩点排名</li>
		</ul>
	</div>
	
	
</body>
</html>