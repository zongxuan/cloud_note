function alertAddBookWindow(){
	$("#can").load("alert/alert_notebook.html");
	$(".opacity_bg").show()
}

//关闭对话框
function closeAlertWindow(){
	//清空div内容
	$("#can").html("");
	//隐藏背景色
	$(".opacity_bg").hide();
}


function alertAddNoteWindow(){
	$("#can").load("alert/alert_note.html");
	$(".opacity_bg").show()
}