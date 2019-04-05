$(function(){
	$("#submit").unbind("click").click(function(){
		var account = $("#account").val();
		var password = $("#password").val();
		sessionStorage.setItem('studentId', account);
		sessionStorage.setItem('password', password);
	});
});