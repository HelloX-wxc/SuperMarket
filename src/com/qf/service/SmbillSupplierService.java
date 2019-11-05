package com.qf.service;

import com.qf.bean.SmbillSupplier;

import java.sql.SQLException;
import java.util.List;

public interface SmbillSupplierService {

    //搜寻所有供应商
    List<SmbillSupplier> queryAllSupplier() throws SQLException;

    //搜寻所有供应商（供应商模块用）
    List<SmbillSupplier> queryAllSuppliers(String providerName,String providerDesc,int offset,int size) throws SQLException;

    //添加供应商信息
    int addSullpiers(SmbillSupplier smbillSupplier);

    //分页查询-----统计总条数
    Long totalCount(String providerName,String providerDesc) throws SQLException;
}
