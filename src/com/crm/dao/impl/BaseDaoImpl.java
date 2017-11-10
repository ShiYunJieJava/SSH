package com.crm.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.crm.dao.BaseDao;
import com.crm.domain.CstCustomer;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class clazz;
	
	public void saveOrUpdate(T t) {
		getHibernateTemplate().saveOrUpdate(t);
		
	}
	public BaseDaoImpl() {
		ParameterizedType ptClass  = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class) ptClass.getActualTypeArguments()[0];
	}

	public void delete(T t) {
		getHibernateTemplate().delete(t);	
	}

	public void delete(Serializable id) {
		T t = this.getById(id);
		getHibernateTemplate().delete(t);
		
	}

	public T getById(Serializable id) {
		return (T) getHibernateTemplate().get(clazz, id);
	}

	public List<T> getPageList(DetachedCriteria dc, int start, Integer pageSize) {
		List<T> list = (List<T>)getHibernateTemplate().findByCriteria(dc, start, pageSize);
		return list;
	}

	public Integer getTotalCount(DetachedCriteria dc) {
		//设置查询的聚合函数
		dc.setProjection(Projections.rowCount());
		
		List list = getHibernateTemplate().findByCriteria(dc);
		
		//设置清空的聚合函数
		dc.setProjection(null);
		
		if(list!= null && list.size()>0){
			Integer rowCount = (Integer) list.get(0);
			return rowCount;
		}
		return null;
	}

	public void save(T t) {
		getHibernateTemplate().save(t);
		
	}
	public void update(T t) {
		getHibernateTemplate().update(t);
		
	}

	

}
