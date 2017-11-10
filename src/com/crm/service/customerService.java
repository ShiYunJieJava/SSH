package com.crm.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.domain.CstCustomer;
import com.crm.utils.pageBean;

public interface customerService {

	//分页 列表查询
	pageBean getPageBean(DetachedCriteria dc, Integer currentPage,Integer pageSize);

	//保存用户
	void save(CstCustomer customer);

	CstCustomer getById(Long custId);

	void delete(CstCustomer customer);
	
	List<Object[]> getIndustryCount();

	List<Object[]> getSourceCount();

}
