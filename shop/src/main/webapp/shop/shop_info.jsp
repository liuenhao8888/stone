<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
$(document).ready( function() {
	$("#type").initializeProptiesType();
	$().registerEvent();
	
});
</script>
</head>
<body>
<center>
<%@ include file="menu.jsp"%>
		<div id="right">
<p>
店铺信息
</p>
  <table border="1">
   <tr>
  	<td>名称</td>
  	<td>${shop.name}</td>
  </tr>
   <tr>
  	<td>联系人</td>
  	<td>${shop.contact}</td>
  </tr>
   <tr>
  	<td>电话</td>
  	<td>${shop.phone}</td>
  </tr>
   <tr>
  	<td>地址</td>
  	<td>${shop.address}</td>
  </tr>
  </table>
 <br>
 </div>
</center>
</body>
</html>