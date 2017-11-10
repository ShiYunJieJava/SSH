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
		//1.调用Dao查询总记录数
		Integer totalCount = cd.getTotalCount(dc);
		//2. 创建PageBean对象
		pageBean pb = new pageBean(currentPage, totalCount, pageSize);
		//3. 调用Dao查询分页列表数据
		List<CstCustomer> list = cd.getPageList(dc,pb.getStart(),pb.getPageSize());
		//4. 列表数据封装到PageBean中，并返回PageBean
		pb.setList(list);
		
		return pb;
	}
	
	//方法优化： 该方法既能完成添加又能完成修改
	public void save(CstCustomer customer) {
		//应该维护Customer与数据字典对象的关系，但由于Struts2参数封装，无需手动维护关系
		cd.saveOrUpdate(customer);
		
	}
	
	//获得统计客户行业数据
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
