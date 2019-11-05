package com.qf.bean;
//供应商管理
public class SmbillSupplier {
    private String supplierId;
    private String supplierName;
    private String supplierDesc;
    private String supplierLink;
    private String supplierTel;
    private String supplierFax;
    private String supplierAddress;

    @Override
    public String toString() {
        return "SmbillSupplier{" +
                "supplierId='" + supplierId + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", supplierDesc='" + supplierDesc + '\'' +
                ", supplierLink='" + supplierLink + '\'' +
                ", supplierTel='" + supplierTel + '\'' +
                ", supplierFax='" + supplierFax + '\'' +
                ", supplierAddress='" + supplierAddress + '\'' +
                '}';
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierDesc() {
        return supplierDesc;
    }

    public void setSupplierDesc(String supplierDesc) {
        this.supplierDesc = supplierDesc;
    }

    public String getSupplierLink() {
        return supplierLink;
    }

    public void setSupplierLink(String supplierLink) {
        this.supplierLink = supplierLink;
    }

    public String getSupplierTel() {
        return supplierTel;
    }

    public void setSupplierTel(String supplierTel) {
        this.supplierTel = supplierTel;
    }

    public String getSupplierFax() {
        return supplierFax;
    }

    public void setSupplierFax(String supplierFax) {
        this.supplierFax = supplierFax;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public SmbillSupplier(String supplierId, String supplierName, String supplierDesc, String supplierLink, String supplierTel, String supplierFax, String supplierAddress) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierDesc = supplierDesc;
        this.supplierLink = supplierLink;
        this.supplierTel = supplierTel;
        this.supplierFax = supplierFax;
        this.supplierAddress = supplierAddress;
    }

    public SmbillSupplier() {
    }
}
