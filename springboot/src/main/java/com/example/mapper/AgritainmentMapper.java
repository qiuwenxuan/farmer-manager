package com.example.mapper;

import com.example.entity.Agritainment;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * @Author Wenxuan.qiu
 * @Date 2024/3/16 18:09
 * @Description 操作农家乐信息表相关数据接口
 */
public interface AgritainmentMapper {
    /*
     * 新增
     * */
    int insert(Agritainment agritainment);

    /*
     * 删除
     * */
    int deleteById(Integer id);

    /*
     * 更新
     * */
    int updateById(Agritainment agritainment);

    /*
     * 根据ID查询
     * */
    Agritainment selectById(Integer id);

    /*
     * 查询所有
     * */
    List<Agritainment> selectAll(Agritainment agritainment);

    /*
     * 查询扶贫政策表前6条数据
     * */
    @Select("select * from agritainment order by id desc limit 6")
    List<Agritainment> selectTop6();


}
