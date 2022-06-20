package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.EquipGuzhangtongjiMapper;
import com.ruoyi.project.system.domain.EquipGuzhangtongji;
import com.ruoyi.project.system.service.IEquipGuzhangtongjiService;

/**
 * 设备故障统计Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-04
 */
@Service
public class EquipGuzhangtongjiServiceImpl implements IEquipGuzhangtongjiService 
{
    @Autowired
    private EquipGuzhangtongjiMapper equipGuzhangtongjiMapper;

    /**
     * 查询设备故障统计
     * 
     * @param id 设备故障统计主键
     * @return 设备故障统计
     */
    @Override
    public EquipGuzhangtongji selectEquipGuzhangtongjiById(Long id)
    {
        return equipGuzhangtongjiMapper.selectEquipGuzhangtongjiById(id);
    }

    /**
     * 查询设备故障统计列表
     * 
     * @param equipGuzhangtongji 设备故障统计
     * @return 设备故障统计
     */
    @Override
    public List<EquipGuzhangtongji> selectEquipGuzhangtongjiList(EquipGuzhangtongji equipGuzhangtongji)
    {
        return equipGuzhangtongjiMapper.selectEquipGuzhangtongjiList(equipGuzhangtongji);
    }

    /**
     * 新增设备故障统计
     * 
     * @param equipGuzhangtongji 设备故障统计
     * @return 结果
     */
    @Override
    public int insertEquipGuzhangtongji(EquipGuzhangtongji equipGuzhangtongji)
    {
        return equipGuzhangtongjiMapper.insertEquipGuzhangtongji(equipGuzhangtongji);
    }

    /**
     * 修改设备故障统计
     * 
     * @param equipGuzhangtongji 设备故障统计
     * @return 结果
     */
    @Override
    public int updateEquipGuzhangtongji(EquipGuzhangtongji equipGuzhangtongji)
    {
        return equipGuzhangtongjiMapper.updateEquipGuzhangtongji(equipGuzhangtongji);
    }

    /**
     * 批量删除设备故障统计
     * 
     * @param ids 需要删除的设备故障统计主键
     * @return 结果
     */
    @Override
    public int deleteEquipGuzhangtongjiByIds(Long[] ids)
    {
        return equipGuzhangtongjiMapper.deleteEquipGuzhangtongjiByIds(ids);
    }

    /**
     * 删除设备故障统计信息
     * 
     * @param id 设备故障统计主键
     * @return 结果
     */
    @Override
    public int deleteEquipGuzhangtongjiById(Long id)
    {
        return equipGuzhangtongjiMapper.deleteEquipGuzhangtongjiById(id);
    }
}
