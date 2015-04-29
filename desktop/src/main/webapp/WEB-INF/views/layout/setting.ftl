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
		<#nested>
	</head>
</#macro>

<#macro defaultFrame menu>
<body oncontextmenu="return false;">
    <div id='ui-setting'>
		<div class="setting_menu_left menu_left">	
			<h1>系统设置</h1>
			<ul class='setting'>
				<#if menus?exists>
				<#list menus as me>
					<li target_url="${contextPath}${me.rightUrl!''}" <#if menu==me.id> class="selected" </#if>><i class="font-icon icon-user"></i>${me.name!''}</li>
               	</#list>
				</#if>
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