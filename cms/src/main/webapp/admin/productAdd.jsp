<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="resource/css/goods.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript"src="resource/js/template.js"></script>
<script>
$(document).ready( function() {
	
	$("#ctgBtn").click(function(){
		$("#ctgDiv").show();
		loadCtgItems(0);
	});
	
	var loadCtgItems = function(pid){
		$.get("category/list.do?pid="+pid, null, function (items){
			renderCtgItems(items);
		});
	}
	
	var renderCtgItems = function(items){
		 	var html = "";
			for(i in items){
				if(i%4==0){
					html += "<br/>";
				}
				html += "<div class='ctgItem' id='"+items[i].id+"' pid='"+items[i].pid+"'>"+items[i].name + "</div>";
			}
			$("#ctgDivItems").html(html);
	}
	
	var renderTmps = function(items){
	 	var html = "<table border='1' width='500'>";
		for(i in items){
			html += "<tr><td width=30%>"+items[i].name + "</td><td>"+$().createTypeElement(items[i].id,items[i].type,items[i].options)+"</td></tr>";
		}
		html += "</table>";
		$("#tmps").html(html);
	}
	
	$(".ctgItem").live('click', function(){
		var o = $(this);
		var pid = o.attr("id");
		$.get("category/list.do?pid="+pid, null, function (items){
			if(items.length>0){
				renderCtgItems(items);
			}else{
				$.get("template/getByCid.do?cid="+pid, null, function (items){
					renderTmps(items);
					$("#ctgName").text(o.text());
					$("#ctgId").val(pid);
				});
			}
		});
		
	});
	
	$("#ctgDivBack").live('click', function(){
		$(".ctgItem").each(function(){
			var pid = $(this).attr("pid");
			$.get("category/listSibling.do?id="+pid, null, function (items){
				if(items.length>0){
					renderCtgItems(items);
				}
			});
			 return false;
		});
	});
	
	$("#ctgDivCancel").click(function(){
		$("#ctgDiv").hide();
	});
	
	
});
</script>
</head>
<body>
<center>
<%@ include file="menu.jsp"%>
		<div id="right">
<p>
商品添加
</p>

<div id="ctgDiv">
<div id="ctgDivItems"></div>
<span id='ctgDivBack'>返回</span><span id='ctgDivCancel'>取消</span>
</div>

<FORM METHOD=POST ACTION="sho/goods/add.do">
  <table border="1" width="500">
   <tr>
  	<td width=30%>类别</td>
  	<td>
  		<span id="ctgName"></span>
  	   <INPUT id="ctgBtn" TYPE="button" value="选择">
  	
  	</td>
  </tr>
  <tr>
  	<td>名称</td>
  	<td><INPUT TYPE="text" NAME="title" value=""></td>
  </tr>
   <tr>
  	<td>价格</td>
  	<td><INPUT TYPE="text" NAME="price" value=""></td>
  </tr>
  </table>
  <div id="tmps">
  </div>
  <p>
	<INPUT TYPE="submit" value="添 加">
	</p>
 <br>
 <input type="hidden" name="status" value="0"/>
 <input type="hidden" name="shopId" value="0"/>
 <input id="ctgId" type="hidden" name="cid" value="0"/>
 </FORM>
 </div>
</center>
</body>
</html>