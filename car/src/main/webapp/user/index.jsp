<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>welcom back</h1>

	<table border="1">
		<tr>
			<td>账号</td>
			<td>${user.username}</td>
		</tr>
		<tr>
			<td>邮箱</td>
			<td>${user.email}</td>
		</tr>
		<tr>
			<td>注册时间</td>
			<td>${user.time}</td>
		</tr>
	</table>


</body>
</html>