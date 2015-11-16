<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../head.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>订单信息确认</title>
<link href="resource/css/global.css" rel="stylesheet" type="text/css" />
<link href="resource/css/orderInfo.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"src="resource/js/order.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#payWay").setPayWay("${order.payWay}");
		$("#billType").setBillType("${order.billType}");
		$("#pay").click(function(){
			$("#orderForm").submit();
			
		});
		$("#orderList").click(function(){
			location.href = "use/order/list.do";
		});
	});
</script>
</head>
<body>
	<center>
	<form id="orderForm" action="use/order/pay.do" method="POST">
		<p>订单编号：${order.orderId}</p>
			<div class="item">
				<div class="title">收货人信息：</div>
				<div class="content">
				<p>
					收货人：${order.linkman}
				</p>
				<p>
					地址：&nbsp;&nbsp;${order.address}
				</p>
				<p>
					电话：&nbsp;&nbsp;${order.phone}
				</p>
				</div>
			</div>
			<div class="item">
				<div class="title">支付方式:</div>
				<div id="payWay" class="content">
				</div>
			</div>
			<div class="item">
				<div class="title">发票信息:</div>
				<div class="content">
					<p>
						发票抬头：${order.billTitle}
					</p>
					<p>
						发票内容：
						<div id="billType"></div> 
					</p>	
				</div>
			</div>
			<div class="item">
				<p>
					订单备注：${order.remark}
				</p>
				<p style="text-align:right;padding-right:20;">
					支付金额：${order.total}
				</p>
			</div>
			<p>
	<c:choose>
            <c:when test="${order.payWay==1}">
            	<input id="pay" type="button" value="去支付" />
            </c:when>
            <c:otherwise>
            	<input id="orderList" type="button" value="订单中心" />
            </c:otherwise>
	</c:choose> 
			</p>
		</form>
	</center>
</body>
</html>

