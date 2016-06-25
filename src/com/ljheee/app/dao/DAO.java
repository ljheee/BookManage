package com.ljheee.app.dao;

import java.util.List;

/**
 * ���ݷ��ʶ���---CRUD
 * @author ljheee
 * @param <T>
 */
public interface DAO<T> {//������--ʵ��ָ�����������
	/**
	 * �洢
	 * @param t
	 */
	void save(T t);
	
	/**
	 * ��id����
	 * @param id
	 * @return
	 */
	T find(long id);
	
	/**
	 * ������ж���
	 * @return   ��������List
	 */
	List<T> find(); 
	
	void remove(long id);
	
	void update(T t);
	
}
