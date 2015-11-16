<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<title>Insert title here</title>
</head>
<body>
<center>
<%@ include file="menu.jsp"%>
		<div id="right">
<p>
${region.grade+1}级区域列表
</p>

<p>
<a href="adm/region/getPrecode.do?grade=${region.grade}&id=${region.id}">添加</a>
<a href="adm/region/list.do?grade=0">首级</a>
</p>
<table border=1;>
<tr><td>ID</td><td>名称</td><td>字母编码</td><td>区域编码</td><td>级别</td><td>edit || del</td><td>进入</td></tr>
<c:forEach var="region" varStatus="s" items="${list}">
<tr>
<td>
${region.id}
</td>
<td>
${region.prename}
</td>
<td>
${region.cname}
</td>
<td>
${region.areacode}
</td>
<td>
${region.grade}
</td>
<td>
<a href="adm/region/get4Edit.do?id=${region.id}">edit</a> || <a href="adm/region/del.do?id=${region.id}&grade=${region.grade}">del</a>
</td>
<td>
<c:choose>
   <c:when test="${region.grade==4}">
   	进入
   </c:when>
   <c:otherwise>
  	<a href="adm/region/sublist.do?id=${region.id}&grade=${region.grade}">进入</a>
   </c:otherwise>
</c:choose>
</td>
</tr>
</c:forEach>
</table>
</div>
</center>
</body>
</html>