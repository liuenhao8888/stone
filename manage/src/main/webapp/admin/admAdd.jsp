<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../head.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
</head>
<body>
 <hr/>
 
  <FORM METHOD=POST ACTION="adm/add.do">
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
  </table>
  <p>
	<INPUT TYPE="submit" value="添   加">
	</p>
 <br>
 </FORM>
 </body>
 
 