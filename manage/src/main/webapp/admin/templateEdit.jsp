<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"src="resource/js/template.js"></script>
<script>
$(document).ready( function() {
	
	$("#format").initializeProptiesFormat();
	$().registerEvent();
	$("#format").selectedFormat("${template.format}");
	$(".options").initializeSelected("${template.options}");
	if("${template.type}"==2){
		$("#format").hide();
	}
	

	
});
</script>
</head>
<body>
<center>
<%@ include file="menu.jsp"%>
		<div id="right">
<p>
属性编辑
</p>


<FORM METHOD=POST ACTION="adm/template/update.do">
  <table border="1">
  <tr>
  	<td>名称</td>
  	<td><INPUT TYPE="text" NAME="name" value="${template.name}"></td>
  </tr>
   <tr>
  	<td>类型</td>
  	<td>
  	<p>
  		<select id="format" name="format">
  		</select>
  	</p>
  	<div id="content" style="display:none;">
  		<p>
  		<span>选项</span>
  		</p>
  		<div class="options">
  		</div>
  		<p>
  		<INPUT id="add" TYPE="button" value="添加">
  		</p>
  	</div>
  	</td>
  </tr>
  </table>
  <p>
	<INPUT TYPE="submit" value="确定">
	</p>
 <br>
  <input type="hidden" name="id" value="${template.id}"/>
  <input type="hidden" name="categoryId" value="${template.categoryId}"/>
  <input type="hidden" name="status" value="${template.status}"/>
  <input type="hidden" name="order" value="${template.order}"/>
  <input type="hidden" name="type" value="${template.type}"/>
 </FORM>
 </div>
</center>
</body>
</html>