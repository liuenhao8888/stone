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
<h3>
<c:choose>
   <c:when test="${param.pid==0}">
   	添加一级类别
   </c:when>
   <c:otherwise>
  	添加二级类别
   </c:otherwise>
</c:choose>
</h3>
<FORM METHOD=POST ACTION="adm/catalog/add.do">
  <table border="1">
  <tr>
  	<td>类别名称</td>
  	<td><INPUT TYPE="text" NAME="name" value="" size="50"></td>
  </tr>
  </table>
  <p>
  	<INPUT type="hidden" name="pid" value="${param.pid}"/>
	<INPUT TYPE="submit" value="添加">
	</p>
 <br>
 </FORM>
 </center>
</body>
 
 