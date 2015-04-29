my.register('my.common');
$(document).ready(function(){
	my.util.leftMenuInit();
	// 刷新桌面应用
	Mousetrap.bind(['f5'],function(e) {
		stopEP(e);
		top.artDialog.focus.refresh();
    });
});