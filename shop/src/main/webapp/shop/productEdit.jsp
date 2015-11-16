<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../head.jsp" %>
<%@page import="com.stone.base.system.SystemConstants"%>                
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"src="resource/js/template.js"></script>
<script type="text/javascript"src="resource/js/descartes.js"></script>
<link href="resource/css/shop-right.css" rel="stylesheet" type="text/css" />
<script>
$(document).ready( function() {
	var fileCount = 0;
	$("#addFile").click(function() {
				var s = '<tr id="tr'+fileCount+'"><td><input  name="files" type="file"/></td><td><input id="'+fileCount+'" type="button" value="删除"  class="delFile"/></td></tr>';
				$("#uploadTable").append(s);
				fileCount++;
	});
	$(".delFile").live('click', function() {
		var id = $(this).attr("id");
		$("#tr" + id).remove();
	});
	
	//渲染商品图片
	var renderImgs = function(imgs){
		if(imgs.length==0)return;
		var imgArr = imgs.split(";");
	 	var html = '';
		for(i in imgArr){
			var imgUrl = "<%=SystemConstants.uploadPath %>"+imgArr[i];
			html += '<tr id="tr'+fileCount+'"><td width=30%><img width="100" onclick="javascript: location.href=" height="80" src="'+imgUrl+ '"/></td><td>'+
			'<input id="'+fileCount+'" type="button" value="删除"  class="delFile"/><input type="hidden" name="imgList" value="'+imgArr[i]+'"/></td></tr>';
			fileCount++;
		}
		$("#uploadTable").append(html);
	}
	renderImgs("${product.imgs}");
	
	
	var maxValueOrder = ${maxValueOrder};
	//渲染扩展属性
	var renderTmps = function(items){
	 	var html = "<table border='1' width='500'>";
		for(i in items){
			var options = $().selectedFormatElement(items[i]);
			html += "<tr><td width=30%>"+items[i].name + "</td><td>"+options+"</td></tr>";
		}
		html += "</table>";
		$("#tmps").html(html);
	}
	var extItems = ${extItems};
	renderTmps(extItems);
	
	
	
	//渲染规格属性
	var renderStds = function(items){
		var stdHtml = "<table border='1' width='500'>";
		var stdTemplates = items[0];
		var stdValues = items[1];
		for(i in stdTemplates){
			var t = stdTemplates[i];
			var values =  new Array();
			for(j in stdValues){
				var val = stdValues[j].values;
				values.push(val.split(",")[i]);
			}
			var options = $().selectedFormatElement4Standard(t,values);
			stdHtml += "<tr><td width=30%>"+ t.name +"</td><td>"+options+"</td></tr>";
		}
		stdHtml += "</table>";
		$("#tmps2").html(stdHtml);
	}
	var stdItems = ${stdItems};
	renderStds(stdItems);
	
	
	
	//渲染规格记录值   库存  价格之类
	var renderStdContent = function(stdValues){
		var map = new Object();
		$("input[name^='std']").each(function(){
			var name = $(this).attr("name");
			var valueOrder = $(this).attr("vo");
			var obj = new Object();
			var val = $(this).val();
			obj.templateId = name.substring(3);
			obj.value = val;
			obj.valueOrder = valueOrder;
			var item = [obj];
			var checked = $(this).attr("checked");
			var items = map[name];
			if(checked){
				if(items==null){
					map[name] = new Array();
				}
				map[name].push(item);
			}
		});
		var typesHtml = "<table border='1'>";
		var records = Descartes.descartes(map);
		if(records==null){
			$("#stds").html("");
			return;
		}
		for(var i=0;i<records.length;i++){
			var std = 'stdList['+i+']';
			var arr = records[i];
			typesHtml += '<tr>';
			var valueArr = new Array();
			for(var j=0;j<arr.length;j++){
				valueArr[arr[j].valueOrder-1] = arr[j].value;
				typesHtml += '<td>'+arr[j].value+'</td>';
			}
			for(var j=0;j<maxValueOrder;j++){
				if(valueArr[j]==null){
					valueArr[j]="";
				}
			}
			
			var price = 0;
			var stock = 0;
			var id = 0;
			for(j in stdValues){
				var sv = stdValues[j];
				var values = sv.values;
				if(values == valueArr){
					price = sv.price;
					stock = sv.stock;
					id = sv.id;
				}
			}
			typesHtml += '<input type="hidden" name="'+std+'.id" value="'+id+'"/>';
			typesHtml += '<input type="hidden" name="'+std+'.values" value="'+valueArr+'"/>';
			typesHtml += '<td>价格：<input name="'+std+'.price" type="text" value="'+price+'"/></td><td>库存：<input name="'+std+'.stock" type="text" value="'+stock+'"/></td></tr>';
		}
		typesHtml += '</table>';
		$("#stds").html(typesHtml);
	}
	renderStdContent(stdItems[1]);
	
	
	$(".2").live('click', function(){
		var map = new Object();
		$("input[name^='std']").each(function(){
			var name = $(this).attr("name");
			var valueOrder = $(this).attr("vo");
			var obj = new Object();
			var val = $(this).val();
			obj.templateId = name.substring(3);
			obj.value = val;
			obj.valueOrder = valueOrder;
			var item = [obj];
			var checked = $(this).attr("checked");
			var items = map[name];
			if(checked){
				if(items==null){
					map[name] = new Array();
				}
				map[name].push(item);
			}
		});
		var typesHtml = "<table border='1'>";
		var records = Descartes.descartes(map);
		if(records==null){
			$("#stds").html("");
			return;
		}
		
		
		var stdMap = $.getStandardsWithValue();
		
		for(var i=0;i<records.length;i++){
			var std = 'stdList['+i+']';
			var arr = records[i];
			typesHtml += '<tr>';
			var valueArr = new Array();
			for(var j=0;j<arr.length;j++){
				valueArr[arr[j].valueOrder-1] = arr[j].value;
				typesHtml += '<td>'+arr[j].value+'</td>';
			}
			
			for(var j=0;j<maxValueOrder;j++){
				if(valueArr[j]==null){
					valueArr[j]="";
				}
			}
			
			var id = 0;
			var price = 0;
			var stock = 0;
			if(stdMap[valueArr]){
				if(stdMap[valueArr].id){
					id = stdMap[valueArr].id;
				}
				if(stdMap[valueArr].price){
					price = stdMap[valueArr].price;
				}
				if(stdMap[valueArr].stock){
					stock = stdMap[valueArr].stock;
				}
			}
			typesHtml += '<input type="hidden" name="'+std+'.id" value="'+id+'"/>';
			typesHtml += '<input type="hidden" name="'+std+'.values" value="'+valueArr+'"/>';
			typesHtml += '<td class="price">价格：<input name="'+std+'.price" type="text" value="'+price+'"/></td>';
			typesHtml += '<td class="stock">库存：<input name="'+std+'.stock" type="text" value="'+stock+'"/></td></tr>';
		}
		typesHtml += '</table>';
		$("#stds").html(typesHtml);
		
	});
	
	
	$.getStandardsWithValue =function(){
		var stdMap = new Object();
		var arr = $("#myform").serializeArray();
		for(a in arr){
			var o = arr[a];
			var name = o.name;
			var value = o.value;
			if(name==null||name==""||value==null||value=="")
				continue;
			var idRE = new RegExp(".id$");
			var valuesRE = new RegExp(".values$");
			var priceRE = new RegExp(".price$");
			var stockRE = new RegExp(".stock$");
			if(idRE.test(name)){
				var index = name.indexOf(".");
				var stdPrefix = name.substring(0,index);
				if(stdMap[stdPrefix]==null){
					stdMap[stdPrefix] = new Object();
				}
				stdMap[stdPrefix].id = o.value;
			}if(valuesRE.test(name)){
				var index = name.indexOf(".");
				var stdPrefix = name.substring(0,index);
				if(stdMap[stdPrefix]==null){
					stdMap[stdPrefix] = new Object();
				}
				stdMap[stdPrefix].values = o.value;
			}else if(priceRE.test(name)){
				var index = name.indexOf(".");
				var stdPrefix = name.substring(0,index);
				if(stdMap[stdPrefix]==null){
					stdMap[stdPrefix] = new Object();
				}
				stdMap[stdPrefix].price = o.value;
			}else if(stockRE.test(name)){
				var index = name.indexOf(".");
				var stdPrefix = name.substring(0,index);
				if(stdMap[stdPrefix]==null){
					stdMap[stdPrefix] = new Object();
				}
				stdMap[stdPrefix].stock = o.value;
			}
		}
		
		for(var k in stdMap){
			var std = stdMap[k];
			stdMap[std.values] = std;
			delete stdMap[k];
		}
		
		return stdMap;
	}
	
	
	
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


<FORM id="myform" METHOD=POST ACTION="sho/product/update.do" enctype="multipart/form-data">
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
<table id="uploadTable" border="1" width="500">
	<tr>
		<td><input style="display:none;" type="file" name="files">商品图片</td>
		<td><input type="hidden" name="imgList" value=""/>
		<input type="button" id="addFile" value="添加"></td>
	</tr>
</table>
<table border="1" width="500">
	<tr>
		<td>描述</td>
		<td><textarea name="introduction" rows="3" cols="20">${product.introduction}</textarea>
		</td>
	</tr>
</table>
  <div id="tmps">
  </div>
   <div id="tmps2">
  </div>
    <div id="stds">
  </div>
  <p>
	<INPUT id="update" TYPE="submit" value="更新">
	</p>
 <br>
  <input type="hidden" name="shopId" value="${product.shopId}"/>
  <input type="hidden" name="id" value="${product.id}"/>
  <input type="hidden" name="cid" value="${product.cid}"/>
 </FORM>
 </div>
</center>
</body>
</html>