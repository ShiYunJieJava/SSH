package com.crm.service.impl;

import java.util.List;

import com.crm.dao.baseDictDao;
import com.crm.domain.BaseDict;
import com.crm.service.baseDictService;

public class baseDictServiceImpl implements baseDictService {
	
	private baseDictDao bdd;

	public List<BaseDict> getListByTypeDode(String dictTypeCode) {
		
		return bdd.getListByTypeDode(dictTypeCode);
	}

	public void setBdd(baseDictDao bdd) {
		this.bdd = bdd;
	}
	
	

}
