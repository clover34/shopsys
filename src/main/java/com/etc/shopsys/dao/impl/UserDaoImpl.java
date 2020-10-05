package com.etc.shopsys.dao.impl;

import com.etc.shopsys.dao.BaseDao;
import com.etc.shopsys.dao.UserDao;
import com.etc.shopsys.domain.Emp;
import com.etc.shopsys.domain.Page;
import com.etc.shopsys.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/05 9:58
 * @Version 1.0
 **/
public class UserDaoImpl extends BaseDao<User> implements UserDao {
    /**
     * 获取一个用户对象
     * @param rs
     * @return
     */
    @Override
    protected User getEntty(ResultSet rs) {
        User user = new User();
        try {
            user.setUUID(rs.getString("UUID"));
            user.setUid(rs.getString("uid"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString( "password"));
            user.setPhone(rs.getString("phone"));
            user.setEmail(rs.getString("email"));
        } catch (SQLException e) {
            System.out.println("获取一个用户对象异常");
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 新增：用户注册，新增用户信息
     * @param user
     * @return
     */
    @Override
    public boolean insertUser(User user) {
        String sql = "insert into user(UUID,uid,username,password,phone,email) values(?,?,?,?,?,?)";
        return super.executeUpdate(sql, user.getUUID(),user.getUid(),user.getUsername(),user.getPassword(),
                user.getPhone(),user.getEmail());
    }

    /**
     * 删除用户信息:根据用户 UUID 删除用户信息
     * @param UUID
     * @return
     */
    @Override
    public boolean deleteUser(String UUID) {
        String sql = "delete from user where UUID=?";
        return super.executeUpdate(sql, UUID);
    }

    /**
     * 修改：根据 UUID 修改用户信息
     * @param user
     * @return
     */
    @Override
    public boolean updateUserByUUID(User user) {
        String sql = "update user set username=?,password=?,phone=?,email=? where UUID=? and uid=?";
        return super.executeUpdate(sql, user.getUsername(),user.getPassword(),user.getPhone(),
                user.getEmail(),user.getUUID(),user.getUid());
    }

    /**
     * 查询：查询所有用户信息
     * @return
     */
    @Override
    public Page<User> findAllUser(int currentPage, int sizePage) {
        String sql = "select * from user limit ?,?";
        String countSql = "select count(UUID) from user";
        int start =  (currentPage-1) * sizePage;// 分页起始位置
        List<User> users = super.executeQuery(sql, start, sizePage);// 分页查询到的数据
        int totalCount = findCount(countSql);// 查询总记录数
        return new Page<User>(currentPage,sizePage,totalCount,users);
    }

    /**
     * 查询：根据编号查询用户信息
     * @param uid
     * @param currentPage
     * @param sizePage
     * @return
     */
    @Override
    public Page<User> findUserById(String uid,int currentPage, int sizePage) {
        String sql = "select * from user where uid like ? limit ?,?";
        String countSql = "select count(UUID) from user where uid like ?";
        uid = "%" + uid + "%";
        int start =  (currentPage-1) * sizePage;// 分页起始位置
        List<User> users = super.executeQuery(sql, uid, start, sizePage);// 分页查询到的数据
        int totalCount = findCount(countSql,uid);// 查询总记录数
        return new Page<User>(currentPage,sizePage,totalCount,users);
    }

    /**
     * 查询：根据名称查询用户信息
     * @param username
     * @param currentPage
     * @param sizePage
     * @return
     */
    @Override
    public Page<User> findUserByName(String username,int currentPage, int sizePage) {
        String sql = "select * from user where username like ? limit ?,?";
        String countSql = "select count(UUID) from user where username like ?";
        username = "%" + username + "%";
        int start =  (currentPage-1) * sizePage;// 分页起始位置
        List<User> users = super.executeQuery(sql, username, start, sizePage);// 分页查询到的数据
        int totalCount = findCount(countSql,username);// 查询总记录数
        return new Page<User>(currentPage,sizePage,totalCount,users);
    }

    /**
     * 查询：查询用戶总记录数
     * @return
     */
    @Override
    public int findCount() {
        String sql = "select count(UUID) from user";
        return super.findCount(sql);
    }
}
