package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.EquipDianjianfenleiMapper;
import com.ruoyi.project.system.domain.EquipDianjianfenlei;
import com.ruoyi.project.system.service.IEquipDianjianfenleiService;

/**
 * 点检分类统计Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-04
 */
@Service
public class EquipDianjianfenleiServiceImpl implements IEquipDianjianfenleiService 
{
    @Autowired
    private EquipDianjianfenleiMapper equipDianjianfenleiMapper;

    /**
     * 查询点检分类统计
     * 
     * @param id 点检分类统计主键
     * @return 点检分类统计
     */
    @Override
    public EquipDianjianfenlei selectEquipDianjianfenleiById(Long id)
    {
        return equipDianjianfenleiMapper.selectEquipDianjianfenleiById(id);
    }

    /**
     * 查询点检分类统计列表
     * 
     * @param equipDianjianfenlei 点检分类统计
     * @return 点检分类统计
     */
    @Override
    public List<EquipDianjianfenlei> selectEquipDianjianfenleiList(EquipDianjianfenlei equipDianjianfenlei)
    {
        return equipDianjianfenleiMapper.selectEquipDianjianfenleiList(equipDianjianfenlei);
    }

    /**
     * 新增点检分类统计
     * 
     * @param equipDianjianfenlei 点检分类统计
     * @return 结果
     */
    @Override
    public int insertEquipDianjianfenlei(EquipDianjianfenlei equipDianjianfenlei)
    {
        return equipDianjianfenleiMapper.insertEquipDianjianfenlei(equipDianjianfenlei);
    }

    /**
     * 修改点检分类统计
     * 
     * @param equipDianjianfenlei 点检分类统计
     * @return 结果
     */
    @Override
    public int updateEquipDianjianfenlei(EquipDianjianfenlei equipDianjianfenlei)
    {
        return equipDianjianfenleiMapper.updateEquipDianjianfenlei(equipDianjianfenlei);
    }

    /**
     * 批量删除点检分类统计
     * 
     * @param ids 需要删除的点检分类统计主键
     * @return 结果
     */
    @Override
    public int deleteEquipDianjianfenleiByIds(Long[] ids)
    {
        return equipDianjianfenleiMapper.deleteEquipDianjianfenleiByIds(ids);
    }

    /**
     * 删除点检分类统计信息
     * 
     * @param id 点检分类统计主键
     * @return 结果
     */
    @Override
    public int deleteEquipDianjianfenleiById(Long id)
    {
        return equipDianjianfenleiMapper.deleteEquipDianjianfenleiById(id);
    }
}
