<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../head.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link href="css/global.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h1>注册成功</h1>
	<p>账号 : ${user.username}</p>
	<p>密码 : ${user.password}</p>
	<p><a href="user/find.do">个人信息</a></p>
 </body>
 
 