<%@page import="cn.snsoft.servlet.GetAllSpecialty"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
		<title>大类分流预报名</title>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link href="css/mui.min.css" rel="stylesheet" />
		<link href="css/common.css" rel="stylesheet" />
		<script src="js/jquery-1.7.2.js"></script>	
</head>
<body>
	<div class="mui-card">
			<ul class="mui-table-view">
				<li class="mui-table-view-cell">学号：</li>
				<li class="mui-table-view-cell">用户名：</li>
				<li class="mui-table-view-cell">性别：</li>
				<li class="mui-table-view-cell">入学日期：</li>
				<li class="mui-table-view-cell">学院：</li>
				<li class="mui-table-view-cell">专业：</li>
				<li class="mui-table-view-cell">班级：</li>
				<li class="mui-table-view-cell">绩点：</li>
			</ul>
		</div>
				<hr style="height:5px;"/>
				<div id="form">
		           <form  class="mui-input-group" >
					<div class="mui-input-row" >
				      <label>第一志愿</label>
				         <select  class="first"  name="firstvoluntary" id="id1">
				         	<option value="">请选择</option>
				         </select>
				    </div>
				    <div class="mui-input-row" >
				    <label>第二志愿</label>
				         <select  class="se"  name="secondvoluntary" id="id2">
					        <option value="">请选择</option>
				         </select>
				</div>
				    <div class="mui-input-row" >
				    <label>第三志愿</label>
				         <select  class="th" name="thirdvoluntary" id="id3">
					        <option value="">请选择</option>
					
				         </select>
				</div>
					<div class="mui-input-row">
						<label>联系电话</label>
						<input type="text" placeholder="电话" name="telephone">
					</div>
		          </form>
		            <font style="display:block;margin-top: 10px;">&nbsp;&nbsp;&nbsp;个人表现[兴趣爱好等]</font>
		            <div class="mui-input-row" style="margin-top: 7px;" >
				  <textarea class="textarea" rows="3" name="performance"></textarea>
				    </div>
=		            <font style="display:block;margin-top: 5px;">&nbsp;&nbsp;&nbsp;学术特长[如:发表论文、竞赛获奖等]</font>
		            <div class="mui-input-row" style="margin-top: 7px;" >
				  <textarea class="textarea" rows="3" name="academic"></textarea>
				    </div>
				    </div>
			<div class="mui-content-padded" id="btu1"> 
				<center><button type="button" class="mui-btn btu" id="submit">
					提交
				</button></center>
				</div>
			  <div class="mui-content-padded" id="btu2"> 
				<button type="button" class="mui-btn btu" id="xiugai">修改</button>
				<button type="button" class="mui-btn btu" id="baocun">保存</button>
				<button type="button" class="mui-btn btu" id="chakan"><a href="${pageContext.request.contextPath }/Sort">查看排名</a></button> 
			  </div>
<!-- <button type="button" class="mui-btn  xia"><a href="${pageContext.request.contextPath }/Load">下载报名信息</a></button> -->
		<center>
		<button type="button" class="mui-btn  xia"> <a href="${pageContext.request.contextPath }/feedBack ">在线反馈</a></button>
		
		</center>
		<script src="js/mui.min.js"></script>
		<script type="text/javascript">
			mui.init()
		</script>
		<script src="js/choose.js"></script>	
</body>
</html>