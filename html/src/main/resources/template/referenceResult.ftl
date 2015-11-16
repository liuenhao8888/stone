<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>检测结果</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css"  href="../../enterprise/resource/css/css.css">
  </head>
  
  <body>
  <div class="qugan" >
   <div class="wxm" style="font-size:12px;">
   		　文献名：${doc.name}&nbsp;
		 	作者：${doc.author}
		 	&nbsp;&nbsp;&nbsp;&nbsp;
		 	检测时间：${(vo.detectTime)!""}
   		</div>
		 <div class="wxm" style="font-size:12px;">
		 <span style="float:left">
   		　　引用率 <font color="green"; style="line-height: 28px; font-size: 12px">
		${vo.refRate*100} %</font>
   		，共有<font color="green">${vo.referenceNum}</font>处引用</span>
	　	
		 </div>
   		
   		 <div class="wxm" style="font-size:12px;">
   		　　如有未被识别的引用，可能会影响检测结果，请用[]{}做为引用标识修改后可再次检测
   		 </div>
   		
   		<div class="gdwl">
	   
	     <div class="gd2">
        
		         <#list vo.tempReferenceList as r>	
		         	<div style="width:96%;border:1px solid #D6E6F8; margin-top:1px; background-color: #FFFFFF">
				         <div style="width:4%; font-weight:bold; float:left; padding-top:5px   "> </div>
				         <div  style="width:96%;color:#000000; line-height:150%; text-decoration:none; float:left; background-color:#D6E6F8">${r}</div>
		        	 </div>
		      </#list> 
				  
		   </div>
	   </div>	
   	   </div>
  </body>
</html>
