package com.gitile.mybatis.mapper;

import java.util.List;

import com.gitile.mybatis.bean.Table;
import com.gitile.mybatis.bean.TableColumn;
import com.gitile.mybatis.util.StringUtils;


public class MapperTemplate {

	public static String buildMapperContent(Table table, String modelPakageName) {
		StringBuilder result = new StringBuilder();
		String tableName = table.getName();
		String modelName = StringUtils.dealLine(tableName, true);
		List<TableColumn> propertys = table.getColumns();
		StringBuilder resultMap = new StringBuilder();
		StringBuilder param = new StringBuilder();
		StringBuilder values = new StringBuilder();
		StringBuilder saveparam = new StringBuilder();
		StringBuilder savevalues = new StringBuilder();
		StringBuilder update = new StringBuilder();
		StringBuilder update2 = new StringBuilder();
		StringBuilder updateSelective = new StringBuilder();
		StringBuilder updateSelective2 = new StringBuilder();
		boolean isLong = true;
		for (int i = 0; i < propertys.size(); i++) {
			TableColumn p = propertys.get(i);
			String column = p.getName();
			String prop = StringUtils.dealLine(column, false);
			if(i!=0) {
				param.append(",");
				values.append(",");
			}
			resultMap.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
			resultMap.append("<result column=\""+column+"\" property=\""+prop+"\" />");
			param.append(column);
			values.append("#{"+prop+"}");
			if(!"id".equals(column)) {
				if(StringUtils.isNotEmpty(saveparam.toString())) {
					saveparam.append(",");
				}
				if(StringUtils.isNotEmpty(savevalues.toString())) {
					savevalues.append(",");
				}
				saveparam.append(column);
				savevalues.append("#{"+prop+"}");
				update.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
				update.append(column+" = #{record."+prop+"},");
				update2.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
				update2.append(column+" = #{"+prop+"},");
				updateSelective.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
				updateSelective.append("<if test=\"record."+prop+" != null\">"+column+" = #{record."+prop+"},</if>");
				updateSelective2.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
				updateSelective2.append("<if test=\""+prop+" != null\">"+column+" = #{"+prop+"},</if>");
			} else {
				if(p.getType().equalsIgnoreCase("VARCHAR")) {
					isLong = false;
				}
			}
		}
		result.append(buildResultMap(resultMap.toString(), modelPakageName, modelName));
		result.append(buildBaseColumn(param.toString()));
		result.append(buildSelectById(tableName, isLong));
		result.append(buildDelete(tableName, isLong));
		result.append(buildSave(tableName, modelPakageName, modelName, saveparam.toString(), savevalues.toString(), isLong));
		result.append(buildUpdate(tableName, modelPakageName, modelName, update2.toString()));
		result.append(buildUpdateSelective(tableName, modelPakageName, modelName, updateSelective2.toString()));
		result.append(buildExampleWhereClause());
		result.append(buildUpdateByExampleWhereClause());
		result.append(buildSelectByExample(tableName, modelPakageName, modelName));
		result.append(buildSelectListByExample(tableName, modelPakageName, modelName));
		result.append(buildSelectCountByExample(tableName, modelPakageName, modelName));
		result.append(buildUpdateByExample(tableName, modelPakageName, modelName, update.toString()));
		result.append(buildUpdateByExampleSelective(tableName, modelPakageName, modelName, updateSelective.toString()));
		return result.toString();
	}

	private static String buildResultMap(String param, String modelPakageName, String modelName) {
		StringBuilder result = new StringBuilder();
		result.append(StringUtils.LINE).append(StringUtils.TAB);
		result.append("<resultMap id=\"BaseResultMap\" type=\""+modelPakageName+"."+modelName+"\">");
		result.append(param);
		result.append(StringUtils.LINE).append(StringUtils.TAB);
		result.append("</resultMap>");
		return result.toString();
	}
	
	private static String buildBaseColumn(String param) {
		StringBuilder result = new StringBuilder();
		result.append(StringUtils.LINE).append(StringUtils.TAB);
		result.append("<sql id=\"Base_Column_List\">");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append(param);
		result.append(StringUtils.LINE).append(StringUtils.TAB);
		result.append("</sql>");
		return result.toString();
	}
	
	private static String buildSelectById(String tableName, boolean isLong) {
		String idType = "";
		if(isLong) {
			idType = "java.lang.Long";
		} else {
			idType = "java.lang.String";
		}
		StringBuilder result = new StringBuilder();
		result.append(StringUtils.LINE).append(StringUtils.TAB);
		result.append("<select id=\"selectById\" resultMap=\"BaseResultMap\" parameterType=\""+idType+"\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("select <include refid=\"Base_Column_List\" /> from "+tableName+" where id = #{id}");
		result.append(StringUtils.LINE).append(StringUtils.TAB);
		result.append("</select>");
		return result.toString();
	}
	
