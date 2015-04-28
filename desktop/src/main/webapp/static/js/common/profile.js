my.register('my.common');
my.common.profile = {
    init:function() {
    	
    }
};
$(document).ready(function(){
	my.util.leftMenuInit();
	my.common.profile.init();
	//去除所有按键事件
	$(document).keydown(function (e){
//		console.log(e.keyCode);
		return false;
	});
	// 刷新桌面应用
	Mousetrap.bind(['f5'],function(e) {
		stopEP(e);
		top.artDialog.focus.refresh();
    });
});