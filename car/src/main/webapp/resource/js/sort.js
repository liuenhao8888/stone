/**   二手交易物品种类     **/
var goodsSort = ["其它","家具/日用品","家用电器","笔记本电脑","台式电脑","服务器","网络设备","手机/通讯","手机号","数码产品","服装/鞋帽/箱包","图书/音像/软件","文体用品/乐器","母婴/儿童用品", "艺术品/收藏品", "办公用品/设备", "机械/五金", "物品交换", "免费赠送", "二手回收"];

/**   票券交易种类     **/
var ticketSort = ["其它","电影票","演唱会","健身卡","购物卡券","优惠卡券","门票"];

/**   火车票种类     **/
var trainSort = ["站票","硬座","软座","硬卧","软卧"];

/**   汽车种类     **/
var carSort = ["捷达","桑塔纳","富康","高尔夫","奥拓","夏利","大众","比亚迪","奇瑞","现代","马自达","本田","丰田","别克","福特","雪佛兰","雪铁龙","标致","菲亚特","铃木","三菱","沃尔沃","奥迪","奔驰","宝马","雷克萨斯","吉普"];

/**   汽车款式     **/
var carStyle = ["轿车/跑车","越野车/SUV","面包车/MPV","客车/货车","其他车型"];
        
/**   汽车颜色     **/
var carColor = ["黑色","白色","银灰色","深灰色","咖啡色","红色","蓝色","绿色","黄色","橙色","香槟色","紫色","多彩色","其他"];

/**   汽车变速箱     **/
var carMotor = ["手动","自动","手自一体","CVT"];

/**   BBS     **/
var bbsCtg = ["全部","餐饮娱乐","服饰鞋帽","电器","情感交流"];


/**   摩托种类     **/
var motoSort = ["雅马哈","本田","嘉陵","嘉陵本田","吉利铃木","豪爵","豪爵铃木","轻骑","轻骑铃木","宗申","钱江","力帆","建设","建设雅马哈","金城","金城铃木","大阳","哈雷","川崎","新大洲","新大洲本田","五羊本田","宝马","轻骑木兰"];

/**   摩托款式     **/
var motoStyle = ["弯梁","踏板","骑式","迷你","太子车","沙滩车","大排量","越野","街车","赛车","巡航","三轮摩托"];



/**************************    房产     ********************************/
/**   房屋朝向     **/
var houseDir = ["朝向","东","南","西","北","东西","南北","东南","东北","西南","西北"];
/**   房屋类型     **/
var houseSty = ["类型","平房/四合院","普通住宅","公寓","商住楼","别墅","其他"];
/**   房屋装修     **/
var houseDec = ["装修","豪华装修","精装修","中等装修","简单装修","毛坯"];



/**************************    二手交易     ********************************/
/**   家用电器类型     **/
var jydqType = ["电器类型","电视","冰箱","洗衣机","空调","微波炉","厨卫电器","小型电器","音响/DVD","音响/DVD","其他"];
/**   家用/日用品     **/
var jjrypType = ["床/床垫","柜子/架子","沙发","桌/椅","日用品","其他"];


jQuery.fn.extend({
	selected: function(val) {
        $(this).children().each(function() { 
			if($(this).attr("value")==val){
				$(this).attr("selected","selected");
			}
		}); 
    },
	initializeGoodsSort: function() {
		for(var i=0;i<goodsSort.length;i++){
			$(this).append("<option value="+i+">"+goodsSort[i]+"</option>");
		}
    },
	initializeTicketSort: function() {
		for(var i=0;i<ticketSort.length;i++){
			$(this).append("<option value="+i+">"+ticketSort[i]+"</option>");
		}
    },
	initializeTrainSort: function() {
		for(var i=0;i<trainSort.length;i++){
			$(this).append("<option value="+i+">"+trainSort[i]+"</option>");
		}
    },
	initializeCarSort: function() {
		for(var i=0;i<carSort.length;i++){
			$(this).append("<option value="+i+">"+carSort[i]+"</option>");
		}
    },
	initializeCarStyle: function() {
		for(var i=0;i<carStyle.length;i++){
			$(this).append("<option value="+i+">"+carStyle[i]+"</option>");
		}
    },
	initializeCarColor: function() {
		for(var i=0;i<carColor.length;i++){
			$(this).append("<option value="+i+">"+carColor[i]+"</option>");
		}
    },
	initializeCarMotor: function() {
		for(var i=0;i<carMotor.length;i++){
			$(this).append("<option value="+i+">"+carMotor[i]+"</option>");
		}
    },
	initializeHouseDir: function() {
		for(var i=0;i<houseDir.length;i++){
			$(this).append("<option value="+i+">"+houseDir[i]+"</option>");
		}
    },
	initializeHouseSty: function() {
		for(var i=0;i<houseSty.length;i++){
			$(this).append("<option value="+i+">"+houseSty[i]+"</option>");
		}
    },
	initializeHouseDec: function() {
		for(var i=0;i<houseDec.length;i++){
			$(this).append("<option value="+i+">"+houseDec[i]+"</option>");
		}
    },
	initializeJydqType: function() {
		for(var i=0;i<jydqType.length;i++){
			$(this).append("<option value="+i+">"+jydqType[i]+"</option>");
		}
    },
	initializeJjrypType: function() {
		for(var i=0;i<jjrypType.length;i++){
			$(this).append("<option value="+i+">"+jjrypType[i]+"</option>");
		}
    }
	
}); 