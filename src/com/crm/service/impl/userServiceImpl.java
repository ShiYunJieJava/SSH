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
		//1.调用Dao查询总记录数
		Integer totalCount = ud.getTotalCount(dc);
		//2. 创建PageBean对象
		pageBean pb = new pageBean(currentPage, totalCount, pageSize);
		//3. 调用Dao查询分页列表数据
		List<SysUser> list = ud.getPageList(dc,pb.getStart(),pb.getPageSize());
		//4. 列表数据封装到PageBean中，并返回PageBean
		pb.setList(list);
		
		return pb;
	}
	
	public void deleteById(Long userId) {
		ud.delete(userId);
	}
	
	public SysUser login(SysUser user) {
		//1 根据登录名称获得用户对象
		 SysUser existUser = ud.getUserByCode(user.getUserCode());
		 //2 判断用户名是否存在
		 if (existUser == null) {
			 throw new RuntimeException("用户名不存在");	
		 }
		 //3 判断密码是否正确
		 if (!existUser.getUserPassword().equals(MD5Utils.md5(user.getUserPassword()))) {
			throw new RuntimeException("密码错误");
		}
		return existUser;
	}
	
	public void regist(SysUser user) {
				if(user.getUserId()==null){
					//1 调用Dao,根据用户登录名查询User对象
					SysUser existUser = ud.getUserByCode(user.getUserCode());
					//2 若User对象存在，则抛出异常
					if(existUser!=null){	//说明该登录名已存在
						throw new RuntimeException("用户名已存在！");
					}
				}
			
		
		//3 调用Dao，实现保存操作
		ud.saveOrUpdate(user);
			
	}

	public void setUd(userDao ud) {
		this.ud = ud;
	}


	

	

	
		
}
