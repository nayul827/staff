<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty loginUser }">
	<jsp:forward page="login.do" ></jsp:forward>
</c:if>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>Main</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="./css/style.css" media="screen" />
	<link rel="shortcut icon" href="/HRIS_Web/favicon.ico"/>
	<link rel="stylesheet" href="../css/jqueryui/base/jquery.ui.all.css"/>
	<link rel="stylesheet" type="text/css" href="../css/styles.css" />
	<link rel="stylesheet" type="text/css" href="../css/home_dialog.css" />
	<link rel="stylesheet" type="text/css" href="/Themes/Home/Summer.css" />

</head>
<body>
<div id="centerColumn">
	<jsp:include page="../common/header.jsp" ></jsp:include>
	
	<form action="logout.do">
		<table>
			<tr>
				<td>
					 안녕하세요 ${username }(사원)님
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="로그아웃"/>&nbsp;
				</td>
			</tr>
		</table>
	</form>
	<jsp:include page="../common/menu.jsp" ></jsp:include>
	
  <div class="notice">
        	        <h3>Notice</h3>
                    <ul>
                        
            	            <li><a href='/HRIS_Web/VPW/VPWA02C0S.aspx?pg=1&seq=703'>[NEW] 제 5회 현대백화점 열정(PASS...</a><span>2016.05.12</span></li>
                        
            	            <li><a href='/HRIS_Web/VPW/VPWA02C0S.aspx?pg=1&seq=663'>제 4회 현대백화점 열정(PASSION) 장...</a><span>2015.11.02</span></li>
                        
            	            <li><a href='/HRIS_Web/VPW/VPWA02C0S.aspx?pg=1&seq=643'>현대백화점 H-Wallet OPEN 안내</a><span>2015.09.02</span></li>
                        
            	            <li><a href='/HRIS_Web/VPW/VPWA02C0S.aspx?pg=1&seq=583'>[동반성장] 가족愛 프로그램 안내 드립니다.</a><span>2015.06.04</span></li>
                        
            	            <li><a href='/HRIS_Web/VPW/VPWA02C0S.aspx?pg=1&seq=476'>현대백화점 아동·유아 신진 브랜드 모집</a><span>2014.03.28</span></li>
                                                
                    </ul>
                    <a href="/HRIS_Web/VPW/VPWA01C0S.ASPX" class="more"><img src="../images/main/more.gif" alt="공지사항 더보기"></a>
                </div>

 <jsp:include page="../common/footer.jsp" ></jsp:include>
  <!--//end #footer//-->
</div>
<!--//end #centerColumn//-->
</body>
</html>
