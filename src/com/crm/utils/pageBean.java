package com.crm.utils;

import java.util.List;

public class pageBean {
	//��ǰҳ
	private Integer currentPage;
	//������
	private Integer totalCount; 
	//ÿҳ��ʾ����
	private Integer pageSize; 
	//��ҳ��
	private Integer totalPage; 
	//ÿҳ��ʾ�Ķ���
	private List list;	
	
	
	
	public pageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		
		//����û�δѡ��ǰҳ�Լ�ÿҳ��ʾ��������������Ĭ��ֵ
		if(this.currentPage == null){
			this.currentPage = 1;
		}
		if(this.pageSize == null){
			this.pageSize = 3;
		}
		
		this.totalPage = (this.totalCount+this.pageSize-1)/this.pageSize;
		
		//����û������ҳ�벻�Ϻ��߼�
		if(this.currentPage <1){
			this.currentPage =1;
		}else if(this.currentPage > this.totalPage){
			this.currentPage = this.totalPage;
		}
	}
	
	//�����ѯ��ҳ�б����ʼ����
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
