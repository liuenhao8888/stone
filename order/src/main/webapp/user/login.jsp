<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../head.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
    <link href="resource/css/global.css" rel="stylesheet" type="text/css"/>
</head>
<body>
  <hr/>
 <center>
 <h3>${type}登录</h3>
  <FORM METHOD=POST ACTION="login.do">
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
	<input type="hidden" name="url" value="${url}"/>
 <br>
 <p><INPUT TYPE="submit" value="登录"><font color="red">${msg}</font><a href="register.jsp">注册</a></p>
  </FORM>
 </center>
 </body>
 
 