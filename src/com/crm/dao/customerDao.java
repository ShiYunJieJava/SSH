package com.crm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.domain.CstCustomer;

public interface customerDao extends BaseDao<CstCustomer> {
	
	//���ͳ����ҵ����
	List<Object[]> getCount(String sql);

}
