package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.EquipJianxiuMapper;
import com.ruoyi.project.system.domain.EquipJianxiu;
import com.ruoyi.project.system.service.IEquipJianxiuService;

/**
 * 计划检修Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-09
 */
@Service
public class EquipJianxiuServiceImpl implements IEquipJianxiuService 
{
    @Autowired
    private EquipJianxiuMapper equipJianxiuMapper;

    /**
     * 查询计划检修
     * 
     * @param id 计划检修主键
     * @return 计划检修
     */
    @Override
    public EquipJianxiu selectEquipJianxiuById(Long id)
    {
        return equipJianxiuMapper.selectEquipJianxiuById(id);
    }

    /**
     * 查询计划检修列表
     * 
     * @param equipJianxiu 计划检修
     * @return 计划检修
     */
    @Override
    public List<EquipJianxiu> selectEquipJianxiuList(EquipJianxiu equipJianxiu)
    {
        return equipJianxiuMapper.selectEquipJianxiuList(equipJianxiu);
    }

    /**
     * 新增计划检修
     * 
     * @param equipJianxiu 计划检修
     * @return 结果
     */
    @Override
    public int insertEquipJianxiu(EquipJianxiu equipJianxiu)
    {
        return equipJianxiuMapper.insertEquipJianxiu(equipJianxiu);
    }

    /**
     * 修改计划检修
     * 
     * @param equipJianxiu 计划检修
     * @return 结果
     */
    @Override
    public int updateEquipJianxiu(EquipJianxiu equipJianxiu)
    {
        return equipJianxiuMapper.updateEquipJianxiu(equipJianxiu);
    }

    /**
     * 批量删除计划检修
     * 
     * @param ids 需要删除的计划检修主键
     * @return 结果
     */
    @Override
    public int deleteEquipJianxiuByIds(Long[] ids)
    {
        return equipJianxiuMapper.deleteEquipJianxiuByIds(ids);
    }

    /**
     * 删除计划检修信息
     * 
     * @param id 计划检修主键
     * @return 结果
     */
    @Override
    public int deleteEquipJianxiuById(Long id)
    {
        return equipJianxiuMapper.deleteEquipJianxiuById(id);
    }
}
