<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="com.stone.base.system.*"%>
<%@ include file="head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>商品列表</title>
<link href="resource/css/global.css" rel="stylesheet" type="text/css" />
<link href="resource/css/productList.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript">
	$(document).ready(function() {

	});
</script>
</head>
<body style="text-align: center;">
	<center>
		<p>商品列表</p>
		<div id="productList">
			<c:forEach var="o" varStatus="s" items="${list}">
				<div class="product">
					${o.id} ${o.title} ${o.price}
					<script type="text/javascript">
					var uploadPath = "<%=SystemConstants.uploadPath%>";
						var imgs = "${o.imgs} ";
						var imgArr = imgs.split(";");
						var img = uploadPath + imgArr[0];
						document
								.write('<img width="200"; height="100" src="'+img+'">');
					</script>
					<br /> <a
						href="<%=Domain.CART%>/cart_add.do?product.id=${o.id}&count=1">加入购物车</a>
					|| <a href="follow.do?id=${o.id}">收藏</a>
				</div>
			</c:forEach>
		</div>
	</center>

</body>