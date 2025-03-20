package com.nlt.zhilian.service.serviceImpl;

import com.nlt.zhilian.mapper.QualityMapper;
import com.nlt.zhilian.pojo.ExamineHistory;
import com.nlt.zhilian.service.QualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualityServiceImpl implements QualityService {

    @Autowired
    private QualityMapper qualityMapper;

    /**
     * 查询监测历史
     * @param pageNo
     * @return
     */
    @Override
    public List<ExamineHistory> examineHistory(int pageNo) {
        int pageSize = 9;
        int offset = (pageNo - 1) * pageSize;
        return qualityMapper.examineHistory(pageSize, offset);
    }

    /**
     * 删除监测历史
     * @param id
     * @return
     */
    @Override
    public int deleteExamineHistory(String id) {
        return qualityMapper.deleteExamineHistory(id);
    }

}
