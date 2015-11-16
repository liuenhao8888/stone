<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<link href="resource/css/global.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<center>
		<FORM METHOD=POST ACTION="register.do">
			<table border="1">
				<tr>
					<td>账号</td>
					<td><INPUT TYPE="text" NAME="username" value=""></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><INPUT TYPE="password" NAME="password" value=""></td>
				</tr>
				<tr>
					<td>确认密码</td>
					<td><INPUT TYPE="password" NAME="password2" value=""></td>
				</tr>
				<tr>
					<td>邮箱</td>
					<td><INPUT TYPE="text" NAME="email" value=""></td>
				</tr>
				<tr>
					<td>会员类型</td>
					<td>
					<INPUT TYPE="radio" NAME="type" value="1" checked="checked"/> 个人 
					<INPUT TYPE="radio" NAME="type" value="2" />店铺
					</td>
				</tr>
			</table>
			<p>
				<INPUT TYPE="submit" value="注    册">
			</p>
			<br> <INPUT type="hidden" name="status" value="1" />
		</FORM>
		<p>
			<a href="login.jsp">登录</a>
		</p>
	</center>
</body>