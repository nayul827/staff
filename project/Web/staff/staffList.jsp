<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<title>Fluid box layout</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../css/main.css" media="screen" />

</head>
<body>
<div id="centerColumn">
	<jsp:include page="../common/header.jsp" ></jsp:include>
	<jsp:include page="../common/menu.jsp" ></jsp:include>
	
  	<div id="wrap" align="center">
  		<table>
  			<tr>
  				<td colspan="4" style="border: white; text-align: right;">
 					<a href="StaffServlet?command=staffInsertForm">사원등록  </a>
  				</td>
  			</tr>
  			<tr><th>순번</th><th>사원명</th><th>직급</th><th>등록일</th>
  			</tr>
  			<c:forEach var="staff" items="${staffList }">
  				<tr>
 					<td>${staff.empno }</td> 
 					<td>
 					<a href="StaffServlet?command=staffView&empname=${staff.empnm }">${staff.empnm }</a>
 					</td>	
 					<td>${staff.deptno }</td>
 					<td>${staff.wdt }</td>			
  				</tr>
  			</c:forEach>
  		</table>
  	</div>
  
 <jsp:include page="../common/footer.jsp" ></jsp:include>
  <!--//end #footer//-->
</div>
</body>
</html>