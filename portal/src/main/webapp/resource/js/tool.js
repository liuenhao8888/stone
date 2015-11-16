jQuery.fn.extend({
    selected: function(val) {
        $(this).children().each(function() { 
			if($(this).attr("value")==val){
				$(this).attr("selected","selected");
			}
		}); 
    }
}); 