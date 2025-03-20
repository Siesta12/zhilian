package com.nlt.zhilian.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String id;
    private String product;
    private int weight;
    private String destination;
    private float distance;
    private String expectTime;
    private float temperature;
    private String car;
    private String orderConfirm;
    private String load;
    private String transport;
    private String reach;
    private String finish;
    private int status;

}
