function loadUserBooks(){
	//获取userId
	var userId = getCookie("userId")
	//alert(userId);
	//判断是否获取到有效userId
	if(cookie != ""){
		$.ajax({
			//发送ajax请求
			url:path+"/book/loadBooks.do",
			type:"post",
			data:{"userId":userId},
			dataType:"json",
			success:function(result){
				if(result.status==0){
					//获取笔记本集合
					var books = result.data;
					for(var i=0;i<books.length;i++){
						//获取笔记本Id
						var bookId=books[i].cn_notebook_id;
						//获取笔记本名字
						var bookName = books[i].cn_notebook_name;
						//创建一个笔记本列表的li元素
						createBookLi(bookId,bookName);
					}
				}
			},
			error:function(){
				alert("获取失败，请稍等重试！");
			}
		});
	}else{
		window.location.href("log_in.html");
	}
}

function createBookLi( bookId,bookName ){
	var sli='<li class="online"> <a> <i class="fa fa-book" title="online" rel="tooltip-bottom"></i>'+bookName+'</a></li> ';
	//alert(sli);
	//将sli字符串转换成jq对象li元素
	//　其中$(text)就text字符串转为了一个Jquery对象
	var $li=$(sli);
	//将bookId值与jq对象绑定
	//向元素附加数据
	//向被选元素附加数据。
	//$(selector).data(name,value)
	$li.data("bookId",bookId);
	//将li元素添加到笔记本ul列表区
	$("#book_ul").append($li);
}	





function addBook(){
	var noteName = $("#input_notebook").val().trim();
	var userId = getCookie("userId");
	var ok = true;
	if(noteName == ""){
		alert("不能为空");
		ok=false;
	}
	if(userId == ""){
		alert("请登录");
		ok=false;
	}
	if(ok){
		$.ajax({
			url:path+"/book/addBook.do",
			type:"post",
			data:{
				"noteName":noteName,
				"userId":userId
			},
			dataType:"json",
			success:function(result){
				if(result.status == 0){
					alert(result.msg);
					var book = result.data;
					//获取笔记本Id
					var bookId=book.cn_notebook_id;
					//获取笔记本名字
					var bookName = book.cn_notebook_name;
					//创建一个笔记本列表的li元素
					var sli='<li class="online"> <a> <i class="fa fa-book" title="online" rel="tooltip-bottom"></i>'+bookName+'</a></li> ';
					var $li=$(sli);
					$li.data("bookId",bookId);
					$("#book_ul").append($li);
				}
			},
			error:function(){
				alert("添加失败,请稍后重试")
			}
		})
	}
}
