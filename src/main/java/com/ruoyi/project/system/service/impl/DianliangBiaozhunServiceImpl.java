package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.DianliangBiaozhunMapper;
import com.ruoyi.project.system.domain.DianliangBiaozhun;
import com.ruoyi.project.system.service.IDianliangBiaozhunService;

/**
 * 电量标准Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-01-12
 */
@Service
public class DianliangBiaozhunServiceImpl implements IDianliangBiaozhunService 
{
    @Autowired
    private DianliangBiaozhunMapper dianliangBiaozhunMapper;

    /**
     * 查询电量标准
     * 
     * @param id 电量标准主键
     * @return 电量标准
     */
    @Override
    public DianliangBiaozhun selectDianliangBiaozhunById(Integer id)
    {
        return dianliangBiaozhunMapper.selectDianliangBiaozhunById(id);
    }

    /**
     * 查询电量标准列表
     * 
     * @param dianliangBiaozhun 电量标准
     * @return 电量标准
     */
    @Override
    public List<DianliangBiaozhun> selectDianliangBiaozhunList(DianliangBiaozhun dianliangBiaozhun)
    {
        return dianliangBiaozhunMapper.selectDianliangBiaozhunList(dianliangBiaozhun);
    }

    /**
     * 新增电量标准
     * 
     * @param dianliangBiaozhun 电量标准
     * @return 结果
     */
    @Override
    public int insertDianliangBiaozhun(DianliangBiaozhun dianliangBiaozhun)
    {
        return dianliangBiaozhunMapper.insertDianliangBiaozhun(dianliangBiaozhun);
    }

    /**
     * 修改电量标准
     * 
     * @param dianliangBiaozhun 电量标准
     * @return 结果
     */
    @Override
    public int updateDianliangBiaozhun(DianliangBiaozhun dianliangBiaozhun)
    {
        return dianliangBiaozhunMapper.updateDianliangBiaozhun(dianliangBiaozhun);
    }

    /**
     * 批量删除电量标准
     * 
     * @param ids 需要删除的电量标准主键
     * @return 结果
     */
    @Override
    public int deleteDianliangBiaozhunByIds(Integer[] ids)
    {
        return dianliangBiaozhunMapper.deleteDianliangBiaozhunByIds(ids);
    }

    /**
     * 删除电量标准信息
     * 
     * @param id 电量标准主键
     * @return 结果
     */
    @Override
    public int deleteDianliangBiaozhunById(Integer id)
    {
        return dianliangBiaozhunMapper.deleteDianliangBiaozhunById(id);
    }
}
