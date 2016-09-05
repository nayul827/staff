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
	if(window.name == "update") {
		window.opener.parent.location.href="ProjectServlet?command=project_update_form&ppronum=${param.ppronum}";
		alert("수정되었습니다.")
	}else if(window.name == "delete") {
		window.opener.parent.location.href="ProejctServlet?command=project_delete_form&ppronum=${param.ppronum}";
		alert("삭제되었습니다.");
	}
	window.close();
</script>
</body>
</html>