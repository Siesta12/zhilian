package com.nlt.zhilian.service;

import com.nlt.zhilian.pojo.ExamineHistory;

import java.util.List;

public interface QualityService {

    /**
     * 查询检测历史
     * @param pageNo
     * @return List
     */
    List<ExamineHistory> examineHistory(int pageNo);

    /**
     * 删除检测历史
     * @param id
     * @return int
     */
    int deleteExamineHistory(String id);
}
