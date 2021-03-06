<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>Fluid box layout</title>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="../css/main.css" media="screen" />
</head>
<body>
<div id="centerColumn">
	<jsp:include page="../common/header.jsp" ></jsp:include>
	<jsp:include page="../common/menu.jsp" ></jsp:include>
	
  <!--//end #nav//-->
  <div id="wrap" align="center">
  	<h1>개인 프로젝트 목록</h1>
	<br/>
		<table id="natable" cellspacing='0'>
			<tr>
				<td><a href="ProjectServlet?command=project_insert_form">프로젝트 등록</a>
				</td>
			</tr>
			<tr>
				<th>순번</th>
				<th>사원번호</th>
				<th>프로젝트 제목</th>
				<th>등록일</th>
			</tr>
			<c:forEach var="project" items="${projectList }">
				<tr>
					<td>${project.ppronum }</td>
					<td>${project.empno }</td>
					<td><a href="ProjectServlet?command=projectView&ppronm=${project.ppronum }">${project.ppronm }</a></td>
					<td>${project.pregidt }</td>
					<br/>
					<br/>
					<br/>
					<td><input type="submit" value="등록" onclick="ProjectServlet?command=project_insert_form_action"></td>
				</tr>
			</c:forEach>    
		</table> 
	</div> 
	<jsp:include page="../common/footer.jsp" ></jsp:include>
  <!--//end #footer//-->
</div>
<!--//end #centerColumn//-->
</body>
</html>