	private static String buildDelete(String tableName, boolean isLong) {
		String idType = "";
		if(isLong) {
			idType = "java.lang.Long";
		} else {
			idType = "java.lang.String";
		}
		StringBuilder result = new StringBuilder();
		result.append(StringUtils.LINE).append(StringUtils.TAB);
		result.append("<delete id=\"delete\" parameterType=\""+idType+"\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("delete from "+tableName+" where id = #{id}");
		result.append(StringUtils.LINE).append(StringUtils.TAB);
		result.append("</delete>");
		return result.toString();
	}
	
	private static String buildSave(String tableName, 
			String modelPakageName, String modelName,
			String param, String values, boolean isLong) {
		String useGeneratedKeys = "";
		if(isLong) {
			useGeneratedKeys = "useGeneratedKeys=\"true\" keyProperty=\"id\"";
		} else {
			param = "id,"+param;
			values = "#{id},"+values;
		}
		StringBuilder result = new StringBuilder();
		result.append(StringUtils.LINE).append(StringUtils.TAB);
		result.append("<insert id=\"save\" parameterType=\""+modelPakageName+"."+modelName+"\" "+useGeneratedKeys+">");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("insert into "+tableName+"("+param+") values ("+values+");");
		result.append(StringUtils.LINE).append(StringUtils.TAB);
		result.append("</insert>");
		return result.toString();
	}
	
	private static String buildUpdate(String tableName, 
			String modelPakageName, String modelName,
			String update) {
		StringBuilder result = new StringBuilder();
		result.append(StringUtils.LINE).append(StringUtils.TAB);
		result.append("<update id=\"update\" parameterType=\""+modelPakageName+"."+modelName+"\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("update "+tableName);
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<set> ");
		result.append(update);
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</set> ");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("where id = #{id}");
		result.append(StringUtils.LINE).append(StringUtils.TAB);
		result.append("</update>");
		return result.toString();
	}
	
	private static String buildUpdateSelective(String tableName, 
			String modelPakageName, String modelName,
			String update) {
		StringBuilder result = new StringBuilder();
		result.append(StringUtils.LINE).append(StringUtils.TAB);
		result.append("<update id=\"updateSelective\" parameterType=\""+modelPakageName+"."+modelName+"\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("update "+tableName);
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<set> ");
		result.append(update);
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</set> ");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("where id = #{id}");
		result.append(StringUtils.LINE).append(StringUtils.TAB);
		result.append("</update>");
		return result.toString();
	}
	
	private static String buildExampleWhereClause() {
		StringBuilder result = new StringBuilder();
		result.append(StringUtils.LINE).append(StringUtils.TAB);
		result.append("<sql id=\"Example_Where_Clause\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<where>");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<foreach collection=\"oredCriteria\" item=\"criteria\" separator=\"or\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<if test=\"criteria.valid\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<trim prefix=\"(\" suffix=\")\" prefixOverrides=\"and\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<foreach collection=\"criteria.criteria\" item=\"criterion\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<choose >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<when test=\"criterion.noValue\" >and ${criterion.condition}</when>");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<when test=\"criterion.singleValue\" >and ${criterion.condition} #{criterion.value}</when>");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<when test=\"criterion.betweenValue\" >and ${criterion.condition} #{criterion.value} and #{criterion.secondValue}</when>");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<when test=\"criterion.listValue\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("and ${criterion.condition}");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<foreach collection=\"criterion.value\" item=\"listItem\" open=\"(\" close=\")\" separator=\",\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("#{listItem}");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</foreach>");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</when>");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</choose >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</foreach>");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</trim>");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</if>");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</foreach>");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</where>");
		result.append(StringUtils.LINE).append(StringUtils.TAB);
		result.append("</sql>");
		return result.toString();
	}
	
