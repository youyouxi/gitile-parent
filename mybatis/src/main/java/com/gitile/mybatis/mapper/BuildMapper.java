package com.gitile.mybatis.mapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.gitile.mybatis.bean.Module;
import com.gitile.mybatis.bean.Table;
import com.gitile.mybatis.util.FileUtils;
import com.gitile.mybatis.util.StringUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class BuildMapper {

	public void run(String configPath) {
		Module project = FileUtils.parseFromXml(configPath);
		String mybatisPath = project.getMybatisPath();
		String mapperPath = project.getMapperPath();
		StringBuilder result = new StringBuilder();
		if(project!=null) {
			List<Table> tables = project.getTables();
			for (Table table:tables) {
				String tableName = table.getName();
				String modelName = StringUtils.dealLine(tableName, true);
				result.append(StringUtils.TAB).append(StringUtils.TAB);
				result.append("<mapper resource=\""+mapperPath+"/"+modelName+"Mapper.xml\"/>");
				result.append(StringUtils.LINE);
				tableToMapper(project, table);
			}
		}
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_21);
		cfg.setEncoding(Locale.getDefault(), "UTF-8");
		cfg.setClassForTemplateLoading(this.getClass(),"/template");
		try {
			Template template = cfg.getTemplate("mybatis.tmp.ftl");
			Map<String, Object> rootMap = new HashMap<String, Object>();
			rootMap.put("mybatisContent", result.toString());
			FileUtils.buildTemplateFile(rootMap, StringUtils.buildResourcesPathMaven(mybatisPath) + "\\" + "mybatis-config.xml", template);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void tableToMapper(Module project, Table table) {
		String modelPakageName = project.getBasePkg()+".model";
		String mapperPath = project.getMapperPath();
		String tableName = table.getName();
		String modelName = StringUtils.dealLine(tableName, true);
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_21);
		cfg.setEncoding(Locale.getDefault(), "UTF-8");
		cfg.setClassForTemplateLoading(this.getClass(),"/template");
		//得FreeMarker的关键对象———模板
		try {
			Template template = cfg.getTemplate("mapper.tmp.ftl");
			Map<String, Object> rootMap = new HashMap<String, Object>();
			rootMap.put("modelName", modelName);
			rootMap.put("modelPakageName", modelPakageName);;
			rootMap.put("mapperContent", MapperTemplate.buildMapperContent(table, modelPakageName));
			FileUtils.buildTemplateFile(rootMap, StringUtils.buildResourcesPathMaven(mapperPath) + "\\" + modelName + "Mapper.xml", template);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
