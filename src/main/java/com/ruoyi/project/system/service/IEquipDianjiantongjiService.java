package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.EquipDianjiantongji;

/**
 * 月点检统计Service接口
 * 
 * @author ruoyi
 * @date 2022-05-17
 */
public interface IEquipDianjiantongjiService 
{
    /**
     * 查询月点检统计
     * 
     * @param id 月点检统计主键
     * @return 月点检统计
     */
    public EquipDianjiantongji selectEquipDianjiantongjiById(Long id);

    /**
     * 查询月点检统计列表
     * 
     * @param equipDianjiantongji 月点检统计
     * @return 月点检统计集合
     */
    public List<EquipDianjiantongji> selectEquipDianjiantongjiList(EquipDianjiantongji equipDianjiantongji);

    /**
     * 新增月点检统计
     * 
     * @param equipDianjiantongji 月点检统计
     * @return 结果
     */
    public int insertEquipDianjiantongji(EquipDianjiantongji equipDianjiantongji);

    /**
     * 修改月点检统计
     * 
     * @param equipDianjiantongji 月点检统计
     * @return 结果
     */
    public int updateEquipDianjiantongji(EquipDianjiantongji equipDianjiantongji);

    /**
     * 批量删除月点检统计
     * 
     * @param ids 需要删除的月点检统计主键集合
     * @return 结果
     */
    public int deleteEquipDianjiantongjiByIds(Long[] ids);

    /**
     * 删除月点检统计信息
     * 
     * @param id 月点检统计主键
     * @return 结果
     */
    public int deleteEquipDianjiantongjiById(Long id);
}
