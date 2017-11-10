package com.crm.action;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.crm.domain.CstCustomer;
import com.crm.domain.SaleVisit;
import com.crm.domain.SysUser;
import com.crm.service.saleVisitService;
import com.crm.utils.pageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class saleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {

	private SaleVisit saleVisit = new SaleVisit();
	private Integer currentPage;
	private Integer pageSize;
	
	private saleVisitService ss;
	
	//��ӿͻ��ݷü�¼
	public String save() throws Exception {
		// ��ȡ��ǰ��¼�û������뵽saleVisit�����У�����ϵ
		SysUser user = (SysUser) ActionContext.getContext().getSession().get("user");
		saleVisit.setSysUser(user);
		
		//����service����������ͻ��ݷü�¼
		ss.save(saleVisit);
		return "toList";
	}
	
	public String edit() throws Exception {
		SaleVisit sv = ss.getById(saleVisit.getVisitId());
		ActionContext.getContext().put("saleVisit", sv);
		return "toEdit";
		
	} 
	
	//��ҳ��ѯ
	public String list() throws Exception {
		
		//��װ���߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
		//�жϲ���װ���߲�ѯ����
		//������Ȼ�Ǹ��ݿͻ�������
		/*if(StringUtils.isNotBlank(saleVisit.getCstCustomer().getCustName())){
			dc.add(Restrictions.like("saleVisit", "%"+saleVisit.getCstCustomer().getCustName()+"%"));
		}*/
		//1 ����Service��ѯ��ҳ����(PageBean)��saveVisit��װ�˲�ѯ����
		pageBean pb = ss.getPageBean(dc,currentPage,pageSize);
		//2 ��PageBean����Request���У�ת�����б���ʾ
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}

	//setter����
	public SaleVisit getModel() {
		
		return saleVisit;
	}
	public void setSaleVisit(SaleVisit saleVisit) {
		this.saleVisit = saleVisit;
	}
	public void setSs(saleVisitService ss) {
		this.ss = ss;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	
	

}
