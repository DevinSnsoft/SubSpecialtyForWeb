function tiaozhuan(){
	var k1=document.getElementsByName("k1")[0];
	var k2=document.getElementsByName("k1")[1];
	if(k1.checked){
		window.location.href="login.jsp";
	}else if(k2.checked){
		window.location.href="admin.jsp";
	}
}
