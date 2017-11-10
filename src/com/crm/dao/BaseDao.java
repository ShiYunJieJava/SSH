package com.crm.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.domain.CstCustomer;

public interface BaseDao<T> {
	
	//增或改
	void saveOrUpdate(T t);
	//增
	 void save(T t);
	//删
	 void delete(T t);
	//删
	 void delete(Serializable id);
	//改
	 void update(T t);
	//查 根据id查询对象
	 T getById(Serializable id);
	//查 根据dc查询总记录数
	 Integer getTotalCount(DetachedCriteria dc);
	//查 根据dc查询列表数据
	List<T> getPageList(DetachedCriteria dc, int start, Integer pageSize); 
}
