<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品图片上传</title>
<script type="text/javascript">
	i = 1;
	$(document).ready(function(){
		
		$("#btn_add").click(function(){
			document.getElementById("newUpload").innerHTML+='<div id="div_'+i+'"><input  name="files" type="file"  /><input type="button" value="删除"  onclick="del('+i+')"/></div>';
			  i = i + 1;
		});
		
	});

	function del(o){
	 document.getElementById("newUpload").removeChild(document.getElementById("div_"+o));
	}
	

</script>
</head>
<body>
<hr/>
 	 <h3>商品图片上传</h3> 
 	<form name="myform" action="file/upload.do" enctype="multipart/form-data" method="post">
 		<div id="newUpload">
			<input type="file" name="files">
		</div>
		<input type="button" id="btn_add" value="添加" >
		<input type="submit" value="上传" >
		
		
 	</form> 
</body>
</html>