<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript"src="resource/js/tuan.js"></script>
    <link href="resource/css/shop-right.css" rel="stylesheet" type="text/css" />
</head>
<body>
<center>

<%@ include file="menu.jsp"%>


<div id="right">
<p>
已删除团购列表
</p>
<table border=1; style="width:90%;table-layout:fixed;">
<tr><td>id</td><td>标题</td><td>价格</td><td>折扣</td><td>销售数量</td><td>开始时间</td><td>结束时间</td><td>状态</td></tr>
<c:forEach var="o" varStatus="s" items="${list}">
<tr>
<td>
${o.id}
</td>
<td>
${o.title}
</td>
<td>
${o.price}
</td>
<td>
${o.discount}
</td>
<td>
${o.salesVolume}
</td>
<td>
${o.startTime}
</td>
<td>
${o.endTime}
</td>
<td>
<script type="text/javascript">
		document.write($().getStatus("${o.status}"));
</script>
</td>
</tr>
</c:forEach>
</table>
</div>
</center>
</body>
</html>