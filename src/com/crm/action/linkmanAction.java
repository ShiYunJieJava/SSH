package com.crm.action;

import java.io.File;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.crm.domain.CstCustomer;
import com.crm.domain.CstLinkman;
import com.crm.service.customerService;
import com.crm.service.linkmanService;
import com.crm.utils.pageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class linkmanAction extends ActionSupport implements ModelDriven<CstLinkman> {
	
	//ģ������
	private CstLinkman linkman = new CstLinkman();
	//��������,�ж�Ӧ��Setter����
	private Integer currentPage;
	private Integer pageSize;
	private linkmanService ls;
	
	
	//��ҳ��ѯ
	public String list() throws Exception {
		//��װ���߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(CstLinkman.class);
		//�жϲ���װ���߲�ѯ����
		if(StringUtils.isNotBlank(linkman.getLkmName())){
			dc.add(Restrictions.like("lkmName", "%"+linkman.getLkmName()+"%"));
		}
		if(linkman.getCstCustomer()!=null && linkman.getCstCustomer().getCustId()!=null){
			dc.add(Restrictions.like("cstCustomer.custId", (linkman.getCstCustomer().getCustId())));
		}
		//1 ����Service��ѯ��ҳ����(PageBean)��customer��װ�˲�ѯ����
		pageBean pb = ls.getPageBean(dc,currentPage,pageSize);
		//2 ��PageBean����Request���У�ת�����б���ʾ
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	
	//���
	public String save() throws Exception {
		ls.save(linkman);
		return "toList";
	}
	
	//�޸�
	public String edit() throws Exception {
		CstLinkman man = ls.getById(linkman.getLkmId());
		System.out.println(man.getLkmId());
		//2 ���ö�����õ�request���У�ת����add.jspҳ����л���
		ActionContext.getContext().put("linkman", man);
		return "toEdit";
	} 
	
	//ɾ��
	public String delete() throws Exception {
		ls.delete(linkman);
		return "toList";
	}


	public CstLinkman getModel() {
		return linkman;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public void setLs(linkmanService ls) {
		this.ls = ls;
	}
	
	
	

}
