package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.EquipDianjianBiaozhunMapper;
import com.ruoyi.project.system.domain.EquipDianjianBiaozhun;
import com.ruoyi.project.system.service.IEquipDianjianBiaozhunService;

/**
 * 点检标准Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-22
 */
@Service
public class EquipDianjianBiaozhunServiceImpl implements IEquipDianjianBiaozhunService 
{
    @Autowired
    private EquipDianjianBiaozhunMapper equipDianjianBiaozhunMapper;

    /**
     * 查询点检标准
     * 
     * @param id 点检标准主键
     * @return 点检标准
     */
    @Override
    public EquipDianjianBiaozhun selectEquipDianjianBiaozhunById(Long id)
    {
        return equipDianjianBiaozhunMapper.selectEquipDianjianBiaozhunById(id);
    }

    /**
     * 查询点检标准列表
     * 
     * @param equipDianjianBiaozhun 点检标准
     * @return 点检标准
     */
    @Override
    public List<EquipDianjianBiaozhun> selectEquipDianjianBiaozhunList(EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
        return equipDianjianBiaozhunMapper.selectEquipDianjianBiaozhunList(equipDianjianBiaozhun);
    }

    /**
     * 新增点检标准
     * 
     * @param equipDianjianBiaozhun 点检标准
     * @return 结果
     */
    @Override
    public int insertEquipDianjianBiaozhun(EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
        return equipDianjianBiaozhunMapper.insertEquipDianjianBiaozhun(equipDianjianBiaozhun);
    }

    /**
     * 修改点检标准
     * 
     * @param equipDianjianBiaozhun 点检标准
     * @return 结果
     */
    @Override
    public int updateEquipDianjianBiaozhun(EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
        return equipDianjianBiaozhunMapper.updateEquipDianjianBiaozhun(equipDianjianBiaozhun);
    }

    /**
     * 批量删除点检标准
     * 
     * @param ids 需要删除的点检标准主键
     * @return 结果
     */
    @Override
    public int deleteEquipDianjianBiaozhunByIds(Long[] ids)
    {
        return equipDianjianBiaozhunMapper.deleteEquipDianjianBiaozhunByIds(ids);
    }

    /**
     * 删除点检标准信息
     * 
     * @param id 点检标准主键
     * @return 结果
     */
    @Override
    public int deleteEquipDianjianBiaozhunById(Long id)
    {
        return equipDianjianBiaozhunMapper.deleteEquipDianjianBiaozhunById(id);
    }
}
