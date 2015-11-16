<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="css/global.css" rel="stylesheet" type="text/css"/>
	<link href="css/siteList.css" rel="stylesheet" type="text/css"/>
	<title>${catalog.name}</title>
</head>
<body style="text-align: center;">
 <hr/>
 <div class="main">
 	<div class="title">
		<span class="ctgName">${catalog.name}</span>
		<span class="rs">
			<a href="rs/list/${catalog.id}.do">网友推荐</a>
		</span>
	</div>
 <div class="list">
	<#list sites as s>	
		<div class="item">
			<a href="${s.url}" target="_blank">${s_index+1}.   ${s.name}</a>
		</div>
 	 </#list>
	</div>
 </div>
    
 </body>
 
 