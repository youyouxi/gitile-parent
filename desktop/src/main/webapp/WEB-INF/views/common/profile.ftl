<#assign contextPath=springMacroRequestContext.getContextPath() />
<#import "/layout/common.ftl" as dk>
<@dk.head "个人中心">
	<link rel="stylesheet" type="text/css" href="${contextPath}/static/css/setting.css?version=20150429" media="screen" />
</@dk.head>

<@dk.defaultFrame "profile">
<div class='main'>
	<div class='h1'><i class="font-icon icon-user"></i>个人中心</div>
	<div class="section">
        <div class='box'>
            <span >旧密码</span>
            <input type="password" id="password_now"value="" />
            <div class='line'></div>
            <span >新密码</span>
            <input type="password" id="password_new" value=""/><div class='upasswordinfo'></div>
            <a id="submitBtn" href="javascript:void(0);" class="save button">保存</a>
        </div>
    </div>
</div>
</@dk.defaultFrame>

<@dk.end>
	<script src="${contextPath}/static/js/common/profile.js"></script>
</@dk.end>