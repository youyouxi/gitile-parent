<Module 
	name="${module.name!'项目名'}"
	caption="${module.caption!'项目简称'}"
	base_pkg="${module.caption!'com.gitile.desktop.base'}"
	mybatis_path="${module.caption!'mybatis'}"
	mapper_path="${module.caption!'mybatis/mapper'}">
	<#list module.tables as table>
		<table name="${table.name!''}" comment="${table.comment!'TODO'}">
			<#list table.columns as column>
			<column name="${column.name!''}" type="${column.type!''}" length="${column.length!0}" digits="${column.digits!0}" caption="${column.caption!''}" notnull="${column.notnull?string('true', 'false')}"/>
			</#list>
			<#list table.primarys as primary>
			<primary column="${primary.column!''}" />
			</#list>
			<#list table.foreigns as foreign>
			<foreign name="${foreign.name!''}" column="${foreign.column!''}" relate="${foreign.relate!''}" relate_column="${foreign.relateColumn!''}" delete="${foreign.delete!''}" update="${foreign.update!''}"/>
			</#list>
		</table>
	</#list>
</Module>