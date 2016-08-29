<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/login2.css" rel="stylesheet" type="text/css">
</head>
<body>

	<section class="container"> 
	<article class="half">
	<h1>사원 정보 관리 시스템</h1>
	<div class="tabs">
		<span class="tab signin active">Login</span>
	</div>
	<div class="content">
		<div class="signin-cont cont">
			<form action="login.do" method="post" name="frm">
				<input type="text" name="empno" value="${empno}" id="empno"
					class="inpt" required="required" placeholder="Number"> 
				<input type="password" name="pwd" id="password" class="inpt"
					required="required" placeholder="Password"> 
				<input type="radio" name="manyn" value="0"> 관리자 
				<input type="radio" name="manyn" value="1"> 일반사원 
				<input	type="submit" value="Sign in">
			</form>
		</div>
	</div>
	</article>
	<div class="half bg"></div>
	</section>
</body>
</html>