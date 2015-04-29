<#assign contextPath=springMacroRequestContext.getContextPath() />
<#import "/layout/common.ftl" as dk>
<@dk.head "关于我们">
	<link rel="stylesheet" type="text/css" href="${contextPath}/static/css/setting.css?version=20150429" media="screen" />
</@dk.head>

<@dk.defaultFrame "aboutus">
<div class='main'>
	<div class='h1'><i class="font-icon icon-info"></i>关于我们</div>
	<div class="section">
	    <div class="content">
	        <div class="box">
			    <div class="title"><span>基础权限系统</span></div>
			    <p>基础权限系统是一套J2EE基础开发环境，可以在此基础上扩展相关的业务，方便、快速的开发出企业相关业务系统。完备的企业组织架构、用户、权限管理，动态配置各个角色权限。	</p>
			    <p><b>——设计理念——</b></p>
			    <p>传承经典,追求创新,为企业提供通用的基础系统框架。</p>
			    <p>它提供了类windows经典用户界面，更方便用户使用。</p>
			    <p><b>——使用技术——</b></p>
			    <p>后台框架：Freemark + Spring + Mybatis</p>
			    <p>前端技术：JQuery(plugin:artDialog.ztree.backstretch.contentmenu).js主流开发框架。</p>
			</div>
	    </div>
	</div>
</div>
</@dk.defaultFrame>

<@dk.end>
	<script src="${contextPath}/static/js/common/common.js"></script>
</@dk.end>