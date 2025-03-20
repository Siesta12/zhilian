package com.nlt.zhilian.service;

import com.nlt.zhilian.pojo.Storage;

import java.util.List;

public interface WarehouseService {

    /**
     * 库存管理查询
     * @param pageNo
     * @return
     */
    List<Storage> storageManage(int pageNo);

    /**
     * 库存管理删除
     * @param id
     * @return
     */
    int deleteStorageManage(String id);
}
