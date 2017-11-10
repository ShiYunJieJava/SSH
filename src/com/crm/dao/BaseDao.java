package com.crm.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.domain.CstCustomer;

public interface BaseDao<T> {
	
	//�����
	void saveOrUpdate(T t);
	//��
	 void save(T t);
	//ɾ
	 void delete(T t);
	//ɾ
	 void delete(Serializable id);
	//��
	 void update(T t);
	//�� ����id��ѯ����
	 T getById(Serializable id);
	//�� ����dc��ѯ�ܼ�¼��
	 Integer getTotalCount(DetachedCriteria dc);
	//�� ����dc��ѯ�б�����
	List<T> getPageList(DetachedCriteria dc, int start, Integer pageSize); 
}
