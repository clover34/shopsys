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
    public boolean insertTrolley(Trolley trolley) {
        return this.dao.insertTrolley(trolley);
    }

    @Override
    public boolean deleteTrolleyById(String gid) {
        return this.dao.deleteTrolleyById(gid);
    }

    @Override
    public boolean updateTrolleyById(String uid, String gid, int trcount) {
        return this.dao.updateTrolleyById(uid,gid,trcount);
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
