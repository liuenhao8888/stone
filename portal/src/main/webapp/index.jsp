<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.stone.base.system.*"%>
<%@ include file="head.jsp" %>
    <!DOCTYPE html>
<html>
  <head>
<base href="<%=basePath%>">
<title>首页</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="resource/css/zzsc.css" rel="stylesheet" type="text/css"/>
<script src="resource/js/jquery-1.7.2.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
    $(function(){
    	
    	var init = function(){
    		$('.navRight li').mouseenter(function(){
                $(this).children('span').css('transform','rotate(135deg)');
            }).mouseleave(function(){
                $(this).children('span').css('transform','rotate(-45deg)');
            })
            $('.fenlei ul li').mouseenter(function(){
                $(this).stop().animate({'height':'200px'},300).siblings().stop().animate({'height':'44px'},300);
                $(this).siblings().css('background','#F5F5F5');
                refreshFenleiright($(this).attr("id"));
                $('.fenleiright').fadeTo(0,0.8).stop().animate({'width':'289px'},300);
            }).mouseleave(function(){
                $('.fenlei ul li').stop().animate({'height':'79px'},300)
                $(this).siblings().css('background','#ffffff');
            });
            $('.navLeft').mouseleave(function(){
                $('.fenleiright').stop().animate({'width':'0px'},300);
            })
    	}
    	
    	init();
    	
    	var refreshFenleiright = function(pid){
    		if(isNaN(pid))return;
    		$.get("<%=Domain.PUBLIC%>/category/listTree.do?pid="+pid, null, function (items){
    			var html = '';
    			for(i in items){
    				html += '<dl class="flright"><dt>'+items[i].name+'</dt><dd>';
    				var items2 = items[i].subList;
   	    			for(i2 in items2){
   	    				html += '<a href="<%=Domain.LIST%>/product_list.do?cid='+items2[i2].id+'">'+items2[i2].name+'</a>';
   	    			}
    				html += '</dd></dl>';
    			}
    			$(".fenleiright").html(html);
    		});
    		
    	}
    	
        
        
        
        
        
        
        
        
        
        
        
    })
