package com.crm.interceptor;

import java.util.Map;

import com.crm.domain.SysUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class PrivilegeInterceptor extends MethodFilterInterceptor{

	@Override
	//校验除过登录和注册的所有方法
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//1 获得session
		Map<String, Object> session = ActionContext.getContext().getSession();
		//2 获得登录标识
		SysUser user = (SysUser) session.get("user");
		//3 判断标识是否存在
		if(user!=null){
			//存在，放行
			return invocation.invoke();
		}else{
			//不存在，跳转到登录页面
			return "toLogin";
		}
	}

}
