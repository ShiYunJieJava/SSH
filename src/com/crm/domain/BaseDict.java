package com.crm.domain;

/**
 * BaseDict entity. @author MyEclipse Persistence Tools
 */

public class BaseDict implements java.io.Serializable {

	// Fields

	private String dictId;
	private String dictTypeCode;
	private String dictTypeName;
	private String dictItemName;
	private String dictItemCode;
	private Integer dictSort;
	private String dictEnable;
	private String dictMemo;

	// Constructors

	/** default constructor */
	public BaseDict() {
	}

	/** minimal constructor */
	public BaseDict(String dictTypeCode, String dictTypeName,
			String dictItemName, String dictEnable) {
		this.dictTypeCode = dictTypeCode;
		this.dictTypeName = dictTypeName;
		this.dictItemName = dictItemName;
		this.dictEnable = dictEnable;
	}

	/** full constructor */
	public BaseDict(String dictTypeCode, String dictTypeName,
			String dictItemName, String dictItemCode, Integer dictSort,
			String dictEnable, String dictMemo) {
		this.dictTypeCode = dictTypeCode;
		this.dictTypeName = dictTypeName;
		this.dictItemName = dictItemName;
		this.dictItemCode = dictItemCode;
		this.dictSort = dictSort;
		this.dictEnable = dictEnable;
		this.dictMemo = dictMemo;
	}

	// Property accessors

	public String getDictId() {
		return this.dictId;
	}

	public void setDictId(String dictId) {
		this.dictId = dictId;
	}

	public String getDictTypeCode() {
		return this.dictTypeCode;
	}

	public void setDictTypeCode(String dictTypeCode) {
		this.dictTypeCode = dictTypeCode;
	}

	public String getDictTypeName() {
		return this.dictTypeName;
	}

	public void setDictTypeName(String dictTypeName) {
		this.dictTypeName = dictTypeName;
	}

	public String getDictItemName() {
		return this.dictItemName;
	}

	public void setDictItemName(String dictItemName) {
		this.dictItemName = dictItemName;
	}

	public String getDictItemCode() {
		return this.dictItemCode;
	}

	public void setDictItemCode(String dictItemCode) {
		this.dictItemCode = dictItemCode;
	}

	public Integer getDictSort() {
		return this.dictSort;
	}

	public void setDictSort(Integer dictSort) {
		this.dictSort = dictSort;
	}

	public String getDictEnable() {
		return this.dictEnable;
	}

	public void setDictEnable(String dictEnable) {
		this.dictEnable = dictEnable;
	}

	public String getDictMemo() {
		return this.dictMemo;
	}

	public void setDictMemo(String dictMemo) {
		this.dictMemo = dictMemo;
	}

}