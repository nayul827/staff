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
		<div>	
		<h1>프로젝트 상세보기</h1>
			<table>
				<tr>
					<th>순번</th><td>${pproject.cpronum }</td>
				</tr>
				<tr>
					<th>사원번호</th><td>${pproject.empno }</td>
				</tr>
				<tr>
					<th>프로젝트 제목</th><td>${pproject.ppronm }</td>
				</tr>
				<tr>
					<th>기간</th><td>${pproject.pinitdt }</td><th>~</th><td>${pproject.poutdt }</td>
				</tr>
				<tr>
					<th>등록일</th><td>${pproject.pregidt }</td>
				</tr>
				<tr>
					<th>프로젝트 내용</th><td>${pproject.pcontent }</td>
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