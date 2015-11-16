<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="css/global.css" rel="stylesheet" type="text/css"/>
	<link href="css/index.css" rel="stylesheet" type="text/css"/>
</head>
<body style="text-align: center;">
 <hr/>
 <div class="main">
		  <#list cl.catalogs as p>	
		<div class="item">
			<div class="pname">
				${p.name}
			</div>
			<div class="name">
				<#list cl.subCatalogs[p_index] as sub>	
					<a href="${sub.id}.html">
						${sub.name}
					</a>
					<br/>
	 			</#list>
			</div>
		</div>
 	 </#list>
 </div>
    
 </body>
 
 