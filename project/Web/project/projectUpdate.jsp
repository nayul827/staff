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
	<h1>프로젝트 수정</h1>
	<form action="ProjectServlet" method="post" name="frm">
		<input type="hidden" name="command" value="project_Update">
		<input type="hidden" name="pronum" value="${project.ppronum }">
		
		<table>
			<tr>
				<th>사번번호</th>
				<td><input type="text" name="empno" value="${project.empno }">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="pwd">* 필수</td>
			</tr>
			<tr>
				<th>프로젝트 제목</th>
				<td><input type="text" name="ppronm" size=30 value="${project.ppronm }"></td>
			</tr>
			<tr>
				<th>기간</th>
				<td><input type="text" name="pinitdt" value="${project.pinitdt }"></td>
				<th>~</th>
				<td><input type="text" name="poutdt" value="${project.poutdt }"></td>
			</tr>
			<tr>
				<th>사용 기술</th>
				<td>${project.careernum }
				</td>
			</tr>
			<tr>
				<th>상세내용</th>
				<td><textarea rows="15" cols="70" name="pcontent">${project.pcontent }</textarea></td>
			</tr>
			<tr>
				<th>수행역할</th>
				<td>${project.worknum }</td>
			</tr>
		</table>
		<br><br>
		<input type="submit" value="등록" onclick="return projectCheck()">
		<input type="reset" value="다시 작성">
		<input type="button" value="취소" onclick="location.href='ProjectServlet?command=project_list'">
	</form> 
	</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</div>
</body>
</html>