<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../head.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
</head>
<body>
	<center>
	<%@ include file="menu.jsp"%>
		<div id="right">
<h3>类别状态修改</h3>
<FORM METHOD=POST ACTION="adm/catalog/updateStatus.do">
  <table border="1">
  <tr>
  	<td>当前状态</td>
  	<td>
	  	<c:if test="${param.status==0}">0:等待审批</c:if>
		<c:if test="${param.status==1}">1:审批未通过</c:if>
		<c:if test="${param.status==2}">2:审批通过</c:if>
		<c:if test="${param.status==3}">3:前台显示</c:if>
		<c:if test="${param.status==4}">4:取消前台显示</c:if>
  	</td>
  </tr>
   <tr>
  	<td>下一步状态</td>
  	<td>
<c:choose>
   <c:when test="${param.status<2}">
   	<input name="status" type="radio" value="2"/>通过
  		<input name="status" type="radio" value="1" checked="checked" />不通过
   </c:when>
   <c:otherwise>
  		<input name="status" type="radio" value="3"/>显示
  		<input name="status" type="radio" value="4" checked="checked" />不显示
   </c:otherwise>
</c:choose>
  	</td>
  </tr>
  </table>
  <p>
  	<INPUT type="hidden" name="id" value="${param.id}"/>
  	<INPUT type="hidden" name="pid" value="${param.pid}"/>
	<INPUT TYPE="submit" value="确定">
	<INPUT onclick="javascript:history.back();" TYPE="button" value="取消">
	</p>
 <br>
 </FORM>
 </div>
 </center>
</body>
 
 