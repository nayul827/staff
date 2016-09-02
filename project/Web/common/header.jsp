<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>
<div id="header">
    <h1><a href="login.do">사원 관리 프로그램</a></h1>
<div class="menu">
			<ul>
				<li><a class="center_hassub" >개인 프로젝트 이력관리</a>
					<ul>
					<li><a href="ProjectServlet?command=project_list">프로젝트 이력 목록</a></li>
					<li><a href="ProjectServlet?command=project_insert_form">프로젝트 이력 등록</a></li>
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
</div>
</body>
</html>