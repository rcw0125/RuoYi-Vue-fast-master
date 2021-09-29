package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.EquipGuzhangMapper;
import com.ruoyi.project.system.domain.EquipGuzhang;
import com.ruoyi.project.system.service.IEquipGuzhangService;

/**
 * 故障报修Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-27
 */
@Service
public class EquipGuzhangServiceImpl implements IEquipGuzhangService 
{
    @Autowired
    private EquipGuzhangMapper equipGuzhangMapper;

    /**
     * 查询故障报修
     * 
     * @param id 故障报修主键
     * @return 故障报修
     */
    @Override
    public EquipGuzhang selectEquipGuzhangById(Long id)
    {
        return equipGuzhangMapper.selectEquipGuzhangById(id);
    }

    /**
     * 查询故障报修列表
     * 
     * @param equipGuzhang 故障报修
     * @return 故障报修
     */
    @Override
    public List<EquipGuzhang> selectEquipGuzhangList(EquipGuzhang equipGuzhang)
    {
        return equipGuzhangMapper.selectEquipGuzhangList(equipGuzhang);
    }

    /**
     * 新增故障报修
     * 
     * @param equipGuzhang 故障报修
     * @return 结果
     */
    @Override
    public int insertEquipGuzhang(EquipGuzhang equipGuzhang)
    {
        return equipGuzhangMapper.insertEquipGuzhang(equipGuzhang);
    }

    /**
     * 修改故障报修
     * 
     * @param equipGuzhang 故障报修
     * @return 结果
     */
    @Override
    public int updateEquipGuzhang(EquipGuzhang equipGuzhang)
    {
        return equipGuzhangMapper.updateEquipGuzhang(equipGuzhang);
    }

    /**
     * 批量删除故障报修
     * 
     * @param ids 需要删除的故障报修主键
     * @return 结果
     */
    @Override
    public int deleteEquipGuzhangByIds(Long[] ids)
    {
        return equipGuzhangMapper.deleteEquipGuzhangByIds(ids);
    }

    /**
     * 删除故障报修信息
     * 
     * @param id 故障报修主键
     * @return 结果
     */
    @Override
    public int deleteEquipGuzhangById(Long id)
    {
        return equipGuzhangMapper.deleteEquipGuzhangById(id);
    }
}
