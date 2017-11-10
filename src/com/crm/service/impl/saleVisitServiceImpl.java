package com.crm.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.dao.saleVisitDao;
import com.crm.domain.CstCustomer;
import com.crm.domain.SaleVisit;
import com.crm.service.saleVisitService;
import com.crm.utils.pageBean;

public class saleVisitServiceImpl implements saleVisitService {
	
	private saleVisitDao sd;

	public void save(SaleVisit saleVisit) {
		sd.saveOrUpdate(saleVisit);	
	}
	
	public pageBean getPageBean(DetachedCriteria dc, Integer currentPage,
			Integer pageSize) {
		//1.调用Dao查询总记录数
		Integer totalCount = sd.getTotalCount(dc);
		//2. 创建PageBean对象
		pageBean pb = new pageBean(currentPage, totalCount, pageSize);
		//3. 调用Dao查询分页列表数据
		List<SaleVisit> list = sd.getPageList(dc,pb.getStart(),pb.getPageSize());
		//4. 列表数据封装到PageBean中，并返回PageBean
		pb.setList(list);
		
		return pb;
	}
	
	public SaleVisit getById(String visitId) {
		return sd.getById(visitId);
	}

	public void setSd(saleVisitDao sd) {
		this.sd = sd;
	}

	

}
