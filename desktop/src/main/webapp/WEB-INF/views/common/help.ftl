<#assign contextPath=springMacroRequestContext.getContextPath() />
<#import "/layout/common.ftl" as dk>
<@dk.head "使用帮助">
	
</@dk.head>

<@dk.defaultFrame "help">
<div class='main'>
	<div class='h1'><i class="font-icon icon-question"></i>使用帮助</div>
	<div class="section">
	    <div class="content">
			<div class="box">
			    <div class="title"><span>快捷键</span></div>
			    <p><i class="icon-direction"></i>enter 打开</p>
			    <p><i class="icon-direction"></i>f5 刷新桌面</p>
			    <p><i class="icon-direction"></i>ctrl+f5 刷新浏览器</p>
			    <p><i class="icon-direction"></i>up/down/left/right 选择文件</p>
			</div>
	    </div>
	</div>
</div>
</@dk.defaultFrame>

<@dk.end>
	<script src="${contextPath}/static/js/common/common.js"></script>
</@dk.end>