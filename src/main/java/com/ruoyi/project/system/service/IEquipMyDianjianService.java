package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.EquipMyDianjian;

/**
 * 配置我的点检Service接口
 * 
 * @author ruoyi
 * @date 2022-06-15
 */
public interface IEquipMyDianjianService 
{
    /**
     * 查询配置我的点检
     * 
     * @param id 配置我的点检主键
     * @return 配置我的点检
     */
    public EquipMyDianjian selectEquipMyDianjianById(Long id);

    /**
     * 查询配置我的点检列表
     * 
     * @param equipMyDianjian 配置我的点检
     * @return 配置我的点检集合
     */
    public List<EquipMyDianjian> selectEquipMyDianjianList(EquipMyDianjian equipMyDianjian);

    /**
     * 新增配置我的点检
     * 
     * @param equipMyDianjian 配置我的点检
     * @return 结果
     */
    public int insertEquipMyDianjian(EquipMyDianjian equipMyDianjian);

    /**
     * 修改配置我的点检
     * 
     * @param equipMyDianjian 配置我的点检
     * @return 结果
     */
    public int updateEquipMyDianjian(EquipMyDianjian equipMyDianjian);

    /**
     * 批量删除配置我的点检
     * 
     * @param ids 需要删除的配置我的点检主键集合
     * @return 结果
     */
    public int deleteEquipMyDianjianByIds(Long[] ids);

    /**
     * 删除配置我的点检信息
     * 
     * @param id 配置我的点检主键
     * @return 结果
     */
    public int deleteEquipMyDianjianById(Long id);
}
