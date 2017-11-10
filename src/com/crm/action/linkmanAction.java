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
	
	//模型驱动
	private CstLinkman linkman = new CstLinkman();
	//属性驱动,有对应的Setter方法
	private Integer currentPage;
	private Integer pageSize;
	private linkmanService ls;
	
	
	//分页查询
	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(CstLinkman.class);
		//判断并封装离线查询条件
		if(StringUtils.isNotBlank(linkman.getLkmName())){
			dc.add(Restrictions.like("lkmName", "%"+linkman.getLkmName()+"%"));
		}
		if(linkman.getCstCustomer()!=null && linkman.getCstCustomer().getCustId()!=null){
			dc.add(Restrictions.like("cstCustomer.custId", (linkman.getCstCustomer().getCustId())));
		}
		//1 调用Service查询分页数据(PageBean)，customer封装了查询条件
		pageBean pb = ls.getPageBean(dc,currentPage,pageSize);
		//2 将PageBean放入Request域中，转发到列表显示
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	
	//添加
	public String save() throws Exception {
		ls.save(linkman);
		return "toList";
	}
	
	//修改
	public String edit() throws Exception {
		CstLinkman man = ls.getById(linkman.getLkmId());
		System.out.println(man.getLkmId());
		//2 将该对象放置到request域中，转发到add.jsp页面进行回显
		ActionContext.getContext().put("linkman", man);
		return "toEdit";
	} 
	
	//删除
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
