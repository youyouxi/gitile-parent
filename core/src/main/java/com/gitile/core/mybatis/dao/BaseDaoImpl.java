package com.gitile.core.mybatis.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.gitile.core.mybatis.dao.BaseDao;
import com.gitile.core.mybatis.dao.SqlId;
import com.gitile.core.mybatis.model.BaseExample;

/**
 * 数据库基本操作实现
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

    @Autowired(required = true)
    protected SqlSession sqlSessionTemplate;
    
    public final static String SQLNAME_SEPARATOR = ".";

    //获取泛型T
    private Class<?> classt;

    private String sqlNamespace;

    public BaseDaoImpl(){
        Type t = this.getClass().getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
            this.classt = ((Class<?>) p[0]);
        }
        this.sqlNamespace = this.classt.getName();
    }

    /**
     * 将SqlMapping命名空间与给定的SqlMapping名组合在一起。
     * @param sqlName SqlMapping名
     * @return 组合了SqlMapping命名空间后的完整SqlMapping名
     */
    protected String getSqlName(String sqlName) {
        return sqlNamespace + SQLNAME_SEPARATOR + sqlName;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public T selectById(Object id) {
        return (T)sqlSessionTemplate.selectOne(getSqlName(SqlId.SQL_SELECTBYID), id);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public T selectByExample(BaseExample example) {
        return (T)sqlSessionTemplate.selectOne(getSqlName(SqlId.SQL_SELECTBYEXAMPLE), example);
    }
    
    @Override
	public List<T> selectListByExample(BaseExample example) {
    	return sqlSessionTemplate.selectList(getSqlName(SqlId.SELECTLISTBYEXAMPLE), example);
    }
    
    @Override
	public int selectCountByExample(BaseExample example) {
    	return sqlSessionTemplate.selectOne(getSqlName(SqlId.SELECTCOUNTBYEXAMPLE), example);
    }

    @Override
    public int save(T record) {
        return sqlSessionTemplate.insert(getSqlName(SqlId.SQL_SAVE), record);
    }
    
    @Override
    public int update(T record) {
        return sqlSessionTemplate.update(getSqlName(SqlId.SQL_UPDATE), record);
    }
 
    @Override
    public int updateSelective(T record) {
        return sqlSessionTemplate.update(getSqlName(SqlId.SQL_UPDATESELECTIVE), record);
    }
    
    @Override
    public int updateByExample(T record, BaseExample example) {
    	Map<String, Object> query = new HashMap<String, Object>();
    	query.put("record", record);
    	query.put("example", example);
        return sqlSessionTemplate.update(getSqlName(SqlId.SQL_UPDATEBYEXAMPLE), query);
    }
 
    @Override
    public int updateByExampleSelective(T record, BaseExample example) {
    	Map<String, Object> query = new HashMap<String, Object>();
    	query.put("record", record);
    	query.put("example", example);
        return sqlSessionTemplate.update(getSqlName(SqlId.SQL_UPDATEBYEXAMPLESELECTIVE), query);
    }
    
    @Override
    public int delete(Object id) {
        return sqlSessionTemplate.delete(getSqlName(SqlId.SQL_DELETE), id);
    }

}
