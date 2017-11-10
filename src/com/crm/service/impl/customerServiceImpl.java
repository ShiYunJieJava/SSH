package com.crm.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.dao.customerDao;
import com.crm.domain.CstCustomer;
import com.crm.service.customerService;
import com.crm.utils.pageBean;

public class customerServiceImpl implements customerService {
	
	private customerDao cd;

	public pageBean getPageBean(DetachedCriteria dc, Integer currentPage,
			Integer pageSize) {
		//1.����Dao��ѯ�ܼ�¼��
		Integer totalCount = cd.getTotalCount(dc);
		//2. ����PageBean����
		pageBean pb = new pageBean(currentPage, totalCount, pageSize);
		//3. ����Dao��ѯ��ҳ�б�����
		List<CstCustomer> list = cd.getPageList(dc,pb.getStart(),pb.getPageSize());
		//4. �б����ݷ�װ��PageBean�У�������PageBean
		pb.setList(list);
		
		return pb;
	}
	
	//�����Ż��� �÷���������������������޸�
	public void save(CstCustomer customer) {
		//Ӧ��ά��Customer�������ֵ����Ĺ�ϵ��������Struts2������װ�������ֶ�ά����ϵ
		cd.saveOrUpdate(customer);
		
	}
	
	//���ͳ�ƿͻ���ҵ����
	public List<Object[]> getIndustryCount(){
		String sql = "select bd.dict_item_name, count(*) total"
			+" from cst_customer c, base_dict bd"
			+" where c.cust_industry = bd.dict_id"
			+" group by bd.dict_id";
		return cd.getCount(sql);
	}
	
	public List<Object[]> getSourceCount() {
		String sql = "select bd.dict_item_name, count(*) total"
					+" from cst_customer c, base_dict bd"
					+" where c.cust_source = bd.dict_id"
					+" group by bd.dict_id";
		return cd.getCount(sql);
	}
	
	public CstCustomer getById(Long custId) {
		return cd.getById(custId);
	}
	
	public void delete( CstCustomer customer ) {
		cd.delete(customer);
	}

	
	public void setCd(customerDao cd) {
		this.cd = cd;
	}

	

	

	

	
	
	

}
