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
分类添加
</p>


<FORM METHOD=POST ACTION="category/add.do">
  <table border="1">
  <tr>
  	<td>名称</td>
  	<td><INPUT TYPE="text" NAME="name" value=""></td>
  </tr>
  </table>
  <p>
	<INPUT TYPE="submit" value="添 加">
	</p>
 <br>
 <input type="hidden" name="pid" value="${param.pid==null?0:param.pid}"/>
 <input type="hidden" name="status" value="12"/>
 <input type="hidden" name="userId" value="0"/>
 </FORM>
 </div>
</center>
</body>
</html>