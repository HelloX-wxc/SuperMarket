package com.qf.dao.impl;

import com.qf.bean.SmbillUser;
import com.qf.dao.SmbillUserDao;
import com.qf.util.DbUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SmbillUserDaoImpl extends DbUtils implements SmbillUserDao {

    //查询用户信息
    @Override
    public List<SmbillUser> queryAllUser(String userName,int offset,int size) throws SQLException {
        StringBuffer sql = new StringBuffer("select * from smbill_user where 1=1");
        List params = new ArrayList();
        if(userName!=""){
            sql.append(" and user_name like '%"+userName+"%' ");
        }
        sql.append(" limit ?,? ");
        params.add(offset);
        params.add(size);
        ResultSet rs = query(sql.toString(), params);
        List<SmbillUser> smbillUsers = new ArrayList<>();
        while (rs.next()){
            SmbillUser smbillUser = new SmbillUser();
            smbillUser.setUserId(rs.getInt("user_id"));
            smbillUser.setUserName(rs.getString("user_name"));
            smbillUser.setUserGender(rs.getInt("user_gender"));
            smbillUser.setUserAge(rs.getInt("user_age"));
            smbillUser.setUserTel(rs.getString("user_tel"));
            smbillUser.setUserAddress(rs.getString("user_address"));
            smbillUser.setUserLimited(rs.getInt("user_limited"));
            smbillUsers.add(smbillUser);
        }
        closeall();
        return smbillUsers;
    }

    //添加用户信息
    @Override
    public int addUsers(SmbillUser smbillUser) throws SQLException {
        String sql = "insert into smbill_user values (?,?,?,?,?,?,?,?)";
        List params = new ArrayList();
        params.add(smbillUser.getUserId());
        params.add(smbillUser.getUserName());
        params.add(smbillUser.getUserPassword());
        params.add(smbillUser.getUserGender());
        params.add(smbillUser.getUserAge());
        params.add(smbillUser.getUserTel());
        params.add(smbillUser.getUserAddress());
        params.add(smbillUser.getUserLimited());
        int i = update(sql, params);
        closeall();
        return i;
    }

    //分页----统计用户总数
    @Override
    public Long totalCount(String userName) throws SQLException {
        StringBuffer sql = new StringBuffer("select count(0) from smbill_user where 1=1");
        List params = new ArrayList();
        if(userName!=""){
            sql.append(" and user_name like '%"+userName+"%' ");
        }
        ResultSet rs = query(sql.toString(), params);
        Long totalCount = 0L;
        while (rs.next()){
            totalCount = rs.getLong(1);
        }
        closeall();
        return totalCount;
    }

    //登录----根据用户名和密码查询用信息
    @Override
    public SmbillUser queryByUserNameAndPassword(String username, String password) throws SQLException {
        String sql = "select * from smbill_user where user_name=? and user_password=?";
        List params = new ArrayList();
        params.add(username);
        params.add(password);
        ResultSet rs = query(sql, params);
        SmbillUser smbillUser = null;
        while (rs.next()){
            smbillUser = new SmbillUser();
            smbillUser.setUserName(rs.getString("user_name"));
        }
        closeall();
        return smbillUser;
    }

    //登录

}
