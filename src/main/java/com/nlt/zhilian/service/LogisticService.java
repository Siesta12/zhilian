package com.nlt.zhilian.service;

import com.nlt.zhilian.pojo.Order;

import java.util.List;

public interface LogisticService {

    /**
     * 查询物流信息
     * @param id
     * @return
     */
    Order orderTrack(String id);

    /**
     * 查询运输中订单数
     * @return
     */
    int transporting();

    /**
     * 查询车辆运行数量
     * @return
     */
    int cars();

    /**
     * 查询温度正常率
     * @return
     */
    float temperature();

    /**
     * 根据id查询对应订单
     * @param id
     * @return
     */
    List<Order> orders(int id);
}
