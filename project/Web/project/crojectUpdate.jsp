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
	<h1>프로젝트 수정</h1>
	<form action="ProjectServlet" method="post" name="frm">
		<input type="hidden" name="command" value="croject_Update">
		<input type="hidden" name="cronum" value="${cpro.cronum }">
		<table>	
			<tr>
				<th>프로젝트 제목</th>
				<td><input type="text" name="cpronm" value="${cpro.cpronm }"></td>
			</tr>
			<tr>
				<th>프로젝트 내용</th>
				<td><textarea rows="5" cols="30">${cpro.ccontent }</textarea></td>
			</tr>
			<tr>
				<th>프로젝트 기간</th>
				<td><input type="text" name="cinitdt" value="${cpro.cinitdt }"></td>
				<th>~</th>
				<td><input type="text" name="coutdt" value="${cpro.coutdt }"></td>
			</tr>
			<tr>
				<th>등록일</th>
				<td><input type="text" name="cregidt" value="${cpro.cregidt }"></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="등록" onclick="return crojectCheck()">
		<input type="button" value="취소" onclick="location.href='ProjectServlet?command=croject_list'">
	</form>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</div>
</body>
</html>