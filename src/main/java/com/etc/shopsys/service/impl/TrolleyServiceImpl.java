package com.etc.shopsys.service.impl;

import com.etc.shopsys.dao.TrolleyDao;
import com.etc.shopsys.dao.impl.TrolleyDaoImpl;
import com.etc.shopsys.domain.Page;
import com.etc.shopsys.domain.Trolley;
import com.etc.shopsys.service.TrolleyService;

public class TrolleyServiceImpl implements TrolleyService {
    private TrolleyDao dao;

    public TrolleyServiceImpl() {
        this.dao =new TrolleyDaoImpl();
    }

    @Override
    public String insertTrolley(Trolley trolley) {
        return this.dao.insertTrolley(trolley)?"添加到购物车成功":"添加到购物车失败";
    }

    @Override
    public String deleteTrolleyById(String gid) {
        return this.dao.deleteTrolleyById(gid)?"购物车信息删除成功":"购物车信息删除失败";
    }

    @Override
    public String updateTrolleyById(String uid, String gid, int trcount) {
        return this.dao.updateTrolleyById(uid,gid,trcount)?"购物车信息修改成功":"购物车信息修改失败";
    }

    @Override
    public Trolley findTrolleyById(String gid) {
        return this.dao.findTrolleyById(gid);
    }

    @Override
    public Page<Trolley> findAllTrolley(int currentPage, int sizePage) {
        return this.dao.findAllTrolley(currentPage,sizePage);
    }
}
