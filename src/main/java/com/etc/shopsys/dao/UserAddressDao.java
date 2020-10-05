package com.etc.shopsys.dao;

import com.etc.shopsys.domain.UserAddress;

import java.util.List;

/**
 * @ClassName UserAddress
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/03 12:22
 * @Version 1.0
 **/
public interface UserAddressDao {
    // 增：新增用户地址信息
    boolean insertAddress(UserAddress ua);
    // 删：根据UUID编号删除用户地址
    boolean deleteAddress(String UUID);
    // 修改：根据UUID修改用户地址信息
    boolean updateAddress(UserAddress ua);
    // 查：查询当前用户地址信息根据用户编号
    List<UserAddress> findAllAddress(String uid);
    // 查：查询总记录数
    int findCount(String uid);
}
