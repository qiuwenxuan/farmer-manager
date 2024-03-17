package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Agritainment;
import com.example.mapper.AgritainmentMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 扶贫政策表业务处理
 **/
@Service
public class AgritainmentService {

    @Resource
    private AgritainmentMapper agritainmentMapper;

    /**
     * 新增
     */
    public void add(Agritainment agritainment) {
//        扶贫咨询新增数据时，自动填入当前时间，格式为2024-03-15
        agritainment.setTime(DateUtil.format(new Date(), "yyyy-MM-dd"));
        agritainmentMapper.insert(agritainment);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        agritainmentMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            agritainmentMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Agritainment agritainment) {
        agritainmentMapper.updateById(agritainment);
    }

    /**
     * 根据ID查询
     */
    public Agritainment selectById(Integer id) {
        return agritainmentMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Agritainment> selectAll(Agritainment agritainment) {
        return agritainmentMapper.selectAll(agritainment);
    }

    /**
     * 分页查询
     */
    public PageInfo<Agritainment> selectPage(Agritainment agritainment, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Agritainment> list = agritainmentMapper.selectAll(agritainment);
        return PageInfo.of(list);
    }

    public List<Agritainment> top6() {
        return agritainmentMapper.selectTop6();
    }
}