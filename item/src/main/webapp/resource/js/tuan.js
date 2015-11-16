/** 支付状态  */
var statusMap = {
	0 : "存库",
	1 : "上架",
	2 : "下架",
	3 : "删除"
};
jQuery.fn.extend({
	initializeStatus : function(key) {
		for ( var k in statusMap) {
			if(k>=3)break;
			var item = '<input name="status" type="radio" value="' + k + '"/>'
			if(k==key){
				item = '<input name="status" type="radio" value="' + k + '" checked="true"/>'
			}
			$(this).append(item + statusMap[k]);
		}
	},
	setStatus : function(k) {
		$(this).html(statusMap[k]);
	},
	getStatus : function(k) {
		return statusMap[k];
	}

});