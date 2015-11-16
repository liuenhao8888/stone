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
	<script type="text/javascript" src="../../enterprise/resource/js/jquery.js"></script>
	
<style type="text/css">
.lookMe{
	position:relative;
	color:#0099FF;
	cursor:pointer;
}
.lookMe span{
	display:none;
	position:absolute;
	left:50px;
	top:20px;
	padding:5px;
	width:200px;
	color:#CC3300;
	background:#FFFADC;
	border:1px solid #CC6600;
}
</style>

<script>
function lookMe(thisTag){
	var span = thisTag.getElementsByTagName('span')[0];
	
	span.style.display = 'block';
	
	thisTag.onmouseout = function(){
		span.style.display = 'none';
	}
}

</script>
<script LANGUAGE="JavaScript"> 

function openwin( ) {
var str ="${ref}" ;
window.open (str, "newwindow", "height=850, width=750, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no") 
return false;
}

</script>

  </head>
  <body>
  
  <table width="820" border="0" cellspacing="0" cellpadding="0" class="tt">
  
    <tr>
      <td style="float:left">
     <a href="../../enterprise/page/index.jsp"  target="_blank" style="float:left;text-decoration:none; line-height:28px;font-size:12px;color:#000000">&lt;&lt;首页 </a>
       <#if vo.similarityNum==0>
   		<font color="red" style="line-height:28px;font-size:14px;">　　　　　　　　　　由于文本字符编码问题，该文献不能正确识别!</font>
   </#if>
     </td>
    </tr>
</table>
   <div class="qugan" >
 
   		
   		<div class="wxm" style="font-size:12px;">
   		　　文献名：${doc.name}
		作者：${doc.author}
		&nbsp;&nbsp;&nbsp;&nbsp;
	    检测时间：${(vo.detectTime)!""}
   		</div>
   		
   		<div style=" width:796px;text-align:left;margin:auto; margin-top:5px;font-size:12px;font-family:'宋体'; line-height:28px">
			<span style="float:left">　　自写率<font color="green";font-size:12px;font-family:'宋体'; line-height:28px>
		${vo.ownWriteRate*100}%</font>
		复写率<font color="green";font-size:12px;font-family:'宋体'; line-height:28px>
		${(1-vo.ownWriteRate)*100}%</font>
		,引用率<font color="green";font-size:12px;font-family:'宋体'; line-height:28px>
		${vo.refRate*100}%</font>
   		,共有<font color="green">${vo.similarityNum}</font>处相似,共有<font color="green">${vo.referenceNum}</font>处</span>
   	
   	<span style="float:left">
   
   	<div onmouseover="lookMe(this);" class="lookMe"><a href="#" onClick="openwin( )"> 引用 </a>
<span>如有未被识别的引用，可能会影响检测结果，请用[]{}做为引用标识修改后再次检测</span>
</div>

   	
   	</span>
   		 <br/>
   		　　比对源：
   		<#list sourceMap?keys as k>
    		 <span class="source" id="${k}">
					${sourceMap[k]}
			</span>
				&nbsp;&nbsp;&nbsp;&nbsp;
		</#list> 
		
	
   		</div>
   		
   		<div class="gdwl">
	   
	     <div class="gd2">
   		
   		
         <#list vo.similarityList as s>
          <div class="block:${s_index+1}" >
			    <div style="width:96%;border:1px solid #D6E6F8; margin-top:1px; background-color: #FFFFFF">
			         <div style="width:4%; font-weight:bold; float:left; padding-top:5px   ">${s_index+1}</div>
			         <div  style="width:96%;color:#000000; line-height:150%; text-decoration:none; float:left; background-color:#D6E6F8">${(s.detectionSegement)!""} 
			          </div>
			   </div>
			   <#if (s.similarityList)?exists>
         	<#list s.similarityList as s2>	
   						<div class="ss${s2.origin}">
   							 <div style="width:96%;border:0px ;solid :#D6E6F8; margin-top:1px; background-color: #FFFFFF;line-height:160%; margin-top:3px; padding-bottom:0x">	
		
					     <div  style="width:4%; font-weight:bold; float:left; background:#FFFFFF; padding-top:5px "></div>
					     <div  style="width:96%;color:#FF0000; line-height:150%; text-decoration:none; float:left; background-color:#FFFFFF">
						      <div style="width:100%"  >
						      <div style="width:85%; height:5px;float:left;text-align:left;line-height:150%;color:#000000">
						
							<#if s2.origin==3>
							<span style="text-align:left; float:left">文献名：</span>
							
							<span style="text-align:left; float:left;color:#0000FF;" >${s2.title}</span>
   									<#elseif s2.origin==1>
   										<span style="text-align:left; float:left">文献名	：</span><span style="text-align:left; float:left" >
   									<a style="color:#0000FF;" target="_blank" href="${s2.url}">${s2.title}</a></span>
   									<#else>
   									<span style="text-align:left; float:left">文献名	：</span><span style="text-align:left; float:left" >
   									<a style="color:#0000FF;" target="_blank">${s2.title}</a></span>
   									</#if>
						
						  
						   <span style="text-align:left; float:left">
						 　  比对源：${sourceMap["${s2.origin}"]},
						   </span>
						    </div>                         
						   <div style="width:15%;  float:left; color:#0000FF;">相似度:${s2.comparability*100}%</div>
						</div>${s2.content} 
						   </div>
						  </div>
				</div>
			 </#list>
			 </#if>
   		</div>
		  
		  </#list>
	     </div>
	   </div>	
   		
   		
   
   </div>
  </body>
</html>

