package com.gitile.core.mybatis.dao;

import java.util.List;

import com.gitile.core.mybatis.model.BaseExample;

/**
 * 数据库基本操作接口
 */
public interface BaseDao<T> {
	
	/**
	 * 根据ID取数据
	 * @param id
	 * @return
	 */
	public T selectById(Object id);

	/**
	 * 保存数据
	 * @param record
	 */
	public int save(T record);

	/**
	 * 更新数据(全部)
	 * @param record
	 */
	public int update(T record);
	
	/**
	 * 更新数据(部分)
	 * @param record
	 */
	public int updateSelective(T record);

	/**
	 * 根据ID删除一个数据
	 * @param id
	 */
	public int delete(Object id);

	/**
	 * 根据查询条件取数据
	 * @param example
	 * @return
	 */
	public T selectByExample(BaseExample example);	
	
    /**
	 * 获取所有数据
	 * @return
	 */
	public List<T> selectListByExample(BaseExample example);
	
	/**
	 * 获取数据总数
	 * @return
	 */	
	public int selectCountByExample(BaseExample example);
	
	/**
	 * 根据条件更新数据(部分)
	 * @param record
	 * @param example
	 */
	int updateByExampleSelective(T record, BaseExample example);
	
	/**
	 * 根据条件更新数据(全部)
	 * @param record
	 * @param example
	 */
    int updateByExample(T record, BaseExample example);

}
