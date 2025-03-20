package com.nlt.zhilian.contrtoller;

import com.nlt.zhilian.pojo.Order;
import com.nlt.zhilian.pojo.Result;
import com.nlt.zhilian.service.LogisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logistic")
public class LogisticController {

    @Autowired
    private LogisticService logisticService;

    /**
     * 根据订单号查询订单跟踪信息
     * @param id
     * @return
     */
    @GetMapping("/orderTrack")
    public Result orderTrack(@RequestParam("id") String id){
        Order order;
        try {
            order = logisticService.orderTrack(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Result.error("查询失败，请稍后重试。");
        }
        return (order != null) ? Result.success(order) : Result.error("查询失败，请稍后重试。");
    }

    /**
     * 查询正在运输的订单数量
     * @return
     */
    @GetMapping("/transporting")
    public Result transporting() {
        int n;
        try {
            n = logisticService.transporting();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Result.error("查询失败，请稍后重试。");
        }
        return Result.success(n);
    }

    /**
     * 查询车辆运行数量
     * @return
     */
    @GetMapping("/cars")
    public Result cars() {
        int n;
        try {
            n = logisticService.cars();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Result.error("查询失败，请稍后重试。");
        }
        return Result.success(n);
    }

    /**
     * 查询温度正常率
     * @return
     */
    @GetMapping("/temperature")
    public Result temperature() {
        float n;
        try {
            n = logisticService.temperature();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Result.error("查询失败，请稍后重试。");
        }
        return Result.success(n);
    }

    /**
     * 根据id查询对应订单
     * @param id
     * @return
     */
    @GetMapping("/orders")
    public Result orders(@RequestParam ("id") int id) {
        List<Order> orderList;
        try {
            orderList = logisticService.orders(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Result.error("查询失败，请稍后重试。");
        }
        return (orderList != null) ? Result.success(orderList) : Result.error("查询失败，请稍后重试。");
    }

}
