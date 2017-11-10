package com.crm.action;


import java.util.HashMap;
import java.util.Map;

import net.sf.json.JsonConfig;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.alibaba.fastjson.JSON;
import com.crm.domain.CstCustomer;
import com.crm.domain.SysUser;
import com.crm.service.userService;
import com.crm.utils.MD5Utils;
import com.crm.utils.pageBean;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class userAction extends ActionSupport implements ModelDriven<SysUser>{
	
	//ǰ̨--->ջ������--->��̨
	//��̨--->ActionContext(request��)--->ǰ̨
	private SysUser user = new SysUser();
	private userService us;
	
	/*private Integer currentPage;
	private Integer pageSize;*/
	
	private Integer page;
	private Integer rows;
	
	//��ҳ��ѯ�б���ʾ
	public String list() throws Exception {
		//��װ���߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(SysUser.class);
		//1 ����Service��ѯ��ҳ����(PageBean)��customer��װ�˲�ѯ����
		pageBean pb = us.getPageBean(dc,page,rows);
		//2 ���б�����ת��Ϊjson���͸������
		
		//total���ܼ�¼��
		//rows: ÿ����ʾ������
		//{total:xx, rows:[{userId:1, userName:'tom'}]}
		Map map = new HashMap();
		
		map.put("total", pb.getTotalCount());
		map.put("rows", pb.getList());
		
		
		
		//JsonConfig config = new JsonConfig();
		//��������Jsonʱ��������Щ�ֶ�,�������������Ҫ�ر�ע�⣬��ֹ��ѭ��
		//��û�й�����������ԣ����������ֵ� �������ļ���many to oneҪ����lazy����Ϊfalse
		//									one to many�еĶ���ֱ����config������setExcludes
		//2.1 ��mapת��Ϊjson
		String json = JSON.toJSONString(map);
		//System.out.println(json);
		//2.2 ��Json���͸������
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		
		return null;
	}
	
	//ɾ��
	public String delete() throws Exception {
		us.deleteById(user.getUserId());
		return null;
	}
	
	
	
	//�޸�
	public String getUserById() throws Exception {
		SysUser u = us.getUserById(user.getUserId());
		//����user������Ϊ���ַ������������
		u.setUserPassword("");
		String json = JSON.toJSONString(u);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		
		return null;
		
	}
	
	//��¼
	public String login() throws Exception {
		SysUser u = us.login(user);
		//�����ص�User����ŵ�Session����
		ActionContext.getContext().getSession().put("user", u);
		return "toHome";
	}
	//���
	public String regist() throws Exception {
		// ����service�����������û�,�ڱ����û�ǰ��ʹ��MD5UtilsΪ�û�����
		try {
			user.setUserPassword(MD5Utils.md5(user.getUserPassword()));
			us.regist(user);
		} catch (Exception e) {	//	���׳��쳣�����쳣��Ϣ���浽request����
			ActionContext.getContext().put("error", e.getMessage());
			return "registError";
		}
		return "toLogin";
	}
	
	

	
	public void setUs(userService us) {
		this.us = us;
	}
	public SysUser getModel() {
		return user;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	

	/*public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}*/
	
}
