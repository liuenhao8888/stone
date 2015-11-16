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
<h3>信息修改</h3>
<FORM METHOD=POST ACTION="adm/site/update.do">
  <table border="1">
  <tr>
  	<td>网站名称</td>
  	<td><INPUT TYPE="text" NAME="name" value="${site.name}" size="50"></td>
  </tr>
   <tr>
  	<td>网站链接</td>
  	<td><INPUT TYPE="text" NAME="url" value="${site.url}" size="50"></td>
  </tr>
  </table>
  <p>
  	<INPUT type="hidden" name="cid" value="${site.cid}"/>
  	<INPUT type="hidden" name="id" value="${site.id}"/>
	<INPUT TYPE="submit" value="修改">
	</p>
 <br>
 </FORM>
 </center>
</body>
 
 