package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.EquipDianjianList;

/**
 * 点检记录Service接口
 *
 * @author ruoyi
 * @date 2021-09-23
 */
public interface IEquipDianjianListService
{
    /**
     * 查询点检记录
     *
     * @param id 点检记录主键
     * @return 点检记录
     */
    public EquipDianjianList selectEquipDianjianListById(Long id);

    /**
     * 查询点检记录列表
     *
     * @param equipDianjianList 点检记录
     * @return 点检记录集合
     */
    public List<EquipDianjianList> selectEquipDianjianListList(EquipDianjianList equipDianjianList);

    /**
     * 查询最新的一条数据点检记录列表
     *
     * @param equipDianjianList 点检记录
     * @return 点检记录集合
     */
    public List<EquipDianjianList> selectLastEquipDianjianList(EquipDianjianList equipDianjianList);

    /**
     * 新增点检记录
     *
     * @param equipDianjianList 点检记录
     * @return 结果
     */
    public int insertEquipDianjianList(EquipDianjianList equipDianjianList);

    /**
     * 修改点检记录
     *
     * @param equipDianjianList 点检记录
     * @return 结果
     */
    public int updateEquipDianjianList(EquipDianjianList equipDianjianList);

    /**
     * 批量删除点检记录
     *
     * @param ids 需要删除的点检记录主键集合
     * @return 结果
     */
    public int deleteEquipDianjianListByIds(Long[] ids);

    /**
     * 删除点检记录信息
     *
     * @param id 点检记录主键
     * @return 结果
     */
    public int deleteEquipDianjianListById(Long id);
}
