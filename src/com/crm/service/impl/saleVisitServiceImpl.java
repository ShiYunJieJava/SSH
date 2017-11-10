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
		//1.����Dao��ѯ�ܼ�¼��
		Integer totalCount = sd.getTotalCount(dc);
		//2. ����PageBean����
		pageBean pb = new pageBean(currentPage, totalCount, pageSize);
		//3. ����Dao��ѯ��ҳ�б�����
		List<SaleVisit> list = sd.getPageList(dc,pb.getStart(),pb.getPageSize());
		//4. �б����ݷ�װ��PageBean�У�������PageBean
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
