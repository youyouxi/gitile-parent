<#assign contextPath=springMacroRequestContext.getContextPath() />
<#macro head title>
<!doctype html>
<html lang="zh">
	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	    <title>${title} - 后台管理系统</title>
	    <link rel="shortcut icon" href="${contextPath}/static/images/logo.png">
	    <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/simple-line-icons.min.css?version=20150429" media="screen" />
	    <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/dialog.css?version=20150429" media="screen" />
	    <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/common.css?version=20150429" media="screen" />
	    <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/subcommon.css?version=20150429" media="screen" />
		<#nested>
	</head>
</#macro>

<#macro defaultFrame menu>
<body oncontextmenu="return false;">
    <div id='ui-common'>
		<div class="common_menu_left menu_left">	
			<h1>个人设置</h1>
			<ul class='sub_common'>
				<li target_url="${contextPath}/common/profile" <#if menu=="profile"> class="selected" </#if>><i class="font-icon icon-user"></i>我的信息</li>
                <li target_url="${contextPath}/common/password" <#if menu=="password"> class="selected" </#if>><i class="font-icon icon-lock"></i>修改密码</li>
                <li target_url="${contextPath}/common/backgroud" <#if menu=="backgroud"> class="selected" </#if>><i class="font-icon icon-picture"></i>更换壁纸</li>
				<li target_url="${contextPath}/common/help" <#if menu=="help"> class="selected" </#if>><i class="font-icon icon-question"></i>使用帮助</li>
                <li target_url="${contextPath}/common/aboutus" <#if menu=="aboutus"> class="selected" </#if>><i class="font-icon icon-info"></i>关于我们</li>
			</ul>
		</div>
		<#nested>
	</div>
</#macro>
<#macro end>
		<script src="${contextPath}/static/js/libs/jquery-2.1.3.min.js?version=20150429"></script>
		<script src="${contextPath}/static/js/libs/mousetrap.min.js?version=20150429"></script>
		<script src="${contextPath}/static/js/common.js?version=20150429"></script>
		<#nested>
	</body>
</html>
</#macro>