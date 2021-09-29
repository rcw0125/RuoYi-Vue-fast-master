package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.EquipDianjianList;

/**
 * 点检记录Mapper接口
 *
 * @author ruoyi
 * @date 2021-09-23
 */
public interface EquipDianjianListMapper
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
     * 删除点检记录
     *
     * @param id 点检记录主键
     * @return 结果
     */
    public int deleteEquipDianjianListById(Long id);

    /**
     * 批量删除点检记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEquipDianjianListByIds(Long[] ids);
}
