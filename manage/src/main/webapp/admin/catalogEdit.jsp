<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../head.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
</head>
<body>
	<center>
<h3>信息修改</h3>
<FORM METHOD=POST ACTION="adm/catalog/update.do">
  <table border="1">
  <tr>
  	<td>类别名称</td>
  	<td><INPUT TYPE="text" NAME="name" value="${catalog.name}" size="50"></td>
  </tr>
  </table>
  <p>
  	<INPUT type="hidden" name="pid" value="${catalog.pid}"/>
  	<INPUT type="hidden" name="id" value="${catalog.id}"/>
	<INPUT TYPE="submit" value="修改">
	</p>
 <br>
 </FORM>
 </center>
</body>
 
 