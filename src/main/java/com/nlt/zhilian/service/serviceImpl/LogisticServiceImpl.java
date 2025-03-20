package com.nlt.zhilian.service.serviceImpl;

import com.nlt.zhilian.mapper.LogisticMapper;
import com.nlt.zhilian.pojo.Order;
import com.nlt.zhilian.service.LogisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogisticServiceImpl implements LogisticService {

    @Autowired
    private LogisticMapper logisticMapper;

    /**
     * 根据订单号查询订单跟踪信息
     * @param id
     * @return
     */
    @Override
    public Order orderTrack(String id) {
        return logisticMapper.orderTrack(id);
    }

    /**
     * 查询在途订单数量
     * @return
     */
    @Override
    public int transporting() {
        return logisticMapper.transporting();
    }

    /**
     * 查询车辆运行数量
     * @return
     */
    @Override
    public int cars() {
        return logisticMapper.cars();
    }

    /**
     * 查询温度正常率
     * @return
     */
    @Override
    public float temperature() {
        int normal = logisticMapper.temperature();
        int total = logisticMapper.total();
        return (float) normal / total;
    }

    /**
     * 根据id查询对应订单
     * @param id
     * @return
     */
    @Override
    public List<Order> orders(int id) {
        return switch (id) {
            case 1 -> logisticMapper.totalOrders();
            case 2 -> logisticMapper.waitDistribute();
            case 3 -> logisticMapper.transportingOrders();
            case 4 -> logisticMapper.finish();
            default -> null;
        };
    }

}
