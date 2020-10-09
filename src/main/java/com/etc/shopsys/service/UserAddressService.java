package com.etc.shopsys.service;

import com.etc.shopsys.domain.UserAddress;

import java.util.List;

/**
 * @ClassName UserAddressService
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/05 17:10
 * @Version 1.0
 **/
public interface UserAddressService {
    // 增：新增用户地址信息
    String insertAddress(UserAddress ua);
    // 删：根据UUID编号删除用户地址
    String deleteAddress(String UUID);
    // 修改：根据UUID修改用户地址信息
    String updateAddress(UserAddress ua);
    // 查:根据UUID查询用户地址信息
    UserAddress findAddressByUUID(String UUID);
    // 查：查询当前用户地址信息根据用户编号
    List<UserAddress> findAllAddress(String uid);
    // 查：查询总记录数
    int findCount(String uid);
}
