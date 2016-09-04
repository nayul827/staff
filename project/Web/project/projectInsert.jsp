<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<title>Fluid box layout</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../css/main.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/project.css">
</head>
<body>
<div id="centerColumn">
	<jsp:include page="../common/header.jsp" ></jsp:include>
  <!--//end #nav//-->
	<h2>개인 프로젝트 등록</h2>
	<br />
	<form action="ProjectServlet" method="get" name="frm">
		<table>
			<tr>
				<td>사원번호</td>
				<td><input type="text" name="empno">
				</td>
			</tr>
			<tr>
				<td>프로젝트 제목</td>
				<td><input type="text" name="ppronm" size="30"></td>
			</tr>
			<tr>
				<td>기간</td>
				<td><input type="text" name="pinitdt"></td>
				<td>~</td>
				<td><input type="text" name="poutdt"></td>
			</tr>
			<tr>
				<td>사용 기술</td>
				<td><input type="checkbox" name="1" >java
					<input type="checkbox" name="2">jquery
					<input type="checkbox" name="3">ajax
				</td>
			</tr>
			<tr>
				<td>상세내용</td>
				<td><textarea rows="5" cols="30"></textarea></td>
			</tr>
			<tr>
				<td>수행역할</td>
				<td><input type="text" name="worknum"></td>
			</tr>
		</table>
	</form>  
	<br>
	<input type="submit" name="등록" onclick="return projectCheck()">
	<input type="reset" name="다시 작성">
	<input type="button" name="목록" onclick="location.href='ProjectServlet?command=pprojectView'">
	<jsp:include page="../common/footer.jsp" ></jsp:include>
  <!--//end #footer//-->
</div>

</body>
</html>