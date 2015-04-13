package com.gitile.mybatis.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gitile.mybatis.bean.Module;
import com.gitile.mybatis.bean.Table;
import com.gitile.mybatis.bean.TableColumn;
import com.gitile.mybatis.bean.TableForeign;
import com.gitile.mybatis.bean.TablePrimary;

/**
 * 数据库相关操作
 *
 */
public class DBUtils {
	
	/**
	 * 获取Mysql数据库连接
	 * @param url
	 * @param username
	 * @param password
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getMySqlConnection(String url, String username,
			String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = null;
		connection = DriverManager.getConnection(url, username, password);
		return connection;
	}

	/**
	 * 将数据库表结构转换成module对象
	 * @param conn
	 * @return
	 */
	public static Module tableToModule(Connection conn) {
		Module module = new Module();
		List<Table> tables = new ArrayList<Table>();
		try {
			DatabaseMetaData databaseMetaData = conn.getMetaData();
			String[] tableType = { "TABLE" };
			ResultSet rs = databaseMetaData.getTables(null, null, "%", tableType);
			while (rs.next()) {
				Table table = new Table();
				String tableName = rs.getString("TABLE_NAME");
				// TODO 获取表的注解，此方法不能获取
				String caption = rs.getString("REMARKS");
				table.setName(tableName);
				table.setComment(caption);
				// 获取主键名称
				ResultSet primaryKeyResultSet = databaseMetaData.getPrimaryKeys(null,null,tableName);
				List<TablePrimary> primarys = new ArrayList<TablePrimary>();
				while(primaryKeyResultSet.next()){
					TablePrimary primary = new TablePrimary();
				    String columnName = primaryKeyResultSet.getString("COLUMN_NAME"); 
				    primary.setColumn(columnName);
				    primarys.add(primary);
				}
				table.setPrimarys(primarys);
				// 获取外键名称
				List<TableForeign> foreigns = new ArrayList<TableForeign>();
				ResultSet foreignKeyResultSet = databaseMetaData.getImportedKeys(null ,null,tableName);  
				while(foreignKeyResultSet.next()){
					String fkColumnName = foreignKeyResultSet.getString("FKCOLUMN_NAME");
				    String pkTablenName = foreignKeyResultSet.getString("PKTABLE_NAME");
				    String fkName = foreignKeyResultSet.getString("FK_NAME");
				    String pkColumnName = foreignKeyResultSet.getString("PKCOLUMN_NAME");
				    /**
				     * 1. CASCADE: 从父表中删除或更新对应的行，同时自动的删除或更新自表中匹配的行。
				     * 				ON DELETE CANSCADE和ON UPDATE CANSCADE都被InnoDB所支持。
					 * 2. SETNULL: 从父表中删除或更新对应的行，同时将子表中的外键列设为空。
					 * 			     注意，这些在外键列没有被设为NOT NULL时才有效。
					 * 			   ON DELETE SET NULL和ON UPDATE SET SET NULL都被InnoDB所支持。
					 * 3. NOACTION: InnoDB拒绝删除或者更新父表。
					 * 4. RESTRICT: 拒绝删除或者更新父表。指定RESTRICT（或者NO ACTION）
					 * 				和忽略ON DELETE或者ON UPDATE选项的效果是一样的。
					 * 5. SET DEFAULT: InnoDB目前不支持。
				     */
				    String deleteRule = foreignKeyResultSet.getString("DELETE_RULE");
				    String updateRule = foreignKeyResultSet.getString("UPDATE_RULE");
				    TableForeign foreign = new TableForeign();
				    foreign.setName(fkName);
				    foreign.setColumn(fkColumnName);
				    foreign.setRelate(pkTablenName);
				    foreign.setRelateColumn(pkColumnName);
				    foreign.setDelete(deleteRule);
				    foreign.setUpdate(updateRule);
				    foreigns.add(foreign);
				}
				table.setForeigns(foreigns);
				List<TableColumn> columns = buildTableColumn(databaseMetaData, tableName);
				table.setColumns(columns);
				tables.add(table);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		module.setTables(tables);
		return module;
	}

	/**
	 * 编辑表结构属性
	 */
	private static List<TableColumn> buildTableColumn(DatabaseMetaData databaseMetaData, String tableName) throws SQLException {
		List<TableColumn> columns = new ArrayList<TableColumn>();
		ResultSet colRet = databaseMetaData.getColumns(null, "%", tableName,"%");
		while(colRet.next()) { 
			String columnName = colRet.getString("COLUMN_NAME"); 
			String columnType = colRet.getString("TYPE_NAME"); 
			int datasize = colRet.getInt("COLUMN_SIZE"); 
			int digits = colRet.getInt("DECIMAL_DIGITS"); 
			int nullable = colRet.getInt("NULLABLE");
			String caption = colRet.getString("REMARKS");
			boolean notnull = true;
			if(nullable==1) {
				notnull = false;
			}
			TableColumn column = new TableColumn();
			column.setCaption(caption);
			column.setName(columnName);
			column.setType(columnType);
			column.setDigits(digits);
			column.setLength(datasize);
			column.setNotnull(notnull);
			columns.add(column);
		}
		return columns;
	}

}
