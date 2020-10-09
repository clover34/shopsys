package com.etc.shopsys.service.impl;

import com.etc.shopsys.dao.UserAddressDao;
import com.etc.shopsys.dao.impl.UserAddressDaoImpl;
import com.etc.shopsys.domain.UserAddress;
import com.etc.shopsys.service.UserAddressService;
import com.etc.shopsys.utils.DBUtil;

import java.util.List;

/**
 * @ClassName UserAddressService
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/05 17:11
 * @Version 1.0
 **/
public class UserAddressServiceImpl implements UserAddressService {
    private UserAddressDao uaDao = new UserAddressDaoImpl();
    /**
     * 新增：新增用户地址信息
     * @param ua
     * @return
     */
    @Override
    public String insertAddress(UserAddress ua) {
        ua.setUUID(DBUtil.getUUID());
        return uaDao.insertAddress(ua) ? "新增地址成功" : "新增地址失败";
    }

    /**
     * 删除：根据 UUID 删除用户地址信息
     * @param UUID
     * @return
     */
    @Override
    public String deleteAddress(String UUID) {
        return uaDao.deleteAddress(UUID) ? "删除地址成功" : "删除地址失败";
    }

    /**
     * 修改：根据 UUID 修改用户地址信息
     * @param ua
     * @return
     */
    @Override
    public String updateAddress(UserAddress ua) {
        return uaDao.updateAddress(ua) ? "修改地址成功" : "修改地址失败";
    }

    @Override
    public UserAddress findAddressByUUID(String UUID) {
        return uaDao.findAddressByUUID(UUID);
    }

    /**
     * 查询：根据用户编号查询地址信息
     * @param uid
     * @return
     */
    @Override
    public List<UserAddress> findAllAddress(String uid) {
        return uaDao.findAllAddress(uid);
    }

    /**
     * 查询：根据编号查询用户地址信息
     * @param uid
     * @return
     */
    @Override
    public int findCount(String uid) {
        return uaDao.findCount(uid);
    }
}
