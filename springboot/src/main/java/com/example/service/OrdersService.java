package com.example.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.example.common.enums.ResultCodeEnum;
import com.example.entity.Goods;
import com.example.entity.Orders;
import com.example.entity.User;
import com.example.exception.CustomException;
import com.example.mapper.GoodsMapper;
import com.example.mapper.OrdersMapper;
import com.example.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 订单信息表业务处理
 **/
@Service
public class OrdersService {

    @Resource
    private OrdersMapper ordersMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private GoodsMapper goodsMapper;

    /**
     * 新增
     */
    public void add(Orders orders) {
//        实现判断一下用户余额够不够
        User user = userMapper.selectById(orders.getUserId());
        if (user.getAccount() < orders.getPrice()) {
            throw new CustomException(ResultCodeEnum.USER_ACCOUNT_ERROR);
        }
//        根据唯一的下单时间戳当做orderId
        orders.setOrderId(DateUtil.format(new Date(), "yyyyMMddHHmmss"));
        orders.setTime(DateUtil.now());
        ordersMapper.insert(orders);
//        扣除用户余额
        if (ObjectUtil.isNotEmpty(user.getAccount())) {
            user.setAccount(user.getAccount() - orders.getPrice());
            userMapper.updateById(user);
        }
//        减少商品库存
        Goods goods = goodsMapper.selectById(orders.getGoodsId());
        if (ObjectUtil.isNotEmpty(goods)) {
            goods.setNum(goods.getNum() - 1);
            goodsMapper.updateById(goods);
        }
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        ordersMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            ordersMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Orders orders) {
        ordersMapper.updateById(orders);
    }

    /**
     * 根据ID查询
     */
    public Orders selectById(Integer id) {
        return ordersMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Orders> selectAll(Orders orders) {
        return ordersMapper.selectAll(orders);
    }

    /**
     * 分页查询,需要关联user表获取userName，关联goods表获取img和goodName
     */
    public PageInfo<Orders> selectPage(Orders orders, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Orders> list = ordersMapper.selectAll(orders);
        // 遍历集合当中的order对象
        for (Orders dbOrders : list) {
            // 通过goodsId获取goods对象
            Goods goods = goodsMapper.selectById(dbOrders.getGoodsId());
//            添加goods对象的img、GoodName到orders对象内
            if (ObjectUtil.isNotEmpty(goods)) {
                dbOrders.setGoodsName(goods.getName());
                dbOrders.setImg(goods.getImg());
            }
//            通过userId获取user对象
            User user = userMapper.selectById(dbOrders.getUserId());
//            添加user的Name到order的下单用户UserName内
            if (ObjectUtil.isNotEmpty(user)) {
                dbOrders.setUserName(user.getName());
            }
        }
        return PageInfo.of(list);
    }

}