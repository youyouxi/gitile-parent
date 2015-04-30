<#assign contextPath=springMacroRequestContext.getContextPath() />
<#import "/layout/common.ftl" as dk>
<@dk.head "修改密码">
	
</@dk.head>

<@dk.defaultFrame "password">
<div class='main'>
	<div class='h1'><i class="font-icon icon-lock"></i>修改密码</div>
	<div class="section">
        <div class='box'>
            <span >旧密码</span>
            <input type="password" id="password_now"value="" />
            <div class='line'></div>
            <span >新密码</span>
            <input type="password" id="password_new" value=""/>
            <div class='upasswordinfo'></div>
            <a id="submitBtn" href="javascript:void(0);" class="save button">保存</a>
        </div>
    </div>
</div>
</@dk.defaultFrame>

<@dk.end>
	<script src="${contextPath}/static/js/common/password.js"></script>
</@dk.end>