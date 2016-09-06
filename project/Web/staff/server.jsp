<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<Resource auth="Container" driverClassName="oracle.jdbc.OracleDriver"
						maxActive="20" maxIdle="10" maxWait="-1" name="jdbc/staff"
						password="1234" type="javax.sql.DataSource" url="jdbc:oracle:thin:@127.0.0.1:1521:testdb"
						username="kedu" />


</body>
</html>