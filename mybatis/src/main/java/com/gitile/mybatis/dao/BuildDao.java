package com.gitile.mybatis.dao;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.gitile.core.utils.DateUtils;
import com.gitile.mybatis.bean.Module;
import com.gitile.mybatis.bean.Table;
import com.gitile.mybatis.util.FileUtils;
import com.gitile.mybatis.util.StringUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class BuildDao {
	
	private String dateTime;

	public BuildDao() {
		dateTime = DateUtils.dateToString(new Date(), 4);
	}

	public void run(String configPath) {
		Module project = FileUtils.parseFromXml(configPath);
		if(project!=null) {
			List<Table> tables = project.getTables();
			for (Table table:tables) {
				tableToDao(project, table);
				tableToDaoImpl(project, table);
			}
		}
	}

	private void tableToDao(Module project, Table table) {
		String projectName = project.getCaption();
		String tableName = table.getName();
		String tableComment = table.getComment();
		String packagesName = project.getBasePkg()+".dao";
		String modelName = StringUtils.dealLine(tableName, true);
		String javaPath = StringUtils.pkgToPathMaven(packagesName);
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_21);
		cfg.setEncoding(Locale.getDefault(), "UTF-8");
		cfg.setClassForTemplateLoading(this.getClass(),"/template");
		//得FreeMarker的关键对象———模板
		try {
			Template template = cfg.getTemplate("dao.tmp.ftl");
			Map<String, Object> rootMap = new HashMap<String, Object>();
			rootMap.put("modelName", modelName);
			rootMap.put("dateTime", dateTime);
			rootMap.put("daoPakageName", packagesName);
			rootMap.put("projectName", projectName);
			rootMap.put("modelCaption", tableComment);
			FileUtils.buildTemplateFile(rootMap, javaPath + "\\" + modelName + "Dao.java", template);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void tableToDaoImpl(Module project, Table table) {
		String projectName = project.getCaption();
		String tableName = table.getName();
		String tableComment = table.getComment();
		String daoPakageName = project.getBasePkg()+".dao";
		String modelPakageName = project.getBasePkg()+".model";
		String modelName = StringUtils.dealLine(tableName, true);
		String javaPath = StringUtils.pkgToPathMaven(daoPakageName+".impl");
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_21);
		cfg.setEncoding(Locale.getDefault(), "UTF-8");
		cfg.setClassForTemplateLoading(this.getClass(),"/template");
		//得FreeMarker的关键对象———模板
		try {
			Template template = cfg.getTemplate("dao.impl.tmp.ftl");
			Map<String, Object> rootMap = new HashMap<String, Object>();
			rootMap.put("modelName", modelName);
			rootMap.put("dateTime", dateTime);
			rootMap.put("daoPakageName", daoPakageName);
			rootMap.put("modelPakageName", modelPakageName);
			rootMap.put("projectName", projectName);
			rootMap.put("modelCaption", tableComment);
			FileUtils.buildTemplateFile(rootMap, javaPath + "\\" + modelName + "DaoImpl.java", template);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
