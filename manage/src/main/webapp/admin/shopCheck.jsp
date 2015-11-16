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
	$("#yes").click(function (){
		$("#status").val("1");
		$("#myform").submit();
	});
	
	$("#no").click(function (){
		$("#status").val("2");
		$("#myform").submit();
	});

	
});
</script>
</head>
<body>
<center>
<%@ include file="menu.jsp"%>
		<div id="right">
<p>
店铺审核
</p>


<FORM id="myform" METHOD=POST ACTION="adm/shop/update.do?">
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
  <p>
	<INPUT id="yes" TYPE="button" value="YES">
	<INPUT id="no" TYPE="button" value="NO">
	</p>
 <br>
  <input type="hidden" name="shopId" value="${shop.shopId}"/>
  <input id="status" type="hidden" name="status" value="${shop.status}"/>
 </FORM>
 </div>
</center>
</body>
</html>