package com.crm.action;

import java.io.File;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.crm.domain.CstCustomer;
import com.crm.service.customerService;
import com.crm.utils.pageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class customerAction extends ActionSupport implements ModelDriven<CstCustomer> {
	
	//模型驱动
	private CstCustomer customer = new CstCustomer();
	//属性驱动,有对应的Setter方法
	private Integer currentPage;
	private Integer pageSize;
	private customerService cs;
	
	//文件上传
	private File photo;
	
	//获得客户行业统计数据
	public String getIndustryCount() throws Exception {
		List<Object[]> list = cs.getIndustryCount();
		ActionContext.getContext().put("industrylist", list);
		return "industryCount";
	}
	
	//获得客户来源统计数据
	public String getSourceCount() throws Exception {
		List<Object[]> list = cs.getSourceCount();
		System.out.println(list.size());
		ActionContext.getContext().put("sourcelist", list);
		return "industryCount";
	}
	
	
	//分页查询
	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(CstCustomer.class);
		//判断并封装离线查询条件
		if(StringUtils.isNotBlank(customer.getCustName())){
			dc.add(Restrictions.like("custName", "%"+customer.getCustName()+"%"));
		}
		//1 调用Service查询分页数据(PageBean)，customer封装了查询条件
		pageBean pb = cs.getPageBean(dc,currentPage,pageSize);
		//2 将PageBean放入Request域中，转发到列表显示
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	//添加用户
	public String save() throws Exception {
		if(photo!=null){
			photo.renameTo(new File("H:/fileUploadTest.jpg"));	
		}
		//添加或修改用户
		cs.save(customer);
		return "toList";
	}
	
	//修改用户
	public String edit() throws Exception {
		//1 调用Service方法 根据栈顶对象的id获得该对象
		
		CstCustomer c = cs.getById(customer.getCustId());
		//2 将该对象放置到request域中，转发到add.jsp页面进行回显
		ActionContext.getContext().put("customer", c);
		return "toEdit";
	} 
	
	//删除用户
	public String delete() throws Exception {
		CstCustomer c = cs.getById(customer.getCustId());
		cs.delete(c);
		return "toList";
	} 
	
	
	//getter/setter
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public void setCs(customerService cs) {
		this.cs = cs;
	}
	public CstCustomer getModel() {
		return customer;
	}
	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}

}
