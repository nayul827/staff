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
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/staff.css"/>
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/staff.js"></script>
</head>
<body>
<div id="centerColumn">
	<jsp:include page="../common/header.jsp" ></jsp:include>
	<jsp:include page="../common/menu.jsp" ></jsp:include>
	
	<div id="tabs">
		<ul>
			<li><a href="#tabs-1">사원</a></li>
			<li><a href="#tabs-2">학력</a></li>
			<li><a href="#tabs-3">경력</a></li>
			<li><a href="#tabs-4">자격증</a></li>
			
		</ul>
		<div id="tabs-1">
		<form action="StaffServlet" method="post" name="frm">
		<input type="hidden" name="command" value="staffList"/>  
		<table>
			<tr>
				<th>사번</th>
				<td><input type="text" readonly="readonly"/></td>
			</tr>
			<tr>
				<th>사원명</th>
				<td><input type="text" name="empnm" placeholder="aaaaaa" /></td>
			</tr>
			<tr>
				<th>주민번호</th>
				<td><input type="text" name="juminno"/></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<th>Tel</th>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<th>사진</th>
				<td></td>
			</tr>
			<tr>
				<th>입사일</th>
				<td>
					<input type="text" id="indt"/>
				</td>
			</tr>
			<tr>
				<th>퇴사일</th>
				<td><input type="text" id="outdt"/></td>
			</tr>
			<tr>
				<th>우편 번호</th>
				<td><input type="text" name="addrno"/></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="addrno"/></td>
			</tr>
			<tr>
				<th>상세 주소</th>
				<td><input type="text" name="addrno"/></td>
			</tr>
			<tr>
				<th>급여</th>
				<td><input type="text" name="salary"/></td>
			</tr>
			<tr>
				<th>등록일</th>
				<td><input type="text" id="datepicker"></td>
			</tr>
			<tr>
				<th>부서명</th>
				<td>
					<select id ="deptno" name="deptno ">
						<option value="">선택하세요</option>
						<option value="10">총무부</option>
						<option value="20">영업부</option>
						<option value="30">인사부</option>
						<option value="40">개발부</option>
						<option value="50">재정부</option>
						<option value="60">디자인부</option>
						<option value="70">홍보부</option>
						<option value="80">관리부</option>
						<option value="90">말리부</option>
					</select>
				</td>
			</tr>
			
			<c:if test="${type eq 0}">
			<tr>
				<th>직급명</th>
				<td>
					<select id="ranknum" name="ranknum">
						<option value="10">대표이사</option>
						<option value="20">이사</option>
						<option value="30">상무</option>
						<option value="40">부장</option>
						<option value="50">차장</option>
						<option value="60">과장</option>
						<option value="70">팀장</option>
						<option value="80">대리</option>
						<option value="90">사원</option>			
					</select>
				</td>
			</tr>
			</c:if>
		</table>
		<input type="submit" name="등록" onclick="location.href='StaffServlet?command=staffView'"/>
		<input type="reset" name="취소"/>	
		</form>	
		</div>
		<div id="tabs-2"></div>
		<div id="tabs-3"></div>
		<div id="tabs-4"></div>
	
	</div>
	
	<div id="wrap" align="center">
	</div>
 <jsp:include page="../common/footer.jsp" ></jsp:include>
  <!--//end #footer//-->
</div>
<!--//end #centerColumn//-->
</body>
</html>
