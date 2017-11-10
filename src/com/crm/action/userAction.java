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
	
	//前台--->栈顶对象--->后台
	//后台--->ActionContext(request域)--->前台
	private SysUser user = new SysUser();
	private userService us;
	
	/*private Integer currentPage;
	private Integer pageSize;*/
	
	private Integer page;
	private Integer rows;
	
	//分页查询列表显示
	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(SysUser.class);
		//1 调用Service查询分页数据(PageBean)，customer封装了查询条件
		pageBean pb = us.getPageBean(dc,page,rows);
		//2 将列表数据转换为json发送给浏览器
		
		//total：总记录数
		//rows: 每行显示的数据
		//{total:xx, rows:[{userId:1, userName:'tom'}]}
		Map map = new HashMap();
		
		map.put("total", pb.getTotalCount());
		map.put("rows", pb.getList());
		
		
		
		//JsonConfig config = new JsonConfig();
		//设置生成Json时不包含哪些字段,关联级别的属性要特别注意，防止死循环
		//而没有关联级别的属性，比如数据字典 在配置文件中many to one要设置lazy属性为false
		//									one to many中的对象直接在config变量中setExcludes
		//2.1 将map转换为json
		String json = JSON.toJSONString(map);
		//System.out.println(json);
		//2.2 将Json发送给浏览器
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		
		return null;
	}
	
	//删除
	public String delete() throws Exception {
		us.deleteById(user.getUserId());
		return null;
	}
	
	
	
	//修改
	public String getUserById() throws Exception {
		SysUser u = us.getUserById(user.getUserId());
		//设置user的密码为空字符串，避免回显
		u.setUserPassword("");
		String json = JSON.toJSONString(u);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		
		return null;
		
	}
	
	//登录
	public String login() throws Exception {
		SysUser u = us.login(user);
		//将返回的User对象放到Session域中
		ActionContext.getContext().getSession().put("user", u);
		return "toHome";
	}
	//添加
	public String regist() throws Exception {
		// 调用service方法保存新用户,在保存用户前，使用MD5Utils为用户加密
		try {
			user.setUserPassword(MD5Utils.md5(user.getUserPassword()));
			us.regist(user);
		} catch (Exception e) {	//	若抛出异常，则将异常信息保存到request域中
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
