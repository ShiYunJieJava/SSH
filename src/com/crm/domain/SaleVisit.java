package com.crm.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * SaleVisit entity. @author MyEclipse Persistence Tools
 */

public class SaleVisit implements java.io.Serializable {

	// Fields

	private String visitId;
	
	//µ›πÈ Ù–‘◊¢ ÕµÙ
	@JSONField(serialize=false)
	private CstCustomer cstCustomer;
	
	private SysUser sysUser;
	private Date visitTime;
	private String visitInterviewee;
	private String visitAddr;
	private String visitDetail;
	private Date visitNexttime;

	// Constructors

	/** default constructor */
	public SaleVisit() {
	}

	/** full constructor */
	public SaleVisit(CstCustomer cstCustomer, SysUser sysUser, Date visitTime,
			String visitInterviewee, String visitAddr, String visitDetail,
			Date visitNexttime) {
		this.cstCustomer = cstCustomer;
		this.sysUser = sysUser;
		this.visitTime = visitTime;
		this.visitInterviewee = visitInterviewee;
		this.visitAddr = visitAddr;
		this.visitDetail = visitDetail;
		this.visitNexttime = visitNexttime;
	}

	// Property accessors
	
	
	public String getVisitTimeNew() {
		return transferDate(visitTime,"yyyy-MM-dd");
	}
	public String getVisitNexttimeNew() {
		return transferDate(visitNexttime,"yyyy-MM-dd");
	}
	public static String  transferDate(Date date,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	//-----------------------------------------------
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}
	public void setVisitNexttime(Date visitNexttime) {
		this.visitNexttime = visitNexttime;
	}

	public String getVisitId() {
		return this.visitId;
	}

	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}

	public CstCustomer getCstCustomer() {
		return this.cstCustomer;
	}

	public void setCstCustomer(CstCustomer cstCustomer) {
		this.cstCustomer = cstCustomer;
	}

	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public Date getVisitTime() {
		return this.visitTime;
	}

	

	public String getVisitInterviewee() {
		return this.visitInterviewee;
	}

	public void setVisitInterviewee(String visitInterviewee) {
		this.visitInterviewee = visitInterviewee;
	}

	public String getVisitAddr() {
		return this.visitAddr;
	}

	public void setVisitAddr(String visitAddr) {
		this.visitAddr = visitAddr;
	}

	public String getVisitDetail() {
		return this.visitDetail;
	}

	public void setVisitDetail(String visitDetail) {
		this.visitDetail = visitDetail;
	}

	public Date getVisitNexttime() {
		return this.visitNexttime;
	}

	

}