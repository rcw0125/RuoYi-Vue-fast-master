package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.EquipMyDianjianMapper;
import com.ruoyi.project.system.domain.EquipMyDianjian;
import com.ruoyi.project.system.service.IEquipMyDianjianService;

/**
 * 配置我的点检Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-15
 */
@Service
public class EquipMyDianjianServiceImpl implements IEquipMyDianjianService 
{
    @Autowired
    private EquipMyDianjianMapper equipMyDianjianMapper;

    /**
     * 查询配置我的点检
     * 
     * @param id 配置我的点检主键
     * @return 配置我的点检
     */
    @Override
    public EquipMyDianjian selectEquipMyDianjianById(Long id)
    {
        return equipMyDianjianMapper.selectEquipMyDianjianById(id);
    }

    /**
     * 查询配置我的点检列表
     * 
     * @param equipMyDianjian 配置我的点检
     * @return 配置我的点检
     */
    @Override
    public List<EquipMyDianjian> selectEquipMyDianjianList(EquipMyDianjian equipMyDianjian)
    {
        return equipMyDianjianMapper.selectEquipMyDianjianList(equipMyDianjian);
    }

    /**
     * 新增配置我的点检
     * 
     * @param equipMyDianjian 配置我的点检
     * @return 结果
     */
    @Override
    public int insertEquipMyDianjian(EquipMyDianjian equipMyDianjian)
    {
        return equipMyDianjianMapper.insertEquipMyDianjian(equipMyDianjian);
    }

    /**
     * 修改配置我的点检
     * 
     * @param equipMyDianjian 配置我的点检
     * @return 结果
     */
    @Override
    public int updateEquipMyDianjian(EquipMyDianjian equipMyDianjian)
    {
        return equipMyDianjianMapper.updateEquipMyDianjian(equipMyDianjian);
    }

    /**
     * 批量删除配置我的点检
     * 
     * @param ids 需要删除的配置我的点检主键
     * @return 结果
     */
    @Override
    public int deleteEquipMyDianjianByIds(Long[] ids)
    {
        return equipMyDianjianMapper.deleteEquipMyDianjianByIds(ids);
    }

    /**
     * 删除配置我的点检信息
     * 
     * @param id 配置我的点检主键
     * @return 结果
     */
    @Override
    public int deleteEquipMyDianjianById(Long id)
    {
        return equipMyDianjianMapper.deleteEquipMyDianjianById(id);
    }
}
