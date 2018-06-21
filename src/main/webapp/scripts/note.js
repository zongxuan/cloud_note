
// 加载笔记列表
function loadUserNotes() {
	$("#book_ul").on("click", "li", function() {
		$("#note_ul").empty();
		var bookId = $(this).data("bookId");
		// 设置选中效果
		// 删除上次选中
		$("#book_ul a").removeClass("checked");
		// 设置这次选中
		$(this).find("a").addClass("checked");
		// 发送ajax请求
		$.ajax({
			url : path + "/note/loadnotes.do",
			type : "post",
			data : {
				"bookId" : bookId
			},
			dataType : "json",
			success : function(result) {
				if (result.status == 0) {
					var note = result.data;
					for (var i = 0; i < note.length; i++) {
						var noteId = note[i].cn_note_id;
						var noteTitle = note[i].cn_note_title;
						createNoteLi(noteId, noteTitle);
					}
				}
			},
			error : function() {
				alert("系统异常，请稍后重试");
			}
		});

	});
}

// 生成笔记
function createNoteLi(noteId, noteTitle) {
	var sli = "";
	sli += '<li class="online" ><a><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom" />';
	sli += noteTitle;
	sli += '<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down" /></button></a>';
	sli += '<div class="note_menu" tabindex="-1">';
	sli += '<dl><dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"/></button></dt>';
	sli += '<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap" /></button></dt>';
	sli += '<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times" /></button></dt></dl></div></li>';
	var $li = $(sli);
	$li.data('noteId', noteId);
	$("#note_ul").append($li);
}

// 显示笔记
function loadNote() {
	$("#note_ul").on("click", "li", function() {
		var noteId = $(this).data("noteId");
		$("#note_ul a").removeClass("checked");
		$(this).find("a").addClass("checked");
		$.ajax({
			url : path + "/note/loadnote.do",
			type : "post",
			data : {
				"noteId" : noteId
			},
			dataType : "json",
			success : function(result) {
				if (result.status == 0) {
					var note = result.data;
					$("#input_note_title").val(note.cn_note_title);
					um.setContent(note.cn_note_body);
				} else {
					alert(note.msg);
				}
			},
			error : function() {
				alert("加载失败稍后重试");
			}
		});
	});
}

function saveNote() {
	$("#save_note")
			.click(
					function() {
						var $li = $("#note_ul a.checked").parent();
						var noteId = $li.data("noteId");
						var title = $("#input_note_title").val().trim();
						var body = um.getContent();
						if (noteId != "" && title != "") {
							$
									.ajax({
										url : path + "/note/updateNote.do",
										type : "post",
										data : {
											"noteId" : noteId,
											"title" : title,
											"body" : body
										},
										dataType : "json",
										success : function(result) {
											if (result.status == 0) {
												alert(result.msg);
												var str = '<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom" />';
												str += title;
												str += '<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down" />';
												// 将str 替换到 选中的a标签里面
												$li.find("a").html(str);
											} else {
												alert(result.msg);
											}
										},
										error : function() {
											alert("保存失败，请稍后重试")
										}
									})
						} else {
							alert("不能为空")
						}

					})
}





function addNote(){
	var noteTitle = $("#input_note").val().trim();
	var userId = getCookie("userId");
	var bookId = $("#book_ul a.checked").parent().data("bookId");
	var ok = true;
	if(noteTitle == ""){
		ok = false;
		alert("title 不能为空")
	}
	if(ok){
		$.ajax({
			url:path+"/note/addNote.do",
			type:"post",
			data:{
				"noteTitle":noteTitle,
				"userId":userId,
				"bookId":bookId
			},
			dataType:"json",
			success:function(result){
				if(result.status==0){
					alert(result.msg);
					var note = result.data;
					var title = note.cn_note_title;
					var noteId = note.cn_note_id
					var str = '<li class="online"><a><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
					str += title;
					str += '<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button></a><div class="note_menu" tabindex="-1"><dl>';
					str += '<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';
					str += '<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
					str += '<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt></dl></div></li>';
					$li = $(str);
					$li.data("noteId",noteId);
					$("#note_ul").append($li);
				}else{
					alert(result.msg)
				}
			},
			error:function(){
				alert("添加失败，请稍后重试");
			}
				
		});
	}
}