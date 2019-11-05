package com.qf.dao.impl;

import com.qf.bean.SmbillBill;
import com.qf.bean.SmbillSupplier;
import com.qf.dao.SmbillBillDao;
import com.qf.dao.SmbillSupplierDao;
import com.qf.util.DbUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SmbillSupplierDaoImpl extends DbUtils implements SmbillSupplierDao {

    //搜寻所有供应商(账单模块用)
    @Override
    public List<SmbillSupplier> queryAllSupplier() throws SQLException {
        String sql = "select * from smbill_supplier where 1=1";
        ResultSet rs = query(sql, null);
        List<SmbillSupplier> smbillSuppliers = new ArrayList<>();
        while (rs.next()){
            SmbillSupplier smbillSupplier = new SmbillSupplier();
            smbillSupplier.setSupplierId(rs.getString("supplier_id"));
            smbillSupplier.setSupplierName(rs.getString("supplier_name"));
            smbillSuppliers.add(smbillSupplier);
        }
        closeall();
        return smbillSuppliers;
    }

    //分页查询所有供应商(供应商模块用)
    @Override
    public List<SmbillSupplier> queryAllSuppliers(String providerName,String providerDesc,int offset,int size) throws SQLException {
        StringBuffer sql = new StringBuffer("select * from smbill_supplier where 1=1");
        List params = new ArrayList();
        if(providerName!=""){
            sql.append(" and supplier_name like '%"+providerName+"%' ");
        }
        if(providerDesc!=""){
            sql.append(" and supplier_desc like '%"+providerDesc+"%' ");
        }
        sql.append(" limit ?,? ");
        params.add(offset);
        params.add(size);
        ResultSet rs = query(sql.toString(), params);
        List<SmbillSupplier> smbillSuppliers = new ArrayList<>();
        while (rs.next()){
            SmbillSupplier smbillSupplier = new SmbillSupplier();
            smbillSupplier.setSupplierId(rs.getString("supplier_id"));
            smbillSupplier.setSupplierName(rs.getString("supplier_name"));
            smbillSupplier.setSupplierDesc(rs.getString("supplier_desc"));
            smbillSupplier.setSupplierLink(rs.getString("supplier_link"));
            smbillSupplier.setSupplierTel(rs.getString("supplier_tel"));
            smbillSupplier.setSupplierAddress(rs.getString("supplier_address"));
            smbillSuppliers.add(smbillSupplier);
        }
        closeall();
        return smbillSuppliers;
    }

    //添加供应商信息
    @Override
    public int addSullpiers(SmbillSupplier smbillSupplier) {
        String sql = "insert into smbill_supplier values (?,?,?,?,?,?,?)";
        List params = new ArrayList();
        params.add(smbillSupplier.getSupplierId());
        params.add(smbillSupplier.getSupplierName());
        params.add(smbillSupplier.getSupplierDesc());
        params.add(smbillSupplier.getSupplierLink());
        params.add(smbillSupplier.getSupplierTel());
        params.add(smbillSupplier.getSupplierFax());
        params.add(smbillSupplier.getSupplierAddress());
        int i = update(sql, params);
        closeall();
        return i;
    }

    //分页查询-----统计总条数
    @Override
    public Long totalCount(String providerName, String providerDesc) throws SQLException {
        StringBuffer sql = new StringBuffer("select count(0) from smbill_supplier where 1=1");
        List params = new ArrayList();
        if(providerName!=""){
            sql.append(" and supplier_name like '%"+providerName+"%' ");
        }
        if(providerDesc!=""){
            sql.append(" and supplier_desc like '%"+providerDesc+"%' ");
        }
        ResultSet rs = query(sql.toString(), params);
        Long totalCount = 0L;
        while (rs.next()){
            totalCount = rs.getLong(1);
        }
        closeall();
        return totalCount;
    }
}
