<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../head.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link href="resource/css/global.css" rel="stylesheet" type="text/css"/>
    <link href="resource/css/user-info.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript"src="resource/js/order.js"></script>
    <script type="text/javascript">
	$(document).ready(function() {
		$("#payWay").setPayWay("${order.payWay}");
		$("#billType").setBillType("${order.billType}");
		$("#back").click(function(){
			location.href="use/order/list.do";
		});
	});
</script>
</head>
<body>
 <hr/>
 <center>
 	<%@ include file="menu.jsp"%>
		<div id="right">
			<h3>订单详情</h3>
			<table border="1">
			<tr>
				<td>订单编号：</td>
				<td>${order.orderId}</td>
			</tr>
			<tr>
				<td>收货人：</td>
				<td>${order.linkman}</td>
			</tr>
			<tr>
				<td>地址：</td>
				<td>${order.address}</td>
			</tr>
			<tr>
				<td>电话：</td>
				<td>${order.phone}</td>
			</tr>
			<tr>
				<td>支付方式:</td>
				<td>
					<div id="payWay" class="content">
					</div>
				</td>
			</tr>
			<tr>
				<td>发票抬头：</td>
				<td>${order.billTitle}</td>
			</tr>
			<tr>
				<td>发票内容：</td>
				<td><div id="billType"></div> </td>
			</tr>
			<tr>
				<td>订单备注：</td>
				<td>${order.remark}</td>
			</tr>
			<tr>
				<td>支付金额：</td>
				<td>${order.total}</td>
			</tr>
			<tr>
				<td>下单时间：</td>
				<td>${order.time}</td>
			</tr>
			<c:if test="${order.status>1}">
			<tr>
				<td>
					<script type="text/javascript">
						document.write($().getStatus("${order.status}"));
					</script>
					时间：
				</td>
				<td>${order.lastTime}</td>
			</tr>
			</c:if>
			</table>
			<p>
				<input id="back" type="button" value="返回" />
			</p>
		</div>
 </center>
 </body>
 
 