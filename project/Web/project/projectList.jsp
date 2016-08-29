<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Fluid box layout</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../css/style.css" media="screen" />

</head>
<body>
<div id="centerColumn">
	<jsp:include page="../common/header.jsp" ></jsp:include>
	<jsp:include page="../common/menu.jsp" ></jsp:include>
	
  <!--//end #nav//-->
  <h2>프로젝트 이력 목록</h2>
<br />
<form action="" method="post" name="frm">
	<table>
		<tr>
			<td>ID</td>
			<td><input type="text" name="empno" value=""></td>
			<td>등록일</td>&nbsp;
			<td><input type="text" name="cregidate"></td>
			<td>~</td>
			<td><input type="text" name="cregidate"></td>
		</tr>
		<tr>
			<td>프로젝트명</td>
			<td><input type="text" name="cpronum"></td>
			<td></td>&nbsp;	
			<td><input type="submit" value="아작스처리" onclick="loginCheck()"></td>
		</tr>
	</table>
</form>  

<table id="natable" cellspacing='0'>
	<tr>
		<th>순번</th>
		<th>ID</th>
		<th>프로젝트명</th>
		<th>등록일</th>
	</tr>
    
	<tr>
		<td>1</td>
		<td>모인성</td>
		<td>김나율</td>
		<td>천생연분</td>
	</tr>
</table>
  
 <jsp:include page="../common/footer.jsp" ></jsp:include>
  <!--//end #footer//-->
</div>
<!--//end #centerColumn//-->
</body>
</html>
