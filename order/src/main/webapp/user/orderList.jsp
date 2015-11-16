<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../head.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link href="resource/css/global.css" rel="stylesheet" type="text/css"/>
    <link href="resource/css/user-orders.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript"src="resource/js/order.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	});
</script>
</head>
<body>
 <hr/>
 <center>
	<%@ include file="menu.jsp"%>
		<div id="right">
			<h3>我的订单</h3>
			<table border=1;>
<tr><td width="15%">订单号</td><td width="15%">下单时间</td><td>联系人</td><td>金额</td><td>订单状态</td><td>支付状态</td><td>操作</td></tr>
<c:forEach var="o" varStatus="s" items="${list}">
<tr>
<td>
${o.orderId}
</td>
<td>
${o.time}
</td>
<td>
${o.linkman}
</td>
<td>
<span style="font-size:18px;font-weight:bold;color:#ff9955;">${o.total}</span>
<br/>
<span style="font-size:12px;">
<script type="text/javascript">
		document.write($().getPayWay("${o.payWay}"));
</script>
</span>
</td>
<td>
<script type="text/javascript">
		document.write($().getStatus("${o.status}"));
</script>
</td>
<td>
<script type="text/javascript">
		document.write($().getPayStatus("${o.payStatus}"));
</script>
</td>
<td>
<c:if test="${o.status<4&&o.payStatus==0}">
	<a href="use/order/pay.do?orderId=${o.orderId}">支付</a>
</c:if>
<a href="use/order/${o.orderId}.do">查看</a> 
<c:if test="${o.status<4}">
	<a href="use/order/cancel.do?orderId=${o.orderId}">取消</a>
</c:if>
 
</td>
</tr>
</c:forEach>
</table>
		</div>
 </center>
 </body>
 
 