function noticeCheck(){
	if(document.frm.writer.value.length==0){
		alert("작성자를 입력하세요");
		return false;
	}
	if(document.frm.pass.value.length==0){
		alert("비밀번호를 입력하세요");
		return false;
	}
	if(document.frm.title.value.length==0){
		alert("제목을 입력하세요");
		return false;
	}
	return true;
}
function open_win(url,writer){
	window.open(url,writer,"width=500 ,height=230")
}
function passCheck(){
	if(document.frm.pass.value.length==0){
		alert("비밀번호를 입력하세요");
		return false;
	}
	return true;
}