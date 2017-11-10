package com.crm.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.dao.linkmanDao;
import com.crm.domain.CstLinkman;
import com.crm.service.linkmanService;
import com.crm.utils.pageBean;

public class linkmanServiceImpl implements linkmanService {
	
	private linkmanDao ld;

	public void save(CstLinkman linkman) {
		
		ld.saveOrUpdate(linkman);
	}
	
	public pageBean getPageBean(DetachedCriteria dc, Integer currentPage,Integer pageSize) {
			//1.调用Dao查询总记录数
			Integer totalCount = ld.getTotalCount(dc);
			//2. 创建PageBean对象
			pageBean pb = new pageBean(currentPage, totalCount, pageSize);
			//3. 调用Dao查询分页列表数据
			List<CstLinkman> list = ld.getPageList(dc,pb.getStart(),pb.getPageSize());
			//4. 列表数据封装到PageBean中，并返回PageBean
			pb.setList(list);
			
			return pb;
		}
	public CstLinkman getById(Long lkmId) {
		
		return ld.getById(lkmId);
	}

	public void delete(CstLinkman linkman) {

		ld.delete(linkman);
	}
	
	
	//setter方法
	public void setLd(linkmanDao ld) {
		this.ld = ld;
	}

	
	
	
	
	
		
}
