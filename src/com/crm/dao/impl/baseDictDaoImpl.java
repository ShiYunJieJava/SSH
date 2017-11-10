package com.crm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.crm.dao.baseDictDao;
import com.crm.domain.BaseDict;

public class baseDictDaoImpl extends BaseDaoImpl<BaseDict> implements baseDictDao {

	public List<BaseDict> getListByTypeDode(String dictTypeCode) {
		//�������߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
		//��Ӳ�ѯ����
		dc.add(Restrictions.eq("dictTypeCode", dictTypeCode));
		
		return (List<BaseDict>)getHibernateTemplate().findByCriteria(dc);
	}
}
