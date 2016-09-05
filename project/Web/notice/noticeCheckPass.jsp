<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/main.css">
<script type="text/javascript" src="js/notice.js"></script>
</head>
<body>
<div id="centerColumn">
	<jsp:include page="../common/header.jsp" ></jsp:include>
	
<div align="center">
<h1>비밀번호 확인</h1>
<form action="NoticeServlet" name="frm" method="get">
	<input type="hidden" name="command" value="notice_check_pass">
	<input type="hidden" name="noticenum" value="${param.noticenum }">
	<table style="width:80%">
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" name="pass" size="20">
			</td>
		</tr>
	</table>
	<br>
	<input type="submit" value="확인" onclick="return passCheck()">
	<br><br>${message }
</form>
</div>
  
 <jsp:include page="../common/footer.jsp" ></jsp:include>
  <!--//end #footer//-->
</div>
</body>
</html>