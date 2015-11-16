<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../head.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link href="resource/css/global.css" rel="stylesheet" type="text/css"/>
    <link href="resource/css/user-orders.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
	$(document).ready(function() {
		$("#account").click(function(){
			location.href="front/orderInfo.jsp";
			
		});
	});
</script>
</head>
<body>
 <hr/>
 <center>
 	<%@ include file="menu.jsp"%>
		<div id="right">
			<h3>我的购物车</h3>
			<form name="productForm" action="" method="POST">
		<table border="1" cellspacing="0">
			<tr bgcolor="#CCCCCC">
				<td>id</td>
				<td>名称</td>
				<td>单价</td>
				<td>数量</td>
			</tr>
			<c:forEach var="item" varStatus="s" items="${sessionScope.cart.items}">
				<tr>
				<td>${item.product.id} </td>
				<td>${item.product.title}</td>
				<td>${item.product.price}</td>
				<td>${item.count}</td>
			</tr>
		</c:forEach>
		</table>
		<p>
			总价：${sessionScope.cart.getTotalPrice()}
		</p>
		
		<p>
			<input type="button" value="继续购物" onclick="history.back(-1);" />
			<input id="account" type="button" value="去结算" />
		</p>
	</form>
		</div>
 </center>
 </body>
 
 