</script>
</head>
<body>
<div id="navOut">
    <div class="nav">
        <div class="navLeft">
            <p>商品类别</p>
            <div class="fenlei">
                <ul>
                    <li id="1">
                         <dl class="fenleiLeft">
                            <dt>数字音像 </dt>
                            <dd>
                                <a href="http://sc.chinaz.com">电子书 </a>
                                <a href="http://sc.chinaz.com">数字音乐</a>
                                <a href="http://sc.chinaz.com">音像</a>
                                <a href="http://sc.chinaz.com">文艺</a>
                                <a href="http://sc.chinaz.com">人文社科 </a>
                                <a href="http://sc.chinaz.com">经管励志 </a>
                                <a href="http://sc.chinaz.com">站长素材</a>
                                <a href="http://sc.chinaz.com">站长素材</a>
                                <a href="http://sc.chinaz.com">站长素材</a>
                                <a href="http://sc.chinaz.com">站长素材</a>
                            </dd>
                         </dl>
                    </li>
                    <li id="2">
                         <dl class="fenleiLeft">
                            <dt>家用电器</dt>
                            <dd>
                                <a href="http://sc.chinaz.com">大家电 </a>
                                <a href="http://sc.chinaz.com">生活电器 </a><a href="http://sc.chinaz.com">厨房电器 </a>
                                <a href="http://sc.chinaz.com">五金 </a><a href="http://sc.chinaz.com">打底衫</a>
                                <a href="http://sc.chinaz.com">腰带</a><a href="http://sc.chinaz.com">男旅行箱</a>
                                <a href="http://sc.chinaz.com">气垫鞋</a><a href="http://sc.chinaz.com">板鞋</a>
                                <a href="http://sc.chinaz.com">温暖一家之主De冬日风采</a><a href="http://sc.chinaz.com">羽绒服羽绒服中的小立领</a>
                                <a href="http://sc.chinaz.com">皮衣潮男装</a>
                            </dd>
                         </dl>
                    </li>
                    <li id="3">
                         <dl class="fenleiLeft">
                            <dt>手机数码 </dt>
                            <dd>
                                <a href="http://sc.chinaz.com">手机通讯 </a><a href="http://sc.chinaz.com">手机配件 </a>
                                <a href="http://sc.chinaz.com">摄影摄像 </a><a href="http://sc.chinaz.com">数码配件</a>
                                <a href="http://sc.chinaz.com">nb男鞋</a><a href="http://sc.chinaz.com">打底衫</a>
                                <a href="http://sc.chinaz.com">拖鞋</a><a href="http://sc.chinaz.com">睡衣</a>
                                <a href="http://sc.chinaz.com">运动裤</a><a href="http://sc.chinaz.com">男棉裤</a>
                                <a href="http://sc.chinaz.com">以纯男T恤包</a><a href="http://sc.chinaz.com">情侣装</a>
                            </dd>
                         </dl>
                    </li>
                    <li id="4">
                         <dl class="fenleiLeft">
                            <dt>电脑办公 </dt>
                            <dd>
                                <a href="http://sc.chinaz.com">电脑整机 </a><a href="http://sc.chinaz.com">电脑配件 </a>
                                <a href="http://sc.chinaz.com">外设产品</a><a href="http://sc.chinaz.com">网络产品 </a>
                                <a href="http://sc.chinaz.com">男皮带</a>
                                <a href="http://sc.chinaz.com">运动裤</a><a href="http://sc.chinaz.com">男棉裤</a>
                                <a href="http://sc.chinaz.com">以纯男T恤包</a><a href="http://sc.chinaz.com">情侣装</a>
                                <a href="http://sc.chinaz.com">男保暖裤</a><a href="http://sc.chinaz.com">运动鞋</a>
                            </dd>
                         </dl>
                    </li>
                    <li id="5">
                         <dl class="fenleiLeft">
                            <dt>服装珠宝</dt>
                            <dd>
                                <a href="http://sc.chinaz.com">男装 </a><a href="http://sc.chinaz.com">女装</a>
                                <a href="http://sc.chinaz.com">珠宝 </a><a href="http://sc.chinaz.com">男卫衣</a>
                                <a href="http://sc.chinaz.com">运动裤</a><a href="http://sc.chinaz.com">男棉裤</a>
                                <a href="http://sc.chinaz.com">气垫鞋</a><a href="http://sc.chinaz.com">板鞋</a>
                                <a href="http://sc.chinaz.com">温暖一家之主De冬日风采</a><a href="http://sc.chinaz.com">羽绒服羽绒服中的小立领</a>
                                <a href="http://sc.chinaz.com">皮衣潮男装</a>
                            </dd>
                         </dl>
                    </li>
                    <li>
                         <dl class="fenleiLeft">
                            <dt>母婴</dt>
                            <dd>
                                <a href="http://sc.chinaz.com">男鞋</a><a href="http://sc.chinaz.com">男裤</a>
                                <a href="http://sc.chinaz.com">手表</a><a href="http://sc.chinaz.com">男卫衣</a>
                                <a href="http://sc.chinaz.com">腰带</a><a href="http://sc.chinaz.com">男旅行箱</a>
                                <a href="http://sc.chinaz.com">气垫鞋</a><a href="http://sc.chinaz.com">板鞋</a>
                                <a href="http://sc.chinaz.com">温暖一家之主De冬日风采</a><a href="http://sc.chinaz.com">羽绒服羽绒服中的小立领</a>
                                <a href="http://sc.chinaz.com">皮衣潮男装</a>
                            </dd>
                         </dl>
                    </li>
                    <li>
                         <dl class="fenleiLeft">
                            <dt>美妆</dt>
                            <dd>
                                <a href="http://sc.chinaz.com">男鞋</a><a href="http://sc.chinaz.com">男裤</a>
                                <a href="http://sc.chinaz.com">手表</a><a href="http://sc.chinaz.com">男卫衣</a>
                                <a href="http://sc.chinaz.com">nb男鞋</a><a href="http://sc.chinaz.com">打底衫</a>
                                <a href="http://sc.chinaz.com">气垫鞋</a><a href="http://sc.chinaz.com">板鞋</a>
                                <a href="http://sc.chinaz.com">温暖一家之主De冬日风采</a><a href="http://sc.chinaz.com">羽绒服羽绒服中的小立领</a>
                                <a href="http://sc.chinaz.com">皮衣潮男装</a>
                            </dd>
                         </dl>
                    </li>
                </ul>
            </div>
            <div class="fenleiright">
            	分类内容
            </div>
        </div>
        <ul class="navRight">
            <li><a href="tuan-list.do">团购</a></li>
            <li><a href="point-list.do">积分兑换</a></li>
            <li><a href="http://sc.chinaz.com">主题</a></li>
            <li><a href="http://sc.chinaz.com">特惠</a></li>
            <li><a href="http://sc.chinaz.com">搭配</a></li>
            <li><a href="http://sc.chinaz.com">店铺</a></li>
        </ul>
    </div>
</div>
<div id="banner">
    <div class="pic">
        <img src="resource/img/banner.jpg"/>
    </div>
</div>

<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
<p>适用浏览器：IE8、360、FireFox、Chrome、Safari、Opera、傲游、搜狗、世界之窗. </p>
</div>
<jsp:include page="foot.jsp"/>
</body>
</html>