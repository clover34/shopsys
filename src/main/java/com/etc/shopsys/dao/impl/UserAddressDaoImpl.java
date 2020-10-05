package com.etc.shopsys.dao.impl;

import com.etc.shopsys.dao.BaseDao;
import com.etc.shopsys.dao.UserAddressDao;
import com.etc.shopsys.domain.UserAddress;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName UserAddressDaoImpl
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/03 12:33
 * @Version 1.0
 **/
public class UserAddressDaoImpl extends BaseDao<UserAddress> implements UserAddressDao {
    /**
     * 获取一个用户地址对象
     * @param rs
     * @return
     */
    @Override
    protected UserAddress getEntty(ResultSet rs) {
        UserAddress ua = new UserAddress();
        try {
            ua.setUUID(rs.getString("UUID"));
            ua.setUid(rs.getString("uid"));
            ua.setContactname(rs.getString("contactname"));
            ua.setPhone(rs.getString("phone"));
            ua.setUaddress(rs.getString("uaddress"));
        } catch (SQLException e) {
            System.out.println("获取一个用户地址实体信息异常");
            e.printStackTrace();
        }
        return ua;
    }

    /**
     * 增：新增一个用户地址
     * @param ua
     * @return
     */
    @Override
    public boolean insertAddress(UserAddress ua) {
        String sql = "insert into useraddress(UUID,uid,contactname,phone,uaddress) values(?,?,?,?,?)";
        return super.executeUpdate(sql, ua.getUUID(), ua.getUid(), ua.getContactname(), ua.getPhone(),
                ua.getUaddress());
    }

    /**
     * 删除：根据UUID删除用户地址信息
     * @param UUID
     * @return
     */
    @Override
    public boolean deleteAddress(String UUID) {
        String sql = "delete from useraddress where UUID=?";
        return super.executeUpdate(sql, UUID);
    }

    /**
     * 修改：根据UUID修改用户地址信息
     * @param ua
     * @return
     */
    @Override
    public boolean updateAddress(UserAddress ua) {
        String sql = "update ";
        return false;
    }

    @Override
    public List<UserAddress> findAllAddress(String uid) {
        return null;
    }
}
