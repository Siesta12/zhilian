package com.nlt.zhilian.contrtoller;

import com.nlt.zhilian.pojo.ExamineHistory;
import com.nlt.zhilian.pojo.Result;
import com.nlt.zhilian.service.QualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quality")
public class QualityController {

    @Autowired
    private QualityService qualityService;

    /**
     * 查询监测历史记录
     *
     * @param pageNo
     * @return List
     */
    @GetMapping("/examineHistory")
    public Result examineHistory(@RequestParam("pageNo") int pageNo) {
        List<ExamineHistory> examineHistoryList = qualityService.examineHistory(pageNo);
        return Result.success(examineHistoryList);
    }

    /**
     * 删除监测历史记录
     *
     * @param id
     * @return Result
     */
    @DeleteMapping("/examineHistory")
    public Result deleteExamineHistory(@RequestParam("id") String id) {
        int n;
        try {
            n = qualityService.deleteExamineHistory(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Result.error("删除失败，请稍后重试。");
        }
        return (n == 1) ? Result.success("删除成功。") : Result.error("删除失败，请稍后重试。");
    }
}