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
区域添加
</p>


<FORM METHOD=POST ACTION="adm/region/add.do">
  <table border="1">
  <tr>
  	<td>ID</td>
  	<td>${region.id}</td>
  </tr>
  <tr>
  	<td>名称</td>
  	<td><INPUT TYPE="text" NAME="prename" value=""></td>
  </tr>
   <tr>
  	<td>字母编码</td>
  	<td><INPUT TYPE="text" NAME="cname" value=""></td>
  </tr>
  <tr>
  	<td>区域编码</td>
  	<td><INPUT TYPE="text" NAME="areacode" value=""></td>
  </tr>
  </table>
  <p>
	<INPUT TYPE="submit" value="添 加">
	</p>
 <br>
 <input type="hidden" name="grade" value="${region.grade}"/>
 <input type="hidden" name="id" value="${region.id}"/>
 <input type="hidden" name="parentid" value="${region.parentid}"/>
 <input type="hidden" name="isleaf" value="${region.isleaf}"/>
 </FORM>
 </div>
</center>
</body>
</html>