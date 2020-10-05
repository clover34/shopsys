package com.etc.shopsys.dao;

import com.etc.shopsys.domain.Page;
import com.etc.shopsys.domain.User;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/05 9:53
 * @Version 1.0
 **/
public interface UserDao {
    // 增：用户注册，新增用户信息
    boolean insertUser(User user);
    // 删除：根据UUID删除用户信息
    boolean deleteUser(String UUID);
    // 修改：根据 UUID 修改用户信息
    boolean updateUserByUUID(User user);
    // 查：查询全部用户信息
    Page<User> findAllUser(int currentPage, int sizePage);
    // 查：根据编号查询用户信息
    Page<User> findUserById(String uid,int currentPage, int sizePage);
    // 查：根据姓名查询用户信息
    Page<User> findUserByName(String username,int currentPage, int sizePage);
    // 查：查询总记录数
    int findCount();
}
