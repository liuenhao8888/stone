<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<%@ include file="menu.jsp"%>
		<div id="right">
<p>
商品列表
</p>

<p>
<a href="goods/goodsAdd4shop.jsp">添加</a>
</p>
<table border=1; style="width:80%;table-layout:fixed;">
<tr><td>id</td><td>类别ID</td><td>名称</td><td>价格</td><td>时间</td><td>状态</td><td>edit || del</td></tr>
<c:forEach var="o" varStatus="s" items="${list}">
<tr>
<td>
${o.id}
</td>
<td>
${o.cid}
</td>
<td>
${o.title}
</td>
<td>
${o.price}
</td>
<td>
${o.time}
</td>
<td>
${o.status}
</td>
<td>
<a href="adm/product/get4Edit.do?id=${o.id}&shopId=${o.shopId}">edit</a> || <a href="adm/product/del.do?id=${o.id}&shopId=${o.shopId}">del</a>
</td>
</tr>
</c:forEach>
</table>
</div>
</center>
</body>
</html>