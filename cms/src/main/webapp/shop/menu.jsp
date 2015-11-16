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
		<li>订单管理
			<ul>
				<li>订单报表</li>
				<li>带确认</li>
				<li>带发货</li>
			</ul>
		</li>
		<li>商品管理
			<ul>
				<li><a href="shop/productAdd.jsp">商品新建</a></li>
				<li><a href="sho/product/list.do">商品清单</a></li>
				<li>库存预警</li>
			</ul>
		</li>
		<li>店铺会员管理
			<ul>
				<li>店铺会员</li>
				<li>会员促销</li>
			</ul>
		</li>
		<li>促销管理
			<ul>
				<li><a href="sho/tuan_list.do">团购</a></li>
				<li><a href="sho/tuan_del_list.do">已删除的团购</a></li>
				<li>抢购</li>
				<li>优惠</li>
			</ul>
		</li>
		<li>店铺信息</li>
	</ul>

</div>