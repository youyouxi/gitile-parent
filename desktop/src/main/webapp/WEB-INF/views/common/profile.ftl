<#assign contextPath=springMacroRequestContext.getContextPath() />
<#import "/layout/common.ftl" as dk>
<@dk.head "个人中心">
	<link rel="stylesheet" type="text/css" href="${contextPath}/static/css/setting.css" media="screen" />
</@dk.head>

<@dk.defaultFrame "profile">
	
</@dk.defaultFrame>

<@dk.end>
	<script src="${contextPath}/static/js/common/profile.js"></script>
</@dk.end>