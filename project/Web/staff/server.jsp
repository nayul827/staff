<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<Resource auth="Container" driverClassName="oracle.jdbc.OracleDriver"
						maxActive="20" maxIdle="10" maxWait="-1" name="jdbc/staff"
						password="1234" type="javax.sql.DataSource" url="jdbc:oracle:thin:@127.0.0.1:1521:testdb"
						username="kedu" />


</body>
</html>