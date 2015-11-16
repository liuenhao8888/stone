/**   域名配置     **/
var domainMap = {"public":"http://localhost/public", "portal":"http://localhost/portal"};


jQuery.fn.extend({
	
	getDomainUrl : function(k) {
		return domainMap[k];
	}	
	
}); 