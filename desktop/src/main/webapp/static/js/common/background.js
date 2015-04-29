my.register('my.common');
my.common.background = {
    init:function() {
    	$("#wallpaper img").click(function(){
    		var imgUrl = $(this).attr("src");
    		top.my.desktop.setWall(imgUrl);
    	});
    	$("#wallpaperBtn").click(function(){
    		var imgUrl = $("#wall_url").val();
    		if(isEmpty(imgUrl)) {
    			tips('请输入网络图片地址！！', 'info');
    			$("#wall_url").focus();
    			return;
    		}
    		if(imgUrl.startWith("http://")) {
    			top.my.desktop.setWall(imgUrl);
    		} else {
    			tips('请输入正确的网络图片地址！', 'error');
    			$("#wall_url").focus();
    		}
    	});
    }
};
$(document).ready(function(){
	my.util.leftMenuInit();
	my.common.background.init();
	// 刷新桌面应用
	Mousetrap.bind(['f5'],function(e) {
		stopEP(e);
		top.artDialog.focus.refresh();
    });
});