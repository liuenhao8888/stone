<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../head.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>订单信息</title>
<link href="resource/css/global.css" rel="stylesheet" type="text/css" />
<link href="resource/css/orderInfo.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="resource/js/order.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#payWay").initializePayWay();
				$("#billType").initializeBillType();

				$("#add").click(
						function() {
							$("#orderForm").submit();
							//FF中需要修改配置window.close方法才能有作用，为了不需要用户去手动修改，所以用一个空白页面显示并且让后退按钮失效
							//Opera浏览器旧版本(小于等于12.16版本)内核是Presto，window.close方法有作用，但页面不是关闭只是跳转到空白页面，后退按钮有效，也需要特殊处理
							var userAgent = navigator.userAgent;
							if (userAgent.indexOf("Firefox") != -1
									|| userAgent.indexOf("Presto") != -1) {
								window.location.replace("about:blank");
							} else {
								window.opener = null;
								window.open("", "_self");
								window.close();
							}
						});
			});
</script>
</head>
<body>
	<center>
		<p>订单信息</p>
		<form id="orderForm" action="use/order/add.do" method="POST"
			target="_blank">
			<div class="item">
				<div class="title">收货人信息：</div>
				<div class="content">
					<p>
						收货人：<input name="linkman" type="text" value="" />
					</p>
					<p>
						地址：&nbsp;&nbsp;<input name="address" type="text" value="" />
					</p>
					<p>
						电话：&nbsp;&nbsp;<input name="phone" type="text" value="" />
					</p>
				</div>
			</div>
			<div class="item">
				<div class="title">支付方式:</div>
				<div id="payWay" class="content"></div>
			</div>
			<div class="item">
				<div class="title">发票信息:</div>
				<div class="content">
					<p>
						发票抬头：<input name="billTitle" type="text" value="个人" />
					</p>
					<p>发票内容：
					<div id="billType"></div>
					</p>
				</div>
			</div>
			<div class="item">
				<p>
					订单备注：<input name="remark" type="text" value="" />
				</p>
				<p style="text-align: right; padding-right: 20;">
					支付金额：${sessionScope.cart.getTotalPrice()} <input type="hidden"
						name="total" value="${sessionScope.cart.getTotalPrice()}" /> 
						<input type="hidden" name="status" value="1" />
				</p>
			</div>
			<p>
				<input id="add" type="button" value="提交" />
			</p>
		</form>
	</center>
</body>
</html>

