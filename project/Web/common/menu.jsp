<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/style.css" media="screen" />

</head>
<body>
<div class="menu">
			<ul>
				<li><a class="center_hassub" >개인 프로젝트 이력관리</a>
					<ul>
					<li><a href="ProjectServlet?command=ProjectList">프로젝트 이력 목록</a></li>
					<li><a href="ProjectServlet?command=ProjectInsertForm">프로젝트 이력 등록</a></li>
					</ul>
				</li>
				<li><a class="center_hassub">개인 정보 관리</a>
					<ul>
					<li><a href="StaffServlet?command=staffList&username=${loginUser}">사원 정보 목록</a></li>
					<li><a href="StaffServlet?command=staffUpdateForm">사원 정보 수정</a></li>
					</ul>
				</li>
				<li><a class="left_nosub" href="NoticeServlet?command=notice_list">공지사항</a></li>
			</ul>
</div>
</body>
</html>