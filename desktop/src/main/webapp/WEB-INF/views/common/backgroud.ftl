<#assign contextPath=springMacroRequestContext.getContextPath() />
<#import "/layout/common.ftl" as dk>
<@dk.head "关于我们">
	
</@dk.head>

<@dk.defaultFrame "backgroud">
<div class='main'>
	<div class='h1'><i class="font-icon icon-picture"></i>更换壁纸</div>
	<div class="section">
        <div id="wallpaper" class='box'>
            <div class='list'><div class='ico'><img src='${contextPath}/static/images/wallpaper/1.jpg'/></div></div>
            <div class='list'><div class='ico'><img src='${contextPath}/static/images/wallpaper/2.jpg'/></div></div>
            <div class='list'><div class='ico'><img src='${contextPath}/static/images/wallpaper/3.jpg'/></div></div>
            <div class='list'><div class='ico'><img src='${contextPath}/static/images/wallpaper/4.jpg'/></div></div>
            <div class='list'><div class='ico'><img src='${contextPath}/static/images/wallpaper/5.jpg'/></div></div>
            <div class='list'><div class='ico'><img src='${contextPath}/static/images/wallpaper/6.jpg'/></div></div>
            <div class='list'><div class='ico'><img src='${contextPath}/static/images/wallpaper/7.jpg'/></div></div>
            <div class='list'><div class='ico'><img src='${contextPath}/static/images/wallpaper/8.jpg'/></div></div>
            <div class='list'><div class='ico'><img src='${contextPath}/static/images/wallpaper/9.jpg'/></div></div>
            <div class='list'><div class='ico'><img src='${contextPath}/static/images/wallpaper/10.jpg'/></div></div>
            <div class='list'><div class='ico'><img src='${contextPath}/static/images/wallpaper/11.jpg'/></div></div>
            <div class='list'><div class='ico'><img src='${contextPath}/static/images/wallpaper/12.jpg'/></div></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    <div class="section">
        自定义壁纸：<input id="wall_url" type="text" style="width: 60%;" />
        <a id="wallpaperBtn" href="javascript:void(0);"class="button" style="padding:5px 1.5em;margin-left:20px;">设置</a> 
        <div style="font-size: 12px;color:#aaa;"></div>
    </div>
</div>
</@dk.defaultFrame>

<@dk.end>
	<script src="${contextPath}/static/js/common/background.js"></script>
</@dk.end>