<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../head.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link href="css/global.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<center>
	<%@ include file="menu.jsp"%>
		<div id="right">
<h2>用户管理</h2>
<table style="width:80%;" border="1" style="text-align:center">
<tr><td>账号</td><td>邮箱</td><td>注册时间</td><td>opt</td></tr>
<c:forEach var="user" items="${users}">
<tr>
<td>${user.username}</td>
<td>${user.email}</td>
<td>${user.time}</td>
<td><a href="#">opt</a></td>
</tr>
</c:forEach>
</table>
</div>
</center>
 </body>
 
 