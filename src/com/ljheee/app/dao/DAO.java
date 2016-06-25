package com.ljheee.app.dao;

import java.util.List;

/**
 * 数据访问对象---CRUD
 * @author ljheee
 * @param <T>
 */
public interface DAO<T> {//让子类--实现指定具体的类型
	/**
	 * 存储
	 * @param t
	 */
	void save(T t);
	
	/**
	 * 按id查找
	 * @param id
	 * @return
	 */
	T find(long id);
	
	/**
	 * 获得所有对象
	 * @return   返回所有List
	 */
	List<T> find(); 
	
	void remove(long id);
	
	void update(T t);
	
}
