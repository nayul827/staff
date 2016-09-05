<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>Fluid box layout</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../css/main.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/project.css">
<script type="text/javascript" src="js/project.js"></script>
</head>
<body>
<div id="centerColumn">
	<jsp:include page="../common/header.jsp" ></jsp:include>
  <!--//end #nav//-->
  	<div id="wrap" align="center">
	<h1>개인 프로젝트 등록</h1>
	<br />
	<form action="ProjectServlet" method="post" name="frm">
		<input type="hidden" name="command" value="project_insert">
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
					<td><input type="text" name="ppronm" size="30">* 필수</td>
				</tr>
				<tr>
					<th>기간</th>
					<td><input type="text" name="pinitdt"></td>
					<th>~</th>
					<td><input type="text" name="poutdt"></td>
				</tr>
				<tr>
					<th>사용 기술</th>
					<td><input type="checkbox" name="1" >java
						<input type="checkbox" name="2">jquery
						<input type="checkbox" name="3">ajax
					</td>
				</tr>
				<tr>
					<th>상세내용</th>
					<td><textarea rows="15" cols="70"></textarea></td>
				</tr>
				<tr>
					<td>수행역할</td>
					<td><input type="text" name="worknum"></td>
				</tr>
			</table>
		<br><br>
		<input type="submit" name="등록" onclick="return projectCheck()">
		<input type="reset" name="다시 작성">
		<input type="button" name="목록" onclick="location.href='ProjectServlet?command=project_view'">
		</form>
		<jsp:include page="../common/footer.jsp" ></jsp:include>
  <!--//end #footer//-->
	</div>
</div>
</body>
</html>