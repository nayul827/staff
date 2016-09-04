<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/main.css">
<link rel="stylesheet" type="text/css" href="../css/project.css">
<script type="text/javascript" src="../js/project.js"></script>
</head>
<body>
<div id="centerColumn">
	<jsp:include page="../common/header.jsp"></jsp:include>
	<h2>그룹 프로젝트 등록</h2>
	<br>
	<form action="ProjectServlet" method="get" name="frm">
		<table>
			<tr>
				<th>프로젝트 제목</th>
				<td><input type="text" name="cpronm"></td>
			</tr>
			<tr>
				<th>프로젝트 내용</th>
				<td><textarea rows="5" cols="30"></textarea></td>
			</tr>
			<tr>
				<th>프로젝트 기간</th>
				<td><input type="text" name="cinitdt"></td>
				<th>~</th>
				<td><input type="text" name="coutdt"></td>
			</tr>
			<tr>
				<th>등록일</th>
				<td><input type="text" name="cregidt"></td>
			</tr>
		</table>
	</form>
	<br>
	<input type="submit" name="등록" onclick="return crojectCheck()">
	<input type="reset" name="다시 작성">
	<input type="button" name="목록" onclick="location.href='ProjectServlet?command=cprojectView'">
	<jsp:include page="../common/footer.jsp"></jsp:include>
</div>
</body>
</html>