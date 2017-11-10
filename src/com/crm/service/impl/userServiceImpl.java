package com.crm.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.dao.userDao;
import com.crm.domain.CstCustomer;
import com.crm.domain.SysUser;
import com.crm.service.userService;
import com.crm.utils.MD5Utils;
import com.crm.utils.pageBean;

public class userServiceImpl implements userService {
	
	private userDao ud;
	
	public SysUser getUserById(Long userId) {
		SysUser user = ud.getById(userId);
		return user;
	}
	
	
	public pageBean getPageBean(DetachedCriteria dc, Integer currentPage,
			Integer pageSize) {
		//1.����Dao��ѯ�ܼ�¼��
		Integer totalCount = ud.getTotalCount(dc);
		//2. ����PageBean����
		pageBean pb = new pageBean(currentPage, totalCount, pageSize);
		//3. ����Dao��ѯ��ҳ�б�����
		List<SysUser> list = ud.getPageList(dc,pb.getStart(),pb.getPageSize());
		//4. �б����ݷ�װ��PageBean�У�������PageBean
		pb.setList(list);
		
		return pb;
	}
	
	public void deleteById(Long userId) {
		ud.delete(userId);
	}
	
	public SysUser login(SysUser user) {
		//1 ���ݵ�¼���ƻ���û�����
		 SysUser existUser = ud.getUserByCode(user.getUserCode());
		 //2 �ж��û����Ƿ����
		 if (existUser == null) {
			 throw new RuntimeException("�û���������");	
		 }
		 //3 �ж������Ƿ���ȷ
		 if (!existUser.getUserPassword().equals(MD5Utils.md5(user.getUserPassword()))) {
			throw new RuntimeException("�������");
		}
		return existUser;
	}
	
	public void regist(SysUser user) {
				if(user.getUserId()==null){
					//1 ����Dao,�����û���¼����ѯUser����
					SysUser existUser = ud.getUserByCode(user.getUserCode());
					//2 ��User������ڣ����׳��쳣
					if(existUser!=null){	//˵���õ�¼���Ѵ���
						throw new RuntimeException("�û����Ѵ��ڣ�");
					}
				}
			
		
		//3 ����Dao��ʵ�ֱ������
		ud.saveOrUpdate(user);
			
	}

	public void setUd(userDao ud) {
		this.ud = ud;
	}


	

	

	
		
}
