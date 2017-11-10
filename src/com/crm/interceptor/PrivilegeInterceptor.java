package com.crm.interceptor;

import java.util.Map;

import com.crm.domain.SysUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class PrivilegeInterceptor extends MethodFilterInterceptor{

	@Override
	//У�������¼��ע������з���
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//1 ���session
		Map<String, Object> session = ActionContext.getContext().getSession();
		//2 ��õ�¼��ʶ
		SysUser user = (SysUser) session.get("user");
		//3 �жϱ�ʶ�Ƿ����
		if(user!=null){
			//���ڣ�����
			return invocation.invoke();
		}else{
			//�����ڣ���ת����¼ҳ��
			return "toLogin";
		}
	}

}
