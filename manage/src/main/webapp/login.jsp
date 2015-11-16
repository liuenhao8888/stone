<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<link href="resource/css/global.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	$(document).ready(function() {
		$("input[type='text']").focus(function() {
			$("#msg").html("");
		});

	});
</script>
</head>
<body>
	<center>
	<h3>管理员登录</h3>
	<FORM METHOD=POST action="admLogin.do">
		<table border="1">
			<tr>
				<td>账号</td>
				<td><INPUT TYPE="text" NAME="username" value=""></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><INPUT TYPE="password" NAME="password" value=""></td>
			</tr>
		</table>
		<input type="hidden" name="url" value="${url}" /> <br>
		<p>
			<INPUT TYPE="submit" value="登录"><font color="red">${msg}</font>
		</p>
	</FORM>
</center>
</body>