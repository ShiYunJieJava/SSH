package com.crm.service;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.domain.CstLinkman;
import com.crm.utils.pageBean;

public interface linkmanService {

	void save(CstLinkman linkman);

	pageBean getPageBean(DetachedCriteria dc, Integer currentPage,
			Integer pageSize);

	CstLinkman getById(Long lkmId);

	void delete(CstLinkman linkman);

}
