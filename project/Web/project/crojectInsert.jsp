<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/main.css">
<link rel="stylesheet" type="text/css" href="../css/project.css">
<script type="text/javascript" src="js/project.js"></script>
</head>
<body>
<div id="centerColumn">
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div id="wrap" align="center">
	<h1>그룹 프로젝트 등록</h1>
	<br>
	<form action="ProjectServlet" method="get" name="frm">
		<input type="hidden" name="command" value="croject_insert">
		<table>
			<tr>
				<th>사원번호</th>
				<td><input type="text" name="empno"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd">* 필수</td>
			</tr>
			<tr>
				<th>프로젝트 제목</th>
				<td><input type="text" name="cpronm" size="30">* 필수</td>
			</tr>
			<tr>
				<th>기간</th>
				<td><input type="text" name="cinitdt"></td>
				<th>~</th>
				<td><input type="text" name="coutdt"></td>
			</tr>
			<tr>
				<th>프로젝트 내용</th>
				<td><textarea rows="15" cols="70"></textarea></td>
			</tr>
		</table>
	</form>
	</div>
	<br><br>
	<input type="submit" name="등록" onclick="return projectCheck()">
	<input type="reset" name="다시 작성">
	<input type="button" name="목록" onclick="location.href='ProjectServlet?command=cproject_view'">
	<jsp:include page="../common/footer.jsp"></jsp:include>
</div>
</body>
</html>