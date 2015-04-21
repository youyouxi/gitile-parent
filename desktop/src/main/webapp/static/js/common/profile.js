my.register('my.common');
my.common = {
    init:function() {
    	$(".setting li").hover(function(){
    		$(this).addClass("hover");
    	},  function(){ 
    		$(this).removeClass("hover");
    	});
    	$(".setting li").on('click',function (e) {
    		var url = $(this).attr("target_url");
    		window.location=url;
        });
    }
};
$(document).ready(function(){
    my.common.init();
});