package com.crm.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * CstCustomer entity. @author MyEclipse Persistence Tools
 */

public class CstCustomer implements java.io.Serializable {

	// Fields

	private Long custId;
	private BaseDict baseDictByCustLevel;
	private BaseDict baseDictByCustIndustry;
	private BaseDict baseDictByCustSource;
	private String custName;
	private Long custUserId;
	private Long custCreateId;
	private String custLinkman;
	private String custPhone;
	private String custMobile;
	private Set saleVisits = new HashSet(0);
	private Set cstLinkmans = new HashSet(0);

	// Constructors

	/** default constructor */
	public CstCustomer() {
	}

	/** minimal constructor */
	public CstCustomer(String custName) {
		this.custName = custName;
	}

	/** full constructor */
	public CstCustomer(BaseDict baseDictByCustLevel,
			BaseDict baseDictByCustIndustry, BaseDict baseDictByCustSource,
			String custName, Long custUserId, Long custCreateId,
			String custLinkman, String custPhone, String custMobile,
			Set saleVisits, Set cstLinkmans) {
		this.baseDictByCustLevel = baseDictByCustLevel;
		this.baseDictByCustIndustry = baseDictByCustIndustry;
		this.baseDictByCustSource = baseDictByCustSource;
		this.custName = custName;
		this.custUserId = custUserId;
		this.custCreateId = custCreateId;
		this.custLinkman = custLinkman;
		this.custPhone = custPhone;
		this.custMobile = custMobile;
		this.saleVisits = saleVisits;
		this.cstLinkmans = cstLinkmans;
	}

	// Property accessors

	public Long getCustId() {
		return this.custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public BaseDict getBaseDictByCustLevel() {
		return this.baseDictByCustLevel;
	}

	public void setBaseDictByCustLevel(BaseDict baseDictByCustLevel) {
		this.baseDictByCustLevel = baseDictByCustLevel;
	}

	public BaseDict getBaseDictByCustIndustry() {
		return this.baseDictByCustIndustry;
	}

	public void setBaseDictByCustIndustry(BaseDict baseDictByCustIndustry) {
		this.baseDictByCustIndustry = baseDictByCustIndustry;
	}

	public BaseDict getBaseDictByCustSource() {
		return this.baseDictByCustSource;
	}

	public void setBaseDictByCustSource(BaseDict baseDictByCustSource) {
		this.baseDictByCustSource = baseDictByCustSource;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Long getCustUserId() {
		return this.custUserId;
	}

	public void setCustUserId(Long custUserId) {
		this.custUserId = custUserId;
	}

	public Long getCustCreateId() {
		return this.custCreateId;
	}

	public void setCustCreateId(Long custCreateId) {
		this.custCreateId = custCreateId;
	}

	public String getCustLinkman() {
		return this.custLinkman;
	}

	public void setCustLinkman(String custLinkman) {
		this.custLinkman = custLinkman;
	}

	public String getCustPhone() {
		return this.custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public String getCustMobile() {
		return this.custMobile;
	}

	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

	public Set getSaleVisits() {
		return this.saleVisits;
	}

	public void setSaleVisits(Set saleVisits) {
		this.saleVisits = saleVisits;
	}

	public Set getCstLinkmans() {
		return this.cstLinkmans;
	}

	public void setCstLinkmans(Set cstLinkmans) {
		this.cstLinkmans = cstLinkmans;
	}

}