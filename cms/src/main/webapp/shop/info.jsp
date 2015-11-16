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
 <center>
 <h3>个人资料</h3>
  <FORM METHOD=POST ACTION="auth/user/update.do">
  <table border="1">
  <tr>
  	<td>账号</td>
  	<td>${user.username}</td>
  </tr>
  <tr>
  	<td>邮箱</td>
  	<td>${user.email}</td>
  </tr><tr>
  <td>注册时间</td>
  	<td>${user.time}</td>
  </tr>
  </table>
  <p>
  	<input type="hidden" name="id" value="${user.userId}"/>
<!-- 	<INPUT TYPE="submit" value="修   改"> -->
	</p>
 <br>
 </FORM>
 </center>
 </body>
 
 