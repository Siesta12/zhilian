package com.nlt.zhilian.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamineHistory {

    private String id;
    private String product;
    private String time;
    private int sampleNumber;
    private int passRate;
    private int level;

}
