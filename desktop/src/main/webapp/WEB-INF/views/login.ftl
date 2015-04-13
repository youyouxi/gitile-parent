<#assign contextPath=springMacroRequestContext.getContextPath() />
<!DOCTYPE html>
<!--[if IE 8]><html class="no-js lt-ie9" lang="zh-cn"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="zh-cn">
<!--<![endif]-->
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <title>登录页面 - 后台管理系统</title>
    <link rel="shortcut icon" href="${contextPath}/static/images/logo.png">
    <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/common.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/jquery.gritter.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/login.css" media="screen" />
</head>
<body oncontextmenu="return false;">
    <div id="ui-preloader">
		<div id="ui-preloader-panel" class="ui-preloader-panel">
			<div class="ui-preload-title">
				<img src="${contextPath}/static/images/logo.png" height="30px" style="margin-top:-5px;margin-right: 10px;"><small>与众不同的Web体验</small>
			</div>
			<div class="ui-preload-progress">
				<img class="ui-preloader-icon" src="${contextPath}/static/images/loading.gif"> <span id="ui-preloader-text" class="ui-preloader-text">正在加载中...</span>
			</div>
		</div>
	</div>
    <div id='ui-login'>
		<div class="title">
			<div class="logo">后台<b>管理系统</b></div>
			<div class='info'>——与众不同的Web体验</div>
		</div>
		<form method="post">
			<div class="inputs">
				<div><span>用户名：</span><input id="username" name='username' type="text" placeholder="用户名" /> </div> 
				<div><span>密　码：</span><input id="password" name='password' type="password" placeholder="密码" /></div>
                <div id="checkCodeDiv" data-target="0" class='check_code'><span>验证码：</span><input id='checkCode' name='checkCode' class="check_code" type="text" placeholder="验证码" /> <img id="checkCodeImage" onclick="this.src='${contextPath}/checkCodeImage'" />
                <div style="clear:both;"></div></div>
			</div>
			<div class="actions">
				<#if refurl?exists>
            		<input type="hidden" id="refurl" value="${refurl!''}">
            	<#else>
            		<input type="hidden" id="refurl" value="${contextPath}/index">
            	</#if>
				<input type="button" id="submit" value="登录" />				
			</div>
			<div style="clear:both;"></div>
		</form>
	</div>
    <div class="footer">
		XXXX科技有限公司
	</div>
    <script src="${contextPath}/static/js/libs/jquery-2.1.3.min.js"></script>
    <script src="${contextPath}/static/js/libs/jquery.gritter.min.js"></script>
    <script src="${contextPath}/static/js/libs/jquery.backstretch.min.js"></script>
    <script src="${contextPath}/static/js/common.js"></script>
    <script src="${contextPath}/static/js/login.js"></script>
</body>
</html>