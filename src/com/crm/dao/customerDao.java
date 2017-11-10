package com.crm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.domain.CstCustomer;

public interface customerDao extends BaseDao<CstCustomer> {
	
	//获得统计行业数据
	List<Object[]> getCount(String sql);

}
