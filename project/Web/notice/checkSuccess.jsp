<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	if(window.name=="update"){
		alert("수정되었습니다.")
		window.opener.parent.location.href="NoticeServlet?command=notice_update_form&noticenum=${param.noticenum}";
		
	}else if(window.name=="delete"){
		alert("삭제 되었습니다.");
		window.opener.parent.location.href="NoticeServlet?command=notice_delete&noticenum=${param.noticenum}";
	}
	window.close();
</script>
</body>
</html>