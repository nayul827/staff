/**
 * 
 */

function loginCheck(){
	if(document.frm.empno.value.length==0){
		alert("아이디를 써주세요");
		frm.empno.focus();
		return false;
	}
	if(document.frm.pwd.value==""){
		alert("암호는 반드시 입력해야 합니다.");
		frm.pwd.focus();
		return false;
	}
	
	return true;
}