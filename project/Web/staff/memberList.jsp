<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>다이얼로그 회원 가입.</title>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<link rel="stylesheet" href="./css/jquery-ui.min3.css">
<script type="text/javascript" src="./js/jquery-ui.min3.js"></script>

<style type="text/css">

body{
	font-size:62.5%;
}

label, input{
	display:block;
}

input.text{
	margin-bottom: 12px;
	width: 95%;
	padding: .4em;
}

fieldset{
	padding: 0;
	border: 0;
	margin-top: 25px;
}

h1{
	font-size: 1.2em;
	margin: .6em 0;
}

div#user-contain{
	width: 350px;
	margin: 20px 0;
}

div#user-contain table{
	margin: 1emp 0;
	border-collapse: collapse;
	width: 100%; 
}

div#user-contain table td,
div#user-contain table th{
	border: 1px solid #eee;
	padding: .6em 10px;
	text-align: left;
}

.ui-dialog
.ui-state-error{
	padding : .3em;
}

.validateTips{
	border : 1px solid transparent;
	padding : 0.3em;
}

</style>

<script type="text/javascript">
$(function(){
	
	var dialog, form,
	//	정규 표현식은 /로 시작해서 /로 끝나야 한다.
		emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/,		
		memnm = $("#memnm"),
		mememail = $("#mememail"),
		mempwd = $("#mempwd"),
		allFields = $([]).add( memnm ).add( mememail ).add(mempwd),
		tips = $( ".validateTips");
	
	
	var updateTips = function(msg){
		tips
			.text(msg)
			.addClass("ui-state-highlight");
		setTimeout(function(){
			tips.removeClass("ui-state-highlight", 1500);
		}, 500);
	}
	
	var checkLength = function( o, n, min, max ) {
	      if ( o.val().length > max || o.val().length < min ) {
	        o.addClass( "ui-state-error" );
	        updateTips( n + "은(는) " + min + "에서 " + max + "자까지 입력해 주세요." );
	        return false;
	      } else {
	        return true;
	      }
	}
	
	var checkRegexp = function( o, regxp, n){
		if(!(regxp.test( o.val()))){
			o.addClass("ui-state-error");
			updateTips(n);
			return false;
		}else{
			return true;
		}
	}
	
	var addUser = function(){
		var valid = true;
		allFields.removeClass("ui-state-error");
	
		valid = valid && checkLength(memnm, "username", 3, 16);
		valid = valid && checkLength(mememail, "email", 6, 80);
		valid = valid && checkLength(mempwd, "password", 5, 16);
		
		valid = valid && checkRegexp( memnm, /^[가-힣a-z]([가-힣0-9a-z_\s])+$/i, "성명은 3자에서 16자 이내로 작성해 주세요" );
	    valid = valid && checkRegexp( mememail, emailRegex, "eg. ui@jquery.com" );
	    valid = valid && checkRegexp( mempwd, /^([0-9a-zA-Z])+$/, "Password는 영문자 소문자, 숫자 5~16 허용합니다. : a-z 0-9" );
	 
	   	if(valid){
	   		
	   		var d=$("#frm").serialize();
	   		
	   		$.ajax({
	   			url:"member.do?command=member_insert",
	   			data: d,
	   			type:'post',
	   			success:function(json){
	   				data = JSON.parse(json);
	   				$("#users tbody").prepend(
	   					"<tr class='"+
	   					data.no+
	   					"'>"+
	   					"<td>"+
	   					data.no+
	   					"</td>"+
	   					"<td>"+
	   					data.memnm+
	   					"</td>"+
	   					"<td>"+
	   					data.mememail+
	   					"</td>"+
	   					"<td>"+
	   					data.mempwd+
	   					"</td>"+
	   					"<td>"+
	   					"<button id='delete-user' class='ui-button' onclick='deleteUser("+
	   					data.no+
	   					");'>"+
	   					"삭제"+
	   					"</button>"+
	   					"</td>"+
	   					"</tr>"
	   				
	   				);
	   				
	   				//window.location.reload(true);
	   			}
	   		});
	   		
	   		dialog.dialog("close");
	   	}
	   	return valid;
	}
	
	var	
	dialog = $("#dialog-insert").dialog({
		autoOpen : false,
		height : 300,
		width : 350,
		modal : true,
		buttons : {
			"회원등록" : addUser,
			"취소" : function(){
				dialog.dialog("close");
			}
		},
		//close가 문법적으로는 dialog의 아래에 있지만
		//컴파일 시 자바스크립트 엔진이 close를 위로 올리고
		//undefind를 걸기 때문에 오류가 없다.
		close: function(){
		//	form의 모든 값을 없애버린다.
			form[ 0 ].reset();
		//	allFields는 위에서 name, email, password를 저장한 벼누
		//	즉, name과 email, password의 ui-state-error클래스를
		//	날려버린다.
			allFields.removeClass("ui-state-error");
		}
	});
	
	//on으로 처리한 자바스크립트는 동적으로 생성된
	//코드에도 적용이 가능. 
	//on이 아닌 그냥 click으로 이벤트 생성시, 동적 생성된 코드에는 이벤트 적용 불가.
	
	
	form = dialog.find("form").on("submit",function(event){
		//submit 클릭시, submit이 적용되지 않고
		//그 대신 addUser로 이동해서 처리하게 함.
		event.preventDefault();
		addUser();
	});
	
	//create-user 아이디를 가진 버튼을 누를경우
	//다이알로그를 연다.
	$("#create-user").button().on("click",function(){
		dialog.dialog("open");
	});
	
});



