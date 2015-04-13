package com.gitile.mybatis.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.gitile.mybatis.bean.Module;
import com.gitile.mybatis.bean.Table;
import com.gitile.mybatis.bean.TableColumn;
import com.gitile.mybatis.bean.TableForeign;
import com.gitile.mybatis.bean.TablePrimary;

import freemarker.template.Template;

/**
 * 文件操作工具类
 *
 */
public class FileUtils {
	
	/**
	 * 生成java文件
	 * @param filePath
	 * @param fileContent
	 */
	public static void buildJavaFile(String filePath, String fileContent) {
		try {
			File file = new File(filePath);
			FileOutputStream osw = new FileOutputStream(file);
			PrintWriter pw = new PrintWriter(osw);
			pw.println(fileContent);
			pw.close();
		} catch (Exception e) {
			System.out.println("生成txt文件出错：" + e.getMessage());
		}
	}
	
	/**
	 * 生成java文件
	 * @param filePath
	 * @param fileContent
	 */
	public static void buildTemplateFile(Map<String, Object> rootMap, String realFileName, Template template) {
		//如果已經存在不创建
		File realFile = new File(realFileName);
		if (!realFile.exists()) {
			try {
				Writer out = new OutputStreamWriter(new FileOutputStream(realFileName), "UTF-8");
				template.process(rootMap, out);
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 生成配置文件
	 */
	public static void buildConfigFile(Map<String, Object> rootMap, String savePath, Template template) {
		String realFileName = savePath + "/config.xml";
		String realSavePath = savePath;
		File newsDir = new File(realSavePath);
		if (!newsDir.exists()) {
			newsDir.mkdirs();
		}
		//如果已經存在不创建
		File realFile = new File(realFileName);
		if (!realFile.exists()) {
			try {
				Writer out = new OutputStreamWriter(new FileOutputStream(realFileName), "UTF-8");
				template.process(rootMap, out);
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 从config.xml读取配置
	 * @param filePath
	 * @return
	 */
	public static Module parseFromXml(String filePath) {
		Module project = new Module();
		Document document = parse(filePath); 
		Element rootElement = document.getDocumentElement();
		project.setName(rootElement.getAttribute("name"));
		project.setCaption(rootElement.getAttribute("caption"));
		project.setBasePkg(rootElement.getAttribute("base_pkg"));
		project.setMapperPath(rootElement.getAttribute("mapper_path"));
		project.setMybatisPath(rootElement.getAttribute("mybatis_path"));
		List<Table> tables = new ArrayList<Table>();
		NodeList elements = rootElement.getElementsByTagName("table");
		for (int i = 0 ; i < elements.getLength(); i++){ 
			Element element = (Element)elements.item(i);
			Table table = new Table();
			table.setName(element.getAttribute("name"));
			table.setComment(element.getAttribute("comment"));
			// 设置字段
			List<TableColumn> columns = new ArrayList<TableColumn>();
            NodeList column_items = element.getElementsByTagName("column");
            for (int j = 0 ; j < column_items.getLength(); j++){
            	TableColumn column = new TableColumn();
            	Element item = (Element)column_items.item(j);
            	column.setName(item.getAttribute("name"));
            	column.setType(item.getAttribute("type"));
            	column.setCaption(item.getAttribute("caption"));
            	column.setLength(StringUtils.toInt(item.getAttribute("length")));
            	column.setDigits(StringUtils.toInt(item.getAttribute("digits")));
            	column.setNotnull(StringUtils.toBoolean(item.getAttribute("notnull")));
            	columns.add(column);
            }
            table.setColumns(columns);
            // 设置主键
            List<TablePrimary> primarys = new ArrayList<TablePrimary>();
            NodeList primary_items = element.getElementsByTagName("primary");
            for (int j = 0 ; j < primary_items.getLength(); j++){
            	TablePrimary primary = new TablePrimary();
            	Element item = (Element)primary_items.item(j);
            	primary.setColumn(item.getAttribute("column"));
            	primarys.add(primary);
            }
            table.setPrimarys(primarys);
            // 设置外键
            List<TableForeign> foreigns = new ArrayList<TableForeign>();
            NodeList foreign_items = element.getElementsByTagName("foreign");
            for (int j = 0 ; j < foreign_items.getLength(); j++){
            	TableForeign foreign = new TableForeign();
            	Element item = (Element)foreign_items.item(j);
            	foreign.setName(item.getAttribute("name"));
            	foreign.setColumn(item.getAttribute("column"));
            	foreign.setDelete(item.getAttribute("delete"));
            	foreign.setUpdate(item.getAttribute("update"));
            	foreign.setRelate(item.getAttribute("relate"));
            	foreign.setRelateColumn(item.getAttribute("relate_column"));
            	foreigns.add(foreign);
            }
            table.setForeigns(foreigns);
            tables.add(table);
		}
		project.setTables(tables);
		return project;
	}
	
	public static Document parse(String filePath) {
		Document document = null; 
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			document = builder.parse(new File(filePath)); 
		} catch (Exception e) { 
			e.printStackTrace();  
		}
		return document; 
	}

}
