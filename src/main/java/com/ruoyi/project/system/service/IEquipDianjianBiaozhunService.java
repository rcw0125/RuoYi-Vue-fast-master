package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.EquipDianjianBiaozhun;

/**
 * 点检标准Service接口
 * 
 * @author ruoyi
 * @date 2021-09-22
 */
public interface IEquipDianjianBiaozhunService 
{
    /**
     * 查询点检标准
     * 
     * @param id 点检标准主键
     * @return 点检标准
     */
    public EquipDianjianBiaozhun selectEquipDianjianBiaozhunById(Long id);

    /**
     * 查询点检标准列表
     * 
     * @param equipDianjianBiaozhun 点检标准
     * @return 点检标准集合
     */
    public List<EquipDianjianBiaozhun> selectEquipDianjianBiaozhunList(EquipDianjianBiaozhun equipDianjianBiaozhun);

    /**
     * 新增点检标准
     * 
     * @param equipDianjianBiaozhun 点检标准
     * @return 结果
     */
    public int insertEquipDianjianBiaozhun(EquipDianjianBiaozhun equipDianjianBiaozhun);

    /**
     * 修改点检标准
     * 
     * @param equipDianjianBiaozhun 点检标准
     * @return 结果
     */
    public int updateEquipDianjianBiaozhun(EquipDianjianBiaozhun equipDianjianBiaozhun);

    /**
     * 批量删除点检标准
     * 
     * @param ids 需要删除的点检标准主键集合
     * @return 结果
     */
    public int deleteEquipDianjianBiaozhunByIds(Long[] ids);

    /**
     * 删除点检标准信息
     * 
     * @param id 点检标准主键
     * @return 结果
     */
    public int deleteEquipDianjianBiaozhunById(Long id);
}
