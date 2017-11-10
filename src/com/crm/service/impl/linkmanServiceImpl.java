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
			//1.����Dao��ѯ�ܼ�¼��
			Integer totalCount = ld.getTotalCount(dc);
			//2. ����PageBean����
			pageBean pb = new pageBean(currentPage, totalCount, pageSize);
			//3. ����Dao��ѯ��ҳ�б�����
			List<CstLinkman> list = ld.getPageList(dc,pb.getStart(),pb.getPageSize());
			//4. �б����ݷ�װ��PageBean�У�������PageBean
			pb.setList(list);
			
			return pb;
		}
	public CstLinkman getById(Long lkmId) {
		
		return ld.getById(lkmId);
	}

	public void delete(CstLinkman linkman) {

		ld.delete(linkman);
	}
	
	
	//setter����
	public void setLd(linkmanDao ld) {
		this.ld = ld;
	}

	
	
	
	
	
		
}
