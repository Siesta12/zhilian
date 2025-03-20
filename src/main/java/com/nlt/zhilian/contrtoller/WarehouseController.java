package com.nlt.zhilian.contrtoller;

import com.nlt.zhilian.pojo.Result;
import com.nlt.zhilian.pojo.Storage;
import com.nlt.zhilian.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;

    /**
     * 库存管理查询
     * @param pageNo
     * @return
     */
    @GetMapping("/storageManage")
    public Result storageManage(@RequestParam("pageNo") int pageNo) {
        List<Storage> storageList = warehouseService.storageManage(pageNo);
        return Result.success(storageList);
    }

    /**
     * 库存管理删除
     * @param id
     * @return
     */
    @DeleteMapping("/storageManage")
    public Result deleteStorageManage(@RequestParam("id") String id) {
        int n;
        try {
            n = warehouseService.deleteStorageManage(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Result.error("删除失败，请稍后重试。");
        }
        return (n == 1) ? Result.success("删除成功。") : Result.error("删除失败，请稍后重试。");
    }

}
