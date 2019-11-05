package com.qf.dao;

import com.qf.bean.SmbillUser;

import java.sql.SQLException;
import java.util.List;

public interface SmbillUserDao {

    //查询用户信息
    List<SmbillUser> queryAllUser(String userName,int offset,int size) throws SQLException;

    //添加用户信息
    int addUsers(SmbillUser smbillUser) throws SQLException;

    //分页----统计用户总数
    Long totalCount(String userName) throws SQLException;

    //登录----根据用户名和密码查询用信息
    SmbillUser queryByUserNameAndPassword(String username,String password) throws SQLException;


}
