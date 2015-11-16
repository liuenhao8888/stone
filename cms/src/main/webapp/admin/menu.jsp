<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<style>
<!--
ul li{  
list-style-type:none;  
}  
li{
	margin-top:10;
}
-->
</style>
<div
	style="position: absolute; left: 100; width: 200; height: 650px; border: 1px solid red; background: white; padding-top: 20; text-align: left;">
	<ul>
		<li>分类管理
			<ul>
				<li><a href="admin/categoryAdd.jsp">添加分类</a></li>
				<li><a href="adm/category/list.do?pid=0">分类列表</a></li>
				<li><a href="adm/category/list4template.do?pid=0">商品模板</a></li>
			</ul>
		</li>
		<li>内容管理
			<ul>
				<li><a href="adm/shop/list.do">店铺报表</a></li>
				<li><a href="adm/category/list4product.do?pid=0">商品管理</a></li>
			</ul>
		</li>
	</ul>

</div>