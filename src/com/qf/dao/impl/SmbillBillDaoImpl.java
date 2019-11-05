package com.qf.dao.impl;

import com.qf.bean.SmbillBill;
import com.qf.bean.SmbillSupplier;
import com.qf.dao.SmbillBillDao;
import com.qf.util.DbUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SmbillBillDaoImpl extends DbUtils implements SmbillBillDao {

    //查询账单信息
    @Override
    public List<SmbillBill> queryAllSmbillBill(String productName,int payStatus,int offset,int size) throws SQLException {
        StringBuffer sql = new StringBuffer("select * from smbill_bill b where 1=1");
        List params = new ArrayList();
        if(productName!=""){
            sql.append(" and b.bill_name like '%"+productName+"%' ");
        }
        if(payStatus!=-1){
            sql.append(" and b.bill_yesono=? ");
            params.add(payStatus);
        }
        sql.append(" limit ?,? ");
        params.add(offset);
        params.add(size);
        ResultSet rs = query(sql.toString(), params);
        List<SmbillBill> smbillBills = new ArrayList<>();
        while (rs.next()){
            SmbillBill smbillBill = new SmbillBill();
            smbillBill.setBillId(rs.getString("bill_id"));
            smbillBill.setBillName(rs.getString("bill_name"));
            smbillBill.setBillCommNum(rs.getInt("bill_commNum"));
            smbillBill.setBillMoney(rs.getInt("bill_money"));
            smbillBill.setBillYsono(rs.getInt("bill_yesono"));
            smbillBill.setSupplierName(rs.getString("supplier_name"));
            smbillBill.setBillCommdesc(rs.getString("bill_commdesc"));
            smbillBill.setBillCreatedate(rs.getDate("bill_createdate"));
            smbillBills.add(smbillBill);
        }
        closeall();
        return smbillBills;
    }

    //添加账单信息
    @Override
    public int addSmbillBill(SmbillBill smbillBill) {
        String sql = "insert into smbill_bill values (?,?,?,?,?,?,?,?,?)";
        List params = new ArrayList();
        params.add(smbillBill.getBillId());
        params.add(smbillBill.getBillName());
        params.add(smbillBill.getBillCommNum());
        params.add(smbillBill.getBillMoney());
        params.add(smbillBill.getBillYsono());
        params.add(smbillBill.getSupplierName());
        params.add(smbillBill.getBillCommdesc());
        params.add(smbillBill.getBillCreatedate());
        params.add(smbillBill.getSupplierId());
        int i = update(sql, params);
        closeall();
        return i;
    }

    //统计账单总条数
    @Override
    public Long countTotal(String productName, int payStatus) throws SQLException {
        StringBuffer sql = new StringBuffer("select count(0) from smbill_bill b where 1=1");
        List params = new ArrayList();
        if(productName!=""){
            sql.append(" and b.bill_name like '%"+productName+"%' ");
        }
        if(payStatus!=-1){
            sql.append(" and b.bill_yesono=? ");
            params.add(payStatus);
        }
        ResultSet rs = query(sql.toString(), params);
        List<SmbillBill> smbillBills = new ArrayList<>();
        Long countTotal = 0L;
        while (rs.next()){
            countTotal = rs.getLong(1);
        }
        closeall();
        return countTotal;
    }
}
