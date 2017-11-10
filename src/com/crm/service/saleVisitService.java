package com.crm.service;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.domain.SaleVisit;
import com.crm.utils.pageBean;

public interface saleVisitService {

	void save(SaleVisit saleVisit);

	pageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	SaleVisit getById(String visitId);

}
