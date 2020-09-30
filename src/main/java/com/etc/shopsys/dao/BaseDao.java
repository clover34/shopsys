package com.etc.shopsys.dao;

import com.etc.shopsys.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BaseDao
 * @Description TODO
 * @Author Administrator
 * @Date 20/09/23 18:52
 * @Version 1.0
 **/
public abstract class BaseDao<T> {
    /**
     * 通用增删改方法
     * @param sql
     * @param params
     * @return
     */
    public int executeUpdate(String sql, Object...params){
        // 步骤一二：加载驱动获得数据库连接
        Connection conn = DBUtil.getConnection();
        // 声明预编译对象
        PreparedStatement pstm = null;
        try {
            // 准备语句
            pstm = conn.prepareStatement(sql);
            if(params != null){
                for(int i = 0; i < params.length; i++){
                    pstm.setObject(i+1, params[i]);
                }
            }
            // 步骤三四：执行语句，处理结果
            return pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            DBUtil.close(null, pstm, conn);
        }
        return 0;
    }

    /**
     * 查询多条记录通用方法
     * @param sql
     * @param params
     * @return
     */
    public List<T> executeQuery(String sql, Object...params){
        // 步骤一二：加载驱动获得连接
        Connection conn = DBUtil.getConnection();
        // 声明预编译对象
        PreparedStatement pstm = null;
        // 声明结果集对象
        ResultSet rs = null;
        // 声明集合
        List<T> target = new ArrayList<T>();

        try {
            // 准备语句
            pstm = conn.prepareStatement(sql);
            if(params != null){
                for (int i = 0; i < params.length; i++) {
                    pstm.setObject(i+1, params[i]);
                }
            }
            // 步骤三：执行语句
            rs = pstm.executeQuery();
            // 步骤四：处理结果
            while (rs.next()) {
                T t = getEntty(rs);
                target.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 步骤五：关闭资源
            DBUtil.close(rs, pstm, conn);
        }
        return target;
    }

    /**
     * 查询单条记录通用
     * @param sql
     * @param params
     * @return
     */
    public T executeQueryOne(String sql, Object...params){
        // 步骤一二：加载驱动获得连接
        Connection conn = DBUtil.getConnection();
        // 声明预编译对象
        PreparedStatement pstm = null;
        // 声明结果集对象
        ResultSet rs = null;
        try {
            // 准备语句
            pstm = conn.prepareStatement(sql);
            if(params != null){
                for (int i = 0; i < params.length; i++) {
                    pstm.setObject(i+1, params[i]);
                }
            }
            // 步骤四：执行语句
            rs = pstm.executeQuery();
            // 步骤五：处理结果
            while (rs.next()) {
                return getEntty(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询总记录数
     * @param sql
     * @return
     */
    public int findCount(String sql){
        // 步骤一二：加载驱动获得连接
        Connection conn = DBUtil.getConnection();
        // 声明预编译语句
        PreparedStatement pstm = null;
        // 声明结果集对象
        ResultSet rs = null;
        // 记录数
        int count = 0;
        try {
            // 准备语句
            pstm = conn.prepareStatement(sql);
            // 执行语句
            rs = pstm.executeQuery();
            // 处理结果
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            DBUtil.close(rs, pstm, conn);
        }
        return count;
    }

    /**
     * 模板方法：父类做不了的事情交给子类
     * @param rs
     * @return
     */
    protected abstract T getEntty(ResultSet rs);
}
