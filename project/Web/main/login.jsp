<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="kr">
	<head>
	<meta charset="UTF-8">
	<title>ㅇㅇ</title>
	<link href="../css/login.css" rel="stylesheet" type ="text/css">
	 <script type="text/javascript" src="js/login.js"></script>
</head>
<body>

<form  action="login.do" method="post" name="frm" class="signUp" id="signupForm">
   <h1 class="signUpTitle">사원 정보 관리 시스템</h1>
   <input type="text" name="empno" value="${empno}" class="signUpInput" placeholder="Type your EmpNo" autofocus required>
   <input type="password" name="pwd" class="signUpInput" placeholder="Input a password" required>
   <input type="radio" name="manyn" value="0" > 관리자
   <input type="radio" name="manyn" value="1"> 일반사원
   <input type="submit"  class="signUpButton">
   ${message}
</form>

</body>
</html>
