package com.example.mapper;

import com.example.entity.Goods;

import java.util.List;

/**
 * @Author Wenxuan.qiu
 * @Date 2024/3/16 18:09
 * @Description 操作Goods商品信息表相关数据接口
 */
public interface GoodsMapper {
    /*
     * 新增
     * */
    int insert(Goods goods);

    /*
     * 删除
     * */
    int deleteById(Integer id);

    /*
     * 更新
     * */
    int updateById(Goods goods);

    /*
     * 根据ID查询
     * */
    Goods selectById(Integer id);

    /*
     * 查询所有
     * */
    List<Goods> selectAll(Goods goods);


}
