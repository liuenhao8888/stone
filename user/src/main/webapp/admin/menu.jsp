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
		<li>分站管理
			<ul>
				<li><a href="adm/region/list.do?grade=0&id=0">区域管理</a></li>
				<li><a href="adm/category/list.do?pid=0">商品分类</a></li>
				<li><a href="adm/category/list4template.do?pid=0">商品模板</a></li>
			</ul>
		</li>
		<li>店铺管理
			<ul>
				<li><a href="adm/shop/list.do">店铺报表</a></li>
				<li><a href="adm/category/list4product.do?pid=0">商品管理</a></li>
			</ul>
		</li>
		<li>订单管理
			<ul>
				<li><a href="adm/region/list.do?level=1">订单报表</a></li>
			</ul>
		</li>
		<li>会员管理
			<ul>
				<li>会员报表</li>
				<li>会员促销</li>
				<li>会员安全</li>
			</ul>
		</li>
		<li>分类信息
			<ul>
				<li>分类管理</li>
				<li>信息管理</li>
				<li>退关管理</li>
			</ul>
		</li>
	</ul>

</div>