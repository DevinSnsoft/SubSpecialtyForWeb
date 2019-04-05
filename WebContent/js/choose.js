//从移动神农获取账户密码
//function androidSetValuesJson(param) {
//	param = JSON.parse(param);
//	sessionStorage.setItem('studentId', param.account);
//	sessionStorage.setItem('password', param.password);
//}
var li = document.getElementsByTagName('li');
var sele = document.getElementsByTagName("select");
var btu1=document.getElementById("btu1");
var btu2=document.getElementById("btu2");
var info;
var data = {};
var studentId;
var className;
var special;
// 个人信息回写
function getInfo(info) {
	// androidSetValuesJson(param);
	data['studentId'] = sessionStorage.getItem('studentId');
	studentId = sessionStorage.getItem('studentId');
	data['password'] = sessionStorage.getItem('password');
	// ${pageContext.request.contextPath }/StudentInfo
	data = JSON.stringify(data);
	mui.ajax("StudentInfo", {
		dataa : data,
		async:false,
		dataType : 'json',
		type : 'post',
		timeout : '10000',
		success : function(dataa) {
			if (dataa.code == '0') {
				info = dataa.data;
				li[0].innerText = '学号：' + info.studentId;
				li[1].innerText = '姓名：' + info.studentName;
				li[2].innerText = '性别：' + info.sex;
				li[3].innerText = '入学日期:' + info.entryDate;
				li[4].innerText = '学院：' + info.faculty;
				li[5].innerText = '专业：' + info.className;
				li[6].innerText = '班级：' + info.classes;
				li[7].innerText = '学分绩点：' + info.credit;
				className = info.className;
				//console.log(className);
			} else {
				mui.alert(dataa.msg);
			}

		},
		error : function(xhr, type, errorThrow) {
			mui.alert(errorThrow, "错误", "OK", null);
		}
	});
}
getInfo(info);

// 预报名（查询）
//data['studentId'] = sessionStorage.getItem('studentId');
//data = JSON.stringify(data);

function getBmInfo() {
	data={};
	data['studentId'] = sessionStorage.getItem('studentId');
	var input = document.getElementsByTagName('input');
	var textarea = document.getElementsByTagName('textarea');
	getSpecialtName(); 
	data = JSON.stringify(data);
	mui.ajax("ApplyInfo", {
		data : data,
		dataType : 'json',
		type : 'post',
		timeout : '10000',
		success : function(data) {
			if (data.code == '0') {
				//console.log(data.data.telephone);
				if (data.data.telephone) {
					second();
					btu1.style.display="none";
					btu2.style.display="block";
					input[0].value = data.data.telephone;
					sele[0].value = data.data.firstvoluntary;
					sele[1].value = data.data.secondvoluntary;
					sele[2].value = data.data.thirdvoluntary;
					textarea[0].value = data.data.performance;
					textarea[1].value = data.data.academic;
					suoding();	
				  }
			}
			else{first();}
			},
		error : function(xhr, type, errorThrow) {
			mui.alert(errorThrow, "错误", "OK", null);
		}
	});
}
getBmInfo();

