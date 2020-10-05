package com.etc.shopsys.service.impl;

import com.etc.shopsys.dao.UserDao;
import com.etc.shopsys.dao.impl.UserDaoImpl;
import com.etc.shopsys.domain.Page;
import com.etc.shopsys.domain.User;
import com.etc.shopsys.service.UserService;
import com.etc.shopsys.utils.CounterUtil;
import com.etc.shopsys.utils.DBUtil;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/05 18:07
 * @Version 1.0
 **/
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    /**
     * 新增：用户信息（注册）
     * @param user
     * @return
     */
    @Override
    public String insertUser(User user) {
        user.setUUID(DBUtil.getUUID());// 用户UUID
        user.setUid(CounterUtil.getCounterStr("user", userDao.findCount()));// 用户编号
        if (userDao.findUserByName(user.getUsername()) == null) {
            // 用户不存在
            return userDao.insertUser(user) ? "注册成功" : "注册失败";
        } else {
            // 用户存在
            return "用户名已存在";
        }
    }

    /**
     * 刪除：根据编号删除用户信息
     * @param UUID
     * @return
     */
    @Override
    public String deleteUser(String UUID) {
        return userDao.deleteUser(UUID) ? "账户已注销" : "账户注销失败";
    }

    /**
     * 修改：根据编号修改用户信息
     * @param user
     * @return
     */
    @Override
    public String updateUserByUUID(User user) {
        return userDao.updateUserByUUID(user) ? "信息修改成功" : "信息修改失败";
    }

    /**
     * 查询：查询所有用户信息
     * @param currentPage
     * @param sizePage
     * @return
     */
    @Override
    public Page<User> findAllUser(int currentPage, int sizePage) {
        return userDao.findAllUser(currentPage, sizePage);
    }

    /**
     * 模糊查询：根据编号查询用户信息
     * @param uid
     * @param currentPage
     * @param sizePage
     * @return
     */
    @Override
    public Page<User> findUserById(String uid, int currentPage, int sizePage) {
        return userDao.findUserById(uid, currentPage, sizePage);
    }

    /**
     * 模糊查询：根据姓名查询用户信息
     * @param username
     * @param currentPage
     * @param sizePage
     * @return
     */
    @Override
    public Page<User> findUserByName(String username, int currentPage, int sizePage) {
        return userDao.findUserByName(username, currentPage, sizePage);
    }

    /**
     * 查询：根据用户名查询用户信息
     * @param username
     * @return
     */
    @Override
    public User findUserByName(String username) {
        return userDao.findUserByName(username);
    }

    /**
     * 查询：查询用户总记录数
     * @return
     */
    @Override
    public int findCount() {
        return userDao.findCount();
    }
}
