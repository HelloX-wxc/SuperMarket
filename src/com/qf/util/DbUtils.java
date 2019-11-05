package com.qf.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import com.alibaba.druid.pool.DruidDataSource;

public class DbUtils {
	
	//1.jdbc api
	protected static Connection con=null;
	protected  static PreparedStatement pps=null;
	protected  static ResultSet rs=null;
	private  static String driverClass;
	private  static String url;
	private   static String username;
	private   static String password;
	private static String init;
	
	//������³���Ķ���
	static DruidDataSource datasource=new DruidDataSource();
	//2.��������
	static {
		//1.�������ļ��л�ȡ��Ϣ
	  ResourceBundle b=ResourceBundle.getBundle("db");
	  driverClass=b.getString("driverclass");
	  url=b.getString("url");	
	  username=b.getString("uname");	
	  password=b.getString("upass");
	  //2.��ֵ����³������  Ĭ��MaxActive��8��
	  datasource.setDriverClassName(driverClass);
	  datasource.setUrl(url);
	  datasource.setUsername(username);
	  datasource.setPassword(password);
	  //datasource.setMaxActive(5);//�����������ӻ�Ծ����
	  System.out.println("max="+datasource.getMaxActive());	
	}
	
	//3.�������
	public static  Connection  getConn() {
		try {
			con= datasource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	//4.��ͨ��
	protected  PreparedStatement getpps(String sql) {
	    try {
			pps= con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return pps;
	}
	//5.�󶨲���  params�����ռλ��������ֵ
	private  void param(List params) {
		try {
			
			if(params!=null&&params.size()>0) {
				for (int i = 0; i < params.size(); i++) {
					pps.setObject(i+1,params.get(i));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//6.��ɾ��
	protected  int  update(String sql,List params) {
		int k=0;
		try {
			getConn();
			getpps(sql);
			param(params);
			k=pps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k;
	}
	//7.��ѯ
	protected  ResultSet  query(String sql,List params) {
		
		try {
			getConn();
			getpps(sql);
			param(params);
			rs=pps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	//8.�ر���Դ
	protected void closeall() {
		try {
			if(rs!=null) rs.close();
			if(pps!=null)pps.close();
			if(con!=null)con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
