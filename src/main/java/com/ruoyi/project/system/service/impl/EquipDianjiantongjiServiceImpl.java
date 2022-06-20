package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.EquipDianjiantongjiMapper;
import com.ruoyi.project.system.domain.EquipDianjiantongji;
import com.ruoyi.project.system.service.IEquipDianjiantongjiService;

/**
 * 月点检统计Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-17
 */
@Service
public class EquipDianjiantongjiServiceImpl implements IEquipDianjiantongjiService 
{
    @Autowired
    private EquipDianjiantongjiMapper equipDianjiantongjiMapper;

    /**
     * 查询月点检统计
     * 
     * @param id 月点检统计主键
     * @return 月点检统计
     */
    @Override
    public EquipDianjiantongji selectEquipDianjiantongjiById(Long id)
    {
        return equipDianjiantongjiMapper.selectEquipDianjiantongjiById(id);
    }

    /**
     * 查询月点检统计列表
     * 
     * @param equipDianjiantongji 月点检统计
     * @return 月点检统计
     */
    @Override
    public List<EquipDianjiantongji> selectEquipDianjiantongjiList(EquipDianjiantongji equipDianjiantongji)
    {
        return equipDianjiantongjiMapper.selectEquipDianjiantongjiList(equipDianjiantongji);
    }

    /**
     * 新增月点检统计
     * 
     * @param equipDianjiantongji 月点检统计
     * @return 结果
     */
    @Override
    public int insertEquipDianjiantongji(EquipDianjiantongji equipDianjiantongji)
    {
        return equipDianjiantongjiMapper.insertEquipDianjiantongji(equipDianjiantongji);
    }

    /**
     * 修改月点检统计
     * 
     * @param equipDianjiantongji 月点检统计
     * @return 结果
     */
    @Override
    public int updateEquipDianjiantongji(EquipDianjiantongji equipDianjiantongji)
    {
        return equipDianjiantongjiMapper.updateEquipDianjiantongji(equipDianjiantongji);
    }

    /**
     * 批量删除月点检统计
     * 
     * @param ids 需要删除的月点检统计主键
     * @return 结果
     */
    @Override
    public int deleteEquipDianjiantongjiByIds(Long[] ids)
    {
        return equipDianjiantongjiMapper.deleteEquipDianjiantongjiByIds(ids);
    }

    /**
     * 删除月点检统计信息
     * 
     * @param id 月点检统计主键
     * @return 结果
     */
    @Override
    public int deleteEquipDianjiantongjiById(Long id)
    {
        return equipDianjiantongjiMapper.deleteEquipDianjiantongjiById(id);
    }
}
