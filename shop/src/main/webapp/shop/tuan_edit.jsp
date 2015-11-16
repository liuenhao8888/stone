<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"src="resource/js/template.js"></script>
<script type="text/javascript"src="resource/js/tuan.js"></script>
<link href="resource/css/shop-right.css" rel="stylesheet" type="text/css" />
<script>
$(document).ready( function() {
	var status = "${tuan.status}";
	$("#statusSpan").initializeStatus(status);
	
});
</script>
</head>
<body>
<center>

<%@ include file="menu.jsp"%>


<div id="right">
<p>
商品编辑
</p>


<FORM id="myForm" METHOD=POST ACTION="sho/tuan_edit.do">
 <table border="1" width="500">
  <tr>
  	<td>标题</td>
  	<td><INPUT TYPE="text" NAME="title" value="${tuan.title}"></td>
  </tr>
   <tr>
  	<td>价格</td>
  	<td><INPUT TYPE="text" NAME="price" value="${tuan.price}"></td>
  </tr>
  <tr>
  	<td>折扣</td>
  	<td><INPUT TYPE="text" NAME="discount" value="${tuan.discount}"><span>(0-100直接的整数)</span></td>
  </tr>
   <tr>
  	<td>开始时间</td>
  	<td><INPUT TYPE="text" NAME="startTime" value="${tuan.startTime}"></td>
  </tr><tr>
  	<td>结束时间</td>
  	<td><INPUT TYPE="text" NAME="endTime" value="${tuan.endTime}"></td>
  </tr>
  <tr>
  	<td>状态</td>
  	<td><span id="statusSpan"></span></td>
  </tr>
  </table>
  <div id="tmps">
  </div>
  <p>
	<INPUT id="update" TYPE="submit" value="更新">
	</p>
 <br>
  <input type="hidden" name="id" value="${tuan.id}"/>
 </FORM>
 </div>
</center>
</body>
</html>