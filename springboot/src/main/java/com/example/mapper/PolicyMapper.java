package com.example.mapper;

import com.example.entity.Policy;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author Wenxuan.qiu
 * @Date 2024/3/16 18:09
 * @Description 操作Policy扶农政策表相关数据接口
 */
public interface PolicyMapper {
    /*
     * 新增
     * */
    int insert(Policy policy);

    /*
     * 删除
     * */
    int deleteById(Integer id);

    /*
     * 更新
     * */
    int updateById(Policy policy);

    /*
     * 根据ID查询
     * */
    Policy selectById(Integer id);

    /*
     * 查询所有
     * */
    List<Policy> selectAll(Policy policy);

    /*
     * 查询扶贫政策表前6条数据
     * */
    @Select("select * from policy order by id desc limit 6")
    List<Policy> selectTop6();


}
