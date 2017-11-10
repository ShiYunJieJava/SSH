package com.crm.domain;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */

public class SysUser implements java.io.Serializable {

	// Fields

	private Long userId;
	private String userCode;
	private String userName;
	private String userPassword;
	private String userState;
	
	@JSONField(serialize=false)
	private Set saleVisits = new HashSet(0);

	// Constructors

	/** default constructor */
	public SysUser() {
	}

	/** minimal constructor */
	public SysUser(String userCode, String userName, String userPassword) {
		this.userCode = userCode;
		this.userName = userName;
		this.userPassword = userPassword;
	}

	/** full constructor */
	public SysUser(String userCode, String userName, String userPassword,
			String userState, Set saleVisits) {
		this.userCode = userCode;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userState = userState;
		this.saleVisits = saleVisits;
	}

	// Property accessors

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserState() {
		return this.userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public Set getSaleVisits() {
		return this.saleVisits;
	}

	public void setSaleVisits(Set saleVisits) {
		this.saleVisits = saleVisits;
	}

}