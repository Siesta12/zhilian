package com.nlt.zhilian.mapper;

import com.nlt.zhilian.pojo.Storage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WarehouseMapper {

    /**
     * 库存管理查询
     * @param pageSize
     * @param offset
     * @return
     */
    @Select("select * from storage limit #{pageSize} offset #{offset}")
    List<Storage> storageManage(@Param("pageSize") int pageSize, @Param("offset") int offset);

    /**
     * 删除库存管理
     * @param id
     * @return
     */
    @Delete("delete from storage where id=#{id}")
    int deleteStorageManage(@Param("id") String id);

}


