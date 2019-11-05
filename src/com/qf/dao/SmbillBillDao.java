package com.qf.dao;

import com.qf.bean.SmbillBill;
import com.qf.bean.SmbillSupplier;

import java.sql.SQLException;
import java.util.List;

public interface SmbillBillDao {

    //分页查询账单信息
    List<SmbillBill> queryAllSmbillBill(String productName,int payStatus,int offset,int size) throws SQLException;

    //添加账单信息
    int addSmbillBill(SmbillBill smbillBill);

    //统计账单总条数
    Long countTotal(String productName,int payStatus) throws SQLException;

}
