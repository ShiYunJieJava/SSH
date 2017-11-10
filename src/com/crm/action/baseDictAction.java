package com.crm.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;

import com.crm.domain.BaseDict;
import com.crm.service.baseDictService;
import com.opensymphony.xwork2.ActionSupport;

public class baseDictAction extends ActionSupport {
	
	private String dictTypeCode;
	private baseDictService bds;
	
	@Override
	public String execute() throws Exception {
		List<BaseDict> list = bds.getListByTypeDode(dictTypeCode);
		//����õ�List����ת��ΪJson���󣬲����͸������
		String json = JSONArray.fromObject(list).toString();
		//����������
		ServletActionContext.getResponse().setContentType("application/json; charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		//���ؽ��Ϊnull,��ʾ����ҪStruts2����
		return null;
	}

	public void setDictTypeCode(String dictTypeCode) {
		this.dictTypeCode = dictTypeCode;
	}

	public void setBds(baseDictService bds) {
		this.bds = bds;
	}
	

}
