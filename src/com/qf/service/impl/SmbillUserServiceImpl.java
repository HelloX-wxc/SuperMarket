package com.qf.service.impl;

import com.qf.bean.SmbillUser;
import com.qf.dao.SmbillUserDao;
import com.qf.dao.impl.SmbillUserDaoImpl;
import com.qf.service.SmbillUserService;

import java.sql.SQLException;
import java.util.List;

public class SmbillUserServiceImpl implements SmbillUserService {

    SmbillUserDao smbillUserDao = new SmbillUserDaoImpl();

    //查询用户信息
    @Override
    public List<SmbillUser> queryAllUser(String userName,int offset,int size) throws SQLException {
        List<SmbillUser> smbillUsers = smbillUserDao.queryAllUser(userName,offset,size);
        return smbillUsers;
    }

    //添加用户信息
    @Override
    public int addUsers(SmbillUser smbillUser) throws SQLException {
        int i = smbillUserDao.addUsers(smbillUser);
        return i;
    }

    //分页----统计用户总数
    @Override
    public Long totalCount(String userName) throws SQLException {
        Long totalCount = smbillUserDao.totalCount(userName);
        return totalCount;
    }

    //登录----根据用户名和密码查询用信息
    @Override
    public SmbillUser queryByUserNameAndPassword(String username, String password) {
        SmbillUser smbillUser = null;
        try {
            smbillUser = smbillUserDao.queryByUserNameAndPassword(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return smbillUser;
    }
}
