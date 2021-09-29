package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.EquipDianjianBiaozhun;

/**
 * 点检标准Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-22
 */
public interface EquipDianjianBiaozhunMapper 
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
     * 删除点检标准
     * 
     * @param id 点检标准主键
     * @return 结果
     */
    public int deleteEquipDianjianBiaozhunById(Long id);

    /**
     * 批量删除点检标准
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEquipDianjianBiaozhunByIds(Long[] ids);
}
