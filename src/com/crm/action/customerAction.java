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
	
	//ģ������
	private CstCustomer customer = new CstCustomer();
	//��������,�ж�Ӧ��Setter����
	private Integer currentPage;
	private Integer pageSize;
	private customerService cs;
	
	//�ļ��ϴ�
	private File photo;
	
	//��ÿͻ���ҵͳ������
	public String getIndustryCount() throws Exception {
		List<Object[]> list = cs.getIndustryCount();
		ActionContext.getContext().put("industrylist", list);
		return "industryCount";
	}
	
	//��ÿͻ���Դͳ������
	public String getSourceCount() throws Exception {
		List<Object[]> list = cs.getSourceCount();
		System.out.println(list.size());
		ActionContext.getContext().put("sourcelist", list);
		return "industryCount";
	}
	
	
	//��ҳ��ѯ
	public String list() throws Exception {
		//��װ���߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(CstCustomer.class);
		//�жϲ���װ���߲�ѯ����
		if(StringUtils.isNotBlank(customer.getCustName())){
			dc.add(Restrictions.like("custName", "%"+customer.getCustName()+"%"));
		}
		//1 ����Service��ѯ��ҳ����(PageBean)��customer��װ�˲�ѯ����
		pageBean pb = cs.getPageBean(dc,currentPage,pageSize);
		//2 ��PageBean����Request���У�ת�����б���ʾ
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	//����û�
	public String save() throws Exception {
		if(photo!=null){
			photo.renameTo(new File("H:/fileUploadTest.jpg"));	
		}
		//��ӻ��޸��û�
		cs.save(customer);
		return "toList";
	}
	
	//�޸��û�
	public String edit() throws Exception {
		//1 ����Service���� ����ջ�������id��øö���
		
		CstCustomer c = cs.getById(customer.getCustId());
		//2 ���ö�����õ�request���У�ת����add.jspҳ����л���
		ActionContext.getContext().put("customer", c);
		return "toEdit";
	} 
	
	//ɾ���û�
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
