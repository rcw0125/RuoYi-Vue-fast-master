package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.EquipJianxiutongjiMapper;
import com.ruoyi.project.system.domain.EquipJianxiutongji;
import com.ruoyi.project.system.service.IEquipJianxiutongjiService;

/**
 * 设备检修统计Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-04
 */
@Service
public class EquipJianxiutongjiServiceImpl implements IEquipJianxiutongjiService 
{
    @Autowired
    private EquipJianxiutongjiMapper equipJianxiutongjiMapper;

    /**
     * 查询设备检修统计
     * 
     * @param id 设备检修统计主键
     * @return 设备检修统计
     */
    @Override
    public EquipJianxiutongji selectEquipJianxiutongjiById(Long id)
    {
        return equipJianxiutongjiMapper.selectEquipJianxiutongjiById(id);
    }

    /**
     * 查询设备检修统计列表
     * 
     * @param equipJianxiutongji 设备检修统计
     * @return 设备检修统计
     */
    @Override
    public List<EquipJianxiutongji> selectEquipJianxiutongjiList(EquipJianxiutongji equipJianxiutongji)
    {
        return equipJianxiutongjiMapper.selectEquipJianxiutongjiList(equipJianxiutongji);
    }

    /**
     * 新增设备检修统计
     * 
     * @param equipJianxiutongji 设备检修统计
     * @return 结果
     */
    @Override
    public int insertEquipJianxiutongji(EquipJianxiutongji equipJianxiutongji)
    {
        return equipJianxiutongjiMapper.insertEquipJianxiutongji(equipJianxiutongji);
    }

    /**
     * 修改设备检修统计
     * 
     * @param equipJianxiutongji 设备检修统计
     * @return 结果
     */
    @Override
    public int updateEquipJianxiutongji(EquipJianxiutongji equipJianxiutongji)
    {
        return equipJianxiutongjiMapper.updateEquipJianxiutongji(equipJianxiutongji);
    }

    /**
     * 批量删除设备检修统计
     * 
     * @param ids 需要删除的设备检修统计主键
     * @return 结果
     */
    @Override
    public int deleteEquipJianxiutongjiByIds(Long[] ids)
    {
        return equipJianxiutongjiMapper.deleteEquipJianxiutongjiByIds(ids);
    }

    /**
     * 删除设备检修统计信息
     * 
     * @param id 设备检修统计主键
     * @return 结果
     */
    @Override
    public int deleteEquipJianxiutongjiById(Long id)
    {
        return equipJianxiutongjiMapper.deleteEquipJianxiutongjiById(id);
    }
}
