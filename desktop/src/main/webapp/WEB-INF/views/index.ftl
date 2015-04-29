<#assign contextPath=springMacroRequestContext.getContextPath() />
<!DOCTYPE html>
<!--[if IE 8]><html class="no-js lt-ie9" lang="zh-cn"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="zh-cn">
<!--<![endif]-->
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <title>我的桌面 - 后台管理系统</title>
    <link rel="shortcut icon" href="${contextPath}/static/images/logo.png">
    <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/simple-line-icons.min.css?version=20150429" media="screen" />
    <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/dialog.css?version=20150429" media="screen" />
    <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/common.css?version=20150429" media="screen" />
    <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/desktop.css?version=20150429" media="screen" />
    <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/themes/default.css?version=20150429" media="screen" />
</head>
<body oncontextmenu="return my.desktop.rightMenu.contextMenu();">
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
    <img class="wallbackground" src="" style='overflow:hidden;position:fixed;'/>
    <div id='ui-desktop'>
		<div id="fileContiner" class="fileList_icon"></div>
        <div id="taskbar" style="display:block;"></div>
	</div>
    <a href="#" class="start"></a>
	<div id="menuwin">
		<div id="startmenu"></div>
		<ul id="programs">
			<li><a href="#">应用安装/卸载</a></li>
			<li><div id="leftspliter"></div></li>
		</ul>
		<ul id="links">
			<li class="icon"></li>
			<li><a href="#" onclick="my.desktop.openWindow('我的文件', '${contextPath}/user/index', 800, 500);"><span>我的文件</span></a></li>
			<li><a href="#" onclick="my.desktop.openWindow('共享文件', '${contextPath}/user/share', 800, 500);"><span>共享文件</span></a></li>
			<li><a href="#" onclick="my.desktop.openWindow('下载目录', '${contextPath}/user/dowload', 800, 500);"><span>下载目录</span></a></li>
			<li><div id="rightspliter"></div></li>
            <li><a href="#" onclick="my.desktop.openWindow('个人设置', '${contextPath}/common/backgroud', 800, 500);"><span>桌面背景</span></a></li>
            <li><a href="#" onclick="my.desktop.openWindow('个人设置', '${contextPath}/common/profile', 800, 500);"><span>个人设置</span></a></li>
            <li><div id="rightspliter"></div></li>
            <li><a href="#" onclick="my.desktop.openWindow('个人设置', '${contextPath}/common/aboutus', 800, 500);"><span>关于我们</span></a></li>
            <li><a href="#" onclick="my.desktop.openWindow('个人设置', '${contextPath}/common/help', 800, 500);"><span>使用帮助</span></a></li>
			<li><a href="${contextPath}/logout" style="margin-top:82px;"><span>安全退出</span></a></li>            
		</ul>
	</div>
    <script src="${contextPath}/static/js/libs/jquery-2.1.3.min.js?version=20150429"></script>
    <script src="${contextPath}/static/js/libs/jquery.cookie.js?version=20150429"></script>
    <script src="${contextPath}/static/js/libs/jquery-artDialog.js?version=20150429"></script>
    <script src="${contextPath}/static/js/libs/jquery-contextMenu.js?version=20150429"></script>
    <script src="${contextPath}/static/js/libs/mousetrap.min.js?version=20150429"></script>
    <script src="${contextPath}/static/js/common.js?version=20150429"></script>
	<script src="${contextPath}/static/js/desktop.js?version=20150429"></script>
</body>
</html>