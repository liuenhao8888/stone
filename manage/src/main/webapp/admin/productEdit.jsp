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
	var renderTmps = function(items){
	 	var html = "<table border='1' width='500'>";
		for(i in items){
			html += "<tr><td width=30%>"+items[i].name + "</td><td>"+$().selectTypeElement(items[i].template_id,items[i].type,items[i].options,items[i].value)+"</td></tr>";
		}
		html += "</table>";
		$("#tmps").html(html);
	}
	var items = ${items};
	renderTmps(items);
	
// 	$("#update").click(function(){
// 		alert(1);
// 	});
	
});
</script>
</head>
<body>
<center>
<%@ include file="menu.jsp"%>
		<div id="right">
<p>
商品编辑
</p>


<FORM id="myForm" METHOD=POST ACTION="sho/goods/update.do">
  <table border='1' width='500'>
  <tr>
  	<td width=30%>名称</td>
  	<td><INPUT TYPE="text" NAME="title" value="${product.title}"></td>
  </tr>
   <tr>
  	<td>价格</td>
  	<td><INPUT TYPE="text" NAME="price" value="${product.price}"></td>
  </tr>
  </table>
  <div id="tmps">
  </div>
  <p>
	<INPUT id="update" TYPE="submit" value="更新">
	</p>
 <br>
  <input type="hidden" name="shopId" value="${product.shopId}"/>
  <input type="hidden" name="id" value="${product.id}"/>
 </FORM>
 </div>
</center>
</body>
</html>