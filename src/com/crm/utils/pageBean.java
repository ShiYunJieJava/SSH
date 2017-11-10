package com.crm.utils;

import java.util.List;

public class pageBean {
	//当前页
	private Integer currentPage;
	//总条数
	private Integer totalCount; 
	//每页显示条数
	private Integer pageSize; 
	//总页数
	private Integer totalPage; 
	//每页显示的对象
	private List list;	
	
	
	
	public pageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		
		//如果用户未选择当前页以及每页显示的条数，则设置默认值
		if(this.currentPage == null){
			this.currentPage = 1;
		}
		if(this.pageSize == null){
			this.pageSize = 3;
		}
		
		this.totalPage = (this.totalCount+this.pageSize-1)/this.pageSize;
		
		//如果用户输入的页码不合乎逻辑
		if(this.currentPage <1){
			this.currentPage =1;
		}else if(this.currentPage > this.totalPage){
			this.currentPage = this.totalPage;
		}
	}
	
	//计算查询分页列表的起始索引
	public int getStart(){
		return (this.currentPage-1)*this.pageSize;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	

}
