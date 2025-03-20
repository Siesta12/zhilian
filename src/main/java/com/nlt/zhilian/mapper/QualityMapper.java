package com.nlt.zhilian.mapper;

import com.nlt.zhilian.pojo.ExamineHistory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QualityMapper {

    /**
     * 查询监测历史记录
     * @param pageSize
     * @param offset
     * @return List
     */
    @Select("select * from examinehistory limit #{pageSize} offset #{offset}")
    List<ExamineHistory> examineHistory(@Param("pageSize") int pageSize, @Param("offset") int offset);

    /**
     * 删除监测历史记录
     * @param id
     * @return
     */
    @Delete("delete from examinehistory where id=#{id}")
    int deleteExamineHistory(@Param("id") String id);
}
