package com.etc.shopsys.service;

import com.etc.shopsys.domain.Page;
import com.etc.shopsys.domain.User;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/05 18:06
 * @Version 1.0
 **/
public interface UserService {
    // 增：用户注册，新增用户信息
    String insertUser(User user);
    // 删除：根据UUID删除用户信息
    String deleteUser(String UUID);
    // 修改：根据 UUID 修改用户信息
    String updateUserByUUID(User user);
    // 查：查询全部用户信息
    Page<User> findAllUser(int currentPage, int sizePage);
    // 查：根据编号查询用户信息
    Page<User> findUserById(String uid, int currentPage, int sizePage);
    // 查：根据姓名查询用户信息
    Page<User> findUserByName(String username, int currentPage, int sizePage);
    // 查：根据姓名查询用户是否存在
    User findUserByName(String username);
    // 查：用户登录，根据用户名和密码查询用户信息
    User findUserByNameAndPwd(String username, String password);
    // 查：查询总记录数
    int findCount();
}
