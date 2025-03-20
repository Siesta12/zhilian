package com.nlt.zhilian.service.serviceImpl;

import com.nlt.zhilian.mapper.WarehouseMapper;
import com.nlt.zhilian.pojo.Storage;
import com.nlt.zhilian.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseMapper warehouseMapper;

    /**
     * 库存管理查询
     * @param pageNo
     * @return
     */
    @Override
    public List<Storage> storageManage(int pageNo) {
        int pageSize = 5;
        int offset = (pageNo - 1) * pageSize;
        return warehouseMapper.storageManage(pageSize, offset);
    }

    /**
     * 库存管理删除
     * @param id
     * @return
     */
    @Override
    public int deleteStorageManage(String id) {
        return warehouseMapper.deleteStorageManage(id);
    }

}
