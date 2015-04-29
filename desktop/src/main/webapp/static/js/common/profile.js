my.register('my.common');
my.common.profile = {
    init:function() {
    	my.util.ajaxInit();
    	$('#submitBtn').click(function(){
    		var oldPwd = $("#password_now").val();
    		var newPwd = $("#password_new").val();
    		if(isEmpty(oldPwd)) {
    			$('#password_now').focus();
    			tips('请输入旧密码！', 'error');
    			return;
    		}
    		if(isEmpty(newPwd)) {
    			$('#password_new').focus();
    			tips('请输入新密码！', 'error');
    			return;
    		}
    		if(oldPwd==newPwd) {
    			$('#password_new').focus();
    			tips('旧密码和新密码不能相同！', 'error');
    			return;
    		}
    		my.common.profile.submitForm(oldPwd, newPwd);
    	});
    },
	submitForm:function(passwordNow, passwordNew) {
		var param = {};
        param['oldpwd'] = passwordNow;
        param['newpwd'] = passwordNew;
        $.ajax({
            type: "POST",
            url: my.util.global.contextPath+"common/changepwd",
            dataType: "json",
            data: param,
            async: false,
            success: function (data) {
            	if (data['code'] == 1) {
            		tips('恭喜您，您的密码已修改成功！', 'success');
            		$('#password_now').val('');
            		$('#password_new').val('');
                } else if(data['code'] == 0) {
                	var resultCode = data['result'];
                    if (resultCode == 2) {
                    	tips('对不起，您的旧密码不正确！', 'error');
                    } else {
                    	tips('对不起，修改失败！', 'error');
                    }
                } else {
                	tips('系统发生错误！', 'error');
                }
            }
        });
	}
};
$(document).ready(function(){
	my.util.leftMenuInit();
	my.common.profile.init();
	// 刷新桌面应用
	Mousetrap.bind(['f5'],function(e) {
		stopEP(e);
		top.artDialog.focus.refresh();
    });
});