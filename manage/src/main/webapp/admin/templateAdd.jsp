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
	$("#type1").click(function(){
		$("#format").selectedFormat(1);
		$("#format").show();
		$("#ckbox").hide();
		$("#content").hide();
	});
	
	$("#type2").click(function(){
		$("#format").selectedFormat(4);
		$("#format").hide();
		$("#ckbox").show();
	});
	
});
</script>
</head>
<body>
<center>
<%@ include file="menu.jsp"%>
		<div id="right">
<p>
属性添加
</p>


<FORM METHOD=POST ACTION="adm/template/add.do">
  <table border="1">
  <tr>
  	<td>属性类型</td>
  	<td>
  	<INPUT id="type1" TYPE="radio" NAME="type" value="1" checked="checked">普通属性
  	<INPUT id="type2" TYPE="radio" NAME="type" value="2">规格属性
  	</td>
  </tr>
  <tr>
  	<td>名称</td>
  	<td><INPUT TYPE="text" NAME="name" value=""></td>
  </tr>
  <tr>
  	<td>文本格式</td>
  	<td>
  	<p>
  	<span id="ckbox" style="display:none;">checkbox</span>
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
	<INPUT TYPE="submit" value="添 加">
	</p>
 <br>
 <input type="hidden" name="categoryId" value="${param.categoryId==null?0:param.categoryId}"/>
 <input type="hidden" name="status" value="0"/>
 <input type="hidden" name="order" value="0"/>
 <input type="hidden" name="valueOrder" value="0"/>
 </FORM>
 </div>
</center>
</body>
</html>