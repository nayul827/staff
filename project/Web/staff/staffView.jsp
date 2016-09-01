<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <c:if test="${empty loginUser }">
	<jsp:forward page="login.do" ></jsp:forward>
</c:if> --%>
<!DOCTYPE html>
<html>
<head>
<title>Fluid box layout</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui.min.css"/>
<link rel="stylesheet" type="text/css" href="css/styles.css" />
<link rel="stylesheet" type="text/css" href="css/staff.css"/>
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/staff.js"></script>
</head>
<body>
<div id="centerColumn">
	<jsp:include page="/common/header.jsp" ></jsp:include>
	<jsp:include page="/common/menu.jsp" ></jsp:include>
	
	<div id="wrap" align="center">
		<h1>사원 정보 상세</h1>
		<table>
			<tr>
				<th>사번</th>
				<td>${staff.empno }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${staff.empnm }</td>
			</tr>
			<tr>
				<th>주민번호</th>
				<td>${staff.juminno }</td>
			</tr>
			<tr>
				<th>입사일</th>
				<td>${staff.indt }</td>
			</tr>
			<tr>
				<th>퇴사일</th>
				<td>${staff.outdt }</td>
			</tr>
			<tr>
				<th>우편번호</th>
			</tr>
			<tr>
				<th>주소</th>
			</tr>
			<tr>
				<th>상세주소</th>
			</tr>
			<tr>
				<th>급여</th>
				<td>${staff.salary }</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td>${staff.wdt }</td>
			</tr>	
			<tr>
				<th>부서명</th>
				<td>${staff.deptno }</td>
			</tr>
			<tr>
				<th>직급명</th>
				<td>${staff.ranknum }</td>
			</tr>
		</table>
		<input type="button" value="목록" onclick="location.href='StaffServlet?command=staffView'">
		<input type="button" value="수정" onclick="location.href='StaffServlet?command=staffUpdateForm'">
		<input type="button" value="삭제" onclick="open_win('StaffServlet?command=staffView')">
	</div>
 <jsp:include page="/common/footer.jsp" ></jsp:include>
  <!--//end #footer//-->
</div>
<!--//end #centerColumn//-->
</body>
</html>
