<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link href="../css/login.css" rel="stylesheet" type="text/css">
<link href="../js/loginanimation.js" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> 
</head>
<body>
	<section class="container"> 
	<article class="half">
	<h1>사원 정보 관리 시스템</h1>
	<div class="tabs">
		<span class="tab">Login</span>
	</div>
	<div class="content">
		<div class="signin-cont cont">
			<form action="login.do" method="post" name="frm">
				<input type="text" name="empno" value="${empno}" id="empno"
					class="inpt" required="required" placeholder="Number">
				<input type="password" name="pwd" id="password" class="inpt"
					required="required" placeholder="Password">
			<div class="manyn">
				<input type="radio" name="manyn" value="0"> 관리자 
				<input type="radio" name="manyn" value="1"> 일반사원
			</div>
				<input	type="submit" value="login" class="submit">
			</form>
		</div>
	</div>
	</article>
	<div class="half bg"></div>
	</section>
	

</body>
</html>