	private static String buildUpdateByExampleWhereClause() {
		StringBuilder result = new StringBuilder();
		result.append(StringUtils.LINE).append(StringUtils.TAB);
		result.append("<sql id=\"Update_By_Example_Where_Clause\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<where>");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<foreach collection=\"example.oredCriteria\" item=\"criteria\" separator=\"or\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<if test=\"criteria.valid\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<trim prefix=\"(\" suffix=\")\" prefixOverrides=\"and\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<foreach collection=\"criteria.criteria\" item=\"criterion\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<choose >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<when test=\"criterion.noValue\" >and ${criterion.condition}</when>");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<when test=\"criterion.singleValue\" >and ${criterion.condition} #{criterion.value}</when>");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<when test=\"criterion.betweenValue\" >and ${criterion.condition} #{criterion.value} and #{criterion.secondValue}</when>");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<when test=\"criterion.listValue\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("and ${criterion.condition}");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<foreach collection=\"criterion.value\" item=\"listItem\" open=\"(\" close=\")\" separator=\",\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("#{listItem}");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</foreach>");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</when>");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</choose >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</foreach>");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</trim>");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</if>");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</foreach>");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</where>");
		result.append(StringUtils.LINE).append(StringUtils.TAB);
		result.append("</sql>");
		return result.toString();
	}

	private static String buildSelectByExample(String tableName, 
			String modelPakageName, String modelName) {
		StringBuilder result = new StringBuilder();
		result.append(StringUtils.LINE).append(StringUtils.TAB);
		result.append("<select id=\"selectByExample\" resultMap=\"BaseResultMap\" parameterType=\""+modelPakageName+"."+modelName+"Example\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("select");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<if test=\"distinct\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("distinct");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</if>");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("'true' as QUERYID,");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<include refid=\"Base_Column_List\" />");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("from "+tableName);
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<if test=\"_parameter != null\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<include refid=\"Example_Where_Clause\" />");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</if>");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<if test=\"orderByClause != null\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("order by ${orderByClause}");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</if>");
		result.append(StringUtils.LINE).append(StringUtils.TAB);
		result.append("</select>");
		return result.toString();
	}
	
	private static String buildSelectListByExample(String tableName, 
			String modelPakageName, String modelName) {
		StringBuilder result = new StringBuilder();
		result.append(StringUtils.LINE).append(StringUtils.TAB);
		result.append("<select id=\"selectListByExample\" resultMap=\"BaseResultMap\" parameterType=\""+modelPakageName+"."+modelName+"Example\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("select");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<if test=\"distinct\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("distinct");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</if>");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("'true' as QUERYID,");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<include refid=\"Base_Column_List\" />");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("from "+tableName);
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<if test=\"_parameter != null\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<include refid=\"Example_Where_Clause\" />");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</if>");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<if test=\"orderByClause != null\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("order by ${orderByClause}");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</if>");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<if test=\"limitByClause != null\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("limit ${limitByClause}");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</if>");
		result.append(StringUtils.LINE).append(StringUtils.TAB);
		result.append("</select>");
		return result.toString();
	}

	private static String buildSelectCountByExample(String tableName, 
			String modelPakageName, String modelName) {
		StringBuilder result = new StringBuilder();
		result.append(StringUtils.LINE).append(StringUtils.TAB);
		result.append("<select id=\"selectCountByExample\" resultType=\"java.lang.Integer\" parameterType=\""+modelPakageName+"."+modelName+"Example\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("select count(*) from "+tableName);
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<if test=\"_parameter != null\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<include refid=\"Example_Where_Clause\" />");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</if>");
		result.append(StringUtils.LINE).append(StringUtils.TAB);
		result.append("</select>");
		return result.toString();
	}
	
	private static String buildUpdateByExample(String tableName, 
			String modelPakageName, String modelName,
			String update) {
		StringBuilder result = new StringBuilder();
		result.append(StringUtils.LINE).append(StringUtils.TAB);
		result.append("<update id=\"updateByExample\" parameterType=\"map\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("update "+tableName);
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<set> ");
		result.append(update);
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</set> ");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<if test=\"_parameter != null\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<include refid=\"Update_By_Example_Where_Clause\" />");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</if>");
		result.append(StringUtils.LINE).append(StringUtils.TAB);
		result.append("</update>");
		return result.toString();
	}

	private static String buildUpdateByExampleSelective(String tableName, 
			String modelPakageName, String modelName,
			String update) {
		StringBuilder result = new StringBuilder();
		result.append(StringUtils.LINE).append(StringUtils.TAB);
		result.append("<update id=\"updateByExampleSelective\" parameterType=\"map\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("update "+tableName);
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<set> ");
		result.append(update);
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</set> ");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<if test=\"_parameter != null\" >");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("<include refid=\"Update_By_Example_Where_Clause\" />");
		result.append(StringUtils.LINE).append(StringUtils.TAB).append(StringUtils.TAB);
		result.append("</if>");
		result.append(StringUtils.LINE).append(StringUtils.TAB);
		result.append("</update>");
		return result.toString();
	}


}
