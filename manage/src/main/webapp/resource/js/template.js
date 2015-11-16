/**   模板文本格式     **/
var proptiesFormat = {1:"text", 2:"textarea", 3:"radio", 4:"checkbox", 5:"select"};

/**   模板属性类型     **/
var proptiesType = {1:"普通属性", 2:"规格属性"};


jQuery.fn.extend({
	selectedFormat: function(val) {
        $(this).children().each(function() { 
			if($(this).attr("value")==val){
				$(this).attr("selected","selected");
			}
		});
        
        if(val>2){
			$("#content").show();
		}
    },
	initializeProptiesFormat: function() {
		for(var p in proptiesFormat){
			$(this).append("<option value="+p+">"+proptiesFormat[p]+"</option>");
		}
    },
    registerEvent: function() {
		 $("#format").change(function(){
				var op = $(this).val();
				if(op<3){
					$("#content").hide();
				}else {
					$(".options").html('<input name="options" TYPE="TEXT" value=""/>');
					$("#content").show();
				}
			});
		 $("#add").click(function(){
				$(".options").append('<p><input name="options" TYPE="TEXT" value=""/></p>');
			});
    },
	initializeSelected: function(options) {
		var arr = options.split(",");
		for(var i=0;i<arr.length;i++){
			$(this).append('<p><input name="options" TYPE="TEXT" value="'+arr[i]+'"/></p>');
		}
    },createFormatElement: function(item) {
    	var id = item.id;
    	var format = item.format;
    	var options = item.options;
    	var type = item.type;
    	var valueOrder = item.valueOrder;
    	
    	var html = "";
    	if(format==1){
    		return "<input name=ext"+id+" type='text' value=''/>";
    	}else if(format==2){
    		return "<textarea name=ext"+id+"></textarea >";
    	}else if(format==3){
    		var options = options.split(",");
    		for(var i in options){
    			var opt = options[i];
    			html += "<input name=ext"+id+" type='radio' value='"+opt+"'/>"+opt;
    		}
    		return html ;
    	}else if (format==4){
    		var options = options.split(",");
    		for(var i in options){
    			var opt = options[i];
    			if(type==2){
    				html += "<input class='2' name='std"+id+"' type='checkbox' value='"+opt+"' vo='"+valueOrder+"'/>"+opt;
    				html += "<input name=std"+id+" type='hidden' value=''/>";
    			}else{
    				html += "<input name='ext"+id+"' type='checkbox' value='"+opt+"'/>"+opt;
    				html += "<input name=ext"+id+" type='hidden' value=''/>";
    			}
    		}
    		return html ;
    	}else if (format==5){
    		var html = "<select name=ext"+id+">";
    		var options = options.split(",");
    		for(var i in options){
    			var opt = options[i];
    			html += "<option value='"+opt+"'>"+opt+"</option>";
    		}
    		return html + "</select>" ;
    	}
    	return html;
    },selectedFormatElement: function(item) {
    	var id = item.id;
    	var value = item.value;
    	var format = item.format;
    	var options = item.options;
    	var type = item.type;
    	
    	var html = "";
    	if(format==1){
    		return "<input name=ext"+id+" type='text' value='"+value+"'/>";
    	}else if(format==2){
    		return "<textarea name=ext"+id+">"+value+"</textarea >";
    	}else if(format==3){
    		var options = options.split(",");
    		for(var i in options){
    			var opt = options[i];
    			if(opt==value){
    				html += "<input name=ext"+id+" type='radio' checked='checked' value='"+opt+"'/>"+opt;
    			}else{
    				html += "<input name=ext"+id+" type='radio' value='"+opt+"'/>"+opt;
    			}
    		}
    		return html ;
    	}else if (format==4){
    		var options = options.split(",");
    		for(var i in options){
    			var opt = options[i];
    			var isChecked = false;
    			var values = value.split(",");
    			for(j in values){
    				if(opt==values[j]){
    					isChecked = true;
    					break;
    				}
    			}
    			if(isChecked){
    				html += "<input name=ext"+id+" type='checkbox' checked='checked' value='"+opt+"'/>"+opt;
    			}else{
    				html += "<input name=ext"+id+" type='checkbox' value='"+opt+"'/>"+opt;
    			}
    		}
    		html += "<input name=ext"+id+" type='hidden' value=''/>";
    		return html ;
    	}else if (format==5){
    		var html = "<select name=ext"+id+">";
    		var options = options.split(",");
    		for(var i in options){
    			var opt = options[i];
    			if(opt==value){
    				html += "<option selected = 'selected' value='"+opt+"'>"+opt+"</option>";
    			}else{
    				html += "<option value='"+opt+"'>"+opt+"</option>";
    			}
    		}
    		return html + "</select>" ;
    	}
    	return html;
    },selectedFormatElement4Standard: function(item,values) {
    	var id = item.id;
    	var options = item.options;
    	var valueOrder = item.valueOrder;
    	
    	var html = "";
		var options = options.split(",");
		for(var i in options){
			var opt = options[i];
			var isChecked = false;
			for(j in values){
				if(opt==values[j]){
					isChecked = true;
					break;
				}
			}
			if(isChecked){
				html += "<input class='2' name=std"+id+" type='checkbox' checked='checked' value='"+opt+"' vo='"+valueOrder+"'/>"+opt;
			}else{
				html += "<input class='2' name=std"+id+" type='checkbox' value='"+opt+"' vo='"+valueOrder+"'/>"+opt;
			}
		}
		html += "<input name=std"+id+" type='hidden' value=''/>";
		return html ;
    },
	getFormat : function(k) {
		return proptiesFormat[k];
	},
	getType: function(k) {
		return proptiesType[k];
	}
	
	
}); 