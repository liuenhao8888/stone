<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"src="js/template.js"></script>
<script>
$(document).ready( function() {
	$("#type").initializeProptiesType();
	$().registerEvent();
	
});
</script>
</head>
<body>
<center>
<p>
店铺注册
</p>


<FORM METHOD=POST ACTION="register.do">
  <table border="1">
  <tr>
  	<td>名称</td>
  	<td><INPUT TYPE="text" NAME="name" value=""></td>
  </tr>
   <tr>
  	<td>联系人</td>
  	<td><INPUT TYPE="text" NAME="contact" value=""></td>
  </tr>
   <tr>
  	<td>电话</td>
  	<td><INPUT TYPE="text" NAME="phone" value=""></td>
  </tr>
   <tr>
  	<td>地址</td>
  	<td><INPUT TYPE="text" NAME="address" value=""></td>
  </tr>
  </table>
  <p>
	<INPUT TYPE="submit" value="添 加">
	</p>
 <br>
 <input type="hidden" name="status" value="0"/>
 <input type="hidden" name="userId" value="0"/>
 <input type="hidden" name="siteId" value="0"/>
 </FORM>
</center>
</body>
</html>