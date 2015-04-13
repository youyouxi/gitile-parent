package com.gitile.mybatis.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gitile.mybatis.bean.DataType;
import com.gitile.mybatis.bean.TableColumn;
import com.gitile.mybatis.util.StringUtils;

/**
 * 注解相关工具类
 *
 */
public class ModelTemplate {

	/**
	 * 构建包内容
	 * @param propertys
	 */
	public static String buildImprotField(List<TableColumn> propertys, String modelPackage, boolean base) {
		StringBuffer sb = new StringBuffer();
		Map<String, String> map = new HashMap<String, String>();
		for (TableColumn property:propertys) {
			String im = DataType.getImport(property.getType()+ "_IMPORT");
			if (im != null && map.get(im) == null) {
				map.put(im, im);
				sb.append(StringUtils.LINE);
				sb.append(im + ";");
			}
		}
		return sb.toString();
	}

	/**
	 * 构建相关属性
	 * @param propertys
	 * @return
	 */
	public static String buildNameField(List<TableColumn> propertys) {
		StringBuffer sb = new StringBuffer();
		for (TableColumn property:propertys) {
			String column = property.getName();
			String prop = StringUtils.dealLine(column, false);
			String columntype = property.getType();
			String proptype = DataType.getPojoType(columntype);
			String caption = property.getCaption();
			boolean notnull = property.isNotnull();
			sb.append(StringUtils.TAB);
			sb.append("private ");
			sb.append(proptype+" "+prop+";");
			sb.append("//");
			sb.append(" "+caption);
			if(notnull) {
				sb.append("（非空） ");
			}
			sb.append(StringUtils.LINE);
		}
		return sb.toString();
	}

	public static Object buildStrutField(List<TableColumn> propertys, String beanName) {
		StringBuffer sb = new StringBuffer();
		sb.append(StringUtils.TAB).append("public "+beanName+"() {}");
		StringBuffer strut = new StringBuffer();
		StringBuffer strutBody = new StringBuffer();
		StringBuffer notstrut = new StringBuffer();
		StringBuffer notstrutBody = new StringBuffer();
		for (int j = 0; j < propertys.size(); j++) {
			TableColumn property = propertys.get(j);
			String column = property.getName();
			boolean notnull = property.isNotnull();
			String pojoType = DataType.getPojoType(property.getType());
			String name = StringUtils.dealLine(column, false);
			if(notnull) {
				if(j!=0) {
					notstrut.append(",");
				}
				notstrut.append(pojoType+" "+name);
				notstrutBody.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append("this."+name+"="+name+";");
			}
			if(j!=0) {
				strut.append(",");
			}
			strut.append(pojoType+" "+name);
			strutBody.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append("this."+name+"="+name+";");
		}
		
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append("public "+beanName+"("+strut+") {");
		sb.append(strutBody);
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append("}");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append("public "+beanName+" setNotNull("+notstrut+") {");
		sb.append(notstrutBody);
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append("return this;");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append("}");
		return sb.toString();
	}

	public static String buildGetSetField(List<TableColumn> propertys) {
		StringBuffer sb = new StringBuffer();
		for (TableColumn property:propertys) {
			String pojoType = DataType.getPojoType(property.getType());
			String column = property.getName();
			sb.append(buildgetSetStr(column, pojoType));
		}
		return sb.toString();
	}
	
	/**
	 * 构建get set函数
	 * @param column
	 * @param pojoType
	 * @return
	 */
	public static String buildgetSetStr(String column, String pojoType) {
		StringBuffer sb = new StringBuffer();
		String columnName = StringUtils.dealLine(column, false);
		String methName = StringUtils.dealLine(column, true);
		String getName = null;
		String setName = null;
		if (column.length() > 1) {
			getName = "public " + pojoType + " get"
					+ methName + "() {";
			setName = "public void set"
					+ methName + "("
					+ pojoType + " " + columnName + ") {";
		} else {
			getName = "public get" + column.toUpperCase() + "() {";
			setName = "public set" + column.toUpperCase() + "("
					+ pojoType + " " + column + ") {";
		}
		sb.append(StringUtils.TAB).append(getName);
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("return " + columnName + ";");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append("}");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(setName);
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("this." + columnName + " = " + columnName + ";");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append("}");
		sb.append(StringUtils.LINE);
		return sb.toString();
	}
	
