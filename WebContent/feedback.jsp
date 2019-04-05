<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>大类分流后台信息反馈页面</title>
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<link href="css/mui.min.css" rel="stylesheet" />
<link href="css/common.css" rel="stylesheet" />
<script src="js/jquery-1.7.2.js"></script>
</head>
<body>
<form height="80%" width="100%" id="form" action="${pageContext.request.contextPath }/AddFeedback" method="post">
<font style="display:block;margin-top: 10px;">反馈信息(温馨提示：不要超过100字!):</font>
<table height="80%" width="100%">
	<tr>
		<textarea id="feedback" rows="10" cols="40" name="feedback"></textarea>
	</tr>	 	
</table>		
 <!-- 
	<font style="display: block; margin-top: 10px;">&nbsp;&nbsp;&nbsp;反馈信息(温馨提示：不要超过100字!):</font>
	<div class="mui-input-row" style="margin-top: 7px;">
		<textarea class="textarea" rows="10" name="feedback"></textarea>
	</div>
	<div>
		<center>
			<button>
				<a href="${pageContext.request.contextPath }/AddFeedback">反馈</a>
			</button>
		</center>
	</div> -->
 <!-- 
 <form id="form" action="${pageContext.request.contextPath }/AddFeedback" method="get">
 	<td>
		<textarea rows="5" cols="60" name="feedback"></textarea>
	</td> -->
	<div>
		<center>
			<button>
				<a href="${pageContext.request.contextPath }/AddFeedback">反馈</a>
			</button>
		</center>
	</div>
 </form>

  <!-- 
  <script type="text/javascript">
  		var doc = document.getElementsByName("feedback").val();
  		console.log(doc);
  </script> -->
</body>
</html>