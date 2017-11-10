package com.crm.dao;

import com.crm.domain.SaleVisit;

public interface saleVisitDao extends BaseDao<SaleVisit> {

	void saveOrUpdate(SaleVisit saleVisit);

}
