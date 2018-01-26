package com.ai.slp.product.vo;

/**
 * 商品分页查询条件对象
 * 
 * Date: 2016年5月13日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author lipeng16
 */
public class ProductPageQueryVo {
	/**
	 * 租户Id，必填
	 */
	private String tenantId;
	/**
     * 请求查询的页码,默认为1
     */
    private Integer pageNo = 1;

    /**
     * 每页显示条数,默认每页20条
     */
    private Integer pageSize =20;
    /**
     * 类目标识
     */
    private String productCatId;
    /**
     * 商城商品标识
     */
    private String prodId;
    /**
     * 商品名称
     */
    private String prodName;
    /**
     * 商品类型
     * 0:全部
     */
    private String productType;
    /**
     * 库存组id
     */
    private String storageGroupId;
    /**
     * 库存组名称
     */
    private String storageGroupName;
    /**
     *标准品标识
     */
    private Long standedProdId;
    /**
     * 标准品名称
     */
    private String standedProdName;
    
    
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getProductCatId() {
		return productCatId;
	}
	public void setProductCatId(String productCatId) {
		this.productCatId = productCatId;
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getStorageGroupId() {
		return storageGroupId;
	}
	public void setStorageGroupId(String storageGroupId) {
		this.storageGroupId = storageGroupId;
	}
	public String getStorageGroupName() {
		return storageGroupName;
	}
	public void setStorageGroupName(String storageGroupName) {
		this.storageGroupName = storageGroupName;
	}
	public Long getStandedProdId() {
		return standedProdId;
	}
	public void setStandedProdId(Long standedProdId) {
		this.standedProdId = standedProdId;
	}
	public String getStandedProdName() {
		return standedProdName;
	}
	public void setStandedProdName(String standedProdName) {
		this.standedProdName = standedProdName;
	}
    

    
}
