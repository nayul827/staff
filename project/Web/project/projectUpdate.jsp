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
		<input type="hidden" name="command" value="project_Update">
		<input type="hidden" name="pronum" value="${pproject.ppronum }">
		
		<table>
			<tr>
				<td>사번번호</td>
				<td><input type="text" name="empno" value="${pproject.empno }">
				</td>
			</tr>
			<tr>
				<td>프로젝트 제목</td>
				<td><input type="text" name="ppronm" size=30 value="${pproject.ppronm }"></td>
			</tr>
			<tr>
				<td>기간</td>
				<td><input type="text" name="pinitdt" value="${pproject.pinitdt }"></td>
				<td>~</td>
				<td><input type="text" name="poutdt" value="${pproject.poutdt }"></td>
			</tr>
			<tr>
				<td>사용 기술</td>
				<td><input type="checkbox" name="1">java
				<input type="checkbox" name="2">jquery
				<input type="checkbox" name="3">ajax
				</td>
			</tr>
			<tr>
				<td>상세내용</td>
				<td><textarea rows="5" cols="30" name="pcontent">${pproject.pcontent }</textarea></td>
			</tr>
			<tr>
				<td>수행역할</td>
				<td><input type="text" name="worknum" value="${pproject.worknum }"></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="등록" onclick="return projectCheck()">
		<input type="button" value="취소" onclick="location.href='ProjectServlet?command=project_list'">
	</form> 
	<jsp:include page="../common/footer.jsp"></jsp:include>
</div>
</body>
</html>