// 提交
$('#submit').click(function() {
	var a=$("select:eq(0)").val();
	console.log(a);
	if(a == "请选择" || a==""){
		mui.alert("第一志愿不能为空!");
		return;
	}
	check1();
	if (statu1 == true) {
		var d = {};
		$('#form').find('input,select,textarea').each(function() {
			d[this.name] = this.value;
		});
		d['studentId']=studentId;
		d = JSON.stringify(d);
		mui.ajax("AddApply", {
			data : d,
			dataType : 'json',
			type : 'post',
			timeout : '10000',
			success : function(data) {
				if (data.code == '0') {
					mui.alert('提交成功', '', '确定', function(e) {
						suoding();
						location.reload();
					});
				} else {
					mui.alert(data.msg, '', '确定', function(e) {
					});
				}
			},
			error : function(xhr, type, errorThrow) {
				mui.alert(errorThrow, "错误", "OK", null);
			}
		});
	}
});
// 修改
$('#xiugai').click(function() {
	mui.alert("请修改");
	bianji();
	//getSpecialtName();
	//second();
	
});
//保存
$('#baocun').click(function() {
	if(sele[0].disabled){
		mui.alert("请先修改再保存");
		return;}
	check1();
	check2();
	if(statu1==true){
	if(statu2==true)
	{
		var d = {};
		$('#form').find('input,select,textarea').each(function() {
			d[this.name] = this.value;
		});
		d['studentId']=studentId;
		d = JSON.stringify(d);
		mui.ajax("UpdateApply", {
			data : d,
			dataType : 'json',
			type : 'post',
			timeout : '10000',
			success : function(data) {
				if (data.code == '0') {
					mui.alert('保存成功', '', '确定', function(e) {
						suoding();
						location.reload();
					});
				} else {
					mui.alert(data.msg, '', '确定', function(e) {
					});
				}
			},
			error : function(xhr, type, errorThrow) {
				mui.alert(errorThrow, "错误", "OK", null);
			}
		});
	} 
	}
});
// 可编辑
function bianji() {
	$('#form').find('input,select,textarea').each(function() {
		$(this).attr('disabled', false);
	});
}
// 不可编辑
function suoding() {
	$('#form').find('input,select,textarea').each(function() {
		$(this).attr('disabled', 'disabled');
	});
}
// 获取大类专业下面的所有专业
function getSpecialtName() {
	var temp = {'className':className};
	temp = JSON.stringify(temp);
	mui.ajax("GetAllSpecialty", {
		data : temp,
		dataType : 'json',
		async : false,
		type : 'post',
		timeout : '10000',
		success : function(data) {
			if (data.code == '0') {
				var str = '<option value="请选择">请选择</option>';
				special=data.data;
				for (var i = 0; i < data.data.length; i++) {
					str += '<option value="' + data.data[i].subSpecialtyName
							+ '">' + data.data[i].subSpecialtyName
							+ '</option>';
				}
				$("select:eq(0)").html(str);
			}else{
				mui.alert(data.msg, '', '确定', function(e) {});
			}
		},
		error : function(xhr, type, errorThrow) {
			mui.alert(errorThrow, "错误", "OK", null);
		}
	});
}
var statu1 = false;
var statu2 = false;
// 对输入数据的检验
function check1() {
	var tel = document.getElementsByName("telephone")[0];
	var text = document.getElementsByTagName('textarea')[0];
		if (tel.value.match(/^\d{11}$/)) {
			if(text.value!="")
			{
				statu1 = true;
			}
			else{mui.alert('表现不能为空');}
		}else{mui.alert('请检查您的手机号');}
}
function check2(){
	var a=$("select:eq(0)").val();
	var b=$("select:eq(1)").val();
	var c=$("select:eq(2)").val();
	console.log(a,b,c);	
	//判空
		if(a == "请选择"){
			mui.alert("第一志愿不能为空");
			return;
		} else if((b =="请选择") && (c != "请选择")) {
			mui.alert("第二志愿不能为空");
			return;
		}else if(b==null && c!=null){
			mui.alert("第二志愿不能为空");
			return;
		}
		//判重复
		if((a == b && a != "请选择") || (a == c && a != "请选择") || (b == c  && (b != null && b !="请选择"))) {
			
			mui.alert("所选志愿不能重复");
			return;
		}
		else{
			statu2=true;
		}
	}

	
function second(){
	var str = '<option value="请选择">请选择</option>';
	for (var i = 0; i < special.length; i++) {
		str += '<option value="' + special[i].subSpecialtyName
				+ '">' + special[i].subSpecialtyName
				+ '</option>';
	}
	$("select:eq(1)").html(str);
	$("select:eq(2)").html(str);
}
function first(){
$("select:eq(0)").unbind();
$("select:eq(0)").bind("change",function(){
	var str = '<option value="请选择">请选择</option>';
	for(var i = 0; i < special.length; i ++){
		if(special[i].subSpecialtyName != this.value){
			str += '<option value="' + special[i].subSpecialtyName
			+ '">' + special[i].subSpecialtyName
			+ '</option>';
		}	
	}
	$("select:eq(1)").html(str);
	});
$("select:eq(1)").unbind();
$("select:eq(1)").bind("change",function(){
	var str = '<option value="请选择">请选择</option>';
	console.log($("select:eq(0)").value);
	for(var i = 0; i < special.length; i ++){
		if(special[i].subSpecialtyName != this.value&&special[i].subSpecialtyName!=$("select:eq(0)").val()){
			str += '<option value="' + special[i].subSpecialtyName
			+ '">' + special[i].subSpecialtyName
			+ '</option>';
		}	
	}
	$("select:eq(2)").html(str);
	});
}
//查看
//$('#chakan').click(function() {
//	window.location.href="sort.jsp";
//})
