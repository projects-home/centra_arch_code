package com.ai.slp.order.vo;

import java.io.Serializable;

/**
 * 订单出货表
 * Date: 2016年11月12日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class OrdOdLogisticsVo implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * 配送ID
	 */
	private long logisticsId;

	/**
	 * 租户ID
	 */
	private String tenantId;

	/**
	 * 订单ID
	 */
	private long orderId;

	/**
	 * 配送方式
	 */
	private String logisticsType;

	/**
	 * 物流单号
	 */
	private String expressOddNumber;

	/**
	 * 到件方公司
	 */
	private String contactCompany;

	/**
	 * 收件人姓名
	 */
	private String contactName;

	/**
	 * 收件人电话
	 */
	private String contactTel;

	/**
	 * 收件人邮箱
	 */
	private String contactEmail;

	/**
	 * 收件人省分
	 */
	private String provinceCode;

	/**
	 * 收件人地市
	 */
	private String cityCode;

	/**
	 * 收件人区县
	 */
	private String countyCode;

	/**
	 * 收件人邮编
	 */
	private String postcode;

	/**
	 * 收件人末级区域
	 */
	private String areaCode;

	/**
	 * 详细地址(自提地址)
	 */
	private String address;

	/**
	 * 物流公司ID
	 */
	private String expressId;

	/**
	 * 快递自提点编码
	 */
	private String expressSelfId;

	/**
	 * 配送时间段
	 */
	private String logisticsTimeId;

	/**
	 * 附加信息
	 */
	private String remark;

	public long getLogisticsId() {
		return logisticsId;
	}

	public void setLogisticsId(long logisticsId) {
		this.logisticsId = logisticsId;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getLogisticsType() {
		return logisticsType;
	}

	public void setLogisticsType(String logisticsType) {
		this.logisticsType = logisticsType;
	}

	public String getExpressOddNumber() {
		return expressOddNumber;
	}

	public void setExpressOddNumber(String expressOddNumber) {
		this.expressOddNumber = expressOddNumber;
	}

	public String getContactCompany() {
		return contactCompany;
	}

	public void setContactCompany(String contactCompany) {
		this.contactCompany = contactCompany;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactTel() {
		return contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCountyCode() {
		return countyCode;
	}

	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getExpressId() {
		return expressId;
	}

	public void setExpressId(String expressId) {
		this.expressId = expressId;
	}

	public String getExpressSelfId() {
		return expressSelfId;
	}

	public void setExpressSelfId(String expressSelfId) {
		this.expressSelfId = expressSelfId;
	}

	public String getLogisticsTimeId() {
		return logisticsTimeId;
	}

	public void setLogisticsTimeId(String logisticsTimeId) {
		this.logisticsTimeId = logisticsTimeId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
