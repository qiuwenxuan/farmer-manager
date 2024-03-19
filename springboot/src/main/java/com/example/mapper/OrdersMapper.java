package com.example.mapper;

import com.example.entity.Orders;

import java.util.List;

/**
 * @Author Wenxuan.qiu
 * @Date 2024/3/19 18:48
 * @Description
 */
public interface OrdersMapper {
    //    新增
    int insert(Orders orders);

    //    删除
    int deleteById(Integer id);

    //    修改
    int updateById(Orders orders);

    //    根据ID查询
    Orders selectById(Integer id);

    //    查询所有
    List<Orders> selectAll(Orders orders);
}


