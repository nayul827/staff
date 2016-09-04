<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<title>Insert title here</title>
<script type="text/javascript">
function goPage(page){
	location.href="BoardServlet?command=board_list&page="+page;	
}
</script>
</head>
<body>
<div id="wrap" align="center">
<h1>게시글 리스트</h1>
<table class="list">
<tr>
	<td colspan="5" style="border: white; text-align: right">
		<a href="BoardServlet?command=board_write_form">게시글 등록</a>
	</td>
</tr>
<tr>
	<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회</th>
</tr>
<c:forEach var="board" items="${boardList }" >
<tr class="record">
	<td>${board.num }</td>
	<td>
		<a href="BoardServlet?command=board_view&num=${board.num }">${board.title }</a>
	</td>
	<td>${board.name }</td>
	<td><f:formatDate value="${board.writedate }" /></td>
	<td>${board.readcount }</td>
</tr>
</c:forEach>
</table>
<div>
    <a href="javascript:goPage(${paging.firstPageNo})" class="first">처음 페이지</a>
    <a href="javascript:goPage(${paging.prevPageNo})" class="prev">이전 페이지</a>
    <span>
        <c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
            <c:choose>
                <c:when test="${i eq paging.pageNo}"><a href="javascript:goPage(${i})" class="choice">${i}</a></c:when>
                <c:otherwise><a href="javascript:goPage(${i})">${i}</a></c:otherwise>
            </c:choose>
        </c:forEach>
    </span>
    <a href="javascript:goPage(${paging.nextPageNo})" class="next">다음 페이지</a>
    <a href="javascript:goPage(${paging.finalPageNo})" class="last">마지막 페이지</a>
</div>
</div>
</body>
</html>