	/**
	 * 构建查询条件
	 * @return
	 */
	public static String buildCriterion(List<TableColumn> propertys) {
		StringBuffer sb = new StringBuffer();
		for (TableColumn property:propertys) {
			String pojoType = DataType.getPojoType(property.getType());
			String column = property.getName();
			String prop = StringUtils.dealLine(column, true);
			String propl = StringUtils.dealLine(column, false);
			sb.append(buildCriterionItem(column, pojoType, prop, propl));
		}
		return sb.toString();
	}
	
	private static String buildCriterionItem(String column, String pojoType, String prop, String propl) {
		StringBuffer sb = new StringBuffer();
		// 是否为空
		sb.append(StringUtils.LINE).append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("public Criteria and"+prop+"IsNull() {");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("addCriterion(\""+column+" is null\");");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("return (Criteria) this;");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("}");
		
		sb.append(StringUtils.LINE).append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("public Criteria and"+prop+"IsNotNull() {");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("addCriterion(\""+column+" is not null\");");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("return (Criteria) this;");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("}");
		// 相等或不等
		sb.append(StringUtils.LINE).append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("public Criteria and"+prop+"EqualTo("+pojoType+" value) {");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("addCriterion(\""+column+" =\", value, \""+propl+"\");");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("return (Criteria) this;");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("}");
		
		sb.append(StringUtils.LINE).append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("public Criteria and"+prop+"NotEqualTo("+pojoType+" value) {");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("addCriterion(\""+column+" <>\", value, \""+propl+"\");");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("return (Criteria) this;");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("}");
		// 大于或小于
		sb.append(StringUtils.LINE).append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("public Criteria and"+prop+"GreaterThan("+pojoType+" value) {");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("addCriterion(\""+column+" >\", value, \""+propl+"\");");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("return (Criteria) this;");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("}");
		
		sb.append(StringUtils.LINE).append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("public Criteria and"+prop+"GreaterThanOrEqualTo("+pojoType+" value) {");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("addCriterion(\""+column+" >=\", value, \""+propl+"\");");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("return (Criteria) this;");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("}");
		
		sb.append(StringUtils.LINE).append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("public Criteria and"+prop+"LessThan("+pojoType+" value) {");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("addCriterion(\""+column+" <\", value, \""+propl+"\");");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("return (Criteria) this;");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("}");
		
		sb.append(StringUtils.LINE).append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("public Criteria and"+prop+"LessThanOrEqualTo("+pojoType+" value) {");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("addCriterion(\""+column+" <=\", value, \""+propl+"\");");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("return (Criteria) this;");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("}");
		// 可选值
		sb.append(StringUtils.LINE).append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("public Criteria and"+prop+"In(List<"+pojoType+"> values) {");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("addCriterion(\""+column+" in\", values, \""+propl+"\");");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("return (Criteria) this;");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("}");
		
		sb.append(StringUtils.LINE).append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("public Criteria and"+prop+"NotIn(List<"+pojoType+"> values) {");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("addCriterion(\""+column+" not in\", values, \""+propl+"\");");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("return (Criteria) this;");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("}");
		
		// 范围
		sb.append(StringUtils.LINE).append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("public Criteria and"+prop+"Between("+pojoType+" value1, "+pojoType+" value2) {");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("addCriterion(\""+column+" between\", value1, value2, \""+propl+"\");");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("return (Criteria) this;");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("}");
		
		sb.append(StringUtils.LINE).append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("public Criteria and"+prop+"NotBetween("+pojoType+" value1, "+pojoType+" value2) {");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("addCriterion(\""+column+" not between\", value1, value2, \""+propl+"\");");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("return (Criteria) this;");
		sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		sb.append("}");
		
		if("String".equals(pojoType)) {
			sb.append(StringUtils.LINE).append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
			sb.append("public Criteria and"+prop+"Like("+pojoType+" value) {");
			sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
			sb.append("addCriterion(\""+column+" like\", value, \""+propl+"\");");
			sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
			sb.append("return (Criteria) this;");
			sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
			sb.append("}");
			
			sb.append(StringUtils.LINE).append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
			sb.append("public Criteria and"+prop+"NotLike("+pojoType+" value) {");
			sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
			sb.append("addCriterion(\""+column+" not like\", value, \""+propl+"\");");
			sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
			sb.append("return (Criteria) this;");
			sb.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
			sb.append("}");
		}
		 
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(buildCriterionItem("id", "String", "id", "id"));
	}


}
