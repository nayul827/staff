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
	<jsp:include page="../common/menu.jsp"></jsp:include>
	
		<h2>그룹 프로젝트 목록</h2>
		<br/>
	<table>
		<tr>
			<th>순번</th>
			<th>사원번호</th>
			<th>프로젝트명</th>
			<th>등록일</th>
		</tr>
		<c:forEach var="project" items="${crojectList }">
			<tr>
				<td>${croject.cpronum }</td>
				<td>${croject.empno }</td>
				<td><a href="ProjectServlet?command=crojectView&cpronm=${croject.cpronm }">${croject.cpronm }</a></td>
				<td>${croject.cregidt }</td>
				<br>
				<br>
				<br>
				<td><input type="submit" value="등록" onclick="ProjectServlet?command=croject_insert_form_action"></td>
			</tr>
		</c:forEach>
	</table>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</div>
</body>
</html>