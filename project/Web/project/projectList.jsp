<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>Fluid box layout</title>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="../css/style.css" media="screen" />
</head>
<body>
<div id="centerColumn">
	<jsp:include page="../common/header.jsp" ></jsp:include>
	<jsp:include page="../common/menu.jsp" ></jsp:include>
	
  <!--//end #nav//-->
  <h2>프로젝트 이력 목록</h2>
<br />
<table id="natable" cellspacing='0'>
	<tr>
		<th>사원번호</th>
		<th>프로젝트명</th>
		<th>등록일</th>
	</tr>
	<c:forEach var="project" items="${projectList }">
		<tr>
			<td>${project.empno }</td>
			<td><a href="ProjectServlet?command=projectView&ppronm=${project.ppronm }">${project.ppronm }</a></td>
			<td>${project.pregidt }</td>
			</br>
			</br>
			</br>
			<td><input type="submit" value="등록" onclick="ProjectServlet?command=projectInsertFormAction"></td>
		</tr>
	</c:forEach>    
</table>  
<jsp:include page="../common/footer.jsp" ></jsp:include>
  <!--//end #footer//-->
</div>
<!--//end #centerColumn//-->
</body>
</html>
