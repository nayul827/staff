<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	if(window.name=="update"){
		window.opener.parent.location.href="NoticeServlet?command=notice_update_form&noticenum=${param.noticenum}";
		
	}else if(window.name=="delete"){
		alert("삭제 되었씁니다.");
		window.opener.parent.location.href="NoticeServlet?command=notice_delete&noticenum=${param.noticenum}";
	}
	window.close();
</script>
</body>
</html>