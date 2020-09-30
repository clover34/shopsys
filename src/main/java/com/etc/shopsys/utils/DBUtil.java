package com.etc.shopsys.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 连接数据库工具
 * 1，导包
 * 2，加载驱动
 * 3，获得连接
 * 4，准备语句，执行 sql 语句
 * 5，处理结果
 * 6，关闭资源
 */
public class DBUtil {

    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动失败");
            e.printStackTrace();
        }
    }

    /**
     * 获得连接
     * @return
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
//            conn = DriverManager.getConnection(url,name,password);
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopsys?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC","root","root");
        } catch (SQLException throwables) {
            System.out.println("获得连接异常");
            throwables.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭资源
     * @param conn
     * @param pstm
     * @param rs
     */
    public static void close(ResultSet rs,PreparedStatement pstm,  Connection conn){
        try {
            if(rs != null){
                rs.close();
            }
            if(pstm != null){
                pstm.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch (SQLException throwables) {
            System.out.println("资源关闭异常");
            throwables.printStackTrace();
        }
    }
//    私有化构造方法
    private DBUtil(){}
}
