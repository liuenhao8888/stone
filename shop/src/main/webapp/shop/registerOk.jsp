<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../head.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link href="css/global.css" rel="stylesheet" type="text/css"/>
</head>
<body>
 <hr/>
<h1>注册成功</h1>
	<p>username : ${user.username}</p>
	<p>password : ${user.password}</p>
	<p><a href="auth/user/find.do">个人信息</a></p>
 </body>
 
 