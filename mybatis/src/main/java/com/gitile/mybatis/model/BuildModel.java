package com.gitile.mybatis.model;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.gitile.core.utils.DateUtils;
import com.gitile.mybatis.bean.Module;
import com.gitile.mybatis.bean.Table;
import com.gitile.mybatis.bean.TableColumn;
import com.gitile.mybatis.util.FileUtils;
import com.gitile.mybatis.util.StringUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class BuildModel {
	
	private String dateTime;
	
	public BuildModel() {
		dateTime = DateUtils.dateToString(new Date(), 4);
	}
	
	public void run(String configPath) {
		Module project = FileUtils.parseFromXml(configPath);
		if(project!=null) {
			List<Table> tables = project.getTables();
			for (Table table:tables) {
				tableToBean(project, table);
			}
		}
	}

	private void tableToBean(Module project, Table table) {
		String projectName = project.getCaption();
		String packagesName = project.getBasePkg()+".model";
		String tableName = table.getName();
		String tableComment = table.getComment();
		String modelName = StringUtils.dealLine(tableName, true);
		List<TableColumn> propertys = table.getColumns();
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_21);
		cfg.setEncoding(Locale.getDefault(), "UTF-8");
		cfg.setClassForTemplateLoading(this.getClass(),"/template");
		//得FreeMarker的关键对象———模板
		try {
			Template template = cfg.getTemplate("model.tmp.ftl");
			Map<String, Object> rootMap = new HashMap<String, Object>();
			rootMap.put("modelName", modelName);
			rootMap.put("dateTime", dateTime);
			rootMap.put("pakageName", packagesName);
			rootMap.put("projectName", projectName);
			rootMap.put("modelCaption", tableComment);
			rootMap.put("improtField", ModelTemplate.buildImprotField(propertys, packagesName, true));
			rootMap.put("nameField", ModelTemplate.buildNameField(propertys));
			rootMap.put("strutField", ModelTemplate.buildStrutField(propertys, modelName));
			rootMap.put("getSetField", ModelTemplate.buildGetSetField(propertys));
			String javaPath = StringUtils.pkgToPathMaven(packagesName);
			FileUtils.buildTemplateFile(rootMap, javaPath + "\\" + modelName + ".java", template);
			Template templateExample = cfg.getTemplate("model.example.tmp.ftl");
			rootMap.put("criteriaField", ModelTemplate.buildCriterion(propertys));
			rootMap.put("improtField", ModelTemplate.buildImprotField(propertys, packagesName, false));
			FileUtils.buildTemplateFile(rootMap, javaPath + "\\" + modelName + "Example.java", templateExample);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
