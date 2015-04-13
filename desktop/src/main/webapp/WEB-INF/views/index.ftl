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
    <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/simple-line-icons.min.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/dialog.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/common.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/desktop.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/themes/default.css" media="screen" />
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
    <div id='ui-desktop' background='${sessionUser.background!""}'>
		<div id="fileContiner" class="fileList_icon">
			<div class="file systemBox menuDefault" data-app='{"name":"我的电脑","resize":1,"width":"800","height":"500","content":"${contextPath}/","icon":"computer.png"}'>
				<div class="ico" style="background-image:url(${contextPath}/static/images/app/computer.png)"></div>
				<div class="titleBox"><span>我的电脑</span></div>
			</div>
			<div class="file systemBox menuDefault" data-app='{"name":"应用商店","width":"800","height":"600","content":"${contextPath}/","icon":"market.png"}'>
				<div class="ico" style="background-image:url(${contextPath}/static/images/app/market.png)"></div>
				<div class="titleBox"><span>应用商店</span></div>
			</div>
            <div class="file systemBox menuApp" data-app='{"name":"计算器","width":"538","height":"600","icon":"calcu.png","content":"http://apps2.bdimg.com/store/static/kvt/3e9b470e8b9fceaa66d46a935b45518e.swf"}'>
				<div class="ico" style="background-image:url(${contextPath}/static/images/app/calcu.png)"></div>
				<div class="titleBox"><span>计算器</span></div>
			</div>
		</div>
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
			<li><a href="#" onclick="my.desktop.openWindow('我的文件', '${contextPath}/');"><span>我的文件</span></a></li>
			<li><a href="#" onclick="my.desktop.openWindow('共享文件', '${contextPath}/');"><span>共享文件</span></a></li>
			<li><a href="#" onclick="my.desktop.openWindow('下载目录', '${contextPath}/');"><span>下载目录</span></a></li>
			<li><div id="rightspliter"></div></li>
            <li><a href="#" onclick="my.desktop.openWindow('桌面背景', '${contextPath}/');"><span>桌面背景</span></a></li>
            <li><a href="#" onclick="my.desktop.openWindow('系统设置', '${contextPath}/');"><span>系统设置</span></a></li>
            <li><div id="rightspliter"></div></li>
            <li><a href="#" onclick="my.desktop.openWindow('关于我们', '${contextPath}/aboutus');"><span>关于我们</span></a></li>
            <li><a href="#" onclick="my.desktop.openWindow('使用帮助', '${contextPath}/help');"><span>使用帮助</span></a></li>
			<li><a href="${contextPath}/logout" style="margin-top:82px;"><span>安全退出</span></a></li>            
		</ul>
	</div>
    <script src="${contextPath}/static/js/libs/jquery-2.1.3.min.js"></script>
    <script src="${contextPath}/static/js/libs/jquery-artDialog.js"></script>
    <script src="${contextPath}/static/js/libs/jquery-contextMenu.js"></script>
    <script src="${contextPath}/static/js/common.js"></script>
	<script src="${contextPath}/static/js/desktop.js"></script>
</body>
</html>