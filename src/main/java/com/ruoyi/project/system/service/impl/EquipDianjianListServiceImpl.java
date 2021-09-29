package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.EquipDianjianListMapper;
import com.ruoyi.project.system.domain.EquipDianjianList;
import com.ruoyi.project.system.service.IEquipDianjianListService;

/**
 * 点检记录Service业务层处理
 *
 * @author ruoyi
 * @date 2021-09-23
 */
@Service
public class EquipDianjianListServiceImpl implements IEquipDianjianListService
{
    @Autowired
    private EquipDianjianListMapper equipDianjianListMapper;

    /**
     * 查询点检记录
     *
     * @param id 点检记录主键
     * @return 点检记录
     */
    @Override
    public EquipDianjianList selectEquipDianjianListById(Long id)
    {
        return equipDianjianListMapper.selectEquipDianjianListById(id);
    }

    /**
     * 查询点检记录列表
     *
     * @param equipDianjianList 点检记录
     * @return 点检记录
     */
    @Override
    public List<EquipDianjianList> selectEquipDianjianListList(EquipDianjianList equipDianjianList)
    {
        return equipDianjianListMapper.selectEquipDianjianListList(equipDianjianList);
    }

    /**
     * 查询最新的一条数据点检记录列表
     *
     * @param equipDianjianList 点检记录
     * @return 点检记录
     */
    @Override
    public List<EquipDianjianList> selectLastEquipDianjianList(EquipDianjianList equipDianjianList)
    {
        return equipDianjianListMapper.selectLastEquipDianjianList(equipDianjianList);
    }

    /**
     * 新增点检记录
     *
     * @param equipDianjianList 点检记录
     * @return 结果
     */
    @Override
    public int insertEquipDianjianList(EquipDianjianList equipDianjianList)
    {
        return equipDianjianListMapper.insertEquipDianjianList(equipDianjianList);
    }

    /**
     * 修改点检记录
     *
     * @param equipDianjianList 点检记录
     * @return 结果
     */
    @Override
    public int updateEquipDianjianList(EquipDianjianList equipDianjianList)
    {
        return equipDianjianListMapper.updateEquipDianjianList(equipDianjianList);
    }

    /**
     * 批量删除点检记录
     *
     * @param ids 需要删除的点检记录主键
     * @return 结果
     */
    @Override
    public int deleteEquipDianjianListByIds(Long[] ids)
    {
        return equipDianjianListMapper.deleteEquipDianjianListByIds(ids);
    }

    /**
     * 删除点检记录信息
     *
     * @param id 点检记录主键
     * @return 结果
     */
    @Override
    public int deleteEquipDianjianListById(Long id)
    {
        return equipDianjianListMapper.deleteEquipDianjianListById(id);
    }
}
