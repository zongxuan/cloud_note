function userRegist(){
			//alert("=+=");
			//获取参数
			var name= $("#regist_username").val().trim();
			var nick=$("#nickname").val().trim();
			var password=$("#regist_password").val().trim();
			var final_password=$("#final_password").val().trim();
			//alert(name+":"+nickname+":"+password+":"+final_password);
			//检查数据格式
			var ok = true;
			//检查用户名
			if(name == ""){
				ok=false;
				$("#warning_1 span").html("用户名不能为空");
				$("#warning_1").show();
			}
			//检查密码1非空，2不能小于8位
			if(password == ""){
				ok=false;
				$("#warning_2 span").html("密码不能为空");
				$("#warning_2").show();
			}else if(password.length<8){
				ok=false;
				$("#warning_2").show();
			}
			//检查确认密码 1非空，2是否与密码一致
			if(final_password == ""){
				ok=false;
				$("#warning_3 span").html("密码不能为空");
				$("#warning_3").show();
			}
			if(password != final_password){
				ok=false;
				$("#warning_3").show();
			}
			if(ok){//前端数据校验通过向do
				$.ajax({
					url:path+"/user/add.do",
					type:"post",
					data:{
						"name":name,
						"nick":nick,
						"password":password,
					},
					dataType:"json",
					success:function(result){
						//注册成功
						if(result.status == 0){
							alert(result.msg);
							//返回到登录页面
							$("#back").click();
						}else{
							//用户名被占用
							$("#warning_1 span").html(result.msg);
							$("#warning_1").show();
						}
						
					},
					error:function(){
						alert("注册失败");
					}
				});
				
			}
		}