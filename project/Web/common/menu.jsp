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
				<li><a class="center_hassub" >���� ������Ʈ �̷°���</a>
					<ul>
					<li><a href="ProjectServlet?command=ProjectList">������Ʈ �̷� ���</a></li>
					<li><a href="ProjectServlet?command=ProjectInsertForm">������Ʈ �̷� ���</a></li>
					</ul>
				</li>
				<li><a class="center_hassub">���� ���� ����</a>
					<ul>
					<li><a href="StaffServlet?command=staffList&username=${loginUser}">��� ���� ���</a></li>
					<li><a href="StaffServlet?command=staffUpdateForm">��� ���� ����</a></li>
					</ul>
				</li>
				<li><a class="left_nosub" href="NoticeServlet?command=notice_list">��������</a></li>
			</ul>
</div>
</body>
</html>