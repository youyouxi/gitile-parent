<#assign contextPath=springMacroRequestContext.getContextPath() />
<#import "/layout/common.ftl" as dk>
<@dk.head "更换壁纸">
	<link rel="stylesheet" type="text/css" href="${contextPath}/static/css/setting.css" media="screen" />
</@dk.head>

<@dk.defaultFrame "aboutus">
<div class='main'>
	<div class='h1'><i class="font-icon icon-info"></i>关于我们</div>
	<div class="section">
	    <div class="content">
	        <div class="box">
			    <div class="title"><span>是什么？</span></div>
			    <p>基础权限系统是一套J2EE基础开发环境，可以在此基础上扩展相关的业务，方便、快速的开发出企业相关业务系统。</p>
			    <p><b>——设计理念——</b></p>
			    <p>传承经典,追求创新,为企业提供通用的基础系统框架。</p>
			    <p>它提供了类windows经典用户界面，更方便用户使用。</p>
			    <p><b>——使用技术——</b></p>
			    <p>后台框架：Freemark + Spring + Mybatis</p>
			    <p>前端技术：JQuery(plugin:artDialog.ztree.backstretch.contentmenu).js主流开发框架。</p>
			</div>
			<div class="box">
			    <div class="title"><span>特色</span></div>
			    <p>完备的企业组织架构、用户、权限管理，动态配置各个角色权限。</p>
			    <p>在线文件管理，无论何时何地都可以管理您的文件。</p>
			    <p>高度可定制，结合快捷键方便、高效的设计系统。</p>  
			    <p>完美中文支持,各种情况下乱码解决；</p>                    
			</div>
	    </div>
	</div>
</div>
</@dk.defaultFrame>

<@dk.end>
	<script src="${contextPath}/static/js/common/profile.js"></script>
</@dk.end>