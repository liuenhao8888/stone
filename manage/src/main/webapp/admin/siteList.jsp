<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.stone.base.system.Status"%>
<%@ include file="../head.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script type="text/javascript">
		$(document).ready( function() {
			$("#ok").click(function(){
				var isOK = true;
				$(".pri").each(function(){
					var p = $(this).val();
					if(isNaN(p)){
						isOK = false;
						return false;
					}
				});
				if(isOK){
					$("#myform").attr("action","adm/site/updatePris.do");
					$("#myform").submit();
				}else{
					$("#tip").text("优先级不能为非数字！");
				}
			});
			$(".pri").focus(function(){
				$("#tip").text("");
			});
		});
    </script>
</head>
<body>
<h3>网站列表</h3>
<a href="admin/siteAdd.jsp?cid=${cid}">添加网站</a>
 <FORM id="myform" METHOD=POST ACTION="">
<table border=1; style="width:80%;table-layout:fixed;">
<tr><td width=10%>优先级</td><td width=20%>名称</td><td width=25%>链接</td><td width=5%>状态</td><td width=30%>加入时间</td><td width=10%>opt</td></tr>
<c:forEach var="site" varStatus="s" items="${list}">
<tr>
<td>
<input name="sites[${s.index}].priority" class="pri" type="text" value="${site.priority}"/>
<input name="sites[${s.index}].id" type="hidden" value="${site.id}"/>
</td>
<td>${site.name}</td>
<td>${site.url}</td>
<td>${site.status}</td>
<td>${site.time}</td>
<td>
<a href="adm/site/del/${cid}/${site.id}.do">del</a>
||
<a href="adm/site/forEdi/${cid}/${site.id}.do">edi</a>
</td>
</tr>
</c:forEach>
</table>
<c:if test="${!empty list}">
<p>
<input name="cid" type="hidden" value="${cid}"/>
<input id="ok" type="button" value="确定"/>
<span id="tip" style="color:red;"></span>
</p>
</c:if>
</FORM>
 </body>
 
 