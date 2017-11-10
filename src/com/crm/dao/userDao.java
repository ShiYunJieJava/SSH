package com.crm.dao;

import com.crm.domain.SysUser;

public interface userDao extends BaseDao<SysUser> {
	
	SysUser getUserByCode(String code);
	
}
