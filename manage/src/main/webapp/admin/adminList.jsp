<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../head.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link href="css/global.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h3>管理员列表</h3>
<a href="admin/admAdd.jsp">添加管理员</a>
<table border=1;>
<tr><td width=15%>账号</td><td width=15%>密码</td><td width=30%>邮箱</td><td width=30%>注册时间</td><td width=10%>opt</td></tr>
<c:forEach var="adm" items="${admins}">
<tr>
<td>${adm.username}</td>
<td>${adm.password}</td>
<td>${adm.email}</td>
<td>${adm.time}</td>
<td><a href="adm/delete/${adm.id}.do">delete</a></td>
</tr>
</c:forEach>
</table>
 </body>
 
 