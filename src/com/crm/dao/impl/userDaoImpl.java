package com.crm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import com.crm.dao.userDao;
import com.crm.domain.SysUser;

public class userDaoImpl extends BaseDaoImpl<SysUser> implements userDao {

	public SysUser getUserByCode(String code) {
		DetachedCriteria dc = DetachedCriteria.forClass(SysUser.class);
		dc.add(Restrictions.eq("userCode", code));
		List<SysUser> list = (List<SysUser>)getHibernateTemplate().findByCriteria(dc);
		if (list!=null && list.size()>0) {
			return list.get(0);
		}else{
			return null;
		}		
	}

}
