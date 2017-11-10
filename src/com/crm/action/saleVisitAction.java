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
	
	//添加客户拜访记录
	public String save() throws Exception {
		// 获取当前登录用户，放入到saleVisit对象中，表达关系
		SysUser user = (SysUser) ActionContext.getContext().getSession().get("user");
		saleVisit.setSysUser(user);
		
		//调用service方法，保存客户拜访记录
		ss.save(saleVisit);
		return "toList";
	}
	
	public String edit() throws Exception {
		SaleVisit sv = ss.getById(saleVisit.getVisitId());
		ActionContext.getContext().put("saleVisit", sv);
		return "toEdit";
		
	} 
	
	//分页查询
	public String list() throws Exception {
		
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
		//判断并封装离线查询条件
		//条件仍然是根据客户的名称
		/*if(StringUtils.isNotBlank(saleVisit.getCstCustomer().getCustName())){
			dc.add(Restrictions.like("saleVisit", "%"+saleVisit.getCstCustomer().getCustName()+"%"));
		}*/
		//1 调用Service查询分页数据(PageBean)，saveVisit封装了查询条件
		pageBean pb = ss.getPageBean(dc,currentPage,pageSize);
		//2 将PageBean放入Request域中，转发到列表显示
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}

	//setter方法
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
