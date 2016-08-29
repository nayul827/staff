<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div id="centerColumn">
	<jsp:include page="../common/header.jsp" ></jsp:include>
	<jsp:include page="../common/menu.jsp" ></jsp:include>
	
	<div id="tabs">
		<ul>
			<li><a href="#tabs-1">학력</a></li>
			<li><a href="#tabs-2">경력</a></li>
			<li><a href="#tabs-3">자격증</a></li>
			<li><a href="#tabs-4">보유 기술</a></li>
		</ul>
		<div id="tabs-1"></div>
		<div id="tabs-2"></div>
		<div id="tabs-3"></div>
		<div id="tabs-4"></div>		
	</div>
	<div id="wrap" align="center">
		<form action="StaffServlet" method="post" name="frm">
		<!-- <input type="hidden" name="command" />  -->
		<table>
			<tr>
				<th>사번</th>
				<td><input type="text" /></td>
			</tr>
			<tr>
				<th>사원명</th>
				<td><input type="text" name="empnm"/></td>
			</tr>
			<tr>
				<th>주민번호</th>
				<td><input type="text" name="juminno"/></td>
			</tr>
			<tr>
				<th>입사일</th>
				<td><input type="text" name="indt"/></td>
			</tr>
			<tr>
				<th>퇴사일</th>
				<td><input type="text" name="outdt"/></td>
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
				<td><input type="text" name="wdt"/></td>
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
		</table>
		<input type="submit" name="등록" onclick="location.href='StaffServlet?command=staffView'"/>
		<input type="reset" name="취소"/>	
		</form>	
	</div>
<jsp:include page="../common/footer.jsp" ></jsp:include>	
</div>
</body>
</html>