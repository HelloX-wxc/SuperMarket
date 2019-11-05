package com.qf.bean;

import java.util.Date;

//账单管理表
public class SmbillBill {
    private String billId;
    private String billName;
    private Integer billCommNum;
    private Integer billMoney;
    private Integer billYsono;
    private String supplierName;
    private String billCommdesc;
    private Date billCreatedate;
    private String supplierId;

    @Override
    public String toString() {
        return "SmbillBill{" +
                "billId='" + billId + '\'' +
                ", billName='" + billName + '\'' +
                ", billCommNum=" + billCommNum +
                ", billMoney=" + billMoney +
                ", billYsono=" + billYsono +
                ", supplierName='" + supplierName + '\'' +
                ", billCommdesc='" + billCommdesc + '\'' +
                ", billCreatedate=" + billCreatedate +
                ", supplierId='" + supplierId + '\'' +
                '}';
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public Integer getBillCommNum() {
        return billCommNum;
    }

    public void setBillCommNum(Integer billCommNum) {
        this.billCommNum = billCommNum;
    }

    public Integer getBillMoney() {
        return billMoney;
    }

    public void setBillMoney(Integer billMoney) {
        this.billMoney = billMoney;
    }

    public Integer getBillYsono() {
        return billYsono;
    }

    public void setBillYsono(Integer billYsono) {
        this.billYsono = billYsono;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getBillCommdesc() {
        return billCommdesc;
    }

    public void setBillCommdesc(String billCommdesc) {
        this.billCommdesc = billCommdesc;
    }

    public Date getBillCreatedate() {
        return billCreatedate;
    }

    public void setBillCreatedate(Date billCreatedate) {
        this.billCreatedate = billCreatedate;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public SmbillBill(String billId, String billName, Integer billCommNum, Integer billMoney, Integer billYsono, String supplierName, String billCommdesc, Date billCreatedate, String supplierId) {
        this.billId = billId;
        this.billName = billName;
        this.billCommNum = billCommNum;
        this.billMoney = billMoney;
        this.billYsono = billYsono;
        this.supplierName = supplierName;
        this.billCommdesc = billCommdesc;
        this.billCreatedate = billCreatedate;
        this.supplierId = supplierId;
    }

    public SmbillBill() {
    }
}
