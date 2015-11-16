<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resource/js/template.js"></script>
<script>
$(document).ready( function() {
	
	$.doDel = function(id,ctgId,type,vo){ alert("不能删除，只能修改或选择是否启用");
// 		$("#id").val(id);
// 		$("#categoryId").val(ctgId);
// 		$("#type").val(type);
// 		$("#valueOrder").val(vo);
// 		$("#myform").submit();
	}
	
});
</script>
</head>
<body>
	<center>
		<%@ include file="menu.jsp"%>
		<div id="right">
			<p>属性列表</p>

			<p>
				<a href="admin/templateAdd.jsp?categoryId=${template.categoryId}">添加</a>
				<a href="adm/category/list4template.do?pid=0">类别</a>
			</p>
			<table border=1;>
				<tr>
					<td>id</td>
					<td>类别</td>
					<td>名称</td>
					<td>状态</td>
					<td>顺序</td>
					<td>文本格式</td>
					<td>选项</td>
					<td>属性类型</td>
					<td>edit <!-- || del  --></td>
				</tr>
				<c:forEach var="t" varStatus="s" items="${list}">
					<tr>
						<td>${t.id}</td>
						<td>${t.categoryId}</td>
						<td>${t.name}</td>
						<td>${t.status}</td>
						<td>${t.order}</td>
						<td><script type="text/javascript">
		document.write($().getFormat("${t.format}"));
</script></td>
						<td>${t.options}</td>
						<td><script type="text/javascript">
		document.write($().getType("${t.type}"));
</script></td>
						<td><a href="adm/template/get4Edit.do?id=${t.id}">edit</a> 
						<!-- 
						||
							<a class="del"
							onclick="$.doDel(${t.id},${t.categoryId},${t.type},${t.valueOrder});"
							href="javascript:;">del</a>
							 -->
							</td>
					</tr>
				</c:forEach>
			</table>
			<form id="myform" action="adm/template/del.do" method="post">
				<input id="id" type="hidden" name="id" value="" /> <input
					id="categoryId" type="hidden" name="categoryId" value="" /> <input
					id="type" type="hidden" name="type" value="" /> <input
					id="valueOrder" type="hidden" name="valueOrder" value="" />
			</form>
		</div>
	</center>
</body>
</html>