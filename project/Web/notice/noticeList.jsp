<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/main.css">
</head>
<body>
<div id="centerColumn">
	<jsp:include page="../common/header.jsp" ></jsp:include>
	<jsp:include page="../common/menu.jsp" ></jsp:include>

	<div id="wrap" align="center">
		<h1>게시글 리스트</h1>
		<table  class="list">
			<tr>
				<td colspan="5" style="border: white; text-align: right;">
					<a href="NoticeServlet?command=notice_write_form">게시글 등록</a>
				</td>
			</tr>
			<tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회</th>
			</tr>
			<c:forEach var="notice" items="${noticeList}">
				<tr class="record">
					<td>${notice.noticenum }</td>
					<td>
						<a href="NoticeServlet?command=notice_view&noticenum=${notice.noticenum }">${notice.title}</a>
					</td>
					<td>${notice.writer}</td>
					<td><fmt:formatDate value="${notice.writedate }"/></td>
					<td>${notice.hits}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
  
 <jsp:include page="../common/footer.jsp" ></jsp:include>
  <!--//end #footer//-->
</div>
</body>
</html>