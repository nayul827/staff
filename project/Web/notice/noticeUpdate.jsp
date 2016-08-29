<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Inserts title here</title>
<link rel="stylesheet" type="text/css" href="./css/shopping.css">
<script type="text/javascript" src="js/notice.js"></script>
</head>
<body>
<div id="centerColumn">
	<jsp:include page="common/header.jsp" ></jsp:include>
	<jsp:include page="common/menu.jsp" ></jsp:include>
<div id="wrap" align="center">
	<h1>게시글 수정</h1>
	<form action="NoticeServlet" method="post" name="frm">
		<input type="hidden" name="command" value="notice_update">
		<input type="hidden" name="noticenum" value="${notice.noticenum }">
		
		<table>
			<tr>
				<th>작성자</th>
				<td><input type="text" size="12" name="writer" value="${notice.noticenum }">*필수</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" size="12" name="pass">*필수</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" size="70" name="title" value="${notice.title }"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="15" cols="70" name="content">${notice.content }</textarea></td>
			</tr>
		</table>
		<br><br>
		<input type="submit" value="등록" onclick="return noticeCheck()">
		<input type="reset" value="다시 작성">
		<input type="button" value="목록" onclick="location.href='NoticeServlet?command=notice_list'">
	</form>
</div>	  
 <jsp:include page="common/footer.jsp" ></jsp:include>
  <!--//end #footer//-->
</div>
</body>
</html>