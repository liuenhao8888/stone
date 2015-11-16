<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<%@ include file="menu.jsp"%>
		<div id="right">
<p>
类别编辑
</p>


<FORM METHOD=POST ACTION="adm/category/update.do">
  <table border="1">
  <tr>
  	<td>ID</td>
  	<td>${category.id}</td>
  </tr>
  <tr>
  	<td>名称</td>
  	<td><INPUT TYPE="text" NAME="name" value="${category.name}"></td>
  </tr>
  </table>
  <p>
	<INPUT TYPE="submit" value="确定">
	</p>
 <br>
  <input type="hidden" name="pid" value="${category.pid}"/>
  <input type="hidden" name="id" value="${category.id}"/>
 </FORM>
 </div>
</center>
</body>
</html>