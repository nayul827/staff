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
		<div id="wrap" align="center">	
		<h1>프로젝트 상세보기</h1>
			<table>
				<tr>
					<th>번호</th><td>${project.ppronum }</td>
				</tr>
				<tr>
					<th>사원번호</th><td>${project.empno }</td>
				</tr>
				<tr>
					<th>프로젝트 제목</th><td>${project.ppronm }</td>
				</tr>
				<tr>
					<th>기간</th><td>${project.pinitdt }</td><th>~</th><td>${project.poutdt }</td>
				</tr>
				<tr>
					<th>사용 기술</th>
					<td>${project.careernum }</td>
				<tr>
					<th>등록일</th><td>${project.pregidt }</td>
				</tr>
				<tr>
					<th>상세내용</th><td>${project.pcontent }</td>
				</tr>
				<tr>
					<th>수행역할</th>
					<td>${project.worknum }</td>
				</tr>
			</table>
			<br>
			<input type="button" value="수정" onclick="open_win('ProjectServlet?command=project_check_pass_form&ppronum=${pproject.ppronum}','update')">
			<input type="button" value="목록" onclick="location.href='ProjectServlet?command=project_list'">
			<input type="button" value="삭제" onclick="open_win('ProjectServlet?command=project_check_pass_form&ppronum=${pproject.ppronum}','delete')">
		</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</div>
</body>
</html>