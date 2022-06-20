package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.EquipDianjianfenlei;

/**
 * 点检分类统计Service接口
 * 
 * @author ruoyi
 * @date 2022-06-04
 */
public interface IEquipDianjianfenleiService 
{
    /**
     * 查询点检分类统计
     * 
     * @param id 点检分类统计主键
     * @return 点检分类统计
     */
    public EquipDianjianfenlei selectEquipDianjianfenleiById(Long id);

    /**
     * 查询点检分类统计列表
     * 
     * @param equipDianjianfenlei 点检分类统计
     * @return 点检分类统计集合
     */
    public List<EquipDianjianfenlei> selectEquipDianjianfenleiList(EquipDianjianfenlei equipDianjianfenlei);

    /**
     * 新增点检分类统计
     * 
     * @param equipDianjianfenlei 点检分类统计
     * @return 结果
     */
    public int insertEquipDianjianfenlei(EquipDianjianfenlei equipDianjianfenlei);

    /**
     * 修改点检分类统计
     * 
     * @param equipDianjianfenlei 点检分类统计
     * @return 结果
     */
    public int updateEquipDianjianfenlei(EquipDianjianfenlei equipDianjianfenlei);

    /**
     * 批量删除点检分类统计
     * 
     * @param ids 需要删除的点检分类统计主键集合
     * @return 结果
     */
    public int deleteEquipDianjianfenleiByIds(Long[] ids);

    /**
     * 删除点检分类统计信息
     * 
     * @param id 点检分类统计主键
     * @return 结果
     */
    public int deleteEquipDianjianfenleiById(Long id);
}
