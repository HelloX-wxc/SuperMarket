package com.qf.service.impl;

import com.qf.bean.SmbillBill;
import com.qf.dao.SmbillBillDao;
import com.qf.dao.impl.SmbillBillDaoImpl;
import com.qf.service.SmbillBillService;
import com.qf.util.DbUtils;

import java.sql.SQLException;
import java.util.List;

public class SmbillBillServiceImpl extends DbUtils implements SmbillBillService {

    SmbillBillDao smbillBillDao = new SmbillBillDaoImpl();

    //查询账单信息
    @Override
    public List<SmbillBill> queryAllSmbillBill(String productName,int payStatus,int offset,int size) {
        List<SmbillBill> smbillBills = null;
        try {
            smbillBills = smbillBillDao.queryAllSmbillBill(productName,payStatus,offset,size);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return smbillBills;
    }

    //添加账单信息
    @Override
    public int addSmbillBill(SmbillBill smbillBill) {
        int i = smbillBillDao.addSmbillBill(smbillBill);
        return i;
    }

    //统计账单总条数
    @Override
    public Long countTotal(String productName, int payStatus) throws SQLException {
        Long countTotal = smbillBillDao.countTotal(productName, payStatus);
        return countTotal;
    }
}
