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
    // 模糊查询：查询全部用户信息
    Page<User> findAllUser(int currentPage, int sizePage);
    // 模糊查询：根据编号查询用户信息
    Page<User> findUserById(String uid, int currentPage, int sizePage);
    // 模糊查询：根据姓名查询用户信息
    Page<User> findUserByName(String username, int currentPage, int sizePage);
    // 查：根据姓名查询用户是否存在
    User findUserByName(String username);
    // 查：根据编号查询用户信息
    User findUserById(String uid);
    // 查：用户登录，根据用户名和密码查询用户信息
    User findUserByNameAndPwd(String username, String password);
    // 查：查询总记录数
    int findCount();
}
