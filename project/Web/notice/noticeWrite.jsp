<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/shopping.css">
<script type="text/javascript" src="js/notice.js"></script>
</head>
<body>
<div id="centerColumn">
	<jsp:include page="../common/header.jsp" ></jsp:include>
	<jsp:include page="../common/menu.jsp" ></jsp:include>
<div id="wrap" align="center">
	<h1>�Խñ� ���</h1>
	<form action="NoticeServlet" method="post" name="frm">
		<input type="hidden" name="command" value="notice_write">
		<table>
			<tr>
				<th>�ۼ���</th>
				<td><input type="text" name="writer">*�ʼ�</td>
			</tr>
			<tr>
				<th>��й�ȣ</th>
				<td><input type="password" name="pass">
					*�ʼ�( �Խù� ���� ������ �ʿ�)
				</td>
			</tr>
			<tr>
				<th>����</th>
				<td><input type="text" size="70" name="title">*�ʼ�</td>
			</tr>
			<tr>
				<th>����</th>
				<td><textarea rows="15" cols="79" name="content"></textarea></td>
			</tr>
		</table>
		<br><br>
		<input type="submit" value="���" onclick="return noticeCheck()">
		<input type="reset" value="�ٽ� �ۼ�">
		<input type="button" value="���" onclick="location.href='NoticeServlet?command=notice_list'">
	</form>
</div>	  
 <jsp:include page="../common/footer.jsp" ></jsp:include>
  <!--//end #footer//-->
</div>
</body>
</html>