var deleteUser = function(no){
	url="member.do?command=member_delete&no="+no;
	delno = "."+no;
	$.ajax({
		type:"get",
		url:url,
		success:function(msg){
			data = JSON.parse(msg);
			if(data.msg=="success"){
				$("tr").remove(delno);
				alert("정상삭제 되었습니다.");
			}else{
				alert("삭제에 실패했습니다.");
			}
		},
		error:function(){
			alert("삭제에 실패했습니다.");
		}
	});
};
</script>
</head>
<body>
<div id="dialog-insert" title="회원등록">
	<p class="validateTips">
		모든 필드에 입력해 주세요
	</p>
	<form id="frm" action="member.do">
		<fieldset>
			<label for="memnm">이름</label>
			<input type="text" name="memnm" id="memnm" class="text ui-widget-content ui-corner-all" placeholder="성명 입력">
			<label for="mememail">이메일</label>
			<input type="text" name="mememail" id="mememail" placeholder="이메일 입력" class="text ui-widget-content ui-corner-all">
			<label for="mempwd">비밀번호</label>
			<input type="password" name="mempwd" id="mempwd" placeholder="비밀번호 입력" class="text ui-widget-content ui-corner-all">			
			<%-- 
			실제 submit처리는 dialog의 
			addUser에서 처리하기 때문에
			화면 위로 올려서 submit을 감춤. 
			tabindex = -1을 이용해 탭키를 이용해 
			탭키로 포커스가 가는 것도 막는다.
			 --%>
			<input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
		</fieldset>
	</form>
</div>

<div id="users-contain" class="ui-widget">
	<h1>회원 현황</h1>
	<table id="users" class="ui-widget ui-widget-content">
		<thead>
			<tr class="${member.no}">
				<th>순번</th>
				<th>이름</th>
				<th>이메일</th>
				<th>비밀번호</th>	
			</tr>
		</thead>
		<tbody>
			<c:forEach var="member" items="${memberList }">
				<tr class="${member.no}">
					<td>${member.no }</td>
					<td>${member.memnm }</td>
					<td>${member.mememail }</td>
					<td>${member.mempwd }</td>
					<td><button id="delete-user" class="ui-button" onclick='deleteUser(${member.no});'>
					삭제
					</button></td>
				</tr>
			</c:forEach>
		</tbody>
	
	</table>
</div>
<button id="create-user">회원등록</button>
</body>
</html>