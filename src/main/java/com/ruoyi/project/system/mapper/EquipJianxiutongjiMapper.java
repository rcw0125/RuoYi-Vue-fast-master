package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.EquipJianxiutongji;

/**
 * 设备检修统计Mapper接口
 * 
 * @author ruoyi
 * @date 2022-06-04
 */
public interface EquipJianxiutongjiMapper 
{
    /**
     * 查询设备检修统计
     * 
     * @param id 设备检修统计主键
     * @return 设备检修统计
     */
    public EquipJianxiutongji selectEquipJianxiutongjiById(Long id);

    /**
     * 查询设备检修统计列表
     * 
     * @param equipJianxiutongji 设备检修统计
     * @return 设备检修统计集合
     */
    public List<EquipJianxiutongji> selectEquipJianxiutongjiList(EquipJianxiutongji equipJianxiutongji);

    /**
     * 新增设备检修统计
     * 
     * @param equipJianxiutongji 设备检修统计
     * @return 结果
     */
    public int insertEquipJianxiutongji(EquipJianxiutongji equipJianxiutongji);

    /**
     * 修改设备检修统计
     * 
     * @param equipJianxiutongji 设备检修统计
     * @return 结果
     */
    public int updateEquipJianxiutongji(EquipJianxiutongji equipJianxiutongji);

    /**
     * 删除设备检修统计
     * 
     * @param id 设备检修统计主键
     * @return 结果
     */
    public int deleteEquipJianxiutongjiById(Long id);

    /**
     * 批量删除设备检修统计
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEquipJianxiutongjiByIds(Long[] ids);
}
