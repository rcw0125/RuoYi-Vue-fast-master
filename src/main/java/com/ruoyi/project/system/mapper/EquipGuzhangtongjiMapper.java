package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.EquipGuzhangtongji;

/**
 * 设备故障统计Mapper接口
 * 
 * @author ruoyi
 * @date 2022-06-04
 */
public interface EquipGuzhangtongjiMapper 
{
    /**
     * 查询设备故障统计
     * 
     * @param id 设备故障统计主键
     * @return 设备故障统计
     */
    public EquipGuzhangtongji selectEquipGuzhangtongjiById(Long id);

    /**
     * 查询设备故障统计列表
     * 
     * @param equipGuzhangtongji 设备故障统计
     * @return 设备故障统计集合
     */
    public List<EquipGuzhangtongji> selectEquipGuzhangtongjiList(EquipGuzhangtongji equipGuzhangtongji);

    /**
     * 新增设备故障统计
     * 
     * @param equipGuzhangtongji 设备故障统计
     * @return 结果
     */
    public int insertEquipGuzhangtongji(EquipGuzhangtongji equipGuzhangtongji);

    /**
     * 修改设备故障统计
     * 
     * @param equipGuzhangtongji 设备故障统计
     * @return 结果
     */
    public int updateEquipGuzhangtongji(EquipGuzhangtongji equipGuzhangtongji);

    /**
     * 删除设备故障统计
     * 
     * @param id 设备故障统计主键
     * @return 结果
     */
    public int deleteEquipGuzhangtongjiById(Long id);

    /**
     * 批量删除设备故障统计
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEquipGuzhangtongjiByIds(Long[] ids);
}
