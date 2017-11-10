package com.crm.dao;

import java.util.List;

import com.crm.domain.BaseDict;

public interface baseDictDao extends BaseDao<BaseDict> {

	List<BaseDict> getListByTypeDode(String dictTypeCode);

}
