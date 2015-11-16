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
					$("#myform").attr("action","adm/catalog/updatePris.do");
					$("#myform").submit();
				}else{
					$("#tip").text("优先级不能为非数字！");
				}
			});
			$(".pri").focus(function(){
				$("#tip").text("");
			});
			
			
			$(".del").click(function(){
				var id = $(this).attr("id");
				var url = "adm/catalog/jsonList/"+id+".do";
				if("${pid}">0)
					url = "adm/site/jsonList/"+id+".do";
				$.post(url,null,function(data){
					var length = data["length"];
					if(length>0){
						alert("请先删除本类子级数据!");
						return ;
					}
					location.href="../../../adm/catalog/del/${pid}/"+id+".do"
 			 	},"json");
			});
			
		});
    </script>
</head>
<body>
<h3>
<c:choose>
   <c:when test="${pid==0}">
   	一级类别列表
   </c:when>
   <c:otherwise>
  	二级类别列表
   </c:otherwise>
</c:choose>
</h3>
<a href="admin/catalogAdd.jsp?pid=${pid}">添加</a>
 <FORM id="myform" METHOD=POST ACTION="">
<table border=1;>
<tr><td width=5%>优先级</td><td width=20%>类别</td><td width=15%>状态</td><td width=20%>加入时间</td><td width=10%>opt</td></tr>
<c:forEach var="catalog" varStatus="s" items="${list}">
<tr>
<td>
<input name="catalogs[${s.index}].priority" class="pri" type="text" value="${catalog.priority}"/>
<input name="catalogs[${s.index}].id" type="hidden" value="${catalog.id}"/>
</td>
<td>
 <c:choose>
   <c:when test="${pid==0}">
   <a href="adm/catalog/list/${catalog.id}.do">${catalog.name}</a>
   </c:when>
   <c:otherwise>
      <a href="adm/site/list/${catalog.id}.do">${catalog.name}</a>
   </c:otherwise>
</c:choose>
</td>
<td>
<a href="admin/ctgStatusEdit.jsp?pid=${catalog.pid}&id=${catalog.id}&status=${catalog.status}">
	<c:if test="${catalog.status==0}">0:等待审批</c:if>
	<c:if test="${catalog.status==1}">1:审批未通过</c:if>
	<c:if test="${catalog.status==2}">2:审批通过</c:if>
	<c:if test="${catalog.status==3}">3:前台显示</c:if>
	<c:if test="${catalog.status==4}">4:取消前台显示</c:if>
</a>
</td>
<td>${catalog.time}</td>
<td>
<a class="del" id="${catalog.id}" href="javascript:void(0);">del</a>
||
<a href="adm/catalog/forEdi/${pid}/${catalog.id}.do">edi</a>
</td>
</tr>
</c:forEach>
</table>
<p>
<input name="pid" type="hidden" value="${pid}"/>
<input id="ok" type="button" value="确定"/>
<span id="tip" style="color:red;"></span>
</p>
</FORM>
 </body>
 
 