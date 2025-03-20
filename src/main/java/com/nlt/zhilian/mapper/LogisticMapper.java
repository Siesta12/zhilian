package com.nlt.zhilian.mapper;

import com.nlt.zhilian.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogisticMapper {

    /**
     * 根据订单号查询订单跟踪信息
     * @param id
     * @return
     */
    @Select("select * from `order` where id=#{id}")
    Order orderTrack(@Param("id") String id);

    /**
     * 查询在途订单数量
     * @return
     */
    @Select("select count(*) from `order` where status = 3")
    int transporting();

    /**
     * 查询车辆运行数量
     * @return
     */
    @Select("select count(*) from cars where status = 1")
    int cars();

    /**
     * 查询温度正常率
     * @return
     */
    @Select("select count(*) from `order` where temperature between 0 and 5")
    int temperature();

    /**
     * 查询总数
     * @return
     */
    @Select("select count(*) from `order`")
    int total();

    /**
     * 查询总订单
     * @return
     */
    @Select("select * from `order`")
    List<Order> totalOrders();

    /**
     * 查询订单已确认且待发货的订单
     * @return
     */
    @Select("select * from `order` where status between 1 and 2")
    List<Order> waitDistribute();

    /**
     * 查询在途订单
     * @return
     */
    @Select("select * from `order` where status = 3")
    List<Order> transportingOrders();

    /**
     * 查询已完成订单
     * @return
     */
    @Select("select * from `order` where status = 5")
    List<Order> finish();

}
