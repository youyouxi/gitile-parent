my.register('my.login');
my.login = {
    init:function() {
    	// 初始化登录表单
    	my.login.initLoginForm();
    	// 背景图片更换
		$.backstretch([
		   my.util.global.staticPath+"/images/login/1.jpg",
		   my.util.global.staticPath+"/images/login/2.jpg",
		   my.util.global.staticPath+"/images/login/3.jpg"], 
		   {
				fade: 1000,
				duration: 8000
		   }
		);
		$("body").on('click', "#checkCodeImage", function (e) {
            //再次绑定，防止冒泡到html的click事件
            stopEP(e);
            $("#checkCodeImage").attr("src", my.util.global.contextPath+"checkCodeImage?t="+Math.random());
        })
    },
    initLoginForm:function() {
    	// 监听回车键
    	$(document).keydown(function(event){
    	    var curKey = event.which; 
    	    if(curKey==13){
    	    	my.login.loginAction();
    	    }
    	});
    	$('#submit').click(function(){
    		my.login.loginAction();
    	});
    },
    loginAction:function() {
    	// 验证表单
		var username = $('#username').val();
		var password = $('#password').val();
		var checkCode = $('#checkCode').val();
		if(isEmpty(username)) {
			my.login.showLoginError('请输入用户名');
			$('#username').focus();
			return;
		}
		if(isEmpty(password)) {
			my.login.showLoginError('请输入密码');
			$('#password').focus();
			return;
		}
		var show = $("#checkCodeDiv").attr('data-target');
    	if(show==1&&isEmpty(checkCode)) {
    		my.login.showLoginError('请输入验证码');
			$('#checkCode').focus();
			return;
    	}
    	var param = {};
        param['username'] = username;
        param['password'] = password;
        param['checkCode'] = checkCode;
        $.ajax({
            type: "POST",
            url: my.util.global.contextPath+"login",
            dataType: "json",
            data: param,
            async: false,
            success: function (data) {
            	if (data['code'] == 1) {
                    window.location.href = $("#refurl").val();
                } else if(data['code'] == 0) {
                    var resultCode = data['result'];
                    if (resultCode == 7) {
                    	var show = $("#checkCodeDiv").attr('data-target');
                    	if(show==0) {
                    		$("#checkCodeDiv").attr('data-target', 1);
                    		$("#checkCodeImage").attr("src", my.util.global.contextPath+"checkCodeImage");
                            $('#checkCodeDiv').show();
                    	} else {
                    		$("#checkCodeImage").trigger("click");
                    	}
                    }
                    my.login.showLoginError(my.login.loginStatus[resultCode]);
                } else {
                	my.login.showLoginError(my.login.loginStatus[8]);
                }
            }
        });
    },
    showLoginError:function(msg) {
    	tips(msg, 'error');
    },
};
my.login.loginStatus = {
    0: '用户名或密码不正确',
    1: '登录成功',
    2: '用户名或密码为空',
    3: '登录用户不存在',
    4: '您的账号不可用',
    5: '账号已冻结，请30分钟后再登录',
    6: '账号在其他地方登录',
    7: '验证码输入不正确',
    8: '系统发生错误'
}
$(document).ready(function(){
    my.login.init();
    $(window).load(function() {
        $('#ui-preloader').delay(350).fadeOut('slow');
    });
});