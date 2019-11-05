package com.qf.service.impl;

import com.qf.bean.SmbillSupplier;
import com.qf.dao.SmbillSupplierDao;
import com.qf.dao.impl.SmbillSupplierDaoImpl;
import com.qf.service.SmbillSupplierService;
import com.qf.util.DbUtils;

import java.sql.SQLException;
import java.util.List;

public class SmbillSupplierServiceImpl extends DbUtils implements SmbillSupplierService {

    SmbillSupplierDao smbillSupplierDao = new SmbillSupplierDaoImpl();

    //搜寻所有供应商
    @Override
    public List<SmbillSupplier> queryAllSupplier() throws SQLException {
        List<SmbillSupplier> smbillSuppliers = smbillSupplierDao.queryAllSupplier();
        return smbillSuppliers;
    }

    //搜寻所有供应商（供应商模块用）
    @Override
    public List<SmbillSupplier> queryAllSuppliers(String providerName,String providerDesc,int offset,int size) throws SQLException {
        List<SmbillSupplier> smbillSuppliers = smbillSupplierDao.queryAllSuppliers(providerName,providerDesc,offset,size);
        return smbillSuppliers;
    }

    //添加供应商信息
    @Override
    public int addSullpiers(SmbillSupplier smbillSupplier) {
        int i = smbillSupplierDao.addSullpiers(smbillSupplier);
        return i;
    }

    //分页查询-----统计总条数
    @Override
    public Long totalCount(String providerName, String providerDesc) throws SQLException {
        Long totalCount = smbillSupplierDao.totalCount(providerName, providerDesc);
        return totalCount;
    }
}
