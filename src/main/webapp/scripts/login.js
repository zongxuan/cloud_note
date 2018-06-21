function userLogin() {
	$("#count_span").html("");
	$("#password_span").html("");
	var name = $("#count").val().trim();
	var password = $("#password").val().trim();
	var auto = "";
	alert(auto);
	var ok = true;
	if (name == "") {
		$("#count_span").html("用户名不能为空");
		ok = false;
	}
	if (password == "") {
		$("#password_span").html("密码不能为空");
		ok = false;
	}
	if($("#auto").is(':checked')){
		auto = $("#auto").val();
	}
	if (ok) {//检测格式通过
		//发送请求
		$.ajax({
			url : path + "/user/login.do",
			type : "post",
			data : {
				"name" : name,
				"password" : password,
				"autoLogin":auto
			},
			dataType : "json",
			success : function(result) {
				//result 是服务器返回的JSON结果
				if (result.status == 0) {
					//登录成功，将用户信息保存到cookie
					var userId = result.data.cn_user_id;
					addCookie("userId", userId, 2);
					window.location.href = "edit.html";
				} else if (result.status == 1) {
					$("#count_span").html(result.msg);
				} else if (result.status == 2) {
					$("#password_span").html(result.msg);
				}
			},
			error : function() {
				alert("登录失败！！！")
			}
		});
	}
}