package com.etc.shopsys.service;

import com.etc.shopsys.domain.Page;
import com.etc.shopsys.domain.Trolley;

public interface TrolleyService {
    //增：新增商品
    String insertTrolley(Trolley trolley);
    //删:根据编号删除商品信息
    String deleteTrolleyById(String gid);
    //改:根据编号修改信息
    String updateTrolleyById(String uid,String gid,int trcount);
    //查:根据商品编号查询商品数量
    Trolley findTrolleyById(String gid);
    // 查：查询所有商品
    Page<Trolley> findAllTrolley(int currentPage, int sizePage);
}
