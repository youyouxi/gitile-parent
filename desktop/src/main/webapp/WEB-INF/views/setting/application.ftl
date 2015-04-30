<#assign contextPath=springMacroRequestContext.getContextPath() />
<#import "/layout/setting.ftl" as dk>
<@dk.head "应用管理">
</@dk.head>

<@dk.defaultFrame 15>
<div class='app_list main'>
	<a class="create button">添加应用</a>
	<div class='h1'><i class="font-icon icon-grid"></i>应用管理</div>
	<ul class="app-list">
        <li>
            <a href="javascript:;" class="icon">
                <img src="http://static.kalcaddle.com/static/images/app/calcu.png">
            </a><p><span class="title">计算器</span><span class="info">计算器</span></p>
            <div class="right">
                <a class="button" href="javascript:;">修改</a>
                <a class="button" href="javascript:;">删除</a>
                <a class="button" href="javascript:;">子菜单(权限)设置</a>
            </div>
            <div style="clear:both;"></div>
        </li>
    </ul>
</div>
</@dk.defaultFrame>

<@dk.end>
	<script src="${contextPath}/static/js/common/common.js"></script>
</@dk.end>