package com.crm.service;

import java.util.List;

import com.crm.domain.BaseDict;

public interface baseDictService {

	List<BaseDict> getListByTypeDode(String dictTypeCode);

}
