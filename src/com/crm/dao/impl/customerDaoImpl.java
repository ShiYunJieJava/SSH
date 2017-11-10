package com.crm.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.crm.dao.customerDao;
import com.crm.domain.CstCustomer;

public class customerDaoImpl extends BaseDaoImpl<CstCustomer> implements customerDao {
	
	public List<Object[]> getCount(String sql){
		
		final String sqlNew = sql;
		List<Object[]> list = getHibernateTemplate().execute(new HibernateCallback<List<Object[]>>() {

			public List<Object[]> doInHibernate(Session session) throws HibernateException,
					SQLException {	
				return 	session.createSQLQuery(sqlNew).list();	
			}
		});
		return list;
	}
}
