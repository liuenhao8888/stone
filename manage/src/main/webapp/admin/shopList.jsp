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
店铺列表
</p>

<p>
<a href="admin/shopAdd.jsp">添加</a>
</p>
<table border=1; width="700">
<tr><td>id</td><td>名称</td><td>状态</td><td>联系人</td><td>电话</td><td>地址</td><td>申请会员</td><td>所属分站</td><td>edit || del</td><td>审核</td></tr>
<c:forEach var="o" varStatus="s" items="${list}">
<tr>
<td>
${o.shopId}
</td>
<td>
${o.name}
</td>
<td>
${o.status}
</td>
<td>
${o.contact}
</td>
<td>
${o.phone}
</td>
<td>
${o.address}
</td>
<td>
${o.userId}
</td>
<td>
${o.siteId}
</td>
<td>
<a href="adm/shop/get4Edit.do?shopId=${o.shopId}">edit</a> || <a href="adm/shop/del.do?shopId=${o.shopId}">del</a>
</td>
<td>
<a href="adm/shop/get4Check.do?shopId=${o.shopId}">审核</a>
</td>

</tr>
</c:forEach>
</table>
</div>
</center>
</body>
</html>