package com.crm.service;

import javax.xml.registry.infomodel.User;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.dao.userDao;
import com.crm.domain.CstCustomer;
import com.crm.domain.SysUser;
import com.crm.utils.pageBean;

public interface userService {
	
	void regist(SysUser user);

	SysUser login(SysUser user);

	pageBean getPageBean(DetachedCriteria dc, Integer currentPage,
			Integer pageSize);

	SysUser getUserById(Long userId);

	void deleteById(Long userId);

}
