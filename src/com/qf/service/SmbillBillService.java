package com.qf.service;

import com.qf.bean.SmbillBill;

import java.sql.SQLException;
import java.util.List;

public interface SmbillBillService {

    //查询账单信息
    List<SmbillBill> queryAllSmbillBill(String productName,int payStatus,int offset,int size);

    //添加账单信息
    int addSmbillBill(SmbillBill smbillBill);

    //统计账单总条数
    Long countTotal(String productName,int payStatus) throws SQLException;
}
