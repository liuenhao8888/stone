<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link href="resource/css/global.css" rel="stylesheet" type="text/css" />
<link href="resource/css/user-info.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<hr />
	<center>
		<div id="right">
			<h3>用户信息</h3>
			<FORM METHOD=POST ACTION="use/user/update.do">
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
				<p>
					<input type="hidden" name="id" value="${user.userId}" />
					<!-- 	<INPUT TYPE="submit" value="修   改"> -->
				</p>
				<br>
			</FORM>
		</div>
	</center>
</body>