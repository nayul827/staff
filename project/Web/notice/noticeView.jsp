<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/shopping.css">
<script type="text/javascript" src="js/notice.js"></script>
</head>
<body>
<div id="centerColumn">
	<jsp:include page="/common/header.jsp" ></jsp:include>
	<div id="wrap" align="center">
		<h1>게시글 상세보기</h1>
		<table>
			<tr>
				<th>작성자</th> <td>${notice.writer }</td>
				<th>작성일</th> <td>${notice.writedate }</td>
			</tr>
			<tr>
				<th>조회수</th> <td>${notice.hits }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3">${notice.title }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3"><pre>${notice.content }</pre></td>
			</tr>
		</table>
		<br><br>
		<input type="button" value="게시글 수정" onclick="open_win('NoticeServlet?command=notice_check_pass_form&noticenum=${notice.noticenum}','update')">
		<input type="button" value="게시글 삭제" onclick="open_win('NoticeServlet?command=notice_check_pass_form&noticenum=${notice.noticenum}','delete')">
		<input type="button" value="게시글 목록" onclick="location.href='NoticeServlet?command=notice_list'">
		<input type="button" value="게시글 등록" onclick="location.href='NoticeServlet?command=notice_write_form'">
	</div>
  
 <jsp:include page="/common/footer.jsp" ></jsp:include>
  <!--//end #footer//-->
</div>
</body